package com.actions;

public class ShowCredits implements IAction{
	
	
	@Override
	public String getName() {
		return "ShowCredits";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}
}
