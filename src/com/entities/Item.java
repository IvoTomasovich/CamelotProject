package com.entities;

public class Item implements IEntity, IThing<Item.Items> {
	private String name;
	private Items template;
	
	public Item(String name, Items template) {
		this.name = name;
		this.template = template;
	}
	
	enum Items {
		Apple,
		Bag,
		BlueBook,
		BlueCloth,
		BlueKey,
		BluePotion,
		Bottle,
		Bread,
		ChickenLeg,
		Coin,
		Compass,
		Cup,
		EvilBook,
		GoldCup,
		GreenBook,
		GreenKey,
		GreenPotion,
		Hammer,
		Helmet,
		InkandQuill,
		JewelKey,
		LitTorch,
		Lock,
		MagnifyingGlass,
		OpenScroll,
		PurpleBook,
		PurpleCloth,
		PurpleKey,
		PurplePotion,
		Rags,
		Redbook,
		RedCloth,
		RedKey,
		RedPotion,
		Scroll,
		Skull,
		SpellBook,
		Sword,
		Torch
	}

	@Override
	public Items getTemplate() {
		return this.template;
	}

	@Override
	public String getName() {
		return this.name;
	}
}
