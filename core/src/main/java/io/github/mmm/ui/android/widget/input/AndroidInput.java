/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.input;

import android.view.View;
import io.github.mmm.ui.android.widget.AndroidActiveWidget;
import io.github.mmm.ui.android.widget.AndroidLabel;
import io.github.mmm.ui.api.datatype.bitmask.BitMask;
import io.github.mmm.ui.api.event.UiValueChangeEvent;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.form.UiInputContainer;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.validation.Validator;

/**
 * Implementation of {@link UiInput} using android.
 *
 * @param <W> type of {@link #getWidget() android widget}.
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class AndroidInput<W extends View, V> extends AndroidActiveWidget<W> implements UiInput<V> {

  private String name;

  private AndroidLabel nameWidget;

  private UiInputContainer<V> containerWidget;

  private Validator<? super V> validator;

  private V originalValue;

  private long modificationTimestamp;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() android widget}.
   */
  public AndroidInput(W widget) {

    super(widget);
    this.validator = Validator.none();
    this.modificationTimestamp = -1;
  }

  @Override
  public String getName() {

    if (this.nameWidget == null) {
      return this.name;
    } else {
      return this.nameWidget.getText();
    }
  }

  @Override
  public void setName(String name) {

    if (this.nameWidget == null) {
      this.name = name;
    } else {
      this.nameWidget.setText(name);
    }
  }

  @Override
  public boolean hasNameWidget() {

    return (this.nameWidget != null);
  }

  @Override
  public AndroidLabel getNameWidget() {

    if (this.nameWidget == null) {
      this.nameWidget = new AndroidLabel();
      if (this.name != null) {
        this.nameWidget.setText(this.name);
      }
      doSetVisibleState(this.nameWidget, doGetVisibleState(this));
      String id = getId();
      if (id != null) {
        this.nameWidget.setId(id + "_label");
      }
    }
    return this.nameWidget;
  }

  @Override
  public boolean hasContainerWidget() {

    return (this.containerWidget != null);
  }

  @Override
  public UiRegularWidget getContainerWidget() {

    if (this.containerWidget == null) {
      this.containerWidget = UiInputContainer.of(this);
    }
    return this.containerWidget;
  }

  @Override
  public void setVisible(boolean visible, BitMask flagMode) {

    super.setVisible(visible, flagMode);
    if (this.nameWidget != null) {
      this.nameWidget.setVisible(visible, flagMode);
    }
  }

  @Override
  public V getOriginalValue() {

    return this.originalValue;
  }

  @Override
  public void setOriginalValue(V originalValue) {

    this.originalValue = originalValue;
  }

  // @Override
  // protected void doSetValidationFailure(String error) {
  //
  // }

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
  public long getModificationTimestamp() {

    return this.modificationTimestamp;
  }

  private void updateModificationTimestamp(boolean reset) {

    if (reset) {
      this.modificationTimestamp = -1;
    } else {
      this.modificationTimestamp = System.currentTimeMillis();
    }
  }

  @Override
  public void setValue(V value, boolean forUser) {

    updateModificationTimestamp(!forUser);
    if (!forUser) {
      setOriginalValue(value);
    }
    setProgrammaticEventType(UiValueChangeEvent.TYPE);
    setValueNative(value);
  }

  /**
   * @param value the new {@link #getValue() value} to set in the native widget.
   */
  protected abstract void setValueNative(V value);

  /**
   * Called when the value has changed.
   */
  protected void onValueChanged() {

    boolean programmatic = getProgrammaticEventType() == UiValueChangeEvent.TYPE;
    onValueChanged(programmatic);
    fireEvent(new UiValueChangeEvent(this, programmatic));
  }

  /**
   * @param programmatic - see {@link io.github.mmm.ui.api.event.UiEvent#isProgrammatic()}.
   */
  protected void onValueChanged(boolean programmatic) {

    if (!programmatic) {
      updateModificationTimestamp(false);
    }
  }

}
