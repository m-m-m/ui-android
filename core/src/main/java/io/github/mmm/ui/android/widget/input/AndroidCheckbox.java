/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import android.widget.CheckBox;
import io.github.mmm.ui.api.widget.input.UiCheckbox;
import io.github.mmm.ui.api.widget.input.UiTextInput;

/**
 * Implementation of {@link UiTextInput} for android.
 *
 * @since 1.0.0
 */
public class AndroidCheckbox extends AndroidSelectionInput<CheckBox> implements UiCheckbox {

  /**
   * The constructor.
   */
  public AndroidCheckbox() {

    super(new CheckBox(getContext()));
  }

}
