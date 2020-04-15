/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.core;

import io.github.mmm.ui.android.widget.panel.AndroidFormPanel;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.panel.UiFormPanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiFormPanel}.
 *
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
public class AndroidFactoryFormPanel implements UiSingleWidgetFactoryNative<UiFormPanel> {

  @Override
  public Class<UiFormPanel> getType() {

    return UiFormPanel.class;
  }

  @Override
  public UiFormPanel create() {

    return new AndroidFormPanel();
  }

}
