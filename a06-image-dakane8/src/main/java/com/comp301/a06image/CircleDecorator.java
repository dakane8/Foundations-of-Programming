package com.comp301.a06image;

import java.awt.*;

import static java.lang.Math.sqrt;

public class CircleDecorator implements Image {
  private final Image image;
  private final int centerX;
  private final int centerY;
  private final int radius;
  private final Color color;

  public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
    if (radius < 0 || image == null) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.centerX = cx;
    this.centerY = cy;
    this.radius = radius;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    int distance = (int) sqrt((Math.pow((x - centerX), 2)) + (Math.pow((y - centerY), 2)));
    if (distance < radius) {
      return color;
    }
    return image.getPixelColor(x, y);
  }

  @Override
  public int getWidth() {
    return image.getWidth();
  }

  @Override
  public int getHeight() {
    return image.getHeight();
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
