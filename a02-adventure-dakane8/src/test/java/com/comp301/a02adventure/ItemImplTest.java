package com.comp301.a02adventure;

import junit.framework.TestCase;

public class ItemImplTest extends TestCase {

    public void testTestGetName() {
        ItemImpl item = new ItemImpl("Test");
        assertEquals("Test", item.getName());
    }

    public void testTestEquals() {
        ItemImpl item = new ItemImpl("Test");
        ItemImpl item2 = new ItemImpl("Test");
        assertEquals(item, item2);
    }

    public void testTestToString() {
        ItemImpl item = new ItemImpl("Test");
        assertEquals("Test", item.toString());
    }
}