/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.time;

import java.time.LocalTime;

import android.widget.TimePicker;
import io.github.mmm.ui.android.widget.input.AbstractAndroidTextualInput;
import io.github.mmm.ui.api.widget.time.UiTimeInput;

/**
 * Implementation of {@link UiTimeInput} for JavaFx.
 *
 * @since 1.0.0
 */
public class AndroidTimeInput extends AbstractAndroidTextualInput<TimePicker, LocalTime> implements UiTimeInput {

  /**
   * The constructor.
   */
  public AndroidTimeInput() {

    super(new TimePicker(getContext()));
    this.widget.setIs24HourView(Boolean.TRUE);
  }

  @Override
  public LocalTime getValueOrThrow() {

    Integer hour = this.widget.getCurrentHour();
    if (hour == null) {
      return null;
    }
    Integer minute = this.widget.getCurrentMinute();
    if (minute == null) {
      return null;
    }
    return LocalTime.of(hour, minute);
  }

  @Override
  protected void setValueNative(LocalTime value) {

    if (value == null) {
      this.widget.setCurrentHour(null);
      this.widget.setCurrentMinute(null);
    } else {
      this.widget.setCurrentHour(value.getHour());
      this.widget.setCurrentMinute(value.getMinute());
    }
  }

  @Override
  public String getText() {

    Integer hour = this.widget.getCurrentHour();
    if (hour == null) {
      return "";
    }
    Integer minute = this.widget.getCurrentMinute();
    if (minute == null) {
      return "";
    }
    return hour + ":" + minute;
  }

  @Override
  public void setText(String text) {

    // not supported
  }

}
