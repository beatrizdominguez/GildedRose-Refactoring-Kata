package com.gildedrose;

public class TicketItem extends Item implements IItem {
	
	public final static String TYPE_NAME = "TicketItem";

	public final static int DECREASE_VALUE = +1;
	public final static int SELL_IN_1 = 10;
	public final static int SELL_IN_2 = 5;
	public final static int NULL_QUALITY = 0;

	public TicketItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {

		if (this.quality < IItem.MAX_QUALITY && this.quality > IItem.MIN_QUALITY) {
			// SPEED
			int speed = 1;
			if (this.sellIn <= SELL_IN_1 && this.sellIn >= SELL_IN_2) {
				speed = 2;
			} else if (this.sellIn <= SELL_IN_2 && this.sellIn > 0) {
				speed = 3;
			}

			// UPDATE VALUE
			if (this.sellIn <= 0) {
				this.quality = NULL_QUALITY;
			} else {
				this.quality = this.quality + (speed * DECREASE_VALUE);
			}

			// CHECK MAX_QUALITY / MIN_QUALITY
			if (this.quality > IItem.MAX_QUALITY) {
				this.quality = IItem.MAX_QUALITY;
			} else if (this.quality < IItem.MIN_QUALITY) {
				this.quality = IItem.MIN_QUALITY;
			}
		}
	}

	@Override
	public void updateSellIn() {
		this.sellIn = this.sellIn - 1;
	}

}
