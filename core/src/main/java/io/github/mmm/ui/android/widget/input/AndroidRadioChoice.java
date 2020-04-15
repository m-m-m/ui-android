/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import io.github.mmm.ui.api.widget.input.UiRadioChoice;
import io.github.mmm.ui.spi.ToStringFormatter;

/**
 * Implementation of {@link UiRadioChoice} for android.
 *
 * @param <V> type of the {@link #getValue() value} and {@link #getOptions() option}.
 * @since 1.0.0
 */
public class AndroidRadioChoice<V> extends AndroidInput<RadioGroup, V> implements UiRadioChoice<V> {

  private final List<RadioButton> radios;

  private List<V> options;

  private Function<V, String> formatter;

  /**
   * The constructor.
   */
  public AndroidRadioChoice() {

    super(new RadioGroup(getContext()));
    this.widget.setOrientation(RadioGroup.HORIZONTAL);
    this.radios = new ArrayList<>();
    this.options = Collections.emptyList();
    this.formatter = ToStringFormatter.get();
    this.widget.setOnCheckedChangeListener(this::onCheckedChanged);
  }

  private void onCheckedChanged(RadioGroup button, int checkedId) {

    onValueChanged();
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.widget.setEnabled(enabled);
  }

  @Override
  public List<V> getOptions() {

    return this.options;
  }

  @Override
  public void setOptions(List<V> options) {

    if (options == null) {
      options = Collections.emptyList();
    }
    this.options = options;
    int optionCount = options.size();
    ensureRadioButtonCount(optionCount);
    while (this.widget.getChildCount() > optionCount) {
      this.widget.removeViewAt(this.widget.getChildCount() - 1);
    }
    for (int i = 0; i < optionCount; i++) {
      V option = options.get(i);
      RadioButton rb = this.radios.get(i);
      rb.setText(this.formatter.apply(option));
    }
  }

  private void ensureRadioButtonCount(int count) {

    for (int i = this.radios.size(); i < count; i++) {
      RadioButton rb = new RadioButton(getContext());
      // rb.setId(rb.generateViewId());
      this.widget.addView(rb);
      rb.setOnFocusChangeListener(this::onFocusChange);
      this.radios.add(rb);
    }
  }

  @Override
  public V getValueOrThrow() {

    int id = this.widget.getCheckedRadioButtonId();
    View view = this.widget.findViewById(id);
    int index = this.widget.indexOfChild(view);
    if (index < 0) {
      return null;
    }
    return this.options.get(index);
  }

  @Override
  protected void setValueNative(V value) {

    int size = this.options.size();
    for (int i = 0; i < size; i++) {
      if (this.options.get(i) == value) {
        this.radios.get(i).setSelected(true);
      }
    }
  }

  @Override
  public Function<V, String> getFormatter() {

    return this.formatter;
  }

  @Override
  public void setFormatter(Function<V, String> formatter) {

    if (formatter == null) {
      this.formatter = ToStringFormatter.get();
    } else {
      this.formatter = formatter;
    }
  }

}
