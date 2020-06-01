/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.img;

import android.view.View;
import io.github.mmm.ui.android.widget.AndroidWidgetView;
import io.github.mmm.ui.api.widget.img.UiAbstractImage;

/**
 * Implementation of {@link UiAbstractImage} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @since 1.0.0
 */
public abstract class AndroidAbstractImage<W extends View> extends AndroidWidgetView<W> implements UiAbstractImage {

  private String altText;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidAbstractImage(W widget) {

    super(widget);
  }

  @Override
  public String getAltText() {

    return this.altText;
  }

  @Override
  public void setAltText(String altText) {

    this.altText = altText;
    this.widget.setContentDescription(altText);
  }

}
