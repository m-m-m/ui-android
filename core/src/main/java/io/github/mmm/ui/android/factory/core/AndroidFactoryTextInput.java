/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.core;

import io.github.mmm.ui.android.widget.input.AndroidTextInput;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.input.UiTextInput;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiTextInput}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryTextInput implements UiSingleWidgetFactoryNative<UiTextInput> {

  @Override
  public Class<UiTextInput> getType() {

    return UiTextInput.class;
  }

  @Override
  public UiTextInput create() {

    return new AndroidTextInput();
  }

}
