/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.ui.api.widget.input.UiIntegerSlider;

/**
 * Implementation of {@link UiIntegerSlider} for android.
 *
 * @since 1.0.0
 */
public class AndroidIntegerSlider extends AndroidSlider<Integer> implements UiIntegerSlider {

  /**
   * The constructor.
   */
  public AndroidIntegerSlider() {

    super();
  }

  @Override
  protected NumberType<Integer> getNumberType() {

    return NumberType.INTEGER;
  }

}
