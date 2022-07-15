package com.github.dmitrKuznetsov.threads.primitiveShips.ships;

import com.github.dmitrKuznetsov.threads.primitiveShips.ships.enums.ShipSize;
import com.github.dmitrKuznetsov.threads.primitiveShips.ships.enums.ShipType;

public class Ship {

    private final ShipSize size;
    private final ShipType type;
    private int goodsCount;

    public Ship(ShipSize size, ShipType type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "size=" + size +
                ", type=" + type +
                '}';
    }

    public ShipType getType() {
        return type;
    }

    public boolean isFull() {
        return goodsCount >= size.value;
    }

    public boolean load(int goods) {
        if (goodsCount >= size.value) return false;

        goodsCount += goods;
        return true;
    }
}
