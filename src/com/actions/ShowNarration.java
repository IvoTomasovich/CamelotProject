package com.actions;

public class ShowNarration implements IAction{

	@Override
	public String getName() {
		return "ShowNarration";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s", getName());
	}

}
