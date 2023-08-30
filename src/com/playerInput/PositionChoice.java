package com.playerInput;

import com.entities.Character;
import com.entities.IEntity;

/**
 * This class implements IPlayerChoice to represent the player entering or leaving a certain position. 
 * All entities and things have at least one position
 * @author Alireza Shirvani
 *
 */
public class PositionChoice implements IPlayerChoice{

	/**
	 * The name of the position that the player could interact with
	 */
	private String position;
	/**
	 * The character that represents the player
	 */
	private Character character;
	/**
	 * Whether the player enters (arrived at) or leaves (exited) the specified position
	 */
	private Condition condition;
	
	/**
	 * An enum representing arriving at or exiting a position
	 * @author Alireza Shirvani
	 */
	public enum Condition{arrived, exited}
	/**
	 * Constructor
	 * @param character The character representing the player
	 * @param entity The entity containing the position that the player interacts with
	 * @param condition Whether the player arrived at or exits this position
	 */
	public PositionChoice(Character character, IEntity entity, Condition condition) {
		this(character, entity.getName(), condition);
	}
	
	/**
	 * Constructor
	 * @param character The character representing the player
	 * @param position The name of the position that the player interacts with
	 * @param condition Whether the player arrived at or exits this position
	 */
	public PositionChoice(Character character, String position, Condition condition) {
		this.character=character;
		this.position=position;
		this.condition=condition;
	}
	
	@Override
	public String getInputMsg() {
		return String.format("input $ %s position %s", condition.toString(), character.getName(), position);
	}

}
