package com.storygraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Optional;

import com.playerInput.IPlayerChoice;
/**
 * This node implements INode
 * @author Alireza Shirvani
 * @see com.sequences.INode
 * @see com.playerInput.IPlayerChoice
 */
public class Node implements INode{
	/**
	 * This hashtable represents the children of this node that are connected to it via outgoing edges (player choices)
	 */
	private Hashtable<IPlayerChoice, INode> children;
	/**
	 * The label of this node. The label is very important to map a node to an action sequence
	 */
	private String label;
	/**
	 * The constructor
	 * @param label The label of this node
	 */
	public Node(String label) {
		this.label=label;
		children=new Hashtable<>();
	}
	
	/**
	 * Use this function to connect another node to this node via an edge (player choice)
	 * @param edge The edge (player choice) that connects this node to the child node
	 * @param child The node that is connected to this node via edge
	 */
	public void addChild(IPlayerChoice edge, INode child) {
		children.put(edge, child);
	}

	@Override
	public
	 INode getNextNode(Optional<IPlayerChoice> edge) {
		if(edge.isPresent())
			return children.get(edge.get());
		return null;
	}
	
	@Override
	public
	 Optional<ArrayList<IPlayerChoice>> getOutgoingEdges() {
		return Optional.ofNullable(Collections.list(children.keys()));
	}

	@Override
	public
	 String getLabel() {
		return label;
	}
	
}
