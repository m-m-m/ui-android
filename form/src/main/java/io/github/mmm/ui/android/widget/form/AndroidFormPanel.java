/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.form;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.TextView;
import io.github.mmm.ui.android.widget.composite.AndroidValuedComposite;
import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.form.UiFormPanel;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;
import io.github.mmm.ui.api.widget.input.UiInput;

/**
 * Implementation of {@link UiFormPanel} for android.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class AndroidFormPanel<V> extends AndroidValuedComposite<GridLayout, UiAbstractInput<?>, V>
    implements UiFormPanel<V> {

  /**
   * The constructor.
   */
  public AndroidFormPanel() {

    super(new GridLayout(getContext()));
    this.widget.setColumnCount(2);
  }

  @Override
  protected void addChildWidget(UiAbstractInput<?> child, int index) {

    int rows = this.children.size();
    View childView = getTopWidget(child);
    if (child instanceof UiInput) {
      UiInput<?> input = (UiInput<?>) child;
      UiLabel label = input.getNameWidget();
      View labelView = getTopWidget(label);
      if ((index == -1) || (index == rows)) {
        this.widget.addView(labelView);
        this.widget.addView(childView);
      } else {
        int i = index * 2;
        this.widget.addView(labelView, i++);
        this.widget.addView(childView, i++);
      }
    } else {
      LayoutParams params = new LayoutParams(1, 2);
      View dummyView = new TextView(getContext());
      dummyView.setVisibility(View.GONE);
      if ((index == -1) || (index == rows)) {
        this.widget.addView(childView, params);
        this.widget.addView(dummyView, params);
      } else {
        int i = index * 2;
        this.widget.addView(childView, i++, params);
        this.widget.addView(dummyView, i++, params);
      }
    }
  }

  @Override
  protected void removeChildWidget(UiAbstractInput<?> child, int index) {

    int i = index * 2;
    this.widget.removeViewAt(i);
    this.widget.removeViewAt(i);
  }

}
