package com.actions;

/**
 * Create an instance of this class whenever you want to enable player input after disabling it. 
 * Mind that you need to enable player input once for every time you have disabled it.
 * The experience manager waits for the success of this action.
 * @author Alireza Shirvani
 * @see com.actions.DisableInput
*/
public class EnableInput implements IAction {
	boolean enable;
	public EnableInput(boolean enable) {
		this.enable=enable;
	}
	@Override
	public String getName() {
		return enable? "EnableInput":"DisableInput";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s()", getName());
	}

}
