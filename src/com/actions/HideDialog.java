package com.actions;

public class HideDialog implements IAction{
public String dialog;
	
	public HideDialog(String dialog) {
		this.dialog=dialog;
	}
	
	@Override
	public String getName() {
		return "HideDialog";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), this.dialog);
	}
}
