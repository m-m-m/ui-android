/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.core;

import io.github.mmm.ui.android.widget.AndroidText;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiText;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiText}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryText implements UiSingleWidgetFactoryNative<UiText> {

  @Override
  public Class<UiText> getType() {

    return UiText.class;
  }

  @Override
  public UiText create() {

    return new AndroidText();
  }

}
