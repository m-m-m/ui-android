/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.composite;

import android.widget.LinearLayout;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiSlot;

/**
 * Implementation of {@link UiSlot} for android.
 *
 * @since 1.0.0
 */
public class AndroidSlot extends AndroidComposite<LinearLayout, UiRegularWidget> implements UiSlot {

  private UiRegularWidget child;

  /**
   * The constructor.
   */
  public AndroidSlot() {

    super(new LinearLayout(getContext()));
  }

  @Override
  public UiRegularWidget getChild() {

    return this.child;
  }

  @Override
  public void setChild(UiRegularWidget child) {

    if (this.child == child) {
      return;
    }
    if (this.child != null) {
      setParent(this.child, null);
      this.widget.removeAllViews();
    }
    this.widget.addView(getTopWidget(child));
    this.child = child;
    setParent(this.child, this);
  }

}
