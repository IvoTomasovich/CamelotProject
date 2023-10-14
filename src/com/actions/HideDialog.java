package com.actions;

public class HideDialog implements IAction{
public String dialog;
	boolean show;
	
	
	@Override
	public String getName() {
		return show?"HideDialog":"ShowDialog";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(\"%s\")", getName());
	}
}
