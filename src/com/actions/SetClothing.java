package com.actions;

import com.entities.Character;
import com.entities.Character.Clothing;

/**
 * Changes the outfit of a character. If the character does not exist, use CharacterCreation to set their outfit instead.
 *  * The experience manager does not wait for the success of this action.
 * @author Alireza Shirvani
 * @see com.entities.Character
 * @see com.sequences.CharacterCreation
 */
public class SetClothing implements IAction {
	/**
	 * @return false
	 */
	@Override
	public boolean getShouldWait() {
		return false;
	}
	
	/**
	 * @return SetClothing
	 */
	@Override
	public String getName() {
		return "SetClothing";
	}
	
	private Character character;
	/**
	 * Changes the outfit of a character to the outfit that was set when creating that character.
	 * If no outfit was set, the default outfit is Peasant.
	 * @param character The outfit of this character will change to their original outfit
	 */
	public SetClothing(Character character) {
		this.character=character;
		this.clothing = character.getClothing();
	}
	private Clothing clothing;
	/**
	 * Changes the outfit of a character to another outfit
	 * @param character The outfit of this character will change
	 * @param clothing The new outfit of the character
	 */
	public SetClothing(Character character, Clothing clothing) {
		this.character=character;
		this.clothing=clothing;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s)", getName(), character.getName(), clothing.toString());
	}



}
