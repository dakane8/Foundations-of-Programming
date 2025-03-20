package com.comp301.a01sushi;

public class YellowtailPortion extends IngredientPortions {
  public YellowtailPortion(double begamount) {
    super(begamount, new Yellowtail());
  }

  public IngredientPortions combine(IngredientPortions other) {
    if (other == null) {
      return this;
    }
    if (!this.equals(other)) {
      throw new IllegalArgumentException("YellowtailPortion does not have the same ingredient");
    }
    return new YellowtailPortion(this.getAmount() + other.getAmount());
  }
}
