package com.gildedrose;

public class Sulfuras extends ItemAdapter {
    private static final int qualityOfSulfuras = 80;

    private Sulfuras(int sellIn) {
        super(ItemList.SULFURAS.toString(), sellIn, qualityOfSulfuras);
    }

    static Sulfuras newItem(int sellIn){
        return new Sulfuras(sellIn);
    }

    static Sulfuras newItem(Item item){
        return new Sulfuras(item.sellIn);
    }

    @Override
    ItemAdapterHook updateQuality() {
        return conjuringHook();
    }
}
