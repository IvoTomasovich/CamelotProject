package com.actions;

public class HideNarration implements IAction{
	boolean Show;
	
	public HideNarration(boolean Show) {
		this.Show = Show;
	}
	@Override
	public String getName() {
		return Show? "HideNarration":"ShowNarration";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}

}
