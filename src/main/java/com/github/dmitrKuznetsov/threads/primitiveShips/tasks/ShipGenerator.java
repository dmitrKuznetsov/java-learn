package com.github.dmitrKuznetsov.threads.primitiveShips.tasks;

import com.github.dmitrKuznetsov.threads.primitiveShips.Tunnel;
import com.github.dmitrKuznetsov.threads.primitiveShips.ships.Ship;
import com.github.dmitrKuznetsov.threads.primitiveShips.ships.enums.ShipSize;
import com.github.dmitrKuznetsov.threads.primitiveShips.ships.enums.ShipType;

import java.util.Random;

public class ShipGenerator implements Runnable{

    private final Tunnel tunnel;
    private final int shipTotalNumber;
    private final Random random;

    private int shipCounter = 0;

    public ShipGenerator(Tunnel tunnel, int shipTotalNumber) {
        this.tunnel = tunnel;
        this.shipTotalNumber = shipTotalNumber;
        random = new Random();
    }

    @Override
    public void run() {
        while (shipCounter++ < shipTotalNumber) {
            Ship ship = new Ship(getRandomShipSize(), getRandomShipType());
            tunnel.addShip(ship);
        }

        System.out.printf("Thread: %s. The Ships are over\n", Thread.currentThread().getName());
    }

    private ShipSize getRandomShipSize() {
        return ShipSize.values()[random.nextInt(ShipSize.values().length)];
    }
    private ShipType getRandomShipType() {
        return ShipType.values()[random.nextInt(ShipType.values().length)];
    }
}

























