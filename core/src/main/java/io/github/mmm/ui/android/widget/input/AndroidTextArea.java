/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import android.view.inputmethod.EditorInfo;
import io.github.mmm.ui.api.widget.input.UiTextArea;

/**
 * Implementation of {@link UiTextArea} for android.
 *
 * @since 1.0.0
 */
public class AndroidTextArea extends AndroidStringInput implements UiTextArea {

  /**
   * The constructor.
   */
  public AndroidTextArea() {

    super();
    this.widget.setSingleLine(false);
    this.widget.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
  }

}
