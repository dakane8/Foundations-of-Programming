package com.comp301.a01sushi;

public class Sashimi implements Sushi {

  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  SashimiType type;
  IngredientPortions portion;

  public Sashimi(SashimiType type) {

    this.type = type;

    if (type == SashimiType.TUNA) {
      portion = new TunaPortion(.75);
    }

    if (type == SashimiType.YELLOWTAIL) {
      portion = new YellowtailPortion(.75);
    }

    if (type == SashimiType.EEL) {
      portion = new EelPortion(.75);
    }

    if (type == SashimiType.CRAB) {
      portion = new CrabPortion(.75);
    }

    if (type == SashimiType.SHRIMP) {
      portion = new ShrimpPortion(.75);
    }
  }

  public String getName() {
    return portion.getIngredient().getName() + " sashimi";
  }

  public IngredientPortion[] getIngredients() {
    return new IngredientPortion[] {portion};
  }

  public int getCalories() {
    return (int) (portion.getCalories() + .5);
  }

  public double getCost() {
    return portion.getCost();
  }

  public boolean getHasRice() {
    return false;
  }

  public boolean getHasShellfish() {
    return portion.getIsShellfish();
  }

  public boolean getIsVegetarian() {
    return false;
  }
}
