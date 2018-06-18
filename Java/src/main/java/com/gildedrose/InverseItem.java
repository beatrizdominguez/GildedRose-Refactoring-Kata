package com.gildedrose;

public class InverseItem extends Item implements IItem {

	public final static String TYPE_NAME = "InverseItem";
	public final static int DECREASE_VALUE = +1;

	public InverseItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {

		if (this.quality < IItem.MAX_QUALITY && this.quality >= IItem.MIN_QUALITY) {

			// SPEED
			int speed = 1;
			if (this.sellIn <= 0) {
				speed = 2;
			}

			// UPDATE VALUE
			this.quality = this.quality + (speed * DECREASE_VALUE);

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
