package com.comp301.a01sushi;

public class Ingredients implements Ingredient {
  String name;
  double price;
  int calories;
  boolean vegetarian;
  boolean rice;
  boolean shellfish;

  public Ingredients(
      String name,
      double price,
      int calories,
      boolean vegetarian,
      boolean rice,
      boolean shellfish) {
    this.name = name;
    this.price = price;
    this.calories = calories;
    this.vegetarian = vegetarian;
    this.rice = rice;
    this.shellfish = shellfish;
  }

  public String getName() {
    return name;
  }

  public double getCaloriesPerDollar() {
    return calories / price;
  }

  public int getCaloriesPerOunce() {
    return calories;
  }

  public double getPricePerOunce() {
    return price;
  }

  public boolean getIsVegetarian() {
    return vegetarian;
  }

  public boolean getIsRice() {
    return rice;
  }

  public boolean getIsShellfish() {
    return shellfish;
  }

  public boolean equals(Ingredient other) {
    if (name.equals(other.getName())
        && price == other.getPricePerOunce()
        && calories == other.getCaloriesPerOunce()
        && vegetarian == other.getIsVegetarian()
        && rice == other.getIsRice()
        && shellfish == other.getIsShellfish()) {
      return true;
    }
    return false;
  }
}
