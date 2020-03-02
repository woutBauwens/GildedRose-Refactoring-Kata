package com.gildedrose;

public class AgedBrie extends ItemAdapter {
    private AgedBrie(int sellIn, int quality) {
        super(ItemList.AGED_BRIE.toString(), sellIn, quality);
    }

    static AgedBrie newItem(int sellIn, int quality){
        return new AgedBrie(sellIn, quality);
    }

    static AgedBrie newItem(Item item){
        return new AgedBrie(item.sellIn, item.quality);
    }

    @Override
    ItemAdapterHook updateQuality() {
        if(item.quality < ItemUpdater.MAX) {
            item.quality = item.quality + 1;

        }
        return conjuringHook();
    }
}
