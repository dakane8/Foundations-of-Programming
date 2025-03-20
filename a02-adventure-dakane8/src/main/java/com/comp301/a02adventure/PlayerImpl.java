package com.comp301.a02adventure;

public class PlayerImpl implements Player {

  private String playerName;
  private Position playerPosition;
  private Inventory playerInventory;

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException("Player name cannot be null");
    }
    this.playerName = name;
    this.playerPosition = new PositionImpl(startX, startY);
    this.playerInventory = new InventoryImpl();
  }

  @Override
  public Position getPosition() {
    return playerPosition;
  }

  @Override
  public Inventory getInventory() {
    return playerInventory;
  }

  @Override
  public String getName() {
    return playerName;
  }

  @Override
  public void move(Direction direction) {
    playerPosition = playerPosition.getNeighbor(direction);
  }
}
