package com.comp301.a01sushi;

import java.util.ArrayList;
import java.util.List;

public class Roll implements Sushi {

  String name;
  IngredientPortion[] roll_ingredients;

  public Roll(String name, IngredientPortion[] roll_ingredients) {
    if (name == null || roll_ingredients == null) {
      throw new IllegalArgumentException("Name and ingredients must not be null");
    }

    List<IngredientPortion> ingredientsList = new ArrayList<>();

    for (IngredientPortion i : roll_ingredients) {

      if (i == null) {
        throw new IllegalArgumentException("IngredientPortions must not be null");
      }

      boolean found = false;

      for (int j = 0; j < ingredientsList.size(); j++) {
        if (i.getIngredient().getName().equals(ingredientsList.get(j).getIngredient().getName())) {
          ingredientsList.set(j, ingredientsList.get(j).combine(i));
          found = true;
          break;
        }
      }

      if (!found) ingredientsList.add(i);
    }

    boolean seaweed = false;

    for (int i = 0; i < ingredientsList.size(); i++) {
      IngredientPortion weed = ingredientsList.get(i);
      if (weed.getIngredient().getName().equals("seaweed")) {
        seaweed = true;
        if (weed.getAmount() < 0.1) {
          ingredientsList.set(i, new SeaweedPortion(.9999));
        }
        break;
      }
    }

    if (!seaweed) {
      ingredientsList.add(new SeaweedPortion(.9999));
    }

    this.name = name;
    this.roll_ingredients = ingredientsList.toArray(new IngredientPortion[0]);
  }

  public String getName() {
    return name;
  }

  public IngredientPortion[] getIngredients() {
    return roll_ingredients.clone();
  }

  public int getCalories() {
    double cals = 0;
    for (IngredientPortion i : roll_ingredients) {
      cals = i.getCalories();
    }
    return (int) cals;
  }

  public double getCost() {
    double cost = 0;
    for (IngredientPortion i : roll_ingredients) {
      cost += i.getCost();
    }
    return (Math.round(cost * 100) / 100.0);
  }

  public boolean getHasRice() {
    for (IngredientPortion i : roll_ingredients) {
      if (i.getIsRice()) return true;
    }
    return false;
  }

  public boolean getHasShellfish() {
    for (IngredientPortion i : roll_ingredients) {
      if (i.getIsShellfish()) return true;
    }
    return false;
  }

  public boolean getIsVegetarian() {
    for (IngredientPortion i : roll_ingredients) {
      if (i.getIsVegetarian()) return true;
    }
    return false;
  }
}
