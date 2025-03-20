package com.comp301.a04junit;

import static org.junit.Assert.*;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.Position;
import com.comp301.a04junit.adventure.PositionImpl;

import org.junit.Test;

/** Write unit tests for the PositionImpl class here */
public class AdeptPositionTests {
  @Test
  public void unitTest1() {
    Position position = new PositionImpl(1, 0);
    assertEquals(1, position.getX());
  }

  @Test
  public void unitTest2() {
    Position position = new PositionImpl(0, 1);
    assertEquals(1, position.getY());
  }


  @Test
  public void unitTest3() {
    Position position = new PositionImpl(-1, 0);
    assertEquals(-1, position.getX());
  }

  @Test
  public void unitTest4() {
    Position position = new PositionImpl(0, -1);
    assertEquals(-1, position.getY());
  }


  @Test
  public void unitTest5() {
    Position position = new PositionImpl(1, 1);
    assertNotEquals(2, position.getX());
  }

  @Test
  public void unitTest6() {
    Position position = new PositionImpl(1, 1);
    assertNotEquals(2, position.getY());
  }

  @Test
  public void unitTest7() {
    Position position = new PositionImpl(1, 1);
    int initialX = position.getX();
    int initialY = position.getY();
    assertEquals(initialX, position.getX());
    assertEquals(initialY, position.getY());

  }


  @Test
  public void unitTest8() {
    Position position = new PositionImpl(1, 1);
    assertTrue(position.getNeighbor(Direction.WEST).getX() == 0);
  }

  @Test
  public void unitTest9() {
    Position position = new PositionImpl(1, 1);
    assertTrue(position.getNeighbor(Direction.EAST).getX() == 2);
  }

  @Test
  public void unitTest10() {
    Position position = new PositionImpl(1, 1);
    assertTrue(position.getNeighbor(Direction.NORTH).getY() == 2);
  }

  @Test
  public void unitTest11() {
    Position position = new PositionImpl(1, 1);
    assertTrue(position.getNeighbor(Direction.SOUTH).getY() == 0);
  }

  @Test
  public void unitTest12() {
    Position pos1 = new PositionImpl(0, 0);
    assertEquals(0, pos1.getNeighbor(Direction.NORTH).getX());
    assertEquals(1, pos1.getNeighbor(Direction.NORTH).getY());
    assertEquals(0, pos1.getNeighbor(Direction.SOUTH).getX());
    assertEquals(-1, pos1.getNeighbor(Direction.SOUTH).getY());
    assertEquals(1, pos1.getNeighbor(Direction.EAST).getX());
    assertEquals(0, pos1.getNeighbor(Direction.EAST).getY());
    assertEquals(-1, pos1.getNeighbor(Direction.WEST).getX());
    assertEquals(0, pos1.getNeighbor(Direction.WEST).getY());
    Position pos2 = new PositionImpl(5, 5);
    assertEquals(5, pos2.getNeighbor(Direction.NORTH).getX());
    assertEquals(6, pos2.getNeighbor(Direction.NORTH).getY());
    assertEquals(5, pos2.getNeighbor(Direction.SOUTH).getX());
    assertEquals(4, pos2.getNeighbor(Direction.SOUTH).getY());
    assertEquals(6, pos2.getNeighbor(Direction.EAST).getX());
    assertEquals(5, pos2.getNeighbor(Direction.EAST).getY());
    assertEquals(4, pos2.getNeighbor(Direction.WEST).getX());
    assertEquals(5, pos2.getNeighbor(Direction.WEST).getY());
    Position pos3 = new PositionImpl(-3, -3);
    assertEquals(-3, pos3.getNeighbor(Direction.NORTH).getX());
    assertEquals(-2, pos3.getNeighbor(Direction.NORTH).getY());
    assertEquals(-3, pos3.getNeighbor(Direction.SOUTH).getX());
    assertEquals(-4, pos3.getNeighbor(Direction.SOUTH).getY());
    assertEquals(-2, pos3.getNeighbor(Direction.EAST).getX());
    assertEquals(-3, pos3.getNeighbor(Direction.EAST).getY());
    assertEquals(-4, pos3.getNeighbor(Direction.WEST).getX());
    assertEquals(-3, pos3.getNeighbor(Direction.WEST).getY());
  }

}
