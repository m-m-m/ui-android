/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of the core UI for android.
 *
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 */
module io.github.mmm.ui.android.time {

  requires transitive io.github.mmm.ui.android.core;

  requires transitive io.github.mmm.ui.api.time;

  exports io.github.mmm.ui.android.widget.time;

}
