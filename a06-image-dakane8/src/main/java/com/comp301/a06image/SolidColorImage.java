package com.comp301.a06image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SolidColorImage implements Image {
  private final int width;
  private final int height;
  private final Color color;

  public SolidColorImage(int width, int height, Color color) {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException();
    }
    this.width = width;
    this.height = height;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= width || y >= height) {
      throw new IllegalArgumentException();
    }
    return color;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getNumLayers() {
    return 1;
  }
}
