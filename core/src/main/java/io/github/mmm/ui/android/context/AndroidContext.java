/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.context;

import android.content.Context;
import android.view.WindowManager;
import io.github.mmm.ui.android.AndroidDispatcher;
import io.github.mmm.ui.android.AndroidToggleGroup;
import io.github.mmm.ui.api.UiDispatcher;
import io.github.mmm.ui.api.UiToggleGroup;
import io.github.mmm.ui.spi.AbstractUiContext;

/**
 * Implementation of {@link io.github.mmm.ui.api.UiContext} for android.
 *
 * @since 1.0.0
 */
public class AndroidContext extends AbstractUiContext {

  private static Context context;

  private final AndroidDispatcher dispatcher;

  /**
   * The constructor.
   */
  public AndroidContext() {

    this(null);
  }

  /**
   * The constructor.
   *
   * @param context the android {@link Context}.
   */
  public AndroidContext(Context context) {

    super();
    AndroidContext.context = context;
    this.dispatcher = new AndroidDispatcher();
  }

  /**
   * @return the native android {@link Context}.
   */
  public static Context getContext() {

    return context;
  }

  /**
   * @return the native android {@link WindowManager}.
   */
  public static WindowManager getWindowManager() {

    return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
  }

  /**
   * @param context the native android {@link Context} to be initialized when the
   *        {@link io.github.mmm.ui.android.AndroidApplication} is launched.
   */
  public static void setContext(Context context) {

    if (AndroidContext.context != null) {
      if (AndroidContext.context == context) {
        return;
      }
      throw new IllegalStateException();
    }
    AndroidContext.context = context;
  }

  @Override
  public UiDispatcher getDispatcher() {

    return this.dispatcher;
  }

  @Override
  public UiToggleGroup createToggleGroup() {

    return new AndroidToggleGroup(getContext());
  }

}
