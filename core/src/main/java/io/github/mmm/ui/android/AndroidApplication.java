/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android;

import android.app.Application;
import io.github.mmm.ui.android.context.AndroidContext;

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

  @Override
  public void onCreate() {

    AndroidContext.setContext(getApplicationContext());
    super.onCreate();
  }

}
