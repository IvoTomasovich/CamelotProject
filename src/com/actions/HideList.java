package com.actions;


public class HideList implements IAction{
	
	
	@Override
	public String getName() {
		return "HideList";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s", getName());
	}

}