/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import java.nio.channels.IllegalSelectorException;

import android.widget.LinearLayout;
import io.github.mmm.ui.android.widget.AndroidWidgetView;
import io.github.mmm.ui.api.datatype.UiEnabledFlags;
import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.api.widget.input.UiInputContainer;

/**
 * {@link AndroidInput#getContainerWidget() Input container widget} for android.
 *
 * @param <V> type of the {@link UiInput#getValue() input value}.
 * @since 1.0.0
 */
public class AndroidInputContainer<V> extends AndroidWidgetView<LinearLayout> implements UiInputContainer<V> {

  private UiInput<V> child;

  /**
   * The constructor.
   */
  public AndroidInputContainer() {

    super(new LinearLayout(getContext()));
  }

  @Override
  public UiInput<V> getChild() {

    return this.child;
  }

  @Override
  public void setChild(UiInput<V> child) {

    if (this.child != null) {
      throw new IllegalSelectorException();
    }
    this.child = child;
    UiLabel nameWidget = child.getNameWidget();
    this.widget.addView(getTopWidget(nameWidget));
    setParent(nameWidget, this);
    this.widget.addView(getTopWidget(child));
    setParent(child, this);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    super.setEnabledNative(enabled);
    this.child.setEnabled(enabled, UiEnabledFlags.PARENT);
  }

}
