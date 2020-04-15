/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android;

import android.content.Context;
import android.widget.RadioGroup;
import io.github.mmm.ui.api.UiToggleGroup;

/**
 * Implementation of {@link UiToggleGroup} for android.
 *
 * @since 1.0.0
 */
public class AndroidToggleGroup implements UiToggleGroup {

  private final RadioGroup group;

  /**
   * The constructor.
   *
   * @param context the android {@link Context}.
   */
  public AndroidToggleGroup(Context context) {

    super();
    this.group = new RadioGroup(context);
  }

  /**
   * @return the native android {@link RadioGroup}.
   */
  @Override
  public RadioGroup getGroup() {

    return this.group;
  }

}
