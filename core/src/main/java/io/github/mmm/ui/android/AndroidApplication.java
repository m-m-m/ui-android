/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android;

import android.app.Application;
import android.content.Context;
import android.view.WindowManager;

/**
 * Base class for you main application to build your client with Android.<br>
 * Example:
 *
 * <pre>
 * public class MyAnrdroidApp extends {@link AndroidApplication} {
 *
 *   public void onCreate() {
 *     super.onCreate();
 *     // add your custom code here if needed...
 *   }
 * }
 * </pre>
 */
public class AndroidApplication extends Application {

  private static Context androidContext;

  @Override
  public void onCreate() {

    androidContext = getApplicationContext();
    super.onCreate();
  }

  /**
   * @return the android {@link Context}.
   */
  public static Context getAndroidContext() {

    if (androidContext == null) {
      throw new IllegalStateException("onCreate has not been called!");
    }
    return androidContext;
  }

  /**
   * @return the native android {@link WindowManager}.
   */
  public static WindowManager getWindowManager() {

    return (WindowManager) getAndroidContext().getSystemService(Context.WINDOW_SERVICE);
  }

}
