package com.comp301.a02adventure;

import junit.framework.TestCase;

public class MapImplTest extends TestCase {

    public void testGetWidth() {
        MapImpl map = new MapImpl(5, 9, 7);
        assertEquals(5, map.getWidth());
    }

    public void testGetHeight() {
        MapImpl map = new MapImpl(5, 9, 7);
        assertEquals(9, map.getHeight());
    }

    public void testGetCell() {
        MapImpl map = new MapImpl(5, 9, 7);

    }

    public void testTestGetCell() {
    }

    public void testInitCell() {
    }

    public void testGetNumItems() {
    }
}