package com.github.dmitrKuznetsov.threads.primitiveShips.ships.enums;

public enum ShipSize {
    SMALL(10),
    MIDDLE(50),
    LARGE(100);

    public final int value;

    ShipSize(int value) {
        this.value = value;
    }
}
