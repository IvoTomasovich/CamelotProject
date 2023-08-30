import com.storygraph.ActionMap;
import com.storygraph.INode;

/**
 * This class represents a story that we want to tell using Camelot
 * @author Alireza Shirvani
 *
 */
public interface IStory {
	/**
	 * This function returns a map that maps story-graph node labels to Camelot action sequences
	 * @return
	 */
	ActionMap getMap();
	/**
	 * This function returns the root of the story graph
	 * @return
	 */
	INode getRoot();
	/**
	 * This function creates an instance of all things that exist in our story
	 */
	void getThings();
}
