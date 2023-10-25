import com.actions.*;
import com.entities.Character;
import com.entities.Item.Items;
import com.entities.*;
import com.entities.Place.Places;
import com.entities.Things.ThingNames;
import com.playerInput.*;
import com.playerInput.ActionChoice.Icons;
import com.sequences.CharacterCreation;
import com.storygraph.*;

/**
 * This class is an example implementation of IStory
 * @author Alireza Shirvani
 * @see IStory
 */
public class SampleStory implements IStory{
	private Item sword;
	private Character tom;
	private Place home;
	
	private enum ActionNames{
		Take, Exit
	}
	
	private enum NodeLabels{
		Start, Init, TakeSword, ExitHome
	}
	public SampleStory() {
		getThings();
	}
	
	@Override
	public void getThings() {
		 tom=new Character(ThingNames.Tom.toString());
		 home = new Place(ThingNames.Home.toString(), Place.Places.Cottage);
		 sword = new Item(ThingNames.Sword.toString(), Items.Sword);
	}
	
	@Override
	public ActionMap getMap() {
		var map=new ActionMap();
		map.add(NodeLabels.Init.toString(), getInitSequence());
		map.add(NodeLabels.Start.toString(), getStartSequence());
		map.add(NodeLabels.ExitHome.toString(), getExitHomeSequence());
		map.add(NodeLabels.TakeSword.toString(), getTakeSwordSequence());
		return map;
	}

	@Override
	public INode getRoot() {
		var takeSwordNode = new Node(NodeLabels.TakeSword.toString());
		var exitHomeNode = new Node(NodeLabels.ExitHome.toString());
		
		var startNode = new Node(NodeLabels.Start.toString());
		startNode.addChild(new ActionChoice(ActionNames.Take.toString(), sword, Icons.sword, "Take the sword", true), takeSwordNode);
		
		startNode.addChild(new ActionChoice(ActionNames.Exit.toString(),home.getFurniture("Door"),Icons.door,"Leave house",true),exitHomeNode);
		
		var root = new Node(NodeLabels.Init.toString());
		root.addChild(new SelectionChoice("Start"), startNode);
		
		return root;
	}
	
	private ActionSequence getInitSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(tom));
		sequence.add(new Create<Place>(home));
		sequence.add(new Position(tom, home));
		sequence.add(new Create<Item>(sword));
		sequence.add(new Position(sword, home, "Shelf"));
		sequence.add(new SetCameraFocus(tom));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getStartSequence() {
		var sequence=new ActionSequence();
		sequence.add(new ShowMenu(false));
		sequence.add(new EnableInput(true));
		return sequence;
	}
	
	private ActionSequence getTakeSwordSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Take(tom, sword));
		return sequence;
	}

	private ActionSequence getExitHomeSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(tom, home.getFurniture("Door"), true));
		return sequence;
	}

}
