package com.actions;

public class DisableInput implements IAction {
	boolean enable;
	
	@Override
	public String getName() {
		return enable? "DisableInput":"EnableInput";
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