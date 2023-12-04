package com.actions;

public class HideCredits implements IAction{
	
	
	@Override
	public String getName() {
		return "HideCredits";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}
}
