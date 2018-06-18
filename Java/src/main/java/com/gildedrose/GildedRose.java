package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {

		Inventory inventary = new Inventory();

		try {

			for (int i = 0; i < items.length; i++) {

				IItem iitem;
				iitem = getItemByType(items[i], inventary);

				// update item
				iitem.updateQuality();
				iitem.updateSellIn();

				Item it = (Item) iitem;
				// update info
				items[i].quality = it.quality;
				items[i].sellIn = it.sellIn;

			}

		} catch (Exception e) {
			System.out.println("Error getting the item updated");
			e.printStackTrace();
		}
	}

	public IItem getItemByType(Item item, Inventory inventary) throws Exception {

		String itemType = inventary.get(item.name);
		if (itemType != null) {

			switch (itemType) {
			case InverseItem.TYPE_NAME:
				return new InverseItem(item.name, item.sellIn, item.quality);

			case LegendaryItem.TYPE_NAME:
				return new LegendaryItem(item.name, item.sellIn, item.quality);

			case TicketItem.TYPE_NAME:
				return new TicketItem(item.name, item.sellIn, item.quality);

			case ConjuredItem.TYPE_NAME:
				return new ConjuredItem(item.name, item.sellIn, item.quality);

			default:
				return new NormalItem(item.name, item.sellIn, item.quality);
			}

		} else {
			return new NormalItem(item.name, item.sellIn, item.quality);
		}

	}

	public void updateQualityOriginal() {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].name.equals("Aged Brie")
					&& !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (items[i].quality > 0) {
					if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
						items[i].quality = items[i].quality - 1;
					}
				}
			} else {
				if (items[i].quality < 50) {
					items[i].quality = items[i].quality + 1;

					if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].sellIn < 11) {
							if (items[i].quality < 50) {
								items[i].quality = items[i].quality + 1;
							}
						}

						if (items[i].sellIn < 6) {
							if (items[i].quality < 50) {
								items[i].quality = items[i].quality + 1;
							}
						}
					}
				}
			}

			if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Aged Brie")) {
					if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].quality > 0) {
							if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
								items[i].quality = items[i].quality - 1;
							}
						}
					} else {
						items[i].quality = items[i].quality - items[i].quality;
					}
				} else {
					if (items[i].quality < 50) {
						items[i].quality = items[i].quality + 1;
					}
				}
			}
		}
	}
}