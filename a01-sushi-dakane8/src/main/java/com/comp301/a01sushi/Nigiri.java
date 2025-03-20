package com.comp301.a01sushi;

public class Nigiri implements Sushi {

  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  NigiriType type;
  IngredientPortions fish;
  IngredientPortions rice;

  public Nigiri(NigiriType type) {
    this.type = type;
    this.rice = new RicePortion(.5);
    if (type == Nigiri.NigiriType.TUNA) {
      fish = new TunaPortion(.75);
    }

    if (type == Nigiri.NigiriType.YELLOWTAIL) {
      fish = new YellowtailPortion(.75);
    }

    if (type == Nigiri.NigiriType.EEL) {
      fish = new EelPortion(.75);
    }

    if (type == Nigiri.NigiriType.CRAB) {
      fish = new CrabPortion(.75);
    }

    if (type == Nigiri.NigiriType.SHRIMP) {
      fish = new ShrimpPortion(.75);
    }
  }

  public String getName() {
    return fish.getIngredient().getName() + " nigiri";
  }

  public IngredientPortion[] getIngredients() {
    return new IngredientPortion[] {fish, rice};
  }

  public int getCalories() {
    return (int) (fish.getCalories() + rice.getCalories() + .5);
  }

  public double getCost() {
    return fish.getCost() + rice.getCost();
  }

  public boolean getHasRice() {
    return true;
  }

  public boolean getHasShellfish() {
    return fish.getIsShellfish();
  }

  public boolean getIsVegetarian() {
    return false;
  }
}
