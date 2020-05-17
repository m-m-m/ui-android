/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of the number widgets for android.
 *
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.android.number {

  requires transitive io.github.mmm.ui.android.core;

  requires transitive io.github.mmm.ui.api.number;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.android.factory.number.AndroidFactoryIntegerInput, //
      io.github.mmm.ui.android.factory.number.AndroidFactoryIntegerSlider //
  ;

  exports io.github.mmm.ui.android.widget.number;

}
