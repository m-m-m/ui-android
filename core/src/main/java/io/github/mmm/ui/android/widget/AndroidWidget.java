/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
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

  private OnLongClickListener tooltipListener;

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

  @Override
  protected void setTooltipNative(String tooltip) {

    if (this.widget instanceof View) {
      setTooltip((View) this.widget, tooltip);
    }
  }

  /**
   * @param view the {@link View}.
   * @param tooltip the new {@link #getTooltip() tooltip}.
   */
  public void setTooltip(View view, String tooltip) {

    view.setContentDescription(tooltip);
    if (isEmpty(tooltip)) {
      if (this.tooltipListener != null) {
        view.setLongClickable(false);
        view.setOnLongClickListener(null);
        this.tooltipListener = null;
      }
    } else {
      if (this.tooltipListener == null) {
        view.setLongClickable(true);
        this.tooltipListener = v -> {
          Toast.makeText(v.getContext(), tooltip, Toast.LENGTH_SHORT).show();
          return true;
        };
        view.setOnLongClickListener(this.tooltipListener);
      }
    }
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

  @Override
  protected void onStylesChanged(String newStyles) {

    super.onStylesChanged(newStyles);
    // widget.setStyle(newStyles);
  }

}