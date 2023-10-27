package com.actions;

import com.entities.Furniture;
import com.entities.Character;;

/**
 * Create an instance of this class whenever you want a character to leave a place and enter another one.
 * The experience manager waits for the success of this action.
 * @author Alireza Shirvani
 * @see com.entities.Character
 * @see com.entities.Furniture
 * @see com.entities.Enter
*/
public class Enter implements IAction{
	Character character;
	Furniture furniture;
	boolean fadeIn;
	
	/**
	 * @param character The character that will leave through a door
	 * @param furniture The door that Character will leave through
	 * @param fadeOut Set true if you want to screen to fade out after Character leaves through the door
	 */
	public Enter(Character character, Furniture furniture, boolean fadeIn) {
		this.character=character;
		this.furniture=furniture;
		this.fadeIn=fadeIn;
	}
	
	/**
	 * @return Exit
	 */
	@Override
	public String getName() {
		return "Enter";
	}

	/**
	 * @return true
	 */
	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s, %s)", getName(), character.getName(), furniture.getName(), fadeIn);
	}

}
