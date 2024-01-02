/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.number;

import android.text.InputType;
import android.widget.EditText;
import io.github.mmm.base.number.NumberType;
import io.github.mmm.base.range.WritableRange;
import io.github.mmm.ui.android.widget.input.AndroidTextualInput;
import io.github.mmm.ui.api.widget.number.UiNumberInput;
import io.github.mmm.ui.spi.range.NumericRange;
import io.github.mmm.validation.Validator;

/**
 * Implementation of {@link UiNumberInput} for android.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class AndroidNumberInput<V extends Number & Comparable<?>> extends AndroidTextualInput<EditText, V>
    implements UiNumberInput<V> {

  private final NumericRange<V> range;

  private V step;

  /**
   * The constructor.
   */
  public AndroidNumberInput() {

    super(new EditText(getContext()));
    int inputType = InputType.TYPE_NUMBER_FLAG_SIGNED;
    if (getNumberType().isDecimal()) {
      inputType = inputType | InputType.TYPE_NUMBER_FLAG_DECIMAL;
    }
    this.widget.setInputType(inputType);
    this.range = new NumericRange<>(getNumberType());
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

    String value = this.widget.getText().toString().trim();
    if (value.isEmpty()) {
      return null;
    }
    return getNumberType().parse(value);
  }

  @Override
  protected void setValueNative(V value) {

    String text = "";
    if (value != null) {
      V c = this.range.clip(value);
      text = c.toString();
    }
    setText(text);
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    super.setValidator(validator);
    this.range.setValidator(validator);
  }

  @Override
  public V getStep() {

    return this.step;
  }

  @Override
  public void setStep(V step) {

    this.step = step;
    // TODO support increment/decrement buttons
  }

}
