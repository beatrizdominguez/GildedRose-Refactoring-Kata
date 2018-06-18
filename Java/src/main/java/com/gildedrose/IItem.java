package com.gildedrose;

public interface IItem {

	public static final int MAX_QUALITY = 50;

	public static final int MIN_QUALITY = 0;

	public static final int MIN_SELL_IN = 0;

	public void updateQuality();

	public void updateSellIn();

}
