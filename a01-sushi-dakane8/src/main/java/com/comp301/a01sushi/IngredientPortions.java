package com.comp301.a01sushi;

public class IngredientPortions implements IngredientPortion {

  double amount;
  Ingredients ingredients;

  public IngredientPortions(double begamount, Ingredients begingredients) {
    if (begamount < 0) {
      throw new IllegalArgumentException("Amount must be greater than zero");
    }
    ingredients = begingredients;
    amount = begamount;
  }

  public Ingredient getIngredient() {
    return ingredients;
  }

  public double getAmount() {
    return amount;
  }

  public String getName() {
    return ingredients.getName();
  }

  public boolean getIsVegetarian() {
    return ingredients.getIsVegetarian();
  }

  public boolean getIsRice() {
    return ingredients.getIsRice();
  }

  public boolean getIsShellfish() {
    return ingredients.getIsShellfish();
  }

  public double getCalories() {
    return ingredients.getCaloriesPerOunce() * amount;
  }

  public double getCost() {
    return ingredients.getPricePerOunce() * amount;
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      throw new IllegalArgumentException("Other portion cannot be null");
    }

    if (!this.getIngredient().equals(other.getIngredient())) {
      throw new IllegalArgumentException("Ingredients must be the same to combine");
    }

    return new IngredientPortions(this.amount + other.getAmount(), this.ingredients);
  }
}
