package com.comp301.a02adventure;

import junit.framework.TestCase;

public class CellImplTest extends TestCase {

    public void testTestGetName() {
        CellImpl cell = new CellImpl(1, 1, "Loot Lake", "the lake of loots");
        assertEquals("Loot Lake", cell.getName());
    }

    public void testGetDescription() {
        CellImpl cell = new CellImpl(1, 1, "Loot Lake", "the lake of loots");
        assertEquals("the lake of loots", cell.getDescription());
    }

    public void testGetPosition() {
    }

    public void testGetChest() {
    }

    public void testGetIsVisited() {
    }

    public void testHasChest() {
    }

    public void testTestSetName() {
    }

    public void testSetDescription() {
    }

    public void testSetChest() {
    }

    public void testVisit() {
    }
}