package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemList.AGED_BRIE;
import static com.gildedrose.ItemTest.qualityOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieTest {
    @Test
    void agedBrieNameTest() {
        Item[] items = new Item[] { brieItem(2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(AGED_BRIE.toString(), app.items.get(0).name);
    }

    @Test
    void agedBrieZeroQualityGoesUp() {
        Item[] items = new Item[] { brieItem(0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, qualityOf(app));
    }

    @Test
    void agedBrieQualityUpdateTwiceGoesUpTwice() {
        Item[] items = new Item[] { brieItem(0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(2, qualityOf(app));
    }

    @Test
    void agedBrieQualityUpdateMultipleGoesUpMultiple() {
        Item[] items = new Item[] { brieItem(0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(4, qualityOf(app));
    }

    @Test
    void agedBrieQualityUpdateMultipleGoesUpMultiple_WithStartQuality() {
        Item[] items = new Item[] { brieItem(0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(6, qualityOf(app));
    }

    @Test
    void agedBrieQualityUpdateMultipleGoesUpMultiple_WithStartQuality_WithSellInValue() {
        Item[] items = new Item[] {brieItem(1, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(6, qualityOf(app));
    }

    @Test
    void qualityNeverGoesAboveMax() {
        Item[] items = new Item[] { brieItem(2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(50, qualityOf(app));
    }

    private Item brieItem(int sellIn, int quality){
        return AgedBrie.newItem(sellIn, quality).item();
    }
}
