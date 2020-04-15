/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.composite;

import android.view.View;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;

/**
 * Implementation of {@link UiMutableComposite} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class AndroidMutableComposite<W extends View, C extends UiWidget> extends AndroidComposite<W, C>
    implements UiMutableComposite<C> {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidMutableComposite(W widget) {

    super(widget);
  }

  @Override
  public void addChild(C child, int index) {

    setParent(child, this);
    addChildWidget(child, index);
    if (index == -1) {
      this.children.add(child);
    } else {
      this.children.add(index, child);
    }
  }

  /**
   * @param child the child to add.
   * @param index the index where to insert the child.
   * @see #addChild(UiWidget, int)
   */
  protected abstract void addChildWidget(C child, int index);

  @Override
  public C removeChild(int index) {

    C child = this.children.remove(index);
    removeChildWidget(child, index);
    setParent(child, null);
    return child;
  }

  /**
   * @param child the child to remove.
   * @param index the index of the child to remove.
   * @see #removeChild(UiWidget)
   * @see #removeChild(int)
   */
  protected abstract void removeChildWidget(C child, int index);

}
