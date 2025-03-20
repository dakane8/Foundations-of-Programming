package com.comp301.a08shopping;

import com.comp301.a08shopping.events.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements Customer {

  private final String name;
  private double budget;
  private final List<ReceiptItem> receipts;

  public CustomerImpl(String name, double budget) {
    if (budget < 0 || name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.budget = budget;
    this.receipts = new ArrayList<>();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getBudget() {
    return this.budget;
  }

  @Override
  public void purchaseProduct(Product product, Store store) {
    if (product == null || store == null) {
      throw new IllegalArgumentException("Product or store cannot be null");
    }
    if (store.getSalePrice(product) > this.budget) {
      throw new IllegalStateException("Discount Price exceeds budget");
    }
    budget -= store.getSalePrice(product);
    ReceiptItem receiptItem = store.purchaseProduct(product);
    receipts.add(receiptItem);
  }

  @Override
  public List<ReceiptItem> getPurchaseHistory() {
    return new ArrayList<>(receipts);
  }

  @Override
  public void update(StoreEvent event) {
    if (event instanceof BackInStockEvent) {
      System.out.println(
          event.getProduct().getName() + " is back in stock at " + event.getStore().getName());
    }
    if (event instanceof OutOfStockEvent) {
      System.out.println(
          event.getProduct().getName() + " is now out of stock at " + event.getStore().getName());
    }
    if (event instanceof SaleEndEvent) {
      System.out.println(
          "The sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + " has ended");
    }
    if (event instanceof PurchaseEvent) {
      System.out.println(
          "Someone purchased "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName());
    }
    if (event instanceof SaleStartEvent) {
      System.out.println(
          "New sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + "!");
    }
  }
}
