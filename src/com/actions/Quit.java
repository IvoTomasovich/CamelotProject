package com.actions;

public class Quit implements IAction{
	
	@Override
	public String getName() {
		return "Quit";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName());
	}

}
