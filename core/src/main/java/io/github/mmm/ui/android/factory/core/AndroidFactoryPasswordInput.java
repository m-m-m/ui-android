/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.core;

import io.github.mmm.ui.android.widget.input.AndroidPasswordInput;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.input.UiPasswordInput;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiPasswordInput}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryPasswordInput implements UiSingleWidgetFactoryNative<UiPasswordInput> {

  @Override
  public Class<UiPasswordInput> getType() {

    return UiPasswordInput.class;
  }

  @Override
  public UiPasswordInput create() {

    return new AndroidPasswordInput();
  }

}
