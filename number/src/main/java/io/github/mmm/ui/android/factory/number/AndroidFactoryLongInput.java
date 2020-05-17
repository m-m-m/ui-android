/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.number;

import io.github.mmm.ui.android.widget.number.AndroidIntegerInput;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.number.UiIntegerInput;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiIntegerInput}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryLongInput implements UiSingleWidgetFactoryNative<UiIntegerInput> {

  @Override
  public Class<UiIntegerInput> getType() {

    return UiIntegerInput.class;
  }

  @Override
  public UiIntegerInput create() {

    return new AndroidIntegerInput();
  }

}
