package com.gildedrose;

import static com.gildedrose.ItemList.*;

public class ItemUpdater {
    private Item item;
    private boolean conjured;

    static final int MIN = 0;
    static final int MAX = 50;

    private ItemUpdater(Item item) {
        this.item = item;
    }

    static ItemUpdater forItem(Item item) {
        return new ItemUpdater(item);
    }

    Item update(){
        updateQuality();
        updateSellIn();
        return item;
    }

    void conjure(){
        conjured = true;
    }

    private void updateSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    private void updateQuality() {
        ItemAdapter adapter = itemFactory();
        adapter.updateQuality()
                .withConjuring(conjured);

        item = adapter.item();
    }

    private ItemAdapter itemFactory(){
        if (SULFURAS.is(item)) {
            return Sulfuras.newItem(item);
        } else if (AGED_BRIE.is(item)) {
            return AgedBrie.newItem(item);
        } else if (BACKSTAGE_TICKET.is(item)) {
            return BackstageTicket.newItem(item);
        }

        return NormalItem.newItem(item);
    }
}


