/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of UI menu widgets for android.
 *
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 */
// @SuppressWarnings("rawtypes") //
module io.github.mmm.ui.android.menu {

  requires transitive io.github.mmm.ui.api.menu;

  requires transitive io.github.mmm.ui.android.core;

  // provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
  // io.github.mmm.ui.android.factory.menu.AndroidFactoryMenuBar, //
  // io.github.mmm.ui.android.factory.menu.AndroidFactoryNavigationBar //
  // ;
  //
  // exports io.github.mmm.ui.android.widget.menu;

}
