package com.comp301.a01sushi;

public class AvocadoPortion extends IngredientPortions {
  public AvocadoPortion(double begamount) {
    super(begamount, new Avocado());
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }

    if (!(other instanceof AvocadoPortion)) {
      throw new IllegalArgumentException("Can only combine with another AvocadoPortion");
    }

    return new AvocadoPortion(this.getAmount() + other.getAmount());
  }
}
