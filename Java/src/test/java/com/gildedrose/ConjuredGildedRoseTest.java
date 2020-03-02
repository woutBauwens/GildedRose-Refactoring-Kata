package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemTest.qualityOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredGildedRoseTest {

    @Test
    void itemWithConjuringAndQualityOfOneUpdatestoZero() {
        Item item = normalItems(2, 1);
        ItemUpdater updater = ItemUpdater.forItem(item);
        updater.conjure();
        item = updater.update();
        assertEquals(0, item.quality);
    }

    @Test
    void itemWithConjuringUpdatesQualityTwice() {
        Item item = normalItems(2, 4);
        ItemUpdater updater = ItemUpdater.forItem(item);
        updater.conjure();
        item = updater.update();
        assertEquals(2, item.quality);
    }

    private Item normalItems(int sellIn, int quality){
        return NormalItem.newItem("foo", sellIn, quality).item();
    }
}
