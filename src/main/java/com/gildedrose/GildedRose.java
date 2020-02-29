package com.gildedrose;

import java.util.Arrays;

public class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::updateSingleItemQuality);
    }

    private void updateSingleItemQuality(Item item) {
        if (item.isNameEqualTo(BACKSTAGE)) {
            backstageStrategy(item);
            return;
        }

        if (item.isNameEqualTo(AGED_BRIE)) {
            agedBridStrategy(item);
            return;
        }

        if (item.isNameEqualTo(SULFURAS)) {
            sulfuasStrategy(item);
            return;
        }

        commonItemStrategy(item);

    }

    private void commonItemStrategy(Item item) {
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

    private void sulfuasStrategy(Item item) {
        if (item.getQuality() < 50) {
            item.plusQuality();
        }
    }

    private void agedBridStrategy(Item item) {
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

    private void backstageStrategy(Item item) {
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
