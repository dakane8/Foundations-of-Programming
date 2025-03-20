package com.comp301.a08shopping;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  public void inventoryTest() {
    ProductImpl product = new ProductImpl("Fan", 2.50, 3);
    Product iProduct = product;
    ProductImpl iProductBacktoImpl = (ProductImpl) product;
    assertTrue(iProductBacktoImpl.getInventory() == 3);
  }
}

