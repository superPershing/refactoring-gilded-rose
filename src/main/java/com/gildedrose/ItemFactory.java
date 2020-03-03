package com.gildedrose;

import com.gildedrose.strategy.AgedBrieStrategy;
import com.gildedrose.strategy.BackstageStrategy;
import com.gildedrose.strategy.CommonItemStrategy;
import com.gildedrose.strategy.SulfurasStrategy;

import java.util.Arrays;
import java.util.HashMap;


public class ItemFactory {
    public static Item createItem(String name, int sellIn, int quality) {
        ItemName itemName = ItemName.fromName(name);
        if (itemName == null) {
            return new Item(name, sellIn, quality, new CommonItemStrategy());
        }
        switch (itemName) {
            case AGED_BRIE:
                return new Item(name, sellIn, quality, new AgedBrieStrategy());
            case SULFURAS:
                return new Item(name, sellIn, quality, new SulfurasStrategy());
            case BACKSTAGE:
                return new Item(name, sellIn, quality, new BackstageStrategy());
            default:
                return new Item(name, sellIn, quality, new CommonItemStrategy());
        }
    }

    public enum ItemName {
        AGED_BRIE("Aged Brie"),
        BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
        SULFURAS("Sulfuras, Hand of Ragnaros");

        private static HashMap<String, ItemName> hashMap = new HashMap<>();

        static {
            Arrays.stream(ItemName.values()).forEach(i -> hashMap.put(i.name, i));
        }

        String name;

        ItemName(String name) {
            this.name = name;
        }

        public static ItemName fromName(String name) {
            return hashMap.get(name);
        }
    }
}
