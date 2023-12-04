package com.actions;

//import com.entities.Character.HairStyles;
import com.entities.Character;

public class SetHairStyle implements IAction{
	private Character character;
	//private HairStyles hairstyle;
	
	public SetHairStyle(Character character) {
		this.character = character;
		//this.hairstyle = hairstyle;
	}
	
	@Override
	public String getName() {
		return "SetHairStyle";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s, %s)", getName(), character.getName(), character.gethair());
	}

}
