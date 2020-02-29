package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstageStrategy extends Strategy {
    @Override
    public void update(Item item) {
        if (item.getQuality() < 50) {
            item.plusQuality();
            if (item.getSellIn() < 11 && item.getQuality() < 50) {
                item.plusQuality();
            }
            if (item.getSellIn() < 6 && item.getQuality() < 50) {
                item.plusQuality();
            }
        }
        item.minusSellIn();

        if (item.getSellIn() >= 0) {
            return;
        }
        item.setQuality(0);
    }
}
