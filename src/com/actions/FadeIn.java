package com.actions;

public class FadeIn implements IAction{
	
	
	@Override
	public String getName() {
		return "FadeIn";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}

}
