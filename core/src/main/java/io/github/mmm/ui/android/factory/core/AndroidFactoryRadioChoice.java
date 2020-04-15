/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.core;

import io.github.mmm.ui.android.widget.input.AndroidRadioChoice;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.input.UiRadioChoice;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiRadioChoice}.
 *
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
public class AndroidFactoryRadioChoice implements UiSingleWidgetFactoryNative<UiRadioChoice> {

  @Override
  public Class<UiRadioChoice> getType() {

    return UiRadioChoice.class;
  }

  @Override
  public UiRadioChoice create() {

    return new AndroidRadioChoice();
  }

}
