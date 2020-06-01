/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget;

import android.view.View;
import io.github.mmm.ui.api.event.UiFocusGainEvent;
import io.github.mmm.ui.api.widget.UiActiveWidget;

/**
 * Implementation of {@link UiActiveWidget} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @since 1.0.0
 */
public abstract class AndroidActiveWidget<W extends View> extends AndroidWidgetView<W> implements UiActiveWidget {

  private char accessKey;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidActiveWidget(W widget) {

    super(widget);
    this.accessKey = ACCESS_KEY_NONE;
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.setOnFocusChangeListener(this::onFocusChange);
  }

  @Override
  public char getAccessKey() {

    return this.accessKey;
  }

  @Override
  public void setAccessKey(char accessKey) {

    this.accessKey = accessKey;
  }

  @Override
  public boolean isFocused() {

    return this.widget.isFocused();
  }

  @Override
  public boolean setFocused() {

    setProgrammaticEventType(UiFocusGainEvent.TYPE);
    this.widget.requestFocus();
    return true;
  }

}
