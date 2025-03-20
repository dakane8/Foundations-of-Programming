package com.comp301.a04junit;

import com.comp301.a04junit.alphabetizer.Alphabetizer;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/** Write tests for the Alphabetizer class here */
public class NoviceAlphabetizerTests {
  @Test
  public void unitTest1() {
    // TODO: Write your first unit test!
    String[] input = {"a1" , "b1" , "c1"};
    Alphabetizer letter = new Alphabetizer(input);
    assertEquals("a1", letter.next());
    assertTrue(letter.hasNext());
    assertEquals("b1", letter.next());
    assertTrue(letter.hasNext());
    assertEquals("c1", letter.next());
    assertFalse(letter.hasNext());
  }

  @Test
  public void unitTest2() {
    String[] input = {"c1" , "b1" , "a1"};
    Alphabetizer letter = new Alphabetizer(input);
    assertEquals("a1", letter.next());
    assertTrue(letter.hasNext());
    assertEquals("b1", letter.next());
    assertTrue(letter.hasNext());
    assertEquals("c1", letter.next());
    assertFalse(letter.hasNext());
  }

  @Test
  public void unitTest3() {
    String[] input = {"c1"};
    Alphabetizer letter = new Alphabetizer(input);
    letter.next();
    try{
      letter.next();
    } catch (NoSuchElementException e){
      System.out.println(e);
    }
  }

  @Test
  public void unitTest4() {
    String[] input = {"c1", "d1"};
    Alphabetizer letter = new Alphabetizer(input);
    letter.next();
    assertEquals(new String[]{"c1", "d1"}, input);
  }

  @Test
  public void unitTest5() {
    String[] input = {"A" , "B" , "C"};
    Alphabetizer letter = new Alphabetizer(input);
    assertEquals("A", letter.next());
    assertTrue(letter.hasNext());
    assertEquals("B", letter.next());
    assertTrue(letter.hasNext());
    assertEquals("C", letter.next());
    assertFalse(letter.hasNext());
  }

  @Test
  public void unitTest6() {
    String[] input = {"b1", "a1", "c1"};
    Alphabetizer alphabetizer = new Alphabetizer(input);
    input[0] = "z1";
    assertTrue(alphabetizer.hasNext());
    assertEquals("a1", alphabetizer.next());
    assertTrue(alphabetizer.hasNext());
    assertEquals("b1", alphabetizer.next());
    assertTrue(alphabetizer.hasNext());
    assertEquals("c1", alphabetizer.next());
    assertFalse(alphabetizer.hasNext());
  }

  @Test
  public void UnitTest7() {
    String[] input = new String[]{};
    Alphabetizer letter = new Alphabetizer(input);
    try{
      letter.next();
    } catch (NoSuchElementException e){
    }
  }


}
