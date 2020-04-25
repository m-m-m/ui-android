/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget;

import android.content.Context;
import android.view.View;
import io.github.mmm.ui.android.AndroidApplication;
import io.github.mmm.ui.api.event.UiEvent;
import io.github.mmm.ui.api.event.UiFocusGainEvent;
import io.github.mmm.ui.api.event.UiFocusLossEvent;
import io.github.mmm.ui.api.widget.UiCustomWidget;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.spi.widget.AbstractUiNativeWidgetWrapper;

/**
 * Implementation of {@link io.github.mmm.ui.api.widget.UiNativeWidget} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @since 1.0.0
 */
public abstract class AndroidWidget<W> extends AbstractUiNativeWidgetWrapper<W> {

  /** @see #getWidget() */
  protected final W widget;

  private String id;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidWidget(W widget) {

    super();
    this.widget = widget;
  }

  /**
   * @return the android {@link Context}.
   */
  protected static Context getContext() {

    return AndroidApplication.getAndroidContext();
  }

  @Override
  public W getWidget() {

    return this.widget;
  }

  @Override
  public abstract View getTopWidget();

  /**
   * @param uiWidget the {@link UiWidget}.
   * @return the {@link #getTopWidget() top widget}.
   */
  protected View getTopWidget(UiWidget uiWidget) {

    if (uiWidget instanceof UiCustomWidget) {
      return getTopWidget(((UiCustomWidget<?>) uiWidget).getDelegate());
    }
    return ((AndroidWidget<?>) uiWidget).getTopWidget();
  }

  @Override
  public String getId() {

    return this.id;
  }

  @Override
  public void setId(String id) {

    this.id = id;
  }

  /**
   * @param view the {@link View} to show or hide.
   * @param visible the new visibility.
   */
  protected static void setVisible(View view, boolean visible) {

    if (visible) {
      view.setVisibility(View.VISIBLE);
    } else {
      view.setVisibility(View.GONE);
    }
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

  }

  /**
   * @param view the {@link View} that changed.
   * @param hasFocus the new focus flag.
   */
  protected void onFocusChange(View view, boolean hasFocus) {

    onFocusChanged(hasFocus);
  }

  /**
   * @param focusGain {@code true} if the focus was gained, {@code false} otherwise (focus has been lost).
   */
  protected void onFocusChanged(boolean focusGain) {

    UiEvent event;
    if (focusGain) {
      event = UiFocusGainEvent.of(this, getProgrammaticEventType());
    } else {
      event = UiFocusLossEvent.of(this, getProgrammaticEventType());
      validate();
    }
    fireEvent(event);
  }

  // /**
  // * @param <V> type of the value.
  // * @param observable the observable (property) that changed.
  // * @param oldValue the old value.
  // * @param newValue the new value.
  // */
  // protected <V> void onValueChange(ObservableValue<? extends V> observable, V oldValue, V newValue) {
  //
  // boolean programmatic = getProgrammaticEventType() == UiValueChangeEvent.TYPE;
  // onValueChanged(programmatic);
  // fireEvent(new UiValueChangeEvent(this, programmatic));
  // }
  //
  // /**
  // * Called from {@link #onValueChange(ObservableValue, Object, Object)} if triggered by end-user.
  // *
  // * @param programmatic - see {@link UiValueChangeEvent#isProgrammatic()}.
  // */
  // protected void onValueChanged(boolean programmatic) {
  //
  // }
  //
  // /**
  // * @param observable the observable (property) that changed.
  // * @param oldValue the old value.
  // * @param newValue the new value.
  // */
  // protected void onClose(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
  //
  // boolean programmatic = getProgrammaticEventType() == UiHideEvent.TYPE;
  // fireEvent(new UiHideEvent(this, programmatic));
  // }

  @Override
  protected void onStylesChanged(String newStyles) {

    super.onStylesChanged(newStyles);
    // widget.setStyle(newStyles);
  }

}