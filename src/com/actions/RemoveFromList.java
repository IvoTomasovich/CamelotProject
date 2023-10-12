package com.actions;

import com.entities.IEntity;

public class RemoveFromList implements IAction{
	private IEntity entity;
	
	public RemoveFromList(IEntity entity) {
		this.entity = entity;
	}
	
	@Override
	public String getName() {
		return "RemoveFromList";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), entity.getName());
	}
}
