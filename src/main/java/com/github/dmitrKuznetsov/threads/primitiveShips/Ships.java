package com.github.dmitrKuznetsov.threads.primitiveShips;

// https://habr.com/ru/post/352374/

import com.github.dmitrKuznetsov.threads.primitiveShips.ships.enums.ShipType;
import com.github.dmitrKuznetsov.threads.primitiveShips.tasks.PierLoader;
import com.github.dmitrKuznetsov.threads.primitiveShips.tasks.ShipGenerator;

public class Ships {

    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel();

        ShipGenerator generator = new ShipGenerator(tunnel,10);

        PierLoader breadLoader = new PierLoader(tunnel, ShipType.BREAD);
        PierLoader bananaLoader = new PierLoader(tunnel, ShipType.BANANAS);
        PierLoader clothesLoader = new PierLoader(tunnel, ShipType.CLOTHES);

        new Thread(generator, "Generator").start();

        new Thread(breadLoader, "BreadLoader").start();
        new Thread(bananaLoader, "BananaLoader").start();
        new Thread(clothesLoader, "ClothesLoader").start();
    }
}
