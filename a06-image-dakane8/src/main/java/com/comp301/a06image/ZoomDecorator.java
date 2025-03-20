package com.comp301.a06image;

import java.awt.*;

public class ZoomDecorator implements Image {

  private final Image image;
  private final int multiplier;

  public ZoomDecorator(Image image, int multiplier) {
    if (image == null) {
      throw new IllegalArgumentException("image cannot be null");
    }
    if (multiplier <= 0) {
      throw new IllegalArgumentException("multiplier cannot be negative");
    }
    this.image = image;
    this.multiplier = multiplier;
  }

  public ZoomDecorator(Image image) {
    this(image, 2);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
      throw new IllegalArgumentException("x or y out of bounds");
    }
    int originalX = x / multiplier;
    int originalY = y / multiplier;
    return image.getPixelColor(originalX, originalY);
  }

  @Override
  public int getWidth() {
    return image.getWidth() * multiplier;
  }

  @Override
  public int getHeight() {
    return image.getHeight() * multiplier;
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
