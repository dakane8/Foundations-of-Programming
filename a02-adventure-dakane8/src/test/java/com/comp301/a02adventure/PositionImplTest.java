package com.comp301.a02adventure;

import junit.framework.TestCase;

public class PositionImplTest extends TestCase {

    public void testGetX() {
        PositionImpl position = new PositionImpl(3, 0);
        assertEquals(3, position.getX());
    }

    public void testGetY() {
        PositionImpl position = new PositionImpl(3, 3);
        assertEquals(3, position.getY());
    }

    public void testGetNeighbor() {
        PositionImpl position = new PositionImpl(3, 0);

    }
}