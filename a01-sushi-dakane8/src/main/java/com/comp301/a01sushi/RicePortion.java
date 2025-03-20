package com.comp301.a01sushi;

public class RicePortion extends IngredientPortions {
  public RicePortion(double begamount) {
    super(begamount, new Rice());
  }

  public IngredientPortions combine(IngredientPortions other) {
    if (other == null) {
      return this;
    }
    if (!this.equals(other)) {
      throw new IllegalArgumentException("RicePortion does not have the same ingredient");
    }
    return new RicePortion(this.getAmount() + other.getAmount());
  }
}
