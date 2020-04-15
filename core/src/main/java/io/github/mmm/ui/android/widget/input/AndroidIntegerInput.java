/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.ui.api.widget.input.UiIntegerInput;

/**
 * Implementation of {@link UiIntegerInput} for android.
 *
 * @since 1.0.0
 */
public class AndroidIntegerInput extends AndroidNumberInput<Integer> implements UiIntegerInput {

  /**
   * The constructor.
   */
  public AndroidIntegerInput() {

    super();
  }

  @Override
  protected NumberType<Integer> getNumberType() {

    return NumberType.INTEGER;
  }

}
