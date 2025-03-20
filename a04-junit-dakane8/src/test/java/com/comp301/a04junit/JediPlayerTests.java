package com.comp301.a04junit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import com.comp301.a04junit.adventure.*;

import org.junit.Test;

/** Write unit tests for the PlayerImpl class here */
public class JediPlayerTests {
  @Test
  public void unitTest1() {
    Player player = new PlayerImpl("john", 0, 0);
    assertEquals("john", player.getName());
  }

  @Test
  public void unitTest2() {
    Player player = new PlayerImpl("john", 0, 0);
    player.move(Direction.EAST);
    assertEquals(1, player.getPosition().getX());
  }

  @Test
  public void unitTest3() {
    Player player = new PlayerImpl("john", 0, 0);
    assertEquals(0, player.getInventory().getNumItems());
  }

  @Test
  public void unitTest4() {
    Player player = new PlayerImpl("john", 0, 0);
    player.move(Direction.EAST);
    assertEquals(1, player.getPosition().getX());
    player.move(Direction.WEST);
    assertEquals(0, player.getPosition().getX());
    player.move(Direction.NORTH);
    assertEquals(1, player.getPosition().getY());
    player.move(Direction.SOUTH);
    assertEquals(0, player.getPosition().getY());
  }

  @Test
  public void unitTest5() {
    Player player = new PlayerImpl("john", 0, 0);
    Item item = new ItemImpl("apple");
    player.getInventory().addItem(item);
    assertEquals("apple", player.getInventory().getItems().get(0).getName());
  }

  @Test
  public void unitTest6() {
    Player player = new PlayerImpl("john", 0, 0);
    player.move(Direction.EAST);
    assertEquals(1, player.getPosition().getX());
    player.move(Direction.WEST);
    assertEquals(0, player.getPosition().getX());
    player.move(Direction.NORTH);
    assertEquals(1, player.getPosition().getY());
    player.move(Direction.SOUTH);
    assertEquals(0, player.getPosition().getY());

    Player player2 = new PlayerImpl("john", 3, 3);
    player2.move(Direction.EAST);
    assertEquals(4, player2.getPosition().getX());
    player2.move(Direction.WEST);
    assertEquals(3, player2.getPosition().getX());
    player2.move(Direction.NORTH);
    assertEquals(4, player2.getPosition().getY());
    player2.move(Direction.SOUTH);
    assertEquals(3, player2.getPosition().getY());
  }

  @Test
  public void unitTest7() {
    try{
      Player player = new PlayerImpl(null, 0, 0);
    } catch (IllegalArgumentException e){
      System.out.println("IllegalArgumentException");
    } catch (Exception e){
      fail("failed");
    }
  }

}
