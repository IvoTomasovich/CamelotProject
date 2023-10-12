package com.actions;

public class SetNarration implements IAction{
	
	private String narration;
	
	public SetNarration(String narration) {
		this.narration = narration;
	}

	@Override
	public String getName() {
		return "SetNarration";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), this.narration);
	}
}
