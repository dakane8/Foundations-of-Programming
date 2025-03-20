package com.comp301.a01sushi;

import junit.framework.TestCase;
public class RollTest extends TestCase {

    Roll roll = new Roll("california", new IngredientPortions[]{new AvocadoPortion(2), new EelPortion(3)});

    public void testTestGetName() {
        String name = roll.getName();
        if (name.equals("california")) {
            assertEquals("california", name);
        }
    }

    public void testGetIngredients() {
        if(roll.getIngredients()[0] instanceof AvocadoPortion) {
            assertEquals("avocado", roll.getIngredients()[0].getName());
        }
      }

    public void testGetCalories() {
      }

    public void testGetCost() {
      }

    public void testGetHasRice() {
      }

    public void testGetHasShellfish() {
      }

    public void testGetIsVegetarian() {
      }
}