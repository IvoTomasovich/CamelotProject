package com.actions;

public class FadeIn implements IAction{
	boolean show;
	
	public FadeIn(boolean show) {
		this.show = show;
	}
	
	@Override
	public String getName() {
		return show? "FadeIn":"FadeOut";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String ToString() {
		return String.format("%s()", getName());
	}

}
