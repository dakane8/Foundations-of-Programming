package com.comp301.a05driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExpandingProximityIterator implements Iterator<Driver> {

    private final Iterator<Driver> iterator;
    private final Position clientPosition;
    private final int expansionStep;
    private final Iterable<Driver> driverPool;
    private ArrayList<Driver> eligibleDrivers;
    private final int maxDrivers;
    private int currentCount;

    public ExpandingProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int expansionStep){
        this.iterator = driverPool.iterator();
        this.clientPosition = clientPosition;
        this.expansionStep = expansionStep;
        this.driverPool = driverPool;
        this.eligibleDrivers = new ArrayList<>();
        this.maxDrivers = maxDrivers();
        this.currentCount = 0;
        nextStep();
    }

    private void nextStep(){
        int lowerBound = 0;
        int upperBound;
        int ringCount = 0;

        while(eligibleDrivers.size() < maxDrivers){
            upperBound = 1 + expansionStep * ringCount;
            ProximityIterator proximityIterator = new ProximityIterator(driverPool, clientPosition, upperBound);
            while(proximityIterator.hasNext()){
                Driver driver = proximityIterator.next();
                int distance = driver.getVehicle().getPosition().getManhattanDistanceTo(clientPosition);
                if(distance > lowerBound){
                    eligibleDrivers.add(driver);
                }
            }
            ringCount ++;
            lowerBound = upperBound;
        }
    }

    private int maxDrivers(){
        int count = 0;
        for (Driver ignored : driverPool) {
            count++;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return currentCount < eligibleDrivers.size();
    }

    @Override
    public Driver next() {
        if(currentCount >= eligibleDrivers.size()){
            throw new NoSuchElementException();
        }
        Driver driver = eligibleDrivers.get(currentCount);
        currentCount += 1;
        return driver;
    }

}
