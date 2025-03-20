package com.comp301.a04junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;

import org.junit.Test;

/** Write unit tests for the ItemImpl class here */
public class  AdeptItemTests {
  @Test
  public void unitTest1() {
    Item item = new ItemImpl("Harry Potter");
    assertEquals("Harry Potter", item.getName());
  }

  @Test
  public void unitTest2() {
    Item item = new ItemImpl("Harry Potter");
    Item item2 = new ItemImpl("Harry Potter");
    assertTrue(item.equals(item2));
  }

  @Test
  public void unitTest3() {
    Item item = new ItemImpl("Harry Potter");
    Item item2 = new ItemImpl("Not Harry Potter");
    assertFalse(item.equals(item2));
  }

  @Test
  public void unitTest4() {
    Item item = new ItemImpl("Harry Potter");
    assertEquals("Harry Potter", item.toString());
  }

  @Test
  public void unitTest5() {
    Item item = new ItemImpl("Harry Potter");
    assertFalse(item.equals(null));
  }
}
