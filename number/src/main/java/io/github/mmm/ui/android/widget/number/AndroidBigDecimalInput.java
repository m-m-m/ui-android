/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.number;

import java.math.BigDecimal;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.ui.api.widget.number.UiBigDecimalInput;

/**
 * Implementation of {@link UiBigDecimalInput} for android.
 *
 * @since 1.0.0
 */
public class AndroidBigDecimalInput extends AndroidNumberInput<BigDecimal> implements UiBigDecimalInput {

  /**
   * The constructor.
   */
  public AndroidBigDecimalInput() {

    super();
  }

  @Override
  protected NumberType<BigDecimal> getNumberType() {

    return NumberType.BIG_DECIMAL;
  }

}
