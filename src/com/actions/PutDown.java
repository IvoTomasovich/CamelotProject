package com.actions;

import com.entities.Item;
import com.entities.Character;

public class PutDown implements IAction{
	private Character character;
	private Item item;
	
	public PutDown(Character character, Item item) {
		this.character = character;
		this.item = item;
	}
	
	
	@Override
	public String getName() {
		return "PutDown";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s)", getName(), character.getName(),item.getName());
	}
}
