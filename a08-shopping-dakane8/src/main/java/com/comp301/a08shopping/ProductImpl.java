package com.comp301.a08shopping;

public class ProductImpl implements Product {

  private final String name;
  private final double basePrice;
  private int inventory;
  private double percentOff;
  private double discountPrice;

  public ProductImpl(String name, double basePrice, int inventory, double percentOff) {
    if (basePrice <= 0) {
      throw new IllegalArgumentException("base price must be greater than zero");
    }
    this.name = name;
    this.basePrice = basePrice;
    this.inventory = inventory;
    this.percentOff = percentOff;
  }

  public ProductImpl(String name, double basePrice, int inventory) {
    this(name, basePrice, inventory, 0);
  }

  public ProductImpl(String name, double basePrice) {
    this(name, basePrice, 0, 0);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getBasePrice() {
    return this.basePrice;
  }

  public int getInventory() {
    return this.inventory;
  }

  public double getPercentOff() {
    return this.percentOff;
  }

  public double getDiscountPrice() {
    return this.basePrice * (1 - this.percentOff);
  }

  public void addInventory(int numItems) {
    if (numItems < 0) {
      throw new IllegalArgumentException("inventory must be greater than zero");
    }
    this.inventory += numItems;
  }

  public void subInventory() {
    if (inventory == 0) {
      throw new IllegalStateException("inventory must be greater than zero");
    }
    this.inventory--;
  }

  public void setPercentOff(double percentOff) {
    this.percentOff = percentOff;
  }
}
