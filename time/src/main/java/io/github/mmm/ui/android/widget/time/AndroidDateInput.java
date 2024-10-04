/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.time;

import java.time.LocalDate;

import android.widget.DatePicker;
import io.github.mmm.ui.android.widget.input.AbstractAndroidTextualInput;
import io.github.mmm.ui.api.widget.time.UiDateInput;

/**
 * Implementation of {@link UiDateInput} for Android.
 *
 * @since 1.0.0
 */
public class AndroidDateInput extends AbstractAndroidTextualInput<DatePicker, LocalDate> implements UiDateInput {

  /**
   * The constructor.
   */
  public AndroidDateInput() {

    super(new DatePicker(getContext()));
  }

  @Override
  public LocalDate getValueOrThrow() {

    int dayOfMonth = this.widget.getDayOfMonth();
    if (dayOfMonth < 0) {
      return null;
    }
    int month = this.widget.getMonth();
    if (month < 0) {
      return null;
    }
    int year = this.widget.getYear();
    return LocalDate.of(year, month + 1, dayOfMonth);
  }

  @Override
  protected void setValueNative(LocalDate value) {

    this.widget.init(ACCESS_KEY_NONE, ACCESS_KEY_NONE, ACCESS_KEY_NONE, null);
  }

  @Override
  public String getText() {

    int dayOfMonth = this.widget.getDayOfMonth();
    if (dayOfMonth < 0) {
      return "";
    }
    int month = this.widget.getMonth();
    if (month < 0) {
      return "";
    }
    int year = this.widget.getYear();
    return year + "-" + month + "-" + dayOfMonth;
  }

  @Override
  public void setText(String text) {

    // unsupported
  }

}
