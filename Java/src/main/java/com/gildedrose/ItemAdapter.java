package com.gildedrose;

abstract class ItemAdapter {
    private ItemAdapterHook conjuringHook = new ItemAdapterHook();
    Item item;

    ItemAdapter(String name, int sellIn, int quality) {
        item = new Item(name, sellIn, quality);
    }

    abstract ItemAdapterHook updateQuality();

    Item item(){
        return item;
    }

    ItemAdapterHook conjuringHook(){
        return conjuringHook;
    }

    class ItemAdapterHook {
        void withConjuring(boolean conjured) {
            if(conjured){
                updateQuality();
            }
        }
    }
}
