package com.actions;

public class SetCredits implements IAction{
	public String dialog;
	
	public SetCredits(String dialog) {
		this.dialog=dialog;
	}
	
	@Override
	public String getName() {
		return "SetCredits";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), this.dialog);
	}

}