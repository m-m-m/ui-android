/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.tab;

import io.github.mmm.ui.api.widget.tab.UiTabPanel;

/**
 * Implementation of {@link UiTabPanel} for android.
 *
 * @since 1.0.0
 */
public class AndroidTabPanel { // extends AndroidMutableComposite<TabLayout, UiTab> implements UiTabPanel {

  /**
   * The constructor.
   */
  public AndroidTabPanel() {

    // super(new TabLayout(getContext()));
  }

  // private Tab getTab(UiTab child) {
  //
  // return ((AndroidTab) child).getWidget();
  // }
  //
  // @Override
  // public UiTab addTab(String text, UiRegularWidget child, int index) {
  //
  // Tab aTab = this.widget.newTab();
  // AndroidTab tab = new AndroidTab(aTab);
  // tab.setText(text);
  // tab.setChild(child);
  // this.widget.addTab(index, aTab);
  // return tab;
  // }
  //
  // @Override
  // protected void addChildWidget(UiTab child, int index) {
  //
  // AndroidTab fxTab = (AndroidTab) child;
  // if (index == -1) {
  // this.widget.getTabs().add(fxTab.getWidget());
  // } else {
  // this.widget.getTabs().add(index, fxTab.getWidget());
  // }
  // }
  //
  // @Override
  // protected void removeChildWidget(UiTab child, int index) {
  //
  // this.widget.getTabs().remove(index);
  // }
  //
  // @Override
  // public UiTab getActiveChild() {
  //
  // Tab tab = this.widget.getSelectionModel().getSelectedItem();
  // if (tab == null) {
  // return null;
  // }
  // return AndroidTab.get(tab);
  // }
  //
  // @Override
  // public int getActiveChildIndex() {
  //
  // UiTab tab = getActiveChild();
  // if (tab == null) {
  // return -1;
  // }
  // return this.children.indexOf(tab);
  // }
  //
  // @Override
  // public boolean setActiveChild(UiTab child) {
  //
  // this.widget.getSelectionModel().select(getTab(child));
  // return true;
  // }
  //
  // /**
  // * @param fxTab the {@link AndroidTab} to change visibility.
  // * @param visible - {@code true} to show, {@code false} to hide.
  // */
  // public void setTabVisible(AndroidTab fxTab, boolean visible) {
  //
  // ObservableList<Tab> tabs = this.widget.getTabs();
  // if (visible) {
  // int index = 0;
  // for (UiTab uiTab : this.children) {
  // if (uiTab == fxTab) {
  // tabs.add(index, fxTab.getWidget());
  // break;
  // } else {
  // if (uiTab.isVisible(UiVisibleFlags.ANY)) {
  // index++;
  // }
  // }
  // }
  // } else {
  // tabs.remove(fxTab.getWidget());
  // }
  // }

}
