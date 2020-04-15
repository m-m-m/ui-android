/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.panel;

import android.widget.LinearLayout;
import io.github.mmm.ui.api.widget.panel.UiVerticalPanel;

/**
 * Implementation of {@link UiVerticalPanel} for android.
 *
 * @since 1.0.0
 */
public class AndroidVerticalPanel extends AndroidMutablePanel<LinearLayout> implements UiVerticalPanel {

  /**
   * The constructor.
   */
  public AndroidVerticalPanel() {

    super(new LinearLayout(getContext()));
    this.widget.setOrientation(LinearLayout.VERTICAL);
  }

}
