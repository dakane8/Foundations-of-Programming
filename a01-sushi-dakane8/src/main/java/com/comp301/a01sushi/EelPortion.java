package com.comp301.a01sushi;

public class EelPortion extends IngredientPortions {
  public EelPortion(double begamount) {
    super(begamount, new Eel());
  }

  public IngredientPortions combine(IngredientPortions other) {
    if (other == null) {
      return this;
    }
    if (!this.equals(other)) {
      throw new IllegalArgumentException("EelPortion does not have the same ingredient");
    }
    return new EelPortion(this.getAmount() + other.getAmount());
  }
}
