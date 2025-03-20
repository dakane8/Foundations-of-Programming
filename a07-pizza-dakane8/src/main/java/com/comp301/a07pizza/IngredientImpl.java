package com.comp301.a07pizza;

public class IngredientImpl implements Ingredient {
  String name;
  boolean vegetarian;
  boolean vegan;

  public IngredientImpl(String name, boolean vegetarian, boolean vegan) {
    this.name = name;
    this.vegetarian = vegetarian;
    this.vegan = vegan;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public boolean isVegetarian() {
    return this.vegetarian;
  }

  @Override
  public boolean isVegan() {
    return this.vegan;
  }
}
