/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget;

import android.widget.TextView;
import io.github.mmm.ui.api.widget.UiLabel;

/**
 * Implementation of {@link UiLabel} for android.
 *
 * @since 1.0.0
 */
public class AndroidLabel extends AndroidAtomicWidget<TextView> implements UiLabel {

  private String text;

  /**
   * The constructor.
   */
  public AndroidLabel() {

    super(new TextView(getContext()));
  }

  @Override
  public String getText() {

    return this.text;
  }

  @Override
  public void setText(String text) {

    this.text = text;
    this.widget.setText(text);
  }

}
