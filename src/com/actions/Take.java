package com.actions;

import com.entities.*;
import com.entities.Character;
/**
 * The specified character walks to an item and takes it. 
 * If the item is not visible in the same place as the character, you must also provide an entity, 
 * and the character takes the item from that entity instead.
 * @author Alireza Shirvani
 * @see com.entities.IEntity
 * @see com.entities.Character
 * @see com.entities.Item
 */
public class Take implements IAction{
	Character character;
	Item item;
	IEntity other;
	/**
	 * If the item is visible in the same place as the character, the character takes it. Otherwise, the action will fail.
	 * If the path to the item is blocked, the action will fail.
	 * The experience manager waits for the success of this action.
	 * @param character The character to take the item
	 * @param item The item that the character takes.
	 */
	public Take(Character character, Item item) {
		this.character=character;
		this.item=item;
	}
	/**
	 * If the item is not visible in the same place as the character, provide another entity, in the same place as the character.
	 * The character will walk to that entity instead and takes the item from it.
	 * @param character The character that takes the item
	 * @param item The item that the character takes and holds
	 * @param other character takes item from other
	 */
	public Take(Character character, Item item, IEntity other) {
		this(character, item);
		this.other=other;
	}
	/**
	 * @return Take
	 */
	@Override
	public String getName() {
		return "Take";
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
		if(other==null)
			return String.format("%s(%s, %s)", getName(), character.getName(), item.getName());
		else
			return String.format("%s(%s, %s, %s)", getName(), character.getName(), item.getName(), other.getName());
	}

}
