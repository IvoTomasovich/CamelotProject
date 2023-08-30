package com.actions;

import com.entities.IEntity;

/**
 * Set the focus of the main camera to an entity. 
 * If that entity is a character and input is enabled, the player can control the character using mouse and keyboard.
 * The experience manager waits for the success of this action.
 * @author Alireza Shirvani
 * @see com.entities.IEntity
 */
public class SetCameraFocus implements IAction{
	private IEntity focus;
	
	/**
	 * @param focus The entity that the camera will focus on.
	 */
	public SetCameraFocus(IEntity focus) {
		this.focus=focus;
	}
	/**
	 * @return SetCameraFocus
	 */
	@Override
	public String getName() {
		return "SetCameraFocus";
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
		return String.format("%s(%s)", getName(), focus.getName());
	}
}
