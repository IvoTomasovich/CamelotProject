package com.actions;
import com.entities.*;
import com.entities.Character;

public class SetRight implements IAction{
	
	private Character character;
	
	public SetRight(Character character) {
		this.character = character;
	}

	@Override
	public String getName() {
		return "SetLeft";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), character.getName());
	}

}
