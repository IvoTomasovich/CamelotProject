package com.playerInput;

import com.entities.IEntity;

/**
 * ActionChoice is the class you must use to create a player choice via interacting with other entities. 
 * For example a character sitting on a chair or taking an item from another character
 * @author Alireza Shirvani
 */
public class ActionChoice implements IPlayerChoice{
	public String action;
	public IEntity target;
	public Icons icon;
	public String description;
	public boolean isDefault;
	
	public enum Icons{
arrest,draw,drink,exit,forge,kneel,listen,lockpick,research,swords,talk,unlock,usekey,armour,beard,boot,crown,dress,gloves,helm,paintbrush,palette,sewing,brokenheart,charm,firespell,hurt,skull,snowflake,star,bed,cauldron,chair,chest,door,fireplace,lockedchest,lockeddoor,plant,target,throne,well,woodendoor,Items,apple,book,bookshelf,bread,chickenleg,coins,darkmagic,evilbook,flask,flower,healingpotion,ink,key,lovepotion,magnifyingglass,openscroll,padlock,poison,potion,present,ring,scroll,sword,torch,woodpile,Other,cancel,checkmark,dice_five,dice_four,dice_one,dice_six,dice_three,dice_two,fist,hand,hourglass,meal,music,sleep,snake,sunrise,time,tree,anvil,bridge,campfire,castle,city,cottage,dungeon,forest,mug,ship,shopsign,stonepath
	}
	/**
	 * Constructor
	 * @param action The name of the action when communicated with Camelot
	 * @param entity The entity involved in the action
	 */
	public ActionChoice(String action, IEntity entity) {
		this(action, entity, Icons.hand, "", true);
	}
	/**
	 * Constructor
	 * @param action The name of the action when communicated with Camelot
	 * @param entity The entity involved in the action
	 * @param icon The icon shown to the player for this option
	 */
	public ActionChoice(String action, IEntity entity, Icons icon) {
		this(action, entity, icon, "", true);
	}
	/**
	 * Constructor
	 * @param action The name of the action when communicated with Camelot
	 * @param entity The entity involved in the action
	 * @param icon The icon shown to the player for this option
	 * @param description The description of the action shown to the player for this option
	 * @param isDefault Whether this is the action that is performed when the player left-clicks on entity
	 */
	public ActionChoice(String action, IEntity entity, Icons icon, String description, boolean isDefault) {
		this.action=action;
		this.target=entity;
		this.icon=icon;
		this.description=description;
		this.isDefault=isDefault;
	}
	
	@Override
	public String getInputMsg() {
		return String.format("input %s %s", action, target.getName());
	}
}
