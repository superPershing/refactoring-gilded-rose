package com.gildedrose;

import com.gildedrose.strategy.Strategy;

import java.util.Objects;


public class Item {
    private String name;
    private int sellIn;
    private int quality;
    private Strategy strategy;

    Item(String name, int sellIn, int quality, Strategy strategy) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.strategy = strategy;
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
