package com.entities;

public class Place implements IThing<Place.Places> {
	private String name;
	private Places template;
	
	public Place(String name, Places template) {
		this.name = name;
		this.template = template;
	}
	
	public enum Places {
		AlchemyShop,
		Blacksmith,
		Bridge,
		Camp,
		CastleBedroom,
		CastleCrossroads,
		City,
		Cottage,
		Courtyard,
		DiningRoom,
		Dungeon,
		Farm,
		ForestPath,
		GreatHall,
		Hallway,
		Library,
		Port,
		Ruins,
		SpookyPath,
		Storage,
		Tavern, 
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Places getTemplate() {
		return this.template;
	}
	
	public Furniture getFurniture(String furn) {
		String furnitureFullName = this.name + "." + furn;
		return new Furniture(furnitureFullName);
	}
	
	
}
