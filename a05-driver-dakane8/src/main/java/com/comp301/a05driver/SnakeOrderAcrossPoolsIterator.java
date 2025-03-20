package com.comp301.a05driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SnakeOrderAcrossPoolsIterator implements Iterator<Driver> {

    private final List<Iterator<Driver>> driverIterators;
    private int index;
    private boolean direction;
    private int poolUsed;

    public SnakeOrderAcrossPoolsIterator(List<Iterable<Driver>> driverPools) {
        this.driverIterators = new ArrayList<>();
        for (Iterable<Driver> pool : driverPools) {
            Iterator<Driver> iterator = pool.iterator();
            if (iterator.hasNext()) {
                this.driverIterators.add(iterator);
            }
        }
        this.index = 0;
        this.direction = true;
        this.poolUsed = 0;
    }

    private void nextPool() {
        int totalPools = driverIterators.size();
        int checkPools = 0;
        while (checkPools < totalPools) {
            if (direction) {
                index++;
            } else {
                index--;
            }
            if (index >= totalPools) {
                index = totalPools - 1;
                direction = false;
            } else if (index < 0) {
                index = 0;
                direction = true;
            }
            if (driverIterators.get(index).hasNext()) {
                return;
            }
            checkPools++;
            if (!driverIterators.get(index).hasNext()) {
                poolUsed++;
            }
            if (poolUsed == totalPools) {
                return;
            }
        }
    }

    @Override
    public boolean hasNext() {
        if (poolUsed == driverIterators.size()) {
            return false;
        }
        if (driverIterators.get(index).hasNext()) {
            return true;
        }
        nextPool();
        return poolUsed != driverIterators.size();
    }

    @Override
    public Driver next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Driver nextDriver = driverIterators.get(index).next();
        nextPool();
        return nextDriver;
    }

}
