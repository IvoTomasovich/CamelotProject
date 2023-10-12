package com.actions;


public class SetDialog implements IAction{
	public String dialog;
	
	public SetDialog(String dialog) {
		this.dialog=dialog;
	}
	
	@Override
	public String getName() {
		return "SetDialog";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), this.dialog);
	}

}
