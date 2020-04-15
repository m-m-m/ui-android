/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import android.widget.RadioButton;
import io.github.mmm.ui.android.AndroidToggleGroup;
import io.github.mmm.ui.api.UiToggleGroup;
import io.github.mmm.ui.api.widget.input.UiRadioButton;

/**
 * Implementation of {@link UiRadioButton} using android {@link RadioButton}.
 *
 * @since 1.0.0
 */
public class AndroidRadioButton extends AndroidSelectionInput<RadioButton> implements UiRadioButton {

  private AndroidToggleGroup toggleGroup;

  /**
   * The constructor.
   */
  public AndroidRadioButton() {

    super(new RadioButton(getContext()));
  }

  @Override
  public AndroidToggleGroup getToggleGroup() {

    return this.toggleGroup;
  }

  @Override
  public void setToggleGroup(UiToggleGroup group) {

    this.toggleGroup = (AndroidToggleGroup) group;
    this.toggleGroup.getGroup().addView(this.widget);
  }

}
