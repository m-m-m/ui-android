/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import android.view.View;
import io.github.mmm.ui.api.widget.input.UiTextualInput;

/**
 * Implementation of {@link UiTextualInput} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class AbstractAndroidTextualInput<W extends View, V> extends AndroidInput<W, V>
    implements UiTextualInput<V> {

  private String autocomplete;

  private String placeholder;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AbstractAndroidTextualInput(W widget) {

    super(widget);
  }

  @Override
  public String getPlaceholder() {

    return this.placeholder;
  }

  @Override
  public void setPlaceholder(String placeholder) {

    this.placeholder = placeholder;
  }

  @Override
  public String getAutocomplete() {

    return this.autocomplete;
  }

  @Override
  public void setAutocomplete(String autocomplete) {

    // Not supported by android
    this.autocomplete = autocomplete;
  }

}
