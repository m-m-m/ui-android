/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.panel;

import android.widget.GridLayout;
import android.widget.LinearLayout;
import io.github.mmm.ui.android.widget.composite.AndroidMutableCompositeViewGroup;
import io.github.mmm.ui.api.widget.panel.UiGridPanel;
import io.github.mmm.ui.api.widget.panel.UiGridRow;
import io.github.mmm.ui.api.widget.panel.UiVerticalPanel;

/**
 * Implementation of {@link UiVerticalPanel} for android.
 *
 * @since 1.0.0
 */
public class AndroidGridPanel extends AndroidMutableCompositeViewGroup<GridLayout, UiGridRow> implements UiGridPanel {

  /**
   * The constructor.
   */
  public AndroidGridPanel() {

    super(new GridLayout(getContext()));
    this.widget.setOrientation(LinearLayout.VERTICAL);
  }

  @Override
  public UiGridRow addRow(int index) {

    AndroidGridRow row = new AndroidGridRow();
    addChild(row, index);
    return row;
  }

}
