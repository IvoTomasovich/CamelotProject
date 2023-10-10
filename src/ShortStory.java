import com.entities.Character;
import com.entities.Place;
import com.entities.Things.ThingNames;
import com.storygraph.ActionMap;
import com.storygraph.INode;
import com.storygraph.Node;

public class ShortStory implements IStory {
	private Character Edric;
	private Character GeneralEduart;
	private Place StarterPlace;
	private Place City;
	private Place AlchemyShop;
	private Character SoldierFrye;
	private Character SoldierHale;
	private Character SoldierWinfred;
	private Character Apprentice;
	
	@Override
	public ActionMap getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INode getRoot() {
		// TODO Auto-generated method stub
		return new Node("root");
	}

	@Override
	public void getThings() {
		Edric = new Character(ThingNames.Tom.toString());
		GeneralEduart = new Character(ThingNames.GeneralEduart.toString());
		StarterPlace = new Place(ThingNames.Home.toString(), Place.Places.Bridge);
		City = new Place(ThingNames.City.toString(), Place.Places.City);
		AlchemyShop = new Place(ThingNames.AlchemyShop.toString(), Place.Places.AlchemyShop);
		SoldierFrye = new Character(ThingNames.SoldierFrye.toString());
		SoldierHale = new Character(ThingNames.SoldierHale.toString());
		SoldierWinfred = new Character(ThingNames.SoldierWinfred.toString());
		Apprentice = new Character(ThingNames.Apprentice.toString());
		
		
	}

}
