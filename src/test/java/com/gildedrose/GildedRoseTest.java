package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class GildedRoseTest {
    private GildedRose gildedRose;
    private Item[] items;

    @Before
    public void setUp() {
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                new Item("Conjured Mana Cake", 3, 6)};

        gildedRose = new GildedRose(items);
    }

    @Test
    public void items_should_be_update_when_gilded_rose_update_quality() {
        gildedRose.updateQuality();

        assertThat(items).isEqualTo(getItemsWhenFirstDay());

        gildedRose.updateQuality();

        assertThat(items).isEqualTo(getItemsWhenSecondDay());
    }

    private Item[] getItemsWhenFirstDay() {
        return new Item[]{
                new Item("+5 Dexterity Vest", 9, 19), //
                new Item("Aged Brie", 1, 1), //
                new Item("Elixir of the Mongoose", 4, 6), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 23),
                new Item("Conjured Mana Cake", 2, 5)};
    }

    private Item[] getItemsWhenSecondDay() {
        return new Item[]{
                new Item("+5 Dexterity Vest", 8, 18), //
                new Item("Aged Brie", 0, 2), //
                new Item("Elixir of the Mongoose", 3, 5), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 13, 22),
                new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
                new Item("Conjured Mana Cake", 1, 4)};
    }


}
