package com.storygraph;

import java.util.ArrayList;
import java.util.Optional;

import com.playerInput.IPlayerChoice;

/**
 *
 * An object of this class represents a node of a story graph
 * @author Alireza Shirvani
 * @see com.sequences.Graph
 * @see com.sequences.Node
 */
public interface INode {
	/**
	 * This function returns the label of this node
	 * @return the label of this node
	 */
	 String getLabel();
	 /**
	  * This function gets the next node of the story graph after following the specified edge
	  * @param edge An optional edge that we follow to get the next node from this node
	  * @return The node at the other side of the edge 
	  */
	 INode getNextNode(Optional<IPlayerChoice> edge);
	 /**
	  * This functions returns all outgoing edges from this node if any
	  * @return An optional list of outgoing edges (player choices) from this node
	  */
	 Optional<ArrayList<IPlayerChoice>> getOutgoingEdges();
}
