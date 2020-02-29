package com.gildedrose;

public class CommonItemStrategy extends Strategy {
    @Override
    public void update(Item item) {
        if (item.getQuality() > 0) {
            item.minusQuality();
        } else if (item.getQuality() < 50) {
            item.plusQuality();
        }

        item.minusSellIn();

        if (item.getSellIn() >= 0) {
            return;
        }

        if (item.getQuality() > 0) {
            item.minusQuality();
        }
    }
}
