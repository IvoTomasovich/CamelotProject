import com.storygraph.*;

public class MainClass {
	public static void main(String[] args) {
		try {
		System.out.println("Hello");
		var story = new ShortStory();
		var graph = new Graph();
		var currentNode = story.getRoot();
		var map = story.getMap();
		while(true) {
			currentNode = graph.traverse(currentNode, map);
			if(currentNode==null)
				break;
		}
		System.out.println("Bye");
		System.out.println("Please work");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
}
