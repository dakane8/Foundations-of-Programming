package com.comp301.a01sushi;

public class CrabPortion extends IngredientPortions {
  public CrabPortion(double begamount) {
    super(begamount, new Crab());
  }

  public IngredientPortions combine(IngredientPortions other) {
    if (other == null) {
      return this;
    }
    if (!this.equals(other)) {
      throw new IllegalArgumentException("CrabPortion does not have the same ingredient");
    }
    return new CrabPortion(this.getAmount() + other.getAmount());
  }
}
