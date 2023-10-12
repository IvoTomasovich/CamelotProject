package com.actions;
import com.entities.Character;
import com.entities.Item;


public class Give implements IAction{
	private Character character1;
	private Item item;
	private Character character2;
	
	public Give(Character character1, Item item, Character character2) {
		this.character1 = character1;
		this.item = item;
		this.character2 = character2;
	}

	@Override
	public String getName() {
		return "Give";
	}
	
	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s, %s)", getName(), character1.getName(), item.getName(), character2.getName());
	}
	
}
