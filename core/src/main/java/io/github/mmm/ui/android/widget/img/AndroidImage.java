/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android.widget.img;

import android.net.Uri;
import android.widget.ImageView;
import io.github.mmm.ui.api.datatype.UiSize;
import io.github.mmm.ui.api.datatype.UiSizeUnit;
import io.github.mmm.ui.api.widget.img.UiImage;

/**
 * Implementation of {@link UiImage} for android using {@link ImageView}.
 *
 * @since 1.0.0
 */
public class AndroidImage extends AndroidAbstractImage<ImageView> implements UiImage {

  private String source;

  private UiSize width;

  private UiSize height;

  /**
   * The constructor.
   */
  public AndroidImage() {

    super(new ImageView(getContext()));
    this.width = UiSize.AUTO;
    this.height = UiSize.AUTO;
  }

  @Override
  public String getSource() {

    return this.source;
  }

  @Override
  public void setSource(String source) {

    Uri uri = Uri.parse(source);
    this.widget.setImageURI(uri);
    this.source = source;
  }

  @Override
  public UiSize getWidth() {

    return this.width;
  }

  @Override
  public double getWidthInPixel() {

    return this.widget.getWidth();
  }

  @Override
  public void setWidth(UiSize width) {

    width = UiSize.getSafe(width);
    UiSizeUnit unit = width.getUnit();
    if (unit == null) {
      this.widget.setScaleX(1);
    } else {
      switch (unit) {
        case PERCENT:
          this.widget.setScaleX((float) (100d / width.getAmount()));
          break;
        case PIXEL:
          this.widget.setScaleX((float) (width.getAmount() / this.widget.getWidth()));
          break;
        default:
          this.widget.setScaleX((float) (width.toPixel(1) / this.widget.getWidth()));
      }
    }
    this.width = width;
  }

  @Override
  public UiSize getHeight() {

    return this.height;
  }

  @Override
  public double getHeightInPixel() {

    return this.widget.getHeight();
  }

  @Override
  public void setHeight(UiSize height) {

    height = UiSize.getSafe(height);
    UiSizeUnit unit = height.getUnit();
    if (unit == null) {
      this.widget.setScaleY(1);
    } else {
      switch (unit) {
        case PERCENT:
          this.widget.setScaleY((float) (100d / height.getAmount()));
          break;
        case PIXEL:
          this.widget.setScaleX((float) (height.getAmount() / this.widget.getHeight()));
          break;
        default:
          this.widget.setScaleX((float) (height.toPixel(1) / this.widget.getHeight()));
      }
    }
    this.height = height;
  }

}
