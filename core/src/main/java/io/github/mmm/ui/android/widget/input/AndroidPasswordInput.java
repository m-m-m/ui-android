/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import android.text.method.PasswordTransformationMethod;
import io.github.mmm.ui.api.widget.input.UiPasswordInput;

/**
 * Implementation of {@link UiPasswordInput} for android.
 *
 * @since 1.0.0
 */
public class AndroidPasswordInput extends AndroidStringInput implements UiPasswordInput {

  /**
   * The constructor.
   */
  public AndroidPasswordInput() {

    super();
    this.widget.setTransformationMethod(PasswordTransformationMethod.getInstance());
    // this.widget.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
  }

}
