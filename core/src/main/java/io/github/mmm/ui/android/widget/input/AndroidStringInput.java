/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import android.widget.EditText;
import io.github.mmm.ui.api.widget.input.UiStringInput;

/**
 * Implementation of {@link UiStringInput} for android.
 *
 * @since 1.0.0
 */
public abstract class AndroidStringInput extends AndroidTextualInput<EditText, String> implements UiStringInput {

  /**
   * The constructor.
   */
  public AndroidStringInput() {

    super(new EditText(getContext()));
  }

  @Override
  public String getValueOrThrow() {

    return getText();
  }

  @Override
  public void setValueNative(String value) {

    setText(value);
  }

  @Override
  protected void doSetValidationFailure(String error) {

    super.doSetValidationFailure(error);
    this.widget.setError(error);
  }

}
