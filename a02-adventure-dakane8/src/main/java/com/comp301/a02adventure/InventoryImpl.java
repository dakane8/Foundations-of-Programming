package com.comp301.a02adventure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private ArrayList<Item> inventory;

  public InventoryImpl() {
    this.inventory = new ArrayList<>();
  }

  @Override
  public boolean isEmpty() {
    if (inventory.isEmpty()) {
      return true;
    }
    return false;
  }

  @Override
  public int getNumItems() {
    return inventory.size();
  }

  @Override
  public ArrayList<Item> getItems() {
    ArrayList<Item> clonedlist = (ArrayList<Item>) inventory.clone();
    return clonedlist;
  }

  @Override
  public void addItem(Item item) {
    inventory.add(item);
  }

  @Override
  public void removeItem(Item item) {
    inventory.remove(item);
  }

  @Override
  public void clear() {
    inventory.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    inventory.addAll(other.getItems());
    other.clear();
  }
}
