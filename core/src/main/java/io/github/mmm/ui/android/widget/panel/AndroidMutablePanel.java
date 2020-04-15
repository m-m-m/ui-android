/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.panel;

import android.view.ViewGroup;
import io.github.mmm.ui.android.widget.composite.AndroidMutableCompositeViewGroup;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.panel.UiMutablePanel;

/**
 * Implementation of {@link UiMutablePanel} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @since 1.0.0
 */
public abstract class AndroidMutablePanel<W extends ViewGroup>
    extends AndroidMutableCompositeViewGroup<W, UiRegularWidget> implements UiMutablePanel {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidMutablePanel(W widget) {

    super(widget);
  }

}
