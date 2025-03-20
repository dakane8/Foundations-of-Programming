package com.comp301.a01sushi;

public class ShrimpPortion extends IngredientPortions {
  public ShrimpPortion(double begamount) {
    super(begamount, new Shrimp());
  }

  public IngredientPortions combine(IngredientPortions other) {
    if (other == null) {
      return this;
    }
    if (!this.equals(other)) {
      throw new IllegalArgumentException("ShrimpPortion does not have the same ingredient");
    }
    return new ShrimpPortion(this.getAmount() + other.getAmount());
  }
}
