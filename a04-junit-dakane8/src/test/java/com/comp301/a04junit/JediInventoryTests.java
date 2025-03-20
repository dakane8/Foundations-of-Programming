package com.comp301.a04junit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;
import com.comp301.a04junit.adventure.Inventory;
import com.comp301.a04junit.adventure.InventoryImpl;

import org.junit.Test;

/** Write unit tests for the InventoryImpl class here */
public class JediInventoryTests {

  @Test
  public void unitTest1() {
    Inventory inventory = new InventoryImpl();
    assertTrue(inventory.isEmpty());
  }

  @Test
  public void unitTest2() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("backback");
    inventory.addItem(item);
    assertFalse(inventory.isEmpty());
    assertEquals(item, inventory.getItems().get(0));
  }

  @Test
  public void unitTest3() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("backback");
    Item item2 = new ItemImpl("flower");
    inventory.addItem(item);
    inventory.addItem(item2);
    assertEquals(item, inventory.getItems().get(0));
    assertEquals(item2, inventory.getItems().get(1));
    inventory.removeItem(item);
    inventory.removeItem(item2);
    assertTrue(inventory.isEmpty());
  }

  @Test
  public void unitTest4() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("backback");
    inventory.addItem(item);
    inventory.getItems().clear();
    assertEquals(item, inventory.getItems().get(0));
  }

  @Test
  public void unitTest5() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("backback");
    Item item2 = new ItemImpl("flower");
    Item item3 = new ItemImpl("orchid");
    inventory.addItem(item);
    inventory.addItem(item2);
    inventory.addItem(item3);
    assertEquals(3, inventory.getNumItems());
  }

  @Test
  public void unitTest6() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("backback");
    Item item2 = new ItemImpl("flower");
    Item item3 = new ItemImpl("orchid");
    inventory.addItem(item);
    inventory.addItem(item2);
    inventory.addItem(item3);
    assertEquals(3, inventory.getNumItems());
    inventory.removeItem(item);
    assertEquals(2, inventory.getNumItems());
    inventory.removeItem(item2);
    assertEquals(1, inventory.getNumItems());
    inventory.removeItem(item3);
    assertEquals(0, inventory.getNumItems());
  }

  @Test
  public void unitTest7() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("backback");
    inventory.addItem(item);
    inventory.clear();
    assertEquals(0, inventory.getNumItems());
  }

  @Test
  public void unitTest8() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("backback");
    inventory.addItem(item);
    Inventory inventory2 = new InventoryImpl();
    Item item2 = new ItemImpl("flower");
    inventory2.addItem(item2);
    inventory.transferFrom(inventory2);
    assertEquals(item2, inventory.getItems().get(1));
  }

  @Test
  public void unitTest9() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("backback");
    inventory.addItem(item);
    inventory.transferFrom(null);
    assertEquals(1, inventory.getNumItems());
  }
}
