package com.comp301.a06image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureImage implements Image {

  private final String pathname;
  private final BufferedImage image;
  private final int width;
  private final int height;

  public PictureImage(String pathname) throws IOException {
    this.pathname = pathname;
    image = ImageIO.read(new File(pathname));
    width = image.getWidth();
    height = image.getHeight();
  }

  @Override
  public Color getPixelColor(int x, int y) {
    return new Color(image.getRGB(x, y));
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
