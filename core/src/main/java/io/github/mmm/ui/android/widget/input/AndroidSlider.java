/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import io.github.mmm.base.number.NumberType;
import io.github.mmm.base.range.WritableRange;
import io.github.mmm.ui.api.widget.input.UiSlider;
import io.github.mmm.ui.spi.range.NumericRange;
import io.github.mmm.validation.Validator;

/**
 * Implementation of {@link UiSlider} for android.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class AndroidSlider<V extends Number> extends AndroidInput<SeekBar, V> implements UiSlider<V> {

  private static final int MAX_PROGRESS = 1000;

  private static final Number ZERO = Integer.valueOf(0);

  private final LinearLayout topWidget;

  private final NumericRange<V> range;

  private final EditText textWidget;

  private V value;

  private String text;

  private boolean textVisible;

  /**
   * The constructor.
   */
  public AndroidSlider() {

    super(new SeekBar(getContext()));
    this.widget.setMax(MAX_PROGRESS);
    this.value = getNumberType().valueOf(ZERO);
    this.topWidget = new LinearLayout(getContext());
    this.textWidget = new EditText(getContext());
    this.textWidget.setEnabled(false);
    this.textVisible = true;
    this.topWidget.addView(this.widget);
    this.topWidget.addView(this.textWidget);
    this.range = new NumericRange<>(getNumberType());
    OnSeekBarChangeListener seekBarChangeListener = new OnSeekBarChangeListener() {

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

        onValueChanged();
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        AndroidSlider.this.onProgressChanged(progress, fromUser);
      }

    };
    this.widget.setOnSeekBarChangeListener(seekBarChangeListener);
    this.textWidget.addTextChangedListener(new TextChangeListener());
  }

  @Override
  public View getTopWidget() {

    return this.topWidget;
  }

  private void onProgressChanged(int progress, boolean fromUser) {

    double v = progress / MAX_PROGRESS;
    double r = 100;
    double dMin = 0;
    V max = AndroidSlider.this.range.getMax();
    if (max != null) {
      r = max.doubleValue();
      V min = AndroidSlider.this.range.getMin();
      if (min != null) {
        dMin = min.doubleValue();
        r = r - dMin;
      }
    }
    v = v * r + dMin;
    this.value = getNumberType().valueOf(Double.valueOf(v));
    setValueAsText(this.value);
  }

  private void setValueAsText(V value) {

    String newText = "";
    if (value != null) {
      newText = value.toString();
    }
    this.textWidget.setText(newText);
  }

  /**
   * @return the {@link NumberType} for the underlying {@link Number}.
   */
  protected abstract NumberType<V> getNumberType();

  @Override
  public WritableRange<V> getRange() {

    return this.range;
  }

  @Override
  public V getValueOrThrow() {

    return this.value;
  }

  @Override
  protected void setValueNative(V value) {

    setValueToSlider(value);
    setValueAsText(this.value);
  }

  private void setValueToSlider(V value) {

    double v = 0;
    if (value == null) {
      this.value = null;
    } else {
      this.value = this.range.clip(value);
      v = this.value.doubleValue();
    }
    double r = 100;
    double p = v;
    V max = this.range.getMax();
    if (max != null) {
      r = max.doubleValue();
      V min = this.range.getMin();
      if (min != null) {
        double dMin = min.doubleValue();
        r = r - dMin;
        p = p - dMin;
      }
    }
    int progress;
    if (p < 0) {
      progress = 0;
    } else if (p > r) {
      progress = MAX_PROGRESS;
    } else {
      progress = (int) (p / r);
    }
    this.widget.setProgress(progress);
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    super.setValidator(validator);
    this.range.setValidator(validator);
  }

  @Override
  public boolean isTextVisible() {

    return this.textVisible;
  }

  @Override
  public void setTextVisible(boolean textVisible) {

    this.textVisible = textVisible;
    setVisible(this.textWidget, textVisible);
  }

  @Override
  public boolean isTextEditable() {

    return this.textWidget.isEnabled();
  }

  @Override
  public void setTextEditable(boolean textEditable) {

    this.textWidget.setEnabled(textEditable);
  }

  private class TextChangeListener implements TextWatcher {

    @Override
    public void onTextChanged(CharSequence txt, int start, int before, int count) {

    }

    @Override
    public void beforeTextChanged(CharSequence txt, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

      try {
        String newText = AndroidSlider.this.textWidget.getText().toString();
        if (newText.equals(AndroidSlider.this.text)) {
          return;
        }
        AndroidSlider.this.text = newText;
        setValueToSlider(getNumberType().valueOf(AndroidSlider.this.text));
        onValueChanged();
      } catch (NumberFormatException e) {
        // TODO
        setValidationFailure("Invalid number");
      }
    }
  };
}
