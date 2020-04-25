/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android;

import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import io.github.mmm.ui.spi.AbstractUiScreen;

/**
 * Implementation of {@link io.github.mmm.ui.api.UiScreen} for android.
 *
 * @since 1.0.0
 */
public class AndroidScreen extends AbstractUiScreen {

  private Display display;

  /**
   * The constructor.
   */
  public AndroidScreen() {

    this(null);
  }

  /**
   * The constructor.
   *
   * @param display the android {@link Display}.
   */
  public AndroidScreen(Display display) {

    super();
    this.display = display;
  }

  /**
   * @return display
   */
  public Display getDisplay() {

    if (this.display == null) {
      this.display = AndroidApplication.getWindowManager().getDefaultDisplay();
    }
    return this.display;
  }

  @Override
  protected void doUpdate() {

    Point dimensions = new Point();
    getDisplay().getSize(dimensions);
    this.width = dimensions.x;
    this.height = dimensions.y;
    DisplayMetrics metrics = new DisplayMetrics();
    getDisplay().getMetrics(metrics);
    this.dpi = metrics.densityDpi;
  }

}
