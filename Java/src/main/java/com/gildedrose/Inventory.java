package com.gildedrose;

import java.util.LinkedHashMap;

public class Inventory extends LinkedHashMap<String, String> {

	public Inventory() {
		this.put("Aged Brie", "InverseItem");
		this.put("Sulfuras, Hand of Ragnaros", "LegendaryItem");
		this.put("Backstage passes to a TAFKAL80ETC concert", "TicketItem");
		this.put("Conjured Mana Cake", "ConjuredItem");
	}

}
