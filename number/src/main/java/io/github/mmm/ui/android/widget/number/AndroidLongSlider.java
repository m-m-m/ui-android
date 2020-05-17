/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.number;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.ui.api.widget.number.UiLongSlider;

/**
 * Implementation of {@link UiLongSlider} for android.
 *
 * @since 1.0.0
 */
public class AndroidLongSlider extends AndroidSlider<Long> implements UiLongSlider {

  /**
   * The constructor.
   */
  public AndroidLongSlider() {

    super();
  }

  @Override
  protected NumberType<Long> getNumberType() {

    return NumberType.LONG;
  }

}
