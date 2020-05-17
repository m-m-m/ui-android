/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.number;

import io.github.mmm.ui.android.widget.number.AndroidLongSlider;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.number.UiLongSlider;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiLongSlider}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryLongSlider implements UiSingleWidgetFactoryNative<UiLongSlider> {

  @Override
  public Class<UiLongSlider> getType() {

    return UiLongSlider.class;
  }

  @Override
  public UiLongSlider create() {

    return new AndroidLongSlider();
  }

}
