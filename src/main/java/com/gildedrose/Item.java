package com.gildedrose;

import java.util.Objects;

public class Item {

    private String name;

    private int sellIn;

    private int quality;
    private Strategy strategy;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        strategy = new CommonItemStrategy();
        if (name.equals("Aged Brie")) {
            strategy = new AgedBrieStrategy();
        }
        if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            strategy = new BackstageStrategy();
        }
        if (name.equals("Sulfuras, Hand of Ragnaros")) {
            strategy = new SulfurasStrategy();
        }
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void minusSellIn() {
        this.sellIn--;
    }

    public void plusQuality() {
        this.quality++;
    }

    public void minusQuality() {
        this.quality--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return sellIn == item.sellIn &&
                quality == item.quality &&
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void update() {
        strategy.update(this);
    }
}
