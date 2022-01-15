/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.tab;

import android.app.ActionBar.Tab;
import android.view.View;
import io.github.mmm.ui.android.widget.AndroidWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.tab.UiTab;

/**
 * Implementation of {@link UiTab} for android.
 *
 * @since 1.0.0
 */
public class AndroidTab extends AndroidWidget<Tab> implements UiTab {

  private String text;

  private UiRegularWidget child;

  /**
   * The constructor.
   *
   * @param tab the {@link #getWidget() android widget}.
   */
  public AndroidTab(Tab tab) {

    super(tab);
  }

  @Override
  public View getTopWidget() {

    return null;
  }

  private AndroidTabPanel getTabPanel() {

    return (AndroidTabPanel) getParent();
  }

  @Override
  public void setChild(UiRegularWidget child) {

    if (child == this.child) {
      return;
    }
    if (this.child != null) {
      setParent(this.child, null);
    }
    this.widget.setContent(getTopWidget(child));
    this.child = child;
    setParent(child, this);
  }

  @Override
  public UiRegularWidget getChild() {

    return this.child;
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

  @Override
  protected void setIdNative(String id) {

    super.setIdNative(id);
    this.widget.setTag(id);
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    AndroidTabPanel tabPanel = getTabPanel();
    if (tabPanel != null) {
      tabPanel.setTabVisible(this, visible);
    }
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.widget.setDisable(!enabled);
  }

  @Override
  public char getAccessKey() {

    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void setAccessKey(char accessKey) {

    // TODO Auto-generated method stub

  }

  @Override
  public boolean isFocused() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean setFocused() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isClosable() {

    return this.widget.isClosable();
  }

  @Override
  public void setClosable(boolean closable) {

    this.widget.setClosable(closable);
    if (closable) {
      ensureHandlers();
    }
  }

  /**
   * @param tab the android {@link Tab}.
   * @return the owning {@link AndroidTab}.
   */
  public static AndroidTab get(Tab tab) {

    return (AndroidTab) tab.getUserData();
  }

}
