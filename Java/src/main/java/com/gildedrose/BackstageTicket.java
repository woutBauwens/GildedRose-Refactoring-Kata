package com.gildedrose;

import static com.gildedrose.ItemUpdater.MAX;

public class BackstageTicket extends ItemAdapter {
    private BackstageTicket(int sellIn, int quality) {
        super(ItemList.BACKSTAGE_TICKET.toString(), sellIn, quality);
    }

    static BackstageTicket newItem(int sellIn, int quality){
        return new BackstageTicket(sellIn, quality);
    }

    static BackstageTicket newItem(Item item){
        return new BackstageTicket(item.sellIn, item.quality);
    }

    @Override
    ItemAdapterHook updateQuality() {
        if(item.sellIn > 0){
            update();
        } else {
            item.quality = 0;
        }

        return conjuringHook();
    }

    private void update(){
        item.quality = item.quality + 1;

        if (item.sellIn < 11) {
            item.quality = item.quality++;
        }

        if (item.sellIn < 6) {
            if (item.quality < MAX) {
                item.quality = item.quality++;
            }
        }
    }
}
