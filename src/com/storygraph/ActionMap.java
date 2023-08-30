package com.storygraph;

import java.util.Hashtable;

import com.actions.ActionSequence;

/**
 * We use this class to map every node in the story graph to a sequence of Camelot actions
 * @author Alireza Shirvani
 * @see com.actions.ActionSequence
 */
public class ActionMap {
	/**
	 * The map is stored in a hashtable. The key of every entry is a string
	 */
	private Hashtable<String, ActionSequence> map;
	
	public ActionMap() {
		map= new Hashtable<>();
	}
	
	/**
	 * Use this function to add an entry to the map (hashtable)
	 * @param label The label of the story-graph node which is used as the key of the entry in the hashtable
	 * @param sequence The sequence of Camelot actions that are mapped to a specific label
	 * @return If the map already contains an entry with that key, this function returns false
	 */
	public boolean add(String label, ActionSequence sequence) {
		if(map.containsKey(label))
			return false;
		map.put(label, sequence);
		return true;
	}
	
	/**
	 * Use this function to get an entry from the map
	 * @param label The function returns a sequence of actions that are mapped to this label
	 * @return A sequence of Camelot actions that were mapped to the specified label
	 */
	public ActionSequence get(String label) {
		return map.get(label);
	}
	
}
