package com.actions;

public class ShowDialog implements IAction{
	boolean Show;
	
	public ShowDialog(boolean Show) {
		this.Show = Show;
	}
	
	@Override
	public String getName() {
		return Show? "ShowDialog":"HideDialog";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}
}
