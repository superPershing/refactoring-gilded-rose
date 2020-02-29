package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieStrategy extends Strategy {
    @Override
    public void update(Item item) {
        if (item.getQuality() < 50) {
            item.plusQuality();
        }
        item.minusSellIn();
        if (item.getSellIn() >= 0) {
            return;
        }

        if (item.getQuality() < 50) {
            item.plusQuality();
        }
    }
}
