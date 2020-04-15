/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.core;

import io.github.mmm.ui.android.widget.input.AndroidRadioButton;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.input.UiRadioButton;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiRadioButton}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryRadioButton implements UiSingleWidgetFactoryNative<UiRadioButton> {

  @Override
  public Class<UiRadioButton> getType() {

    return UiRadioButton.class;
  }

  @Override
  public UiRadioButton create() {

    return new AndroidRadioButton();
  }

}
