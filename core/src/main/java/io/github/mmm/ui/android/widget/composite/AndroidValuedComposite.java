/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.composite;

import android.view.ViewGroup;
import io.github.mmm.ui.api.binding.UiValueBinding;
import io.github.mmm.ui.api.event.UiValueChangeEvent;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiValuedComposite;
import io.github.mmm.validation.Validator;

/**
 * Implementation of {@link UiValuedComposite} for android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @param <V> type of the {@link #getValue() value}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class AndroidValuedComposite<W extends ViewGroup, C extends UiWidget, V>
    extends AndroidFailureComposite<W, C> implements UiValuedComposite<C, V> {

  private Validator<? super V> validator;

  private V originalValue;

  private UiValueBinding<V> binding;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidValuedComposite(W widget) {

    super(widget);
    this.validator = Validator.none();
  }

  @Override
  public void initBinding(UiValueBinding<V> newBinding) {

    if (this.binding != null) {
      throw new IllegalStateException();
    }
    this.binding = newBinding;
    this.binding.setWidget(this);
  }

  @Override
  public V getOriginalValue() {

    return this.originalValue;
  }

  @Override
  public void setOriginalValue(V originalValue) {

    this.originalValue = originalValue;
  }

  @Override
  public Validator<? super V> getValidator() {

    return this.validator;
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    if (validator == null) {
      this.validator = Validator.none();
    } else {
      this.validator = validator;
    }
  }

  @Override
  public V getValueOrThrow() {

    if (this.binding != null) {
      return this.binding.getValue();
    }
    return null;
  }

  @Override
  public void setValue(V value, boolean forUser) {

    if (!forUser) {
      setOriginalValue(value);
    }
    if (this.binding != null) {
      this.binding.setValue(value, forUser);
      fireEvent(new UiValueChangeEvent(this, true));
    }
  }

}
