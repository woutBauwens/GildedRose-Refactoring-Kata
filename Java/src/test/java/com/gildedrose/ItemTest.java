package com.gildedrose;

class ItemTest {
    static int qualityOf(GildedRose app) {
        return app.items.get(0).quality;
    }

    static int sellInOf(GildedRose app) {
        return app.items.get(0).sellIn;
    }
}
