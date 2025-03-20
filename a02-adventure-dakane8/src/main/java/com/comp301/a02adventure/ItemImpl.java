package com.comp301.a02adventure;

public class ItemImpl implements Item {
  private String itemName;

  public ItemImpl(String itemName) {
    if (itemName == null || itemName.isEmpty()) {
      throw new IllegalArgumentException("Item name cannot be null or empty");
    }
    this.itemName = itemName;
  }

  @Override
  public String getName() {
    return itemName;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof ItemImpl) {
      if (((ItemImpl) other).getName().equals(this.getName())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return itemName;
  }
}
