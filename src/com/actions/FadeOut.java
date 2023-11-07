package com.actions;

public class FadeOut implements IAction{
	boolean show;
	
	public FadeOut(boolean show) {
		this.show = show;
	}
	
	@Override
	public String getName() {
		return show? "FadeOut":"FadeIn";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String ToString() {
		return String.format("%s()", getName());
	}

}
