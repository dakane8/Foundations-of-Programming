package com.comp301.a02adventure;

import junit.framework.TestCase;

public class GameImplTest extends TestCase {

    public void testGetPlayerPosition() {
        MapImpl map = new MapImpl(7, 7, 7);
        PlayerImpl player = new PlayerImpl("jake", 1, 1);
        GameImpl game = new GameImpl(map, player);
        assertEquals(player.getPosition(), game.getPlayerPosition());
    }

    public void testGetPlayerName() {
    }

    public void testGetPlayerItems() {
    }

    public void testGetIsWinner() {
    }

    public void testPrintCellInfo() {
    }

    public void testOpenChest() {
    }

    public void testCanMove() {
    }

    public void testMove() {
    }
}