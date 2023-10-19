package com.actions;

import com.entities.Item;
import com.entities.Character;

public class SetPosition implements IAction{
	
	private Character character;
	private Item item;
	private Position position;

	public SetPosition(Character character, Position position) {
		this.character = character;
		this.position = position;
	}
	
	public SetPosition(Item item, Position position) {
		this.item = item;
		this.position = position;
	}
	
	@Override
	public String getName() {
		return "SetPosition";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		if (character == null) {
			return String.format("%s(%s, %s)", getName(), item.getName(), position);
		} else {
			return String.format("%s(%s, %s)", getName(), character.getName(), position);

		}
	}

}
