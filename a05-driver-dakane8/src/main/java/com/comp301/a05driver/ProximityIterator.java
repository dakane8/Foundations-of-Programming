package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProximityIterator implements Iterator<Driver> {

    private Position clientPosition;
    private int proximityRange;
    private Iterator<Driver> iterator;
    private Driver nextDriver;


    public ProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int proximityRange){
        if(driverPool == null || clientPosition == null || proximityRange < 0){
            throw new IllegalArgumentException();
        }
        this.clientPosition = clientPosition;
        this.proximityRange = proximityRange;
        this.iterator = driverPool.iterator();
        this.nextDriver = null;
    }

    private void nextDriver(){
        if(nextDriver != null){
            return;
        }
        while(iterator.hasNext()){
            Driver currentDriver = iterator.next();
            if(currentDriver.getVehicle().getPosition().getManhattanDistanceTo(clientPosition) <= proximityRange){
                nextDriver = currentDriver;
                break;
            }
        }
    }


    @Override
    public boolean hasNext() {
        nextDriver();
        return nextDriver != null;
    }

    @Override
    public Driver next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        Driver driver = nextDriver;
        nextDriver = null;
        return driver;
    }
}
