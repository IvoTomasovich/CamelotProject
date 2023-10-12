package com.actions;

public class FadeIn implements IAction{

	@Override
	public String getName() {
		return "FadeIn";
	}

	@Override
	public boolean getShouldWait() {
		return false;
	}
	
	public String ToString() {
		return String.format("%s(%s)", getName());
	}

}
