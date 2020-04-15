/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget;

import android.view.View;
import io.github.mmm.ui.api.event.UiClickEvent;
import io.github.mmm.ui.api.widget.UiClickableWidget;

/**
 * Implementation of {@link UiClickableWidget} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @since 1.0.0
 */
public abstract class AndroidClickableWidget<W extends View> extends AndroidActiveWidget<W>
    implements UiClickableWidget {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidClickableWidget(W widget) {

    super(widget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.setOnClickListener(this::onClick);
  }

  /**
   * @param view the {@link View} that has been clicked.
   */
  protected void onClick(View view) {

    fireEvent(new UiClickEvent(this, false));
  }

  @Override
  public void click() {

    fireEvent(new UiClickEvent(this, true));
  }

}
