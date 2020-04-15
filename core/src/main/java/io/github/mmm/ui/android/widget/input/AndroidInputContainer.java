/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import android.widget.LinearLayout;
import io.github.mmm.ui.android.widget.AndroidAtomicWidget;

/**
 * {@link AndroidInput#getContainerWidget() Input container widget} for android.
 *
 * @since 1.0.0
 */
public class AndroidInputContainer extends AndroidAtomicWidget<LinearLayout> {

  /**
   * The constructor.
   *
   * @param input the {@link AndroidInput}.
   */
  public AndroidInputContainer(AndroidInput<?, ?> input) {

    super(new LinearLayout(getContext()));
    this.widget.addView(input.getNameWidget().getWidget());
    this.widget.addView(input.getWidget());
  }

}
