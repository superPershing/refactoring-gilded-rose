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
        if (!item.isNameEqualTo(AGED_BRIE) && !item.isNameEqualTo(BACKSTAGE)
                && item.getQuality() > 0 && !item.isNameEqualTo(SULFURAS)) {
            item.setQuality(item.getQuality() - 1);
        } else if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);

            if (item.isNameEqualTo(BACKSTAGE)) {
                if (item.getSellIn() < 11 && item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }

                if (item.getSellIn() < 6 && item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }

        if (!item.isNameEqualTo(SULFURAS)) {
            item.setSellIn(item.getSellIn() - 1);
        }

        if (item.getSellIn() < 0) {
            if (!item.isNameEqualTo(AGED_BRIE)) {
                if (!item.isNameEqualTo(BACKSTAGE)) {
                    if (item.getQuality() > 0 && !item.isNameEqualTo(SULFURAS)) {
                        item.setQuality(item.getQuality() - 1);
                    }
                } else {
                    item.setQuality(0);
                }
            } else if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }
        }
    }
}
