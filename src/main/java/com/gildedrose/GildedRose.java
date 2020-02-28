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
        stage1(item);

        stage2(item);

        stage3(item);
    }

    private void stage1(Item item) {
        if (!item.isNameEqualTo(AGED_BRIE) && !item.isNameEqualTo(BACKSTAGE)
                && item.getQuality() > 0 && !item.isNameEqualTo(SULFURAS)) {
            item.setQuality(item.getQuality() - 1);
            return;
        }
        if (item.getQuality() >= 50) {
            return;
        }

        item.setQuality(item.getQuality() + 1);

        if (item.isNameEqualTo(BACKSTAGE) && item.getSellIn() < 11 && item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }

        if (item.isNameEqualTo(BACKSTAGE) && item.getSellIn() < 6 && item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private void stage2(Item item) {
        if (!item.isNameEqualTo(SULFURAS)) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    private void stage3(Item item) {
        if (item.getSellIn() >= 0) {
            return;
        }
        if (item.isNameEqualTo(BACKSTAGE)) {
            item.setQuality(0);
            return;
        }

        if (item.isNameEqualTo(AGED_BRIE) && item.getQuality() >= 50) {
            return;
        }

        if (item.isNameEqualTo(AGED_BRIE) && item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
            return;
        }

        if (item.getQuality() > 0 && !item.isNameEqualTo(SULFURAS)) {
            item.setQuality(item.getQuality() - 1);
        }

    }
}
