package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("foo", app.getItems()[0].getName());
        assertThat(app.getItems()[0].getQuality(), is(4));
        assertThat(app.getItems()[0].getSellIn(), is(0));
    }

}
