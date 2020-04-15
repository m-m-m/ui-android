/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.button;

import android.widget.Button;
import io.github.mmm.ui.android.widget.AndroidClickableWidget;
import io.github.mmm.ui.api.widget.button.UiButton;

/**
 * Implementation of {@link UiButton} using android {@link Button}.
 *
 * @since 1.0.0
 */
public class AndroidButton extends AndroidClickableWidget<Button> implements UiButton {

  private String text;

  /**
   * The constructor.
   */
  public AndroidButton() {

    super(new Button(getContext()));
  }

  @Override
  public String getText() {

    return this.text;
  }

  @Override
  public void setText(String text) {

    this.widget.setText(text);
    this.text = text;
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    super.setEnabledNative(enabled);
    this.widget.setEnabled(enabled);
  }

}
