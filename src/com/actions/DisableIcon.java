package com.actions;

import com.playerInput.ActionChoice;

/**
 * The story graph automatically creates instances of this class. This action corresponds to Camelot's DisableIcon. 
 * It is used to disable all previously enabled player choices.
 * The experience manager does not wait for the success of this action.
 * @author Alireza Shirvani
 * @see com.playerInput.ActionChoice
 */
public class DisableIcon implements IAction{
	/**
	 * @return DisableIcon
	 */
	@Override
	public String getName() {
		return "DisableIcon";
	}
	/**
	 * @return false
	 */
	@Override
	public boolean getShouldWait() {
		return false;
	}
	private ActionChoice choice;
	/**
	 * @param choice The player choice that was enabled before
	 */
	public DisableIcon(ActionChoice choice) {
		this.choice=choice;
	}
	@Override
	public String toString() {
			return String.format("%s(%s, %s)", getName(), choice.action, choice.target.getName());
		}
}
