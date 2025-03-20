package com.comp301.a08shopping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import com.comp301.a08shopping.ProductImpl.*;
import com.comp301.a08shopping.events.*;
import com.comp301.a08shopping.exceptions.OutOfStockException;
import com.comp301.a08shopping.exceptions.ProductNotFoundException;

public class StoreImpl implements Store {

  private final String name;
  private final ArrayList<Product> products;
  private final List<StoreObserver> observers;

  public StoreImpl(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    this.name = name;
    this.products = new ArrayList<>();
    this.observers = new ArrayList<>();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void addObserver(StoreObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException("Observer cannot be null");
    }
    this.observers.add(observer);
  }

  @Override
  public void removeObserver(StoreObserver observer) {
    observers.remove(observer);
  }

  @Override
  public List<Product> getProducts() {
    return new ArrayList<>(this.products);
  }

  @Override
  public Product createProduct(String name, double basePrice, int inventory) {
    if (name == null || basePrice < 0.00 || inventory < 0) {
      throw new IllegalArgumentException("Invalid input CreateProduct");
    }
    ProductImpl product = new ProductImpl(name, basePrice, inventory);
    this.products.add(product);
    return product;
  }

  @Override
  public ReceiptItem purchaseProduct(Product product) {
    boolean productFound = false;
    if (product == null) {
      throw new IllegalArgumentException("PurchaseProduct input cannot be null");
    }
    for (Product p : this.products) {
      if (p.getName().equals(product.getName()) && p.getBasePrice() == product.getBasePrice()) {
        productFound = true;
      }
    }
    if (productFound) {
      ProductImpl pi = (ProductImpl) product;
      if (pi.getInventory() == 0) {
        throw new OutOfStockException("Out of stock");
      }
      pi.subInventory();
      for (StoreObserver observer : observers) {
        observer.update(new PurchaseEvent(product, this));
      }
      if (pi.getInventory() == 0) {
        for (StoreObserver observer : observers) {
          observer.update(new OutOfStockEvent(product, this));
        }
      }
      return new ReceiptItemImpl(pi.getName(), pi.getDiscountPrice(), this.name);
    }
    throw new ProductNotFoundException("Product not found in PurchaseProduct");
  }

  @Override
  public void restockProduct(Product product, int numItems) {
    boolean productFound = false;
    if (product == null) {
      throw new IllegalArgumentException("RestockProduct input cannot be null");
    }
    if (numItems < 0) {
      throw new IllegalArgumentException("RestockProduct input cannot be negative");
    }
    for (Product p : this.products) {
      if (p.getName().equals(product.getName()) && p.getBasePrice() == product.getBasePrice()) {
        productFound = true;
      }
    }
    if (productFound) {
      ProductImpl pi = (ProductImpl) product;
      boolean restock = pi.getInventory() == 0;
      pi.addInventory(numItems);
      if (restock) {
        for (StoreObserver observer : observers) {
          observer.update(new BackInStockEvent(product, this));
        }
      }
    } else {
      throw new ProductNotFoundException("Product not found in RestockProduct");
    }
  }

  @Override
  public void startSale(Product product, double percentOff) {
    boolean productFound = false;
    if (product == null) {
      throw new IllegalArgumentException("Input cannot be null StartSale");
    }
    if (percentOff < 0.0 || percentOff > 1.0) {
      throw new IllegalArgumentException("PercentOff must be between 0.0 and 1.0");
    }
    for (Product p : this.products) {
      if (p.getName().equals(product.getName()) && p.getBasePrice() == product.getBasePrice()) {
        productFound = true;
      }
    }
    if (productFound) {
      ProductImpl pi = (ProductImpl) product;
      pi.setPercentOff(percentOff);
      for (StoreObserver observer : observers) {
        observer.update(new SaleStartEvent(product, this));
      }
    } else {
      throw new ProductNotFoundException("Product not found in StartSale");
    }
  }

  @Override
  public void endSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException("Input cant be null EndSale");
    }
    if (!products.contains(product)) {
      throw new ProductNotFoundException("Product not found in EndSale");
    }
    ProductImpl pi = (ProductImpl) product;
    pi.setPercentOff(0.0);
    for (StoreObserver observer : observers) {
      observer.update(new SaleEndEvent(product, this));
    }
  }

  @Override
  public int getProductInventory(Product product) {
    boolean productFound = false;
    if (product == null) {
      throw new IllegalArgumentException("input cant be null GetProductInventory");
    }
    for (Product p : this.products) {
      if (p.getName().equals(product.getName()) && p.getBasePrice() == product.getBasePrice()) {
        productFound = true;
      }
    }
    if (productFound) {
      ProductImpl pi = (ProductImpl) product;
      return pi.getInventory();
    }
    throw new ProductNotFoundException("Product not found in GetProductInventory");
  }

  @Override
  public boolean getIsInStock(Product product) {
    boolean productFound = false;
    if (product == null) {
      throw new IllegalArgumentException(" input cant be null GetIsInStock");
    }
    for (Product p : this.products) {
      if (p.getName().equals(product.getName()) && p.getBasePrice() == product.getBasePrice()) {
        productFound = true;
        break;
      }
    }
    if (productFound) {
      return getProductInventory(product) > 0;
    }
    throw new ProductNotFoundException("Product not found in GetIsInStock");
  }

  @Override
  public double getSalePrice(Product product) {
    boolean productFound = false;
    if (product == null) {
      throw new IllegalArgumentException(" input cant be null GetSalePrice");
    }
    for (Product p : this.products) {
      if (p.getName().equals(product.getName()) && p.getBasePrice() == product.getBasePrice()) {
        productFound = true;
        break;
      }
    }
    if (productFound) {
      ProductImpl pi = (ProductImpl) product;
      if (pi.getDiscountPrice() >= 0) {
        return pi.getDiscountPrice();
      }
    }
    throw new ProductNotFoundException("Product not found in GetSalePrice");
  }

  @Override
  public boolean getIsOnSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException(" input cant be null GetIsOnSale");
    }
    if (!this.products.contains(product)) {
      throw new ProductNotFoundException("Product not found in GetIsOnSale");
    }
    ProductImpl pi = (ProductImpl) product;
    return pi.getDiscountPrice() < pi.getBasePrice();
  }
}
