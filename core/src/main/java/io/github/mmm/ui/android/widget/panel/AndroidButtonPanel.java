/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.panel;

import android.widget.LinearLayout;
import io.github.mmm.ui.android.widget.composite.AndroidMutableCompositeViewGroup;
import io.github.mmm.ui.api.widget.button.UiAbstractButton;
import io.github.mmm.ui.api.widget.panel.UiButtonPanel;

/**
 * Implementation of {@link UiButtonPanel} for android.
 *
 * @since 1.0.0
 */
public class AndroidButtonPanel extends AndroidMutableCompositeViewGroup<LinearLayout, UiAbstractButton>
    implements UiButtonPanel {

  /**
   * The constructor.
   */
  public AndroidButtonPanel() {

    super(new LinearLayout(getContext()));
    this.widget.setOrientation(LinearLayout.HORIZONTAL);
  }

}
