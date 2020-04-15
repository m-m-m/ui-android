/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.core;

import io.github.mmm.ui.android.widget.img.AndroidImage;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.img.UiImage;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiLabel}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryImage implements UiSingleWidgetFactoryNative<UiImage> {

  @Override
  public Class<UiImage> getType() {

    return UiImage.class;
  }

  @Override
  public UiImage create() {

    return new AndroidImage();
  }

}
