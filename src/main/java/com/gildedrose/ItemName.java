package com.gildedrose;

import java.util.Arrays;
import java.util.HashMap;

public enum ItemName {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros");

    private static HashMap<String, ItemName> strategyEnumMap = new HashMap<>();

    static {
        Arrays.stream(ItemName.values()).forEach(i -> strategyEnumMap.put(i.name, i));
    }

    String name;

    ItemName(String name) {
        this.name = name;
    }

    public static ItemName forName(String name) {
        return strategyEnumMap.get(name);
    }
}