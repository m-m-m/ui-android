/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.button;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import io.github.mmm.ui.android.widget.AndroidClickableWidget;
import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.api.widget.img.UiAbstractImage;

/**
 * Implementation of {@link UiButton} using android {@link Button}.
 *
 * @since 1.0.0
 */
public class AndroidButton extends AndroidClickableWidget<Button> implements UiButton {

  private String text;

  private UiAbstractImage icon;

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
  public UiAbstractImage getImage() {

    return this.icon;
  }

  @Override
  public void setImage(UiAbstractImage icon) {

    // TODO: use MaterialButton
    this.icon = icon;
    Drawable drawable = null;
    if (icon != null) {
      View view = getTopWidget(icon);
      if (view instanceof ImageView) {
        drawable = ((ImageView) view).getDrawable();
      }
    }
    this.widget.setCompoundDrawables(drawable, null, null, null);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    super.setEnabledNative(enabled);
    this.widget.setEnabled(enabled);
  }

}
