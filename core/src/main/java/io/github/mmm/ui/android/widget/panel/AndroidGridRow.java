/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.panel;

import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.panel.UiGridRow;

/**
 *
 */
public class AndroidGridRow extends AndroidMutablePanel<ViewGroup> implements UiGridRow {

  /**
   * The constructor.
   */
  public AndroidGridRow() {

    super(new AbsoluteLayout(getContext()));
  }

  @Override
  public void addChild(UiRegularWidget child, int index, int colspan, int rowspan) {

    // TODO Auto-generated method stub

  }

}
