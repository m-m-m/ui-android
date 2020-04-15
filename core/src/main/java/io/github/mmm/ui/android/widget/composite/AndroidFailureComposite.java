/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.composite;

import android.view.ViewGroup;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiFailureComposite;

/**
 * Implementation of {@link UiFailureComposite} using android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class AndroidFailureComposite<W extends ViewGroup, C extends UiWidget>
    extends AndroidMutableCompositeViewGroup<W, C> implements UiFailureComposite<C> {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidFailureComposite(W widget) {

    super(widget);
  }

  @Override
  protected void doSetValidationFailure(String error) {

    super.doSetValidationFailure(error);
    // TODO: apply to view
  }
}
