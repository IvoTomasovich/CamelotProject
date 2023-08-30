package com.playerInput;

/**
 * This class implements IPlayerChoice to represent when the player presses a keyboard key
 * @author Alireza Shirvani
 * @see com.playerInput.IPlayerChoice
 */
public class KeyboardChoice implements IPlayerChoice{

	/**
	 * The keyboard key that was pressed
	 */
	private Keys key;
	/**
	 * An enum representing all the keyboard keys that the player can press
	 * @author Alireza Shirvani
	 */
	public enum Keys{Pause, Inventory, Interact}
	/**
	 * The constructor
	 * @param key The keyboard key that corresponds to an object of this class
	 */
	public KeyboardChoice(Keys key) {
		this.key=key;
	}
	
	@Override
	public String getInputMsg() {
		return String.format("input Key %s", key.toString());
	}

}
