/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.core;

import io.github.mmm.ui.android.widget.AndroidLabel;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiLabel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiLabel}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryLabel implements UiSingleWidgetFactoryNative<UiLabel> {

  @Override
  public Class<UiLabel> getType() {

    return UiLabel.class;
  }

  @Override
  public UiLabel create() {

    return new AndroidLabel();
  }

}
