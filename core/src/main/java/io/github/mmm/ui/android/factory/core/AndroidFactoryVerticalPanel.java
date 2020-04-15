/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.core;

import io.github.mmm.ui.android.widget.panel.AndroidVerticalPanel;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.panel.UiVerticalPanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiVerticalPanel}.
 *
 * @since 1.0.0
 */
public class AndroidFactoryVerticalPanel implements UiSingleWidgetFactoryNative<UiVerticalPanel> {

  @Override
  public Class<UiVerticalPanel> getType() {

    return UiVerticalPanel.class;
  }

  @Override
  public UiVerticalPanel create() {

    return new AndroidVerticalPanel();
  }

}
