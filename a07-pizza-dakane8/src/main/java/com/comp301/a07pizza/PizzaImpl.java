package com.comp301.a07pizza;

import java.util.List;

public class PizzaImpl implements Pizza {

  private final Size size;
  private final Crust crust;
  private final Sauce sauce;
  private final Cheese cheese;
  private final List<Topping> toppings;

  public PizzaImpl(Size size, Crust crust, Sauce sauce, Cheese cheese, List<Topping> toppings) {
    if (size == null || crust == null || sauce == null || cheese == null || toppings == null) {
      throw new IllegalArgumentException("Pizza fields cannot be null.");
    }
    this.size = size;
    this.crust = crust;
    this.sauce = sauce;
    this.cheese = cheese;
    this.toppings = toppings;
  }

  @Override
  public boolean isVegetarian() {
    if (!cheese.isVegetarian()) {
      return false;
    }
    if (!sauce.isVegetarian()) {
      return false;
    }
    for (Topping value : toppings) {
      if (!value.isVegetarian()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isVegan() {
    if (!sauce.isVegan()) {
      return false;
    }
    if (!cheese.isVegan()) {
      return false;
    }
    for (Topping value : toppings) {
      if (!value.isVegan()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public double getPrice() {
    double price = 0;
    int length = toppings.size();
    if (this.size == Size.SMALL) {
      price = 7 + .25 * length;
    } else if (this.size == Size.MEDIUM) {
      price = 9 + .5 * length;
    } else if (this.size == Size.LARGE) {
      price = 11 + .75 * length;
    }
    return price;
  }

  @Override
  public Size getSize() {
    return this.size;
  }

  @Override
  public Ingredient getSauce() {
    return this.sauce;
  }

  @Override
  public Ingredient getCheese() {
    return this.cheese;
  }

  @Override
  public Ingredient getCrust() {
    return this.crust;
  }

  @Override
  public Ingredient[] getToppings() {
    Ingredient[] ingredients = new Ingredient[toppings.size()];
    int i = 0;
    for (Ingredient value : toppings) {
      ingredients[i++] = value;
    }
    return ingredients;
  }

  @Override
  public Ingredient[] getIngredients() {
    Ingredient[] ingredients = new Ingredient[toppings.size() + 3];
    ingredients[0] = this.cheese;
    ingredients[1] = this.sauce;
    ingredients[2] = this.crust;
    int i = 3;
    for (Ingredient value : toppings) {
      ingredients[i++] = value;
    }
    return ingredients;
  }
}
