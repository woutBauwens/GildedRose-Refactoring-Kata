package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemList.SULFURAS;
import static com.gildedrose.ItemTest.qualityOf;
import static com.gildedrose.ItemTest.sellInOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasTest {
    @Test
    void sulfurasNameCorrect() {
        Item[] items =  getSulfurases(1);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(SULFURAS.toString(), app.items.get(0).name);
    }

    @Test
    void sulfurasQualityIs80() {
        Item[] items = getSulfurases(1);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, qualityOf(app));
    }

    @Test
    void sulfurasQualityRemains80AfterManyUpdates() {
        Item[] items = getSulfurases(0);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(80, qualityOf(app));
        assertEquals(-4, sellInOf(app));
    }

    private Item[] getSulfurases(int sellIn){
        return new Item[] { Sulfuras.newItem(sellIn).item() };
    }
}
