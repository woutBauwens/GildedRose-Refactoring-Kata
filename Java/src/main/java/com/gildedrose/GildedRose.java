package com.gildedrose;

import java.util.List;

import static java.util.Arrays.asList;

class GildedRose {
    private Item currentItem;
    List<Item> items;

    GildedRose(com.gildedrose.Item[] items) {
        this.items = asList(items);
    }

    void updateQuality(){
        items.stream()
                .map(this::currentItem)
                .map(ItemUpdater::forItem)
                .map(ItemUpdater::update)
                .forEach(this::setValues);
    }

    private Item currentItem(Item item) {
        currentItem = item;
        return item;
    }

    private void setValues(Item item) {
        currentItem.quality = item.quality;
        currentItem.sellIn = item.sellIn;
    }
}