package com.storygraph;

import java.util.ArrayList;
import java.util.Optional;
import com.communication.InputManager;
import com.playerInput.IPlayerChoice;
import com.sequences.DisablePlayerOptionsSequence;
import com.sequences.EnablePlayerOptionsSequence;
import com.utility.DelayExecution;
import com.utility.Event;

/**
 * An object of this class represents a story graph
 * @author Alireza Shirvani
 * @see com.storygraph.ActionMap
 */
public class Graph extends DelayExecution<IPlayerChoice>{
	/**
	 * Whenever a player choice is presented to the player, we keep track of them in this list
	 */
	private ArrayList<IPlayerChoice> enabledChoices;
	
	public Graph() {
		enabledChoices=new ArrayList<>();
	}
	
	/**
	 * This method first executes the action sequence corresponding to the current node. It then enables and disables player choices
	 * based on the outgoing edges of the current node and waits for the player to make a choice. After a choice is made, it returns 
	 * the next node of the graph following the edge that corresponds to that choice
	 * @param current The current node of the graph (by default, it points to the root)
	 * @param map The action map to use for executing Camelot actions corresponding to each node
	 * @return After the player makes a choice, follows the corresponding edge and returns the node at the end of that edge
	 * @throws Exception Throws an exception if the map does not contain an action sequence for the current node. 
	 * It also It throws an exception if the action sequence fails to execute completely
	 */
	public INode traverse(INode current, ActionMap map) throws Exception {
		//execute current node's sequence
		var label = current.getLabel();
		var sequence = map.get(label);
		if(sequence!=null)
			sequence.execute();
		else
			throw new Exception("map must contain the label "+label);
		
		//wait for input and return the next node
		var possibleOptions = current.getOutgoingEdges();
		INode nextNode = null;
		
		if(possibleOptions.isPresent()) {
			var options = possibleOptions.get();
			disablePreviousChoices(options);
			enableNewChoices(options);
			var input = waitFor();
			nextNode = current.getNextNode(Optional.of(input));
		}
		return nextNode;
	}
	
	/**
	 * Executes an action sequence that enables the player choices specified by choices
	 * @param choices This list specifies what player choices need to be enabled at the current node
	 * @throws InterruptedException It throws an exception if the action sequence fails to execute completely
	 */
	private void enableNewChoices(ArrayList<IPlayerChoice> choices) throws InterruptedException {
		enabledChoices=choices;
		var enableSequence = new EnablePlayerOptionsSequence(enabledChoices);
		enableSequence.execute();
	}

	/**
	 * Executes an action sequence that disables the player choices that were enabled in the previous node
	 * @param choices This list specifies what player choices were enabled in the previous node
	 * @throws InterruptedException It throws an exception if the action sequence fails to execute completely
	 */
	private void disablePreviousChoices(ArrayList<IPlayerChoice> choices) throws InterruptedException {
		var disableSequence=new DisablePlayerOptionsSequence(enabledChoices);
		disableSequence.execute();
		
	}

	@Override
	protected Event<String> getEvent() {
		return InputManager.getInstance().subscribers;
	}

	@Override
	protected Optional<IPlayerChoice> checkFormat(String msg) {
		return enabledChoices.stream().filter(t->t.getInputMsg().equals(msg)).findFirst();
	}
	
}
