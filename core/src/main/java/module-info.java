/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of the core UI for android.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.android.core {

  requires transitive io.github.mmm.ui.spi.core;

  requires transitive android;

  provides io.github.mmm.ui.api.UiDispatcher with //
      io.github.mmm.ui.android.AndroidDispatcher;

  provides io.github.mmm.ui.api.UiScreen with //
      io.github.mmm.ui.android.AndroidScreen;

  provides io.github.mmm.ui.api.factory.UiToggleGroupFactory with //
      io.github.mmm.ui.android.AndroidToggleGroupFactory;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.android.factory.core.AndroidFactoryButton, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryButtonPanel, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryCheckbox, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryCollapsiblePanel, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryFormGroup, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryFormPanel, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryHorizontalPanel, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryImage, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryIntegerInput, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryIntegerSlider, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryLabel, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryPasswordInput, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryRadioButton, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryRadioChoice, //
      io.github.mmm.ui.android.factory.core.AndroidFactorySlot, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryScrollPanel, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryText, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryTextInput, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryTextArea, //
      io.github.mmm.ui.android.factory.core.AndroidFactoryVerticalPanel //
  ;

  exports io.github.mmm.ui.android;

  exports io.github.mmm.ui.android.widget;

  exports io.github.mmm.ui.android.widget.img;

  exports io.github.mmm.ui.android.widget.composite;

  exports io.github.mmm.ui.android.widget.input;

}
