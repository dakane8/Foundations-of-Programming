package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {

  private final Image image;
  private final int thiccness;
  private final Color borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if (thiccness < 0 || image == null) {
      throw new IllegalArgumentException("border thiccness cant be neg or image not null");
    }
    this.image = image;
    this.thiccness = thiccness;
    this.borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
      throw new IllegalArgumentException("x or y out of bounds");
    }
    if (x < thiccness
        || x >= getWidth() - thiccness
        || y < thiccness
        || y >= getHeight() - thiccness) {
      return borderColor;
    }
    return image.getPixelColor(x - thiccness, y - thiccness);
  }

  @Override
  public int getWidth() {
    return image.getWidth() + (2 * thiccness);
  }

  @Override
  public int getHeight() {
    return image.getHeight() + (2 * thiccness);
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
