/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import io.github.mmm.ui.api.event.UiValueChangeEvent;
import io.github.mmm.ui.api.widget.input.UiTextualInput;

/**
 * Implementation of {@link UiTextualInput} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class AndroidTextualInput<W extends TextView, V> extends AndroidInput<W, V>
    implements UiTextualInput<V> {

  private String autocomplete;

  private String placeholder;

  private TextChangeListener textChangeListener;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidTextualInput(W widget) {

    super(widget);
    this.textChangeListener = new TextChangeListener();
    this.widget.addTextChangedListener(this.textChangeListener);
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

    this.textChangeListener.readonly = readOnly;
    this.textChangeListener.originalText = null;
  }

  @Override
  public String getPlaceholder() {

    return this.placeholder;
  }

  @Override
  public void setPlaceholder(String placeholder) {

    this.placeholder = placeholder;
    this.widget.setHint(placeholder);
  }

  @Override
  public String getText() {

    return this.widget.getText().toString();
  }

  @Override
  public void setText(String text) {

    setProgrammaticEventType(UiValueChangeEvent.TYPE);
    this.widget.setText(text);
  }

  @Override
  public String getAutocomplete() {

    return this.autocomplete;
  }

  @Override
  public void setAutocomplete(String autocomplete) {

    // Not supported by android
    this.autocomplete = autocomplete;
  }

  private class TextChangeListener implements TextWatcher {

    private boolean readonly;

    private String originalText;

    @Override
    public void onTextChanged(CharSequence text, int start, int before, int count) {

    }

    @Override
    public void beforeTextChanged(CharSequence text, int start, int count, int after) {

      if ((this.originalText == null) && this.readonly) {
        this.originalText = text.toString();
      }
    }

    @Override
    public void afterTextChanged(Editable s) {

      if (this.originalText == null) {
        onValueChanged();
      } else {
        AndroidTextualInput.this.widget.setText(this.originalText);
        this.originalText = null;
      }
    }
  }
}
