package com.entities;

public class Character implements IEntity, IThing<Character.BodyType>{
	private String name;
	private BodyType bodyType;
	private Clothing clothing;
	private HairStyles hairStyle;
	
	public Character(String name) {
		this.name = name;
	}
	
	public Character(String name, BodyType bodyType) {
		this.name = name;
		this.bodyType = bodyType;
	}
	
	public Character(String name, BodyType bodyType, Clothing clothing) {
		this.name = name;
		this.bodyType = bodyType;
		this.clothing = clothing;
	}
	
	public Character(String name, BodyType bodyType, Clothing clothing, HairStyles hairStyle) {
		this.name = name;
		this.bodyType = bodyType;
		this.clothing = clothing;
		this.hairStyle = hairStyle;
	}
	
	enum BodyType {
		A,
		B,
		C,
		D,
		E,
		F,
		G,
		H
	}
	
	enum Clothing {
		Bandit,
		Beggar,
		LightArmour,
		HeavyArmour,
		Merchant,
		Noble,
		Naked,
		Peasant,
		Priest
	}
	
	enum HairStyles {
		Long,
		Spiky,
		Short,
	}
	
	public BodyType body() {
		return this.bodyType;
	}
	
	public Clothing cloth() {
		return this.clothing;
	}
	
	public HairStyles hair() {
		return this.hairStyle;
	}
	
	public String getName() {
		return this.name;
	}
	
	public BodyType getTemplate() {
		return this.bodyType;
	}

	
}
