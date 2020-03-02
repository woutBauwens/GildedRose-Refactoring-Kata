package com.gildedrose;

import static com.gildedrose.ItemUpdater.MIN;

public class NormalItem extends ItemAdapter {
    private NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    static NormalItem newItem(String name, int sellIn, int quality){
        return new NormalItem(name, sellIn, quality);
    }

    static NormalItem newItem(Item item){
        return new NormalItem(item.name, item.sellIn, item.quality);
    }

    @Override
    ItemAdapterHook updateQuality() {
        if(item.quality > MIN) {
            item.quality = item.quality - 1;
        }
        return conjuringHook();
    }
}
