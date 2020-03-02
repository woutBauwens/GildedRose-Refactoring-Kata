package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemTest.qualityOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    //@Test
    void foo() {
        Item[] items = normalItems(0,0);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items.get(0).name);
    }

    @Test
    void qualityDegradesByOne() {
        Item[] items = normalItems(2, 2);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, qualityOf(app));
    }

    @Test
    void qualityDegradesByOneUpdateTwiceToZero() {
        Item[] items = normalItems(2, 2);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, qualityOf(app));
    }

    @Test
    void qualityCannotBeNegative() {
        Item[] items = normalItems(2, 2);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, qualityOf(app));
    }

    @Test
    void itemWithSellInFilledIn() {
        Item[] items = normalItems(1, 2);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, qualityOf(app));
    }

    private Item[] normalItems(int sellIn, int quality){
        return new Item[] {NormalItem.newItem("foo", sellIn, quality).item()};
    }
}
