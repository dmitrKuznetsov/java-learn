package com.github.dmitrKuznetsov.threads.primitiveShips.tasks;

import com.github.dmitrKuznetsov.threads.primitiveShips.Tunnel;
import com.github.dmitrKuznetsov.threads.primitiveShips.ships.Ship;
import com.github.dmitrKuznetsov.threads.primitiveShips.ships.enums.ShipType;

import java.util.Optional;

public class PierLoader implements Runnable{

    private final Tunnel tunnel;
    private final ShipType type;

    public PierLoader(Tunnel tunnel, ShipType type) {
        this.tunnel = tunnel;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Optional<Ship> optionalShip = tunnel.getShip(type);
                if (optionalShip.isEmpty()) {
                    System.out.printf("Thread: %s. Pier loader closed cause unexpected tunnel behaviour\n", Thread.currentThread().getName());
                    break;
                }
                Ship ship = optionalShip.get();

                while (!ship.isFull()) {
                    ship.load(10);
                    Thread.sleep(100);
                    System.out.printf("Thread: %s. Load 10 goods\n", Thread.currentThread().getName());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
