package com.actions;

import com.entities.IEntity;

public class ShowList implements IAction{
	private IEntity entity;
	boolean show;
	
	public ShowList(IEntity entity) {
		this.entity = entity;
	}
	
	@Override
	public String getName() {
		return show? "ShowList":"HideList";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), entity.getName());
	}

}
