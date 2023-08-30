package com.actions;

import java.util.ArrayList;

import com.communication.Messenger;

/**
 * An object of this class represents a sequence of Camelot Actions
 * @author Alireza Shirvani
 * @see com.actions.IAction
 */
public class ActionSequence {
	/**
	 * The list of Camelot actions to execute (implementing IAction)
	 */
	private ArrayList<IAction> actions;
	
	public ActionSequence() {
		actions=new ArrayList<>();
	}
	/**
	 * Use this function to add an action (implementing IAction) to the sequence
	 * @param action
	 */
	public void add(IAction action) {
		actions.add(action);
	}
	/**
	 * This function executes all actions of the sequence in Camelot
	 * @throws InterruptedException
	 */
	public void execute() throws InterruptedException {
		for(var action:actions) {
			Messenger.getInstance().Send(action);
		}
	}
	/**
	 * You can use this function to combine two sequences together
	 * @param other The other sequence that is appended to this sequence
	 * @return The resulting sequence
	 */
	public ActionSequence combineWith(ActionSequence other) {
		for(var action:other.actions) {
			add(action);
		}
		return this;
	}
	
}
