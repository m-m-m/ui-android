/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of the form widgets for android.
 *
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.android.form {

  requires transitive io.github.mmm.ui.api.form;

  requires transitive io.github.mmm.ui.android.core;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.android.factory.form.AndroidFactoryFormGroup, //
      io.github.mmm.ui.android.factory.form.AndroidFactoryFormPanel //
  ;

  exports io.github.mmm.ui.android.widget.form;

}
