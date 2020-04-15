/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.composite;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import io.github.mmm.ui.android.widget.AndroidWidget;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiComposite;

/**
 * Implementation of {@link UiComposite} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class AndroidComposite<W extends View, C extends UiWidget> extends AndroidWidget<W>
    implements UiComposite<C> {

  /** @see #getChild(int) */
  protected final List<C> children;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidComposite(W widget) {

    super(widget);
    this.children = new ArrayList<>();
  }

  @Override
  public int getChildCount() {

    return this.children.size();
  }

  @Override
  public C getChild(int index) {

    if ((index < 0) || (index >= this.children.size())) {
      return null;
    }
    return this.children.get(index);
  }

  @Override
  public int getChildIndex(C child) {

    if (child == null) {
      return -1;
    }
    return this.children.indexOf(child);
  }

}
