/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget;

import android.widget.TextView;
import io.github.mmm.ui.api.datatype.UiTextAlignment;
import io.github.mmm.ui.api.widget.UiText;

/**
 * Implementation of {@link UiText} for android.
 *
 * @since 1.0.0
 */
public class AndroidText extends AndroidWidgetView<TextView> implements UiText {

  private String text;

  private UiTextAlignment alignment;

  /**
   * The constructor.
   */
  public AndroidText() {

    super(new TextView(getContext()));
    this.alignment = UiTextAlignment.LEFT;
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

  @Override
  public UiTextAlignment getAlignment() {

    return this.alignment;
  }

  @Override
  public void setAlignment(UiTextAlignment alignment) {

    if (this.alignment == alignment) {
      return;
    }
    // Android sucks and is so lame...
    // LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
    // convertDpToPixel(23));
    // params.gravity = Gravity.CENTER_HORIZONTAL;
    // this.widget.setLayoutParams(params);
    // this.widget.getLayout().getAlignment();
    // this.widget.setJustificationMode;
    this.alignment = alignment;
  }

}
