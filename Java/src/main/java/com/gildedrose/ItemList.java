package com.gildedrose;

public enum ItemList {
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_TICKET("Backstage passes to a TAFKAL80ETC concert");

    private String name;

    ItemList(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean is(Item item) {
        return name.equals(item.name);
    }
}
