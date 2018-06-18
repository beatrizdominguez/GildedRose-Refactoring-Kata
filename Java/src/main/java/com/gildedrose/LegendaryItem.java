package com.gildedrose;

public class LegendaryItem extends Item implements IItem {

	public final static int QUALITY_VALUE = 80;

	public LegendaryItem(String name, int sellIn, int quality) {
		super(name, sellIn, QUALITY_VALUE);
	}

	@Override
	public void updateQuality() {
		// NO MODIFICATION IN QUALITY
	}

	@Override
	public void updateSellIn() {
		// NO MODIFICATION IN SELLINGIN
	}

}
