/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.panel;

import android.widget.LinearLayout;
import io.github.mmm.ui.api.widget.panel.UiCollapsiblePanel;

/**
 * Implementation of {@link UiCollapsiblePanel} for android.
 *
 * @since 1.0.0
 */
public class AndroidCollapsiblePanel extends AndroidMutablePanel<LinearLayout> implements UiCollapsiblePanel {

  private String text;

  private boolean collapsed;

  private boolean collapsible;

  // private final CollapsingToolbarLayout topWidget;

  /**
   * The constructor.
   */
  public AndroidCollapsiblePanel() {

    super(new LinearLayout(getContext()));
    this.widget.setOrientation(LinearLayout.VERTICAL);
    // this.topWidget = new CollapsingToolbarLayout(getContext());
    // this.topWidget.addView(this.widget);
  }

  // @Override
  // public View getTopWidget() {
  //
  // return this.topWidget;
  // }

  @Override
  public String getText() {

    return this.text;
  }

  @Override
  public void setText(String text) {

    this.text = text;
  }

  @Override
  public boolean isCollapsed() {

    return this.collapsed;
  }

  @Override
  public void setCollapsed(boolean collapsed) {

    this.collapsed = collapsed;
  }

  @Override
  public boolean isCollapsible() {

    return this.collapsible;
  }

  @Override
  public void setCollapsible(boolean collapsible) {

    this.collapsible = collapsible;
  }

}
