package com.comp301.a07pizza;

import com.comp301.a07pizza.Pizza.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PizzaFactory {

  public static Pizza makeCheesePizza(Size size) {
    return new PizzaImpl(size, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, new ArrayList<>());
  }

  public static Pizza makeHawaiianPizza(Size size) {
    return new PizzaImpl(
        size,
        Crust.HAND_TOSSED,
        Sauce.TOMATO,
        Cheese.BLEND,
        Arrays.asList(Topping.HAM, Topping.PINEAPPLE));
  }

  public static Pizza makeMeatLoversPizza(Size size) {
    return new PizzaImpl(
        size,
        Crust.DEEP_DISH,
        Sauce.TOMATO,
        Cheese.BLEND,
        Arrays.asList(Topping.PEPPERONI, Topping.SAUSAGE, Topping.BACON, Topping.GROUND_BEEF));
  }

  public static Pizza makeVeggieSupremePizza(Size size) {
    return new PizzaImpl(
        size,
        Crust.THIN,
        Sauce.TOMATO,
        Cheese.BLEND,
        Arrays.asList(
            Topping.SUN_DRIED_TOMATO, Topping.GREEN_PEPPER, Topping.MUSHROOMS, Topping.OLIVES));
  }

  public static Pizza makeDailySpecialPizza() {
    return new PizzaImpl(
        Size.LARGE,
        Crust.DEEP_DISH,
        Sauce.TOMATO,
        Cheese.BLEND,
        Arrays.asList(Topping.PEPPERONI, Topping.SAUSAGE));
  }
}
