package com.github.dmitrKuznetsov.threads.primitiveShips;

import com.github.dmitrKuznetsov.threads.primitiveShips.ships.Ship;
import com.github.dmitrKuznetsov.threads.primitiveShips.ships.enums.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tunnel {

    private final List<Ship> ships = new ArrayList<>();
    private final int minCount = 0;
    private final int maxCount = 5;

    public synchronized boolean addShip(Ship ship) {
        try {
            while (true) {
                if (ships.size() < maxCount) {
                    ships.add(ship);
                    System.out.printf("Thread: %s. Add ship: %s\n", Thread.currentThread().getName(), ship);
                    notifyAll();
                    return true;
                } else {
                    System.out.printf("Thread: %s. There is no place for a ship in the tunnel\n", Thread.currentThread().getName());
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public synchronized Optional<Ship> getShip(ShipType type) {
        try {
            while (true) {
                if (ships.size() > minCount) {
                    for (Ship ship : ships) {
                        if (ship.getType() == type) {
                            ships.remove(ship);
                            System.out.printf("Thread: %s. Get ship: %s\n", Thread.currentThread().getName(), ship);
                            notifyAll();
                            return Optional.of(ship);
                        }
                    }
                }
                System.out.printf("Thread: %s. There are no ships in the tunnel\n", Thread.currentThread().getName());
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
