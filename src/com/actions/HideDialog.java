package com.actions;

public class HideDialog implements IAction{
	boolean Show;
	
	public HideDialog(boolean Show) {
		this.Show = Show;
	}
	
	@Override
	public String getName() {
		return Show? "HideDialog":"ShowDialog";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}
}
