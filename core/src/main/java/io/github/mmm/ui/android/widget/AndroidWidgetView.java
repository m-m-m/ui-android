/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget;

import android.view.View;

/**
 * Implementation of {@link io.github.mmm.ui.api.widget.UiNativeWidget} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @since 1.0.0
 */
public abstract class AndroidWidgetView<W extends View> extends AndroidWidget<W> {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidWidgetView(W widget) {

    super(widget);
  }

  @Override
  public View getTopWidget() {

    return this.widget;
  }

  @Override
  public void setId(String id) {

    super.setId(id);
    this.widget.setTag(id);
    int idInt = 0;
    for (int i = 0; i < id.length(); i++) {
      char c = id.charAt(i);
      if ((c >= '0') && (c <= '9')) {
        idInt = (idInt * 10) + (c - '0');
      } else {
        return;
      }
    }
    this.widget.setId(idInt);
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    setVisible(getTopWidget(), visible);
  }

  @Override
  protected void setTooltipNative(String tooltip) {

    setTooltip(this.widget, tooltip);
  }

}