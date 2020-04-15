/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.composite;

import android.view.ViewGroup;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;

/**
 * Implementation of {@link UiMutableComposite} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class AndroidMutableCompositeViewGroup<W extends ViewGroup, C extends UiWidget>
    extends AndroidMutableComposite<W, C> {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidMutableCompositeViewGroup(W widget) {

    super(widget);
  }

  @Override
  protected void addChildWidget(C child, int index) {

    if (index == -1) {
      this.widget.addView(getTopWidget(child));
    } else {
      this.widget.addView(getTopWidget(child), index);
    }
  }

  @Override
  protected void removeChildWidget(C child, int index) {

    this.widget.removeView(getTopWidget(child));
  }

}
