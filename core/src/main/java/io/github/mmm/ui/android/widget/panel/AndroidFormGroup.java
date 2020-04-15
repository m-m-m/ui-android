/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.panel;

import android.view.View;
import android.widget.GridLayout;
import io.github.mmm.ui.android.widget.composite.AndroidValuedComposite;
import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.api.widget.panel.UiFormGroup;

/**
 * Implementation of {@link UiFormGroup} for android.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class AndroidFormGroup<V> extends AndroidValuedComposite<GridLayout, UiInput<?>, V> implements UiFormGroup<V> {

  // private final CollapsingToolbarLayout topWidget;

  private String name;

  private boolean collapsed;

  private boolean collapsible;

  /**
   * The constructor.
   */
  public AndroidFormGroup() {

    super(new GridLayout(getContext()));
    // this.topWidget = new CollapsingToolbarLayout(getContext());
    // this.topWidget.addView(this.widget);
  }

  // @Override
  // public View getTopWidget() {
  //
  // return this.topWidget;
  // }

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public boolean isCollapsed() {

    return this.collapsed;
  }

  @Override
  public void setCollapsed(boolean collapsed) {

    this.collapsed = collapsed;
  }

  @Override
  public boolean isCollapsible() {

    return this.collapsible;
  }

  @Override
  public void setCollapsible(boolean collapsible) {

    this.collapsible = collapsible;
  }

  @Override
  protected void addChildWidget(UiInput<?> child, int index) {

    int rows = this.children.size();
    View childView = getTopWidget(child);
    UiLabel label = child.getNameWidget();
    View labelView = getTopWidget(label);
    if ((index == -1) || (index == rows)) {
      this.widget.addView(labelView);
      this.widget.addView(childView);
    } else {
      int i = index * 2;
      this.widget.addView(labelView, i++);
      this.widget.addView(childView, i++);
    }
  }

  @Override
  protected void removeChildWidget(UiInput<?> child, int index) {

    int i = index * 2;
    this.widget.removeViewAt(i);
    this.widget.removeViewAt(i);
  }

}
