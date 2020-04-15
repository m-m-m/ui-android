/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.core;

import io.github.mmm.ui.android.widget.input.AndroidTextArea;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.input.UiTextArea;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiTextArea}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryTextArea implements UiSingleWidgetFactoryNative<UiTextArea> {

  @Override
  public Class<UiTextArea> getType() {

    return UiTextArea.class;
  }

  @Override
  public UiTextArea create() {

    return new AndroidTextArea();
  }

}
