/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.panel;

import android.widget.ScrollView;
import io.github.mmm.ui.android.widget.composite.AndroidComposite;
import io.github.mmm.ui.api.datatype.UiScrollBarVisibility;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.panel.UiScrollPanel;

/**
 * Implementation of {@link UiScrollPanel} for android.
 *
 * @since 1.0.0
 */
public class AndroidScrollPanel extends AndroidComposite<ScrollView, UiRegularWidget> implements UiScrollPanel {

  private UiRegularWidget child;

  private UiScrollBarVisibility horizontalScrolling;

  private UiScrollBarVisibility verticalScrolling;

  /**
   * The constructor.
   */
  public AndroidScrollPanel() {

    super(new ScrollView(getContext()));
    this.horizontalScrolling = UiScrollBarVisibility.AUTO;
    this.verticalScrolling = UiScrollBarVisibility.AUTO;
  }

  @Override
  public void setChild(UiRegularWidget child) {

    if (this.child == child) {
      return;
    }
    if (this.child != null) {
      this.widget.removeView(getTopWidget(this.child));
      setParent(this.child, null);
    }
    this.widget.addView(getTopWidget(child));
    this.child = child;
    setParent(this.child, this);
  }

  @Override
  public UiRegularWidget getChild() {

    return this.child;
  }

  @Override
  public UiScrollBarVisibility getHorizontalScrolling() {

    return this.horizontalScrolling;
  }

  @Override
  public void setHorizontalScrolling(UiScrollBarVisibility scrolling) {

    if (this.horizontalScrolling == scrolling) {
      return;
    }
    if (scrolling == UiScrollBarVisibility.HIDDEN) {
      this.widget.setHorizontalScrollBarEnabled(false);
    } else {
      this.widget.setHorizontalScrollBarEnabled(true);
    }
    this.horizontalScrolling = scrolling;
  }

  @Override
  public UiScrollBarVisibility getVerticalScrolling() {

    return this.verticalScrolling;
  }

  @Override
  public void setVerticalScrolling(UiScrollBarVisibility scrolling) {

    if (this.verticalScrolling == scrolling) {
      return;
    }
    if (scrolling == UiScrollBarVisibility.HIDDEN) {
      this.widget.setVerticalScrollBarEnabled(false);
    } else {
      this.widget.setVerticalScrollBarEnabled(true);
    }
    this.verticalScrolling = scrolling;
  }

}
