package com.actions;

import com.entities.IThing;

/**
 * You can create an instance of this class to run Camelot's "CreateCharacter", "CreatePlace", "CreateItem" actions.
 * The experience manager waits for the success of this action.
 * @author Alireza Shirvani
 * @param <T> T is the type of the Thing that you want to create. Supply T with types, Character, Place, or Item.
 * @see com.entities.IThing
 * @see com.entities.Character
 * @see com.entities.Place
 * @see com.entities.Item
 */
public class Create<T extends IThing<?>> implements IAction {
	/**
	 * The instance of the Thing that will be created
	 */
	T toCreate;
	
	/**
	 * @return true
	 */
	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	/**
	 * @return CreateCharacter, CreateItem, or CreatePlace
	 */
	@Override
	public String getName() {
		return "Create"+toCreate.getClass().getSimpleName();
	}
	
	/**
	 * @param t The instance of the Thing that must be created
	 */
	public Create(T t) {
		this.toCreate=t;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s)",getName(), toCreate.getName(), toCreate.getTemplate());
	}



}
