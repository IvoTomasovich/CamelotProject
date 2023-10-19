package com.entities;

import java.util.Hashtable;
import java.util.Optional;
public class Things {
	public enum ThingNames{ Tom, Home, Sword, Entrance, GeneralEduart, Edric, City, AlchemyShop, SoldierFrye, SoldierHale, SoldierWinfred, Apprentice, Bartender, DrunkMan, SuspiciousMan, SoldierKingsley, SoldierEdric, Skull, GreenPotion, OpenScroll, Cup, BartenderMeier, MurdererRoki, Port, LadyMarina, LadyKasumi, SuspectHumphrey, CustomerAleksey, Cottage2, CourtYard, Tavern, Cottage1, Dungeon, Roki, SoldierTyre, SoldierStani, OppopentShopKeeper, SpellBook;

	String SpellBook() {
		// TODO Auto-generated method stub
		return null;
	}} 
	private static Hashtable<ThingNames, IThing<?>> list=new Hashtable<>();
	public static boolean add(ThingNames name, IThing<?> thing) {
		if(list.containsKey(name))
			return false;
		list.put(name, thing);
		return true;
	}
	
	public static Optional<IThing<?>> get(ThingNames name) {
		return Optional.ofNullable(list.get(name));
	}
}
