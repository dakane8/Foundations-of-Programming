package com.comp301.a02adventure;

import junit.framework.TestCase;

public class InventoryImplTest extends TestCase {

    public void testIsEmpty() {
        InventoryImpl inventory = new InventoryImpl();
        assertTrue(inventory.isEmpty());
    }

    public void testGetNumItems() {
        InventoryImpl inventory = new InventoryImpl();
        assertEquals(0, inventory.getNumItems());
    }

    public void testGetItems() {
        InventoryImpl inventory = new InventoryImpl();
        ItemImpl item = new ItemImpl("Test");
        inventory.addItem(item);
    }

    public void testAddItem() {
        InventoryImpl inventory = new InventoryImpl();
        ItemImpl item = new ItemImpl("Test");
        inventory.addItem(item);
    }

    public void testRemoveItem() {
    }

    public void testClear() {
    }

    public void testTransferFrom() {
    }
}