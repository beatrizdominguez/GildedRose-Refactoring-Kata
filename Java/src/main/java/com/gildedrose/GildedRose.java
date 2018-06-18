package com.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GildedRose {
	Item[] items;

	String[] inverseItemNames = { "Aged Brie"};

	String[] legendaryItemNames = { "Sulfuras, Hand of Ragnaros" };
	
	String[] ticketItemNames = { "Backstage passes to a TAFKAL80ETC concert" };
	
	String[] conjuredItemNames = { "Conjured Mana Cake" };

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {

		List<IItem> itemList = new ArrayList();

		for (int i = 0; i < items.length; i++) {
			
			IItem iitem = getItemByType(items[i]);
			//update item 
			iitem.updateQuality();
			iitem.updateSellIn();
			
			Item it = (Item) iitem;
			//update info
			items[i].quality = it.quality;
			items[i].sellIn = it.sellIn;
			
			

			//itemList.add(getItemByType(items[i]));
			
			//IItem iitem = itemList.get(i);

			// getType
			// quality
			//System.out.println("UPDATE QUALITY");
			//itemList.get(i).updateQuality();
			// sellIn
			//System.out.println("UPDATE SELLIN");
			//itemList.get(i).updateSellIn();
			

		}
	}

	public IItem getItemByType(Item item) {
		
//		System.out.println(" item.name = " + item.name );
		
		
		 if(Arrays.asList(inverseItemNames).contains(item.name)){
//			System.out.println("INVERSE ITEM");
			return new InverseItem(item.name, item.sellIn, item.quality);
			
		} else if(Arrays.asList(legendaryItemNames).contains(item.name)){
//			System.out.println("LEGENDARY ITEM");
			return new LegendaryItem(item.name, item.sellIn, item.quality);
			
		} else if(Arrays.asList(ticketItemNames).contains(item.name)){
//			System.out.println("TICKET ITEM");
			return new TicketItem(item.name, item.sellIn, item.quality);
			
		} else if(Arrays.asList(conjuredItemNames).contains(item.name)){
//			System.out.println("CONJURED ITEM");
			return new ConjuredItem(item.name, item.sellIn, item.quality);
		}else{
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