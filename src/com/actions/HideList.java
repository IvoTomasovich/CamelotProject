package com.actions;


public class HideList implements IAction{
	boolean show;
	
	
	@Override
	public String getName() {
		return show? "HideList":"ShowList";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName());
	}

}