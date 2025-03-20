package com.comp301.a06image;

import java.awt.*;

public class SquareDecorator implements Image {

  private final Image image;
  private final int size;
  private final Color color;
  private final int squareX;
  private final int squareY;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    if (squareSize < 0 || image == null) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.size = squareSize;
    this.color = color;
    this.squareX = squareX;
    this.squareY = squareY;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x >= squareX && x < squareX + size && y >= squareY && y < squareY + size) {
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
