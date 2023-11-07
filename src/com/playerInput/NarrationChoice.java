package com.playerInput;

/**
 * This class implements IPlayerChoice to represent the player selecting a dialog or interface option
 * @author Alireza Shirvani
 * @see com.playerInput.PlayerChoice
 */
public class NarrationChoice implements IPlayerChoice{
	/**
	 * The text of the option that the player interacts with
	 */
	private String key;
	/**
	 * Constructor
	 * @param key The text of the option that the player interacts with
	 */
	public NarrationChoice(String key) {
		this.key=key;
	}
	
	@Override
	public String getInputMsg() {
		return String.format("input Close %s", key);
	}

}
