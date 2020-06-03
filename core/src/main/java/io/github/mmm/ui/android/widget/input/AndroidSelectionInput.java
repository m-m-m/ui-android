/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import android.widget.CompoundButton;
import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.widget.value.UiWidgetWithSelection;

/**
 * Implementation of {@link UiWidgetWithSelection} and {@link io.github.mmm.ui.api.widget.input.UiInput} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @since 1.0.0
 */
public class AndroidSelectionInput<W extends CompoundButton> extends AndroidInput<W, Boolean>
    implements UiWidgetWithSelection, AttributeWriteText {

  private String text;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidSelectionInput(W widget) {

    super(widget);
    this.widget.setOnCheckedChangeListener(this::onCheckedChanged);
  }

  private void onCheckedChanged(CompoundButton button, boolean isChecked) {

    onValueChanged();
  }

  @Override
  public Boolean getValueOrThrow() {

    return Boolean.valueOf(this.widget.isSelected());
  }

  @Override
  public void setValueNative(Boolean selected) {

    this.widget.setSelected(Boolean.TRUE.equals(selected));
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
