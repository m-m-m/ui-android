/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import io.github.mmm.ui.api.widget.UiAtomicWidget;

/**
 * Implementation of {@link UiAtomicWidget} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @since 1.0.0
 */
public abstract class AndroidAtomicWidget<W extends View> extends AndroidWidgetView<W> implements UiAtomicWidget {

  private String tooltip;

  private OnLongClickListener tooltipListener;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidAtomicWidget(W widget) {

    super(widget);
  }

  @Override
  public String getTooltip() {

    return this.tooltip;
  }

  @Override
  public void setTooltip(String tooltip) {

    this.tooltip = tooltip;
    if (!isEmpty(tooltip)) {
      this.widget.setContentDescription(tooltip);
      if (this.tooltipListener == null) {
        this.widget.setLongClickable(true);
        this.tooltipListener = v -> {
          Toast.makeText(v.getContext(), AndroidAtomicWidget.this.tooltip, Toast.LENGTH_SHORT).show();
          return true;
        };
        this.widget.setOnLongClickListener(this.tooltipListener);
      }
    }
  }

}
