package com.gildedrose;

public class SulfurasStrategy extends Strategy {
    @Override
    public void update(Item item) {
        if (item.getQuality() < 50) {
            item.plusQuality();
        }
    }
}
