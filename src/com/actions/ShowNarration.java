package com.actions;

public class ShowNarration implements IAction{
	boolean Show;
	
	public ShowNarration(boolean Show) {
		this.Show = Show;
	}
	@Override
	public String getName() {
		return Show? "ShowNarration":"HideNarration";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}

}
