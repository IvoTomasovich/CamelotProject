package com.actions;


public class ClearDialog implements IAction{
	
	@Override
	public String getName() {
		return "ClearDialog";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s", getName());
	}

}
