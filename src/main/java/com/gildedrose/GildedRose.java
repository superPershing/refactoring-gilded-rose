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
            return;
        }

        if (item.isNameEqualTo(AGED_BRIE)) {
            if (item.getQuality() < 50) {
                item.plusQuality();
            }
            item.minusSellIn();
            if (item.getSellIn() >= 0) {
                return;
            }

            if (item.getQuality() >= 50) {
                return;
            }
            item.plusQuality();
            return;
        }

        if (item.getQuality() > 0 && !item.isNameEqualTo(SULFURAS)) {
            item.minusQuality();
        } else if (item.getQuality() < 50) {
            item.plusQuality();
        }

        if (!item.isNameEqualTo(SULFURAS)) {
            item.minusSellIn();
        }

        if (item.getSellIn() >= 0) {
            return;
        }

        if (item.getQuality() > 0 && !item.isNameEqualTo(SULFURAS)) {
            item.minusQuality();
        }

    }

}
