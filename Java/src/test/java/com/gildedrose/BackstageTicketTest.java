package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemList.BACKSTAGE_TICKET;
import static com.gildedrose.ItemTest.qualityOf;
import static com.gildedrose.ItemTest.sellInOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstageTicketTest {
    @Test
    void qualityStandartTest() {
        Item[] items = new Item[] { backstageTicket(2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(BACKSTAGE_TICKET.toString(), app.items.get(0).name);
    }

    @Test
    void qualityISIncreasing() {
        Item[] items = new Item[] { backstageTicket(0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, qualityOf(app));
    }

    @Test
    void qualityIsDecreasing() {
        Item[] items = new Item[] { backstageTicket(20, 1)  };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(3, qualityOf(app));
    }

    @Test
    void qualityIsDecreasingBy3() {
        Item[] items = new Item[] { backstageTicket(6, 0)  };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(3, qualityOf(app));
    }

    @Test
    void qualityUpdateMultipleTimes() {
        Item[] items = new Item[] { backstageTicket(5, 0)  };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(4, qualityOf(app));
    }

    @Test
    void qualityUpdateMultipleTimesUntilTicktLosstValue() {
        Item[] items = new Item[] {  backstageTicket(2, 2)  };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, qualityOf(app));
        assertEquals(-2, sellInOf(app));
    }

    private Item backstageTicket(int sellIn, int quality){
        return BackstageTicket.newItem(sellIn, quality).item;
    }
}
