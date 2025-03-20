package com.comp301.a01sushi;

public class SeaweedPortion extends IngredientPortions {
  public SeaweedPortion(double begamount) {
    super(begamount, new Seaweed());
  }

  public IngredientPortions combine(IngredientPortions other) {
    if (other == null) {
      return this;
    }
    if (!this.equals(other)) {
      throw new IllegalArgumentException("SeaweedPortion does not have the same ingredient");
    }
    return new SeaweedPortion(this.getAmount() + other.getAmount());
  }

  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }

    if (!(other instanceof SeaweedPortion)) {
      throw new IllegalArgumentException("Can only combine with another SeaweedPortion");
    }

    return new SeaweedPortion(this.getAmount() + other.getAmount());
  }
}
