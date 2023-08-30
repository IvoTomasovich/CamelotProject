package com.actions;

/**
 * This class represents a Camelot action. All classes that implement this interface must determine the name of the corresponding
 * Camelot action and whether we should wait for this action to complete 
 * @author Alireza Shirvani
 *
 */
public interface IAction {
	
	public String getName();
	public boolean getShouldWait();
}
