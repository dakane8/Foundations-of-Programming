package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {

  private Map map;
  private Player player;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException("Map or Player cannot be null");
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    if (player.getInventory().getNumItems() == map.getNumItems()) {
      return true;
    }
    return false;
  }

  @Override
  public void printCellInfo() {
    String location = map.getCell(player.getPosition()).getName();
    System.out.println("Location: " + location);
    String description = map.getCell(player.getPosition()).getDescription();
    System.out.println(description);
    if (map.getCell(player.getPosition()).getIsVisited() == true) {
      System.out.println("You have already visited this location.");
    }
    if (map.getCell(player.getPosition()).hasChest() == true) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    map.getCell(getPlayerPosition()).visit();
  }

  @Override
  public void openChest() {
    if (!map.getCell(player.getPosition()).hasChest()) {
      System.out.println("No chest to open, sorry!");
    }
    if (map.getCell(player.getPosition()).hasChest()
        && map.getCell(player.getPosition()).getChest().isEmpty()) {
      System.out.println("The chest is empty.");
    }
    if (map.getCell(player.getPosition()).hasChest()
        && !map.getCell(player.getPosition()).getChest().isEmpty()) {
      System.out.println(
          "You collected these items: "
              + map.getCell(player.getPosition()).getChest().getItems().toString());
      player.getInventory().transferFrom(map.getCell(player.getPosition()).getChest());
    }
  }

  @Override
  public boolean canMove(Direction direction) {

    int nextX = player.getPosition().getNeighbor(direction).getX();
    int nextY = player.getPosition().getNeighbor(direction).getY();

    if (nextX >= 0 && nextY >= 0 && nextX < map.getWidth() && nextY < map.getHeight()) {
      return map.getCell(nextX, nextY) != null;
    } else {
      return false;
    }
  }

  @Override
  public void move(Direction direction) {
    if (canMove(direction)) {
      player.move(direction);
      printCellInfo();
    } else {
      System.out.println("You can't go that way! Try another direction.");
    }
  }
}
