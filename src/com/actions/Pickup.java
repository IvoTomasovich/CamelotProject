package com.actions;

import com.entities.Furniture;
import com.entities.Item;

public class Pickup implements IAction{
	private Character character;
	private Item item;
	private Furniture furniture;
	
	public Pickup(Character character, Item item) {
		this.character = character;
		this.item = item;
	}
	
	public Pickup(Character character, Item item, Furniture furniture) {
		this.character = character;
		this.item = item;
		this.furniture = furniture;
	}

	@Override
	public String getName() {
		return "Pickup";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		if (furniture == null) {
			return String.format("%s(%s, %s)", getName(), item.getName());
		} else {
			return String.format("%s(%s, %s)", getName(), item.getName(), furniture.getName());
			}
		}
	}
	
