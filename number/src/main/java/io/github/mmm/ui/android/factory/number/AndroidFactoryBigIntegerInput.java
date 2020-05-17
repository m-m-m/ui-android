/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.number;

import io.github.mmm.ui.android.widget.number.AndroidBigIntegerInput;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.number.UiBigIntegerInput;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiBigIntegerInput}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryBigIntegerInput implements UiSingleWidgetFactoryNative<UiBigIntegerInput> {

  @Override
  public Class<UiBigIntegerInput> getType() {

    return UiBigIntegerInput.class;
  }

  @Override
  public UiBigIntegerInput create() {

    return new AndroidBigIntegerInput();
  }

}
