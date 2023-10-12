package com.actions;

import com.entities.IEntity;
import com.entities.Item;

public class AddToList implements IAction{
	
	private IEntity item;
	private IEntity description;
	
	public AddToList(IEntity item) {
		this.item = item;
	}
	
	public AddToList(IEntity item, IEntity description) {
		this.item = item;
		this.description = description;
	}
	
	
	@Override
	public String getName() {
		return "AddToList";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		if (description == null) {
			return String.format("%s(%s, %s)", getName(), item.getName());
		} else {
			return String.format("%s(%s, %s, %s)", getName(), item.getName(), description.getName());
		}

		}
	}

