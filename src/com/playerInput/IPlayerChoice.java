package com.playerInput;

/**
 * This class represents a player choice or an edge of a story graph
 * @author Alireza Shirvani
 *
 */
public interface IPlayerChoice {
	/**
	 * This function summarizes this player choice to a string that is readable by Camelot
	 * @return The Camelot input message that corresponds to this player choice. This message is determined by the classes that 
	 * implement this interface
	 */
	public String getInputMsg();
}
