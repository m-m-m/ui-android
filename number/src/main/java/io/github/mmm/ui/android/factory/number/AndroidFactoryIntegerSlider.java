/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.number;

import io.github.mmm.ui.android.widget.number.AndroidIntegerSlider;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.number.UiIntegerSlider;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiIntegerSlider}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryIntegerSlider implements UiSingleWidgetFactoryNative<UiIntegerSlider> {

  @Override
  public Class<UiIntegerSlider> getType() {

    return UiIntegerSlider.class;
  }

  @Override
  public UiIntegerSlider create() {

    return new AndroidIntegerSlider();
  }

}
