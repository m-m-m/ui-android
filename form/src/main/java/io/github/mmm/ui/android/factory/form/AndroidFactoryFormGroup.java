/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.factory.form;

import io.github.mmm.ui.android.widget.form.AndroidFormGroup;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.form.UiFormGroup;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiFormGroup}.
 *
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
public class AndroidFactoryFormGroup implements UiSingleWidgetFactoryNative<UiFormGroup> {

  @Override
  public Class<UiFormGroup> getType() {

    return UiFormGroup.class;
  }

  @Override
  public UiFormGroup create() {

    return new AndroidFormGroup();
  }

}
