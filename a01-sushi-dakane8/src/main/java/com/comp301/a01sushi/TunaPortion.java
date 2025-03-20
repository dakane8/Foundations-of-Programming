package com.comp301.a01sushi;

public class TunaPortion extends IngredientPortions {
  public TunaPortion(double begamount) {
    super(begamount, new Tuna());
  }

  public IngredientPortions combine(IngredientPortions other) {
    if (other == null) {
      return this;
    }
    if (!this.equals(other)) {
      throw new IllegalArgumentException("TunaPortion does not have the same ingredient");
    }
    return new TunaPortion(this.getAmount() + other.getAmount());
  }
}
