package com.actions;

import com.entities.IThing;
import com.entities.*;
import com.entities.Character;

/**
 * Create an instance of this class whenever you want to change the position of a character or item.
 * The experience manager waits for the success of this action.
 * @author Alireza Shirvani
 *@see <a href="http://cs.uky.edu/~sgware/projects/camelot/v1-2/setPosition.html">SetPosition</a>
 *@see com.entities.IThing
 *@see com.entities.Character
 *@see com.entities.Item
*/
public class Position implements IAction {

	private Character character;
	private Item item;
	private IThing<?> thing;
	private String position;
	
	/**
	 * Make a character disappear. Mind that the character will still exist.
	 * @param character The character that will disappear
	 */
	public Position(Character character) {
		this.character=character;
	}
	/**
	 * Make an item disappear. Mind that the item will still exist.
	 * @param item The item that will disappear
	 */
	public Position(Item item) {
		this.item=item;
	}
	/**
	 * Move a character near a Thing
	 * @param character The character to move
	 * @param thing A place, item, or another character
	 * @see com.entities.IThing
	 */
	public Position(Character character, IThing<?> thing) {
		this(character);
		this.thing=thing;
	}
	/**
	 * Move a character to a specific position.
	 * @param character The character to move
	 * @param place The place that holds the position
	 * @param position The position or furniture name.
	 * @see You can see the furniture and positions within each place <a href="http://cs.uky.edu/~sgware/projects/camelot/v1-2/places.html">here</a>
	 */
	public Position(Character character, Place place, String position) {
		this(character, place);
		this.position=place.getName()+"."+position;
	}
	/**
	 * Move an item to a specific position.
	 * @param item The item to move
	 * @param place The place that holds the position
	 * @param position The position or furniture name.
	 * @see You can see the furniture and positions within each place <a href="http://cs.uky.edu/~sgware/projects/camelot/v1-2/places.html">here</a>
	 */
	public Position(Item item, Place place, String position) {
		this(item, place);
		this.position=place.getName()+"."+position;
	}
	/**
	 * Move an item near a Thing
	 * @param item The item to move
	 * @param thing A place, item, or another character
	 * @see com.entities.IThing
	 */
	public Position(Item item, IThing<?> thing) {
		this(item);
		this.thing=thing;
	}
	
	/**
	 * @return SetPosition
	 */
	@Override
	public String getName() {
		return "SetPosition";
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
		if(character!=null) {
			if(position!=null) {
				return String.format("%s(%s, %s)", getName(), character.getName(), position);
			}else if(thing!=null) {
				return String.format("%s(%s, %s)", getName(), character.getName(), thing.getName());
			}else {
				return String.format("%s(%s, null)", getName(), character.getName());
			}
		}else {
			if(position!=null) {
				return String.format("%s(%s, %s)", getName(), item.getName(), position);
			}else if(thing!=null) {
				return String.format("%s(%s, %s)", getName(), item.getName(), thing.getName());
			}else {
				return String.format("%s(%s, null)", getName(), item.getName());
			}
		}
		
	}

}
