package com.actions;

public class HideNarration implements IAction{
	

	@Override
	public String getName() {
		return "HideNarration";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName());
	}
}
