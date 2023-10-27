import com.entities.Character;
import com.entities.Character.BodyType;
import com.entities.Character.Clothing;
import com.entities.Character.HairStyles;
import com.entities.Furniture;
import com.entities.IEntity;
import com.entities.Item;
import com.entities.Item.Items;
import com.entities.Place;
import com.entities.Things.ThingNames;
import com.playerInput.ActionChoice;
import com.playerInput.ActionChoice.Icons;
import com.playerInput.PositionChoice;
import com.playerInput.PositionChoice.Condition;
import com.playerInput.SelectionChoice;
import com.sequences.CharacterCreation;
import com.storygraph.ActionMap;
import com.storygraph.INode;
import com.storygraph.Node;

import javax.swing.Icon;

import com.actions.*;

public class ShortStory implements IStory {
	//note, not all objects here are used
	 	private Character Edric;
	    private Character GeneralEduart;
	    private Character SoldierHale;
	    private Character SoldierFrye;
	    private Character SoldierWinfred;
	    private Character Roki;
	    private Character LadyMarina;
	    private Character LadyKasumi;
	    private Character SuspectHumphrey;
	    private Character Rimmons;
	    private Character BartenderMeier;
	    private Character SoldierTyre;
	    private Character SoldierStani;
	    private Character OpponentShopKeeper;
	    private Place Tavern;
	    private Place StarterPlace;
	    private Place City;
	    private Place Tarven;
	    private Place Port;
	    private Place CourtYard;
	    private Place Cottage1;
	    private Place Cottage2;
	    private Place Dungeon;
	    private Place AlchemyShop;
	    private Item Skull;
	    private Item GreenPotion;
	    private Item Cup;
	    private Item Ledger;
	    private Item Soporific;
	    private Item Book;
	    private Item Scroll;
	    private String Talk = "Talk";
	    private Icons talk = Icons.talk;
	    private ActionChoice actionChoice1 = new ActionChoice("Talk", GeneralEduart, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice2 = new ActionChoice("Talk", SoldierHale, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice3 = new ActionChoice("Talk", SoldierWinfred, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice4 = new ActionChoice("Talk", SoldierFrye, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice5 = new ActionChoice("Talk", LadyMarina, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice6 = new ActionChoice("Talk", LadyKasumi, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice7 = new ActionChoice("Talk", Rimmons, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice8 = new ActionChoice("Talk", BartenderMeier, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice9 = new ActionChoice("Talk", Roki, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice10 = new ActionChoice("Talk", SoldierTyre, Icons.talk, "Talk", true);
	    private ActionChoice actionChoice11 = new ActionChoice("Talk", SoldierStani, Icons.talk, "Talk", true);
	    
	    //Note, not all enums are used
	    private enum NodeLabels{
			Init, Start, AbilityToOpenInventory, BeginTalkWithGuard, ExitAreaViaTeleport,
			SpeakWithSoldierHale, AcceptCup, AddCupToInventory, ExitAlchemyShop, ContinueExploring, WarpToCity, ExitCityToDungeonGoodEnding, Promotion, endFade,
			EnterAlchemyShop, TalkToGuard2, TalkToGuard3, TeleportToShopViaGeneral, GoodChoiceFrye, BadChoiceFrye, DialogForCorrectEvidenceForApprentice, ShowEvidenceForApprentice,
			BadEndingForShoppKeeper, TeleportToDungeonForBadEnding, GiveRightEvidenceToEduartForShopKeeper, ShowEvidenceForOpponentShopKeeper,
			TalkToApprentice, Continue, LessIdealAnswerwithHale, BetterOptionWinfred, WorseOptionWinfred, ContinueWinfred, GoodOptionKasumi, BadOptionKasumi, TeleportToPier, SayNoToPier,
			OpenTavernDoor, EnterTavern, SpeakToDrunkMan1, ExitConversation, SpeakToDrunkMan2, SpeakToBarTender, EndConversationAfterListening, PickUpBook, PutBookInInventory,
			EnterCity, SpeakWithLady, ChooseToContinueInCity, ChooseToGoToPort, LeaveCity, SpeakWithCustomerAleksey, SayNoToKnowingKiller, ShowEvidenceForRoki,
			OpenCottageDoor, EnterCottage, ReadScroll, AddScrollToInventory, ClickOnPotion, AddPotionToInventory, YesToKnowingKiller, ShowProof, NoProof, OkayFromGeneralToGoodChoice, GiveWrongItemForRightChoice,
			SpeakWithGuard, YouDLikeToContinueSearching, YouDLikeToMakeAVerdict, PickShopKeeper, BadEnding1, PickSuspiciousMan, GoodEnding, PickApprentice,
			EnterPort, TalkToGuard5, TalkToMan, TalkToGuard6, DialogOptionOne, DialogOptionTwo, GoodOptionFromMeiser, GoodOptionFromGoodOptionFromMeiser, BadOptionFromMeiser, BadOptionFromGoodOptionMeiser, SpeakToGuard, AddBookToInventory, SpeakwithSoldierHale, IdealAnswerwithHale, speakwithsoldierwinfred, Speakwithsoldierfrye, SpeakwithladyMarina, SpeakwithLadyKasumi, Speakwithsoldierstani, Speakwithroki, Speakwithsoldiertyre, CitytoTavern, SpeakwithRimmons, BadOptionFromGoodOptionFromMeiser, ExitTavern, ExitCottage, SpeakWithGeneralEduarttogivedecision, BadEndingForShoppKeeperDialog, BadEndingDialog, PickUpScroll, CloseandPutDownScroll, PickUpPotionandAddToInventory, getGoodAnswerFromTyreforfirstquestion, NeutralAnswerFromTyre, FinalDialogFromTyre, DoNotLeavePierYet, ExitPier, GetGoodDialogFromRoki, GetBadDialogFromRoki, ExitCityToCollege, ExitCityToCottage, Talk, TavernToCity, ShowCorrectEvidenceForRoki, ShowCorrectEvidenceForOpponentShopKeeper, IncorrectEvidenceForRokiBook, ShowIncorrectEvidenceForOpponentShopKeeperMug, IncorrectEvidenceForRokiGreenPotion, ShowIncorrectEvidenceForOpponentShopKeeperBook, ShowCorrectEvidenceForApprentice, ShowIncorrectEvidenceForApprentice1Mug, ShowIncorrectEvidenceForApprentice1GreenPotion, Rokiisthekiller, Apprenticeisthekiller, Othershopkeeperisthekiller, Give, ExitCityToDungeonGoodEndingInitialSequence, ExitCityToDuneonBadEndingInitialSequence, Filler, Filler2, Filler3
			}
	
	@Override
	public ActionMap getMap() {
		var map = new ActionMap();
		map.add(NodeLabels.Init.toString(), getInitSequence());
		map.add(NodeLabels.Start.toString(), getStartSequence());
		map.add(NodeLabels.SpeakToGuard.toString(), getSpeakToGuardSequence());
		map.add(NodeLabels.TeleportToShopViaGeneral.toString(),getTeleportToShopViaGeneralSequence());
		map.add(NodeLabels.EnterAlchemyShop.toString(), getEnterAlchemyShopSequence());
		map.add(NodeLabels.PickUpBook.toString(), getPickUpBookSequence());
		map.add(NodeLabels.AddBookToInventory.toString(),getAddBookToInventorySequence());
		map.add(NodeLabels.SpeakwithSoldierHale.toString(),getSpeakWithSoldierHaleSequence());
		map.add(NodeLabels.IdealAnswerwithHale.toString(),getIdealAnswerwithHaleSequence());
		map.add(NodeLabels.LessIdealAnswerwithHale.toString(),getLessIdealAnswerwithHaleSequence());
		map.add(NodeLabels.Continue.toString(),getContinueSequence());
		map.add(NodeLabels.speakwithsoldierwinfred.toString(),getSpeakWithSoldierWinfredSequence());
		map.add(NodeLabels.BetterOptionWinfred.toString(),getBetterOptionWinfredSequence());
		map.add(NodeLabels.WorseOptionWinfred.toString(),getWorseOptionWinfredSequence());
		map.add(NodeLabels.ContinueWinfred.toString(),getContinueWinfredSequence());
		map.add(NodeLabels.Speakwithsoldierfrye.toString(),getSpeakWithSoldierFryeSequence());
		map.add(NodeLabels.GoodChoiceFrye.toString(),getGoodChoiceFryeSequence());
		map.add(NodeLabels.BadChoiceFrye.toString(),getBadChoiceFryeSequence());
		map.add(NodeLabels.SpeakwithladyMarina.toString(),getSpeakWithLadyMarinaSequence());
		map.add(NodeLabels.ExitAlchemyShop.toString(),getExitAlchemyShopViaTeleportSequence());
		map.add(NodeLabels.EnterCity.toString(),getEnterCitySequence());
		map.add(NodeLabels.SpeakwithLadyKasumi.toString(),getSpeakWithLadyKasumiSequence());
		map.add(NodeLabels.GoodOptionKasumi.toString(),getGoodOptionKasumiSequence());
		map.add(NodeLabels.BadOptionKasumi.toString(),getBadOptionKasumiSequence());
		map.add(NodeLabels.TeleportToPier.toString(),getTeleportToPierSequence());
		map.add(NodeLabels.SayNoToPier.toString(),getSayNoToPierSequence());
		map.add(NodeLabels.EnterPort.toString(),getEnterPierSequence());
		map.add(NodeLabels.Speakwithsoldierstani.toString(),getSpeakWithSoliderStaniSequence());
		map.add(NodeLabels.DoNotLeavePierYet.toString(), getDoNotLeavePierYetSequence());
		map.add(NodeLabels.ExitPier.toString(), getExitPierSequence());
		map.add(NodeLabels.Speakwithroki.toString(),getSpeakWithRokiSequence());
		map.add(NodeLabels.GetGoodDialogFromRoki.toString(), getGoodDialogRokiSequence());
		map.add(NodeLabels.GetBadDialogFromRoki.toString(), getBadDialogRokiSequence());
		map.add(NodeLabels.Speakwithsoldiertyre.toString(),getSpeakWithSoldierTyreSequence());
		map.add(NodeLabels.getGoodAnswerFromTyreforfirstquestion.toString(), getGoodAnswerFromTyreforfirstquestionSequence());
		map.add(NodeLabels.NeutralAnswerFromTyre.toString(), getNeutralAnswerFromTyreSequence());
		map.add(NodeLabels.FinalDialogFromTyre.toString(), getFinalDialogFromTyreSequence());
		map.add(NodeLabels.AddCupToInventory.toString(), getAddCupToInventorySequence());
		map.add(NodeLabels.CitytoTavern.toString(),getCityToTavernSequence());
		map.add(NodeLabels.EnterTavern.toString(),getEnterTavernSequence());
		map.add(NodeLabels.SpeakwithRimmons.toString(),getSpeakWithRimmonsSequence());
		map.add(NodeLabels.SpeakToBarTender.toString(),getSpeakWithBartenderMeierSequence());
		map.add(NodeLabels.GoodOptionFromMeiser.toString(),getGoodOptionFromMeiserSequence());
		map.add(NodeLabels.GoodOptionFromGoodOptionFromMeiser.toString(),getGoodOptionFromGoodOptionFromMeiserSequence());
		map.add(NodeLabels.BadOptionFromMeiser.toString(),getBadOptionFromMeiserSequence());
		map.add(NodeLabels.BadOptionFromGoodOptionFromMeiser.toString(),getBadOptionFromGoodOptionMeiserSequence());
		map.add(NodeLabels.ExitTavern.toString(),getExitTavernSequence());
		map.add(NodeLabels.TavernToCity.toString(), getTavernToCitySequence());
		map.add(NodeLabels.ExitCityToCottage.toString(), getExitCityToCollegeSequence());
		map.add(NodeLabels.EnterCottage.toString(),getEnterCottageSequence());
		map.add(NodeLabels.PickUpScroll.toString(), getPickUpScrollSequence());
		//map.add(NodeLabels.ReadScroll.toString(),getReadScrollSequence());
		map.add(NodeLabels.CloseandPutDownScroll.toString(), getCloseandPutDownScrollSequence());
		map.add(NodeLabels.PickUpPotionandAddToInventory.toString(), getPickUpPotionandAddtoInventorySequence());
		map.add(NodeLabels.ExitCottage.toString(),getExitCottageSequence());
		map.add(NodeLabels.SpeakWithGeneralEduarttogivedecision.toString(),getSpeakWithGeneralEduartToGiveDecision());
		map.add(NodeLabels.YesToKnowingKiller.toString(),getYesToKnowingKillerSequence());
		map.add(NodeLabels.SayNoToKnowingKiller.toString(),getSayNoToKnowingKillerSequence());
		//map.add(NodeLabels.ShowProof.toString(),getShowProofSequence());
		//map.add(NodeLabels.NoProof.toString(),getNoProofSequence());
		
		map.add(NodeLabels.ShowCorrectEvidenceForRoki.toString(),getShowCorrectEvidenceForRokiSequence());
		map.add(NodeLabels.IncorrectEvidenceForRokiBook.toString(), getIncorrectEvidenceForRokiBookSequence());
		map.add(NodeLabels.ShowIncorrectEvidenceForOpponentShopKeeperMug.toString(), getShowIncorrectEvidenceForOpponentShopKeeperMugSequence());
		map.add(NodeLabels.IncorrectEvidenceForRokiGreenPotion.toString(), getIncorrectEvidenceForRokiGreenPotionSequence());
		map.add(NodeLabels.ShowIncorrectEvidenceForOpponentShopKeeperBook.toString(), getShowIncorrectEvidenceForOpponentShopKeeperBookSequence());
		map.add(NodeLabels.ShowCorrectEvidenceForApprentice.toString(), getShowCorrectEvidenceForApprenticeSequence());
		map.add(NodeLabels.ShowIncorrectEvidenceForApprentice1Mug.toString(), getShowIncorrectEvidenceForApprentice1MugSequence());
		map.add(NodeLabels.ShowIncorrectEvidenceForApprentice1GreenPotion.toString(), getShowIncorrectEvidenceForApprentice1GreenPotionSequence());
		map.add(NodeLabels.ShowIncorrectEvidenceForOpponentShopKeeperBook.toString(), getShowIncorrectEvidenceForOpponentShopKeeperBookSequence());
		//map.add(NodeLabels.ShowIncorrectEvidenceForOpponentShopKeeperMug.toString(), getShowIncorrectEvidenceForOpponentShopKeeperMugSequence());
		
		map.add(NodeLabels.Rokiisthekiller.toString(), getRokiisthekillerSequence());
		map.add(NodeLabels.Apprenticeisthekiller.toString(), getApprencticeisthekillerSequence());
		map.add(NodeLabels.Othershopkeeperisthekiller.toString(), getOtherShopKeeperisthekillerSequence());
		
		map.add(NodeLabels.OkayFromGeneralToGoodChoice.toString(),getOkayFromGeneralToGoodChoiceSequence());
		map.add(NodeLabels.GiveWrongItemForRightChoice.toString(),getGiveWrongItemForRightChoiceSequence());
		map.add(NodeLabels.ExitCityToDungeonGoodEnding.toString(),getExitCityToDungeonGoodEndingSequence());
		map.add(NodeLabels.Promotion.toString(),getPromotionSequence());
		map.add(NodeLabels.endFade.toString(),getendFadeSequence());
		map.add(NodeLabels.ShowCorrectEvidenceForOpponentShopKeeper.toString(),getShowCorrectEvidenceForOpponentShopKeeperSequence());
		map.add(NodeLabels.GiveRightEvidenceToEduartForShopKeeper.toString(),getGiveRightEvidenceToEduartForShopKeeperSequence());
		map.add(NodeLabels.TeleportToDungeonForBadEnding.toString(),getTeleportToDungeonForBadEndingSequence());
		map.add(NodeLabels.BadEndingDialog.toString(),getBadEndingSequence());
		//map.add(NodeLabels.ShowCorrectEvidenceForApprentice.toString(),getShowCorrectEvidenceForApprenticeSequence());
		map.add(NodeLabels.DialogForCorrectEvidenceForApprentice.toString(),getDialogForCorrectEvidenceForApprenticeSequence());
		map.add(NodeLabels.ExitCityToDungeonGoodEndingInitialSequence.toString(), getExitCityToDungeonGoodEndingInitialSequence());
		map.add(NodeLabels.ExitCityToDuneonBadEndingInitialSequence.toString(), getExitCityToDungeonBadEndingInitialSequence());
		map.add(NodeLabels.Filler.toString(), getFillerNodeSequence());
		map.add(NodeLabels.Filler2.toString(), getFiller2NodeSequence());
		map.add(NodeLabels.Filler3.toString(), getFiller3NodeSequence());
		return map;
	}

	@Override
	public INode getRoot() {
		
		//Nodes Themselves
		var root = new Node(NodeLabels.Init.toString());
		var rightevidenceforothershopkeepernode = new Node(NodeLabels.ShowCorrectEvidenceForOpponentShopKeeper.toString());
		var startNode = new Node(NodeLabels.Start.toString());
		var SpeakToGuardNode = new Node(NodeLabels.SpeakToGuard.toString());
		var TeleportToShopviaGeneralNode = new Node(NodeLabels.TeleportToShopViaGeneral.toString());
		var EnterAlchemyShopNode = new Node(NodeLabels.EnterAlchemyShop.toString());
		var PickUpBookNode = new Node(NodeLabels.PickUpBook.toString());
		var AddBookToInventoryNode = new Node(NodeLabels.AddBookToInventory.toString());
		var SpeakWitheSoldierHaleNode = new Node(NodeLabels.SpeakwithSoldierHale.toString());
		var IdealAnswerWithHale = new Node(NodeLabels.IdealAnswerwithHale.toString());
		var LessIdealAnswerWithHaleNode = new Node(NodeLabels.LessIdealAnswerwithHale.toString());
		var ContinueNode = new Node(NodeLabels.Continue.toString());
		var SpeakWithSoliderWinfredNode = new Node(NodeLabels.speakwithsoldierwinfred.toString());
		var BetterOptionWinfredNode = new Node(NodeLabels.BetterOptionWinfred.toString());
		var WorseOptionWinfredNode = new Node(NodeLabels.WorseOptionWinfred.toString());
		var ContinueWinfredNode = new Node(NodeLabels.ContinueWinfred.toString());
		var SpeakWithSoliderFryeNode = new Node(NodeLabels.Speakwithsoldierfrye.toString());
		var GoodChoiceFryeNode = new Node(NodeLabels.GoodChoiceFrye.toString());
		var BadChoiceFryeNode = new Node(NodeLabels.BadChoiceFrye.toString());
		var SpeakWithLadyMarinaNode = new Node(NodeLabels.SpeakwithladyMarina.toString());
		var ExitAlchemyShopNode = new Node(NodeLabels.ExitAlchemyShop.toString());
		var EnterCityNode = new Node(NodeLabels.EnterCity.toString());
		var SpeakWithLadyKasumiNode = new Node(NodeLabels.SpeakwithLadyKasumi.toString());
		var GoodOptionkasumiNode = new Node(NodeLabels.GoodOptionKasumi.toString());
		var BadOptionkasumiNode = new Node(NodeLabels.BadOptionKasumi.toString());
		var TeleportToPierNode = new Node(NodeLabels.TeleportToPier.toString());
		var SayNoToPierNode = new Node(NodeLabels.SayNoToPier.toString());
		var EnterPortNode = new Node(NodeLabels.EnterPort.toString());
		var SpeakWithSoldierStaniNode = new Node(NodeLabels.Speakwithsoldierstani.toString());
		var DoNotLeavePierYetNode = new Node(NodeLabels.DoNotLeavePierYet.toString());
		var ExitPierNode = new Node(NodeLabels.ExitPier.toString());
		var SpeakWithRokiNode = new Node(NodeLabels.Speakwithroki.toString());
		var GoodDialogFromRokiNode = new Node(NodeLabels.GetGoodDialogFromRoki.toString());
		var BadDialogFromRokiNode = new Node(NodeLabels.GetBadDialogFromRoki.toString());
		var SpeakwithSoldierTyreNode = new Node(NodeLabels.Speakwithsoldiertyre.toString());
		var GetGoodOptionFromTyreForFirstQuestionNode = new Node(NodeLabels.getGoodAnswerFromTyreforfirstquestion.toString());
		var GetNeutralOptionFromTyreNode = new Node(NodeLabels.NeutralAnswerFromTyre.toString());
		var GetFinalDialogFromTyreNode = new Node(NodeLabels.FinalDialogFromTyre.toString());
		var AddCupToInventoryNode = new Node(NodeLabels.AddCupToInventory.toString());
		var CityToTavernNode = new Node(NodeLabels.CitytoTavern.toString());
		var EnterTavernNode = new Node(NodeLabels.EnterTavern.toString());
		var SpeakWithRimmonsNode = new Node(NodeLabels.SpeakwithRimmons.toString());
		var SpeakToBarTenderNode = new Node(NodeLabels.SpeakToBarTender.toString());
		var GoodOptionFromMeiserNode = new Node(NodeLabels.GoodOptionFromMeiser.toString());
		var GoodOptionFromGoodOptionFromMeiserNode = new Node(NodeLabels.GoodOptionFromGoodOptionFromMeiser.toString());
		var BadOptionFromMeiserNode = new Node(NodeLabels.BadOptionFromMeiser.toString());
		var BadOptionFromGoodOptionNode = new Node(NodeLabels.BadOptionFromGoodOptionFromMeiser.toString());
		var ExitTavernNode = new Node(NodeLabels.ExitTavern.toString());
		//var TavernToCityNode = new Node(NodeLabels.TavernToCity.toString());
		var ExitCityToCollege = new Node(NodeLabels.ExitCityToCottage.toString());
		var EnterCottageNode = new Node(NodeLabels.EnterCottage.toString());
		var PickUpScrollNode = new Node(NodeLabels.PickUpScroll.toString());
		//var ReadScrollNode = new Node(NodeLabels.ReadScroll.toString());
		var CloseandPutDownScrollNode = new Node(NodeLabels.CloseandPutDownScroll.toString());
		var PickUpPotionandAddToInventoryNode = new Node(NodeLabels.PickUpPotionandAddToInventory.toString());
		var ExitCottageNode = new Node(NodeLabels.ExitCottage.toString());
		var SpeakWithGeneralEduarttogivedecisionNode = new Node(NodeLabels.SpeakWithGeneralEduarttogivedecision.toString());
		var YesToKnowingKillernode = new Node(NodeLabels.YesToKnowingKiller.toString());
		var SayNoToKnowingKillernode = new Node(NodeLabels.SayNoToKnowingKiller.toString());
		//var IncorrectEvidenceForRokiBookNode = new Node(NodeLabels.IncorrectEvidenceForRokiBook.toString());
		var ShowCorrectEvidenceForRokiNode = new Node(NodeLabels.ShowCorrectEvidenceForRoki.toString());
		var ShowIncorrectEvidenceForRokiBookNode = new Node(NodeLabels.IncorrectEvidenceForRokiBook.toString());
		var ShowCorrectEvidenceForOponentShopKeeperNode = new Node(NodeLabels.ShowIncorrectEvidenceForOpponentShopKeeperMug.toString());
		var ShowIncorrectEvidenceForRokiGreenPotionNode = new Node(NodeLabels.IncorrectEvidenceForRokiGreenPotion.toString());
		var ShowCorrectEvidenceForApprenticeNodeNode = new Node(NodeLabels.ShowCorrectEvidenceForApprentice.toString());
		var ShowIncorrectEvnidenceForApprenctice1MugNode = new Node(NodeLabels.ShowIncorrectEvidenceForApprentice1Mug.toString());
		var ShowIncorrectEvidenceForApprenctice1GreenPotionNode= new Node(NodeLabels.ShowIncorrectEvidenceForApprentice1GreenPotion.toString());
		var ShowIncorrectEvidenceForOpponentShopKeeperBookNode= new Node(NodeLabels.ShowIncorrectEvidenceForOpponentShopKeeperBook.toString());
		var ShowIncorrectEvidenceForOpponentSHopKeeperMug = new Node(NodeLabels.ShowIncorrectEvidenceForOpponentShopKeeperMug.toString());
		var Rokiisthekiller = new Node(NodeLabels.Rokiisthekiller.toString());
		var Apprenticeisthekiller = new Node(NodeLabels.Apprenticeisthekiller.toString());
		var Opponentshopkeeperisthekiller = new Node(NodeLabels.Othershopkeeperisthekiller.toString());
		//Pick up here
		var GoToDungeonGoodEndingInitialNode = new Node(NodeLabels.ExitCityToDungeonGoodEndingInitialSequence.toString());
		var GoToDungeonBadEndingInitialNode = new Node(NodeLabels.ExitCityToDuneonBadEndingInitialSequence.toString());
		//var ShowProofNode = new Node(NodeLabels.ShowProof.toString());
		//var ShowEvidenceForRokiNode = new Node(NodeLabels.ShowEvidenceForRoki.toString());
		var PromotionNode = new Node(NodeLabels.Promotion.toString());
		
		var OkayFromGeneralToGoodChoiceNode = new Node(NodeLabels.OkayFromGeneralToGoodChoice.toString());
		//var GiveWrongItemForWriteChoiceNode = new Node(NodeLabels.GiveWrongItemForRightChoice.toString());
		var BadEndingDialogNode = new Node(NodeLabels.TeleportToDungeonForBadEnding.toString());
		var ShowEvidenceForApprenticeNode = new Node(NodeLabels.ShowEvidenceForApprentice.toString());
		var DialogForCorrectEvidenceForApprencticeNode = new Node(NodeLabels.DialogForCorrectEvidenceForApprentice.toString());
		var FillerNode = new Node(NodeLabels.Filler.toString());
		var FillerNode2 = new Node(NodeLabels.Filler2.toString());
		var FillerNode3 = new Node(NodeLabels.Filler3.toString());
		
		//make an ending node
		
		//Mapping the nodes
		root.addChild(new SelectionChoice("Start"), startNode);
		startNode.addChild(new ActionChoice(NodeLabels.Talk.toString(), GeneralEduart, Icons.talk), SpeakToGuardNode);
		SpeakToGuardNode.addChild(new SelectionChoice("Continue") ,TeleportToShopviaGeneralNode);
		TeleportToShopviaGeneralNode.addChild(new PositionChoice(Edric, "AlchemyShop.Spawn", Condition.arrived), EnterAlchemyShopNode);
		EnterAlchemyShopNode.addChild(new PositionChoice(Edric, "AlchemyShop.Spawn", Condition.arrived), PickUpBookNode);
		PickUpBookNode.addChild(new ActionChoice(NodeLabels.AddBookToInventory.toString(), Book, Icons.book, "Add Book To Inventory", true), AddBookToInventoryNode);
		EnterAlchemyShopNode.addChild(new ActionChoice(NodeLabels.Talk.toString(), SoldierHale, Icons.talk), SpeakWitheSoldierHaleNode);
		SpeakWitheSoldierHaleNode.addChild(new SelectionChoice("\"[ideal|Do you have any idea where I could look]\""), IdealAnswerWithHale);
		SpeakWitheSoldierHaleNode.addChild(new SelectionChoice("\"[lazy|Okay, I'll take a look around]\""),LessIdealAnswerWithHaleNode);
		IdealAnswerWithHale.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		LessIdealAnswerWithHaleNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		EnterAlchemyShopNode.addChild(new PositionChoice(Edric, "AlchemyShop.Spawn", Condition.arrived), SpeakWithSoliderWinfredNode);
		SpeakWithSoliderWinfredNode.addChild(new SelectionChoice("\"[GoodOption|Do you know of any places to look?]\""), BetterOptionWinfredNode);
		SpeakWithSoliderWinfredNode.addChild(new SelectionChoice("\"[worseoption|Indeed]\""),WorseOptionWinfredNode);
		BetterOptionWinfredNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueWinfredNode);
		ContinueWinfredNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		EnterAlchemyShopNode.addChild(new PositionChoice(Edric, "AlchemyShop.Spawn", Condition.arrived), SpeakWithSoliderFryeNode);
		SpeakWithSoliderFryeNode.addChild(new SelectionChoice("\"[GoodOption|Do you know of any places to look?]\""), GoodChoiceFryeNode);
		SpeakWithSoliderFryeNode.addChild(new SelectionChoice("\"[BadOption|How are you that incompetent at your job?]\""), BadChoiceFryeNode);
		GoodChoiceFryeNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		BadChoiceFryeNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		EnterAlchemyShopNode.addChild(new ActionChoice(NodeLabels.Talk.toString(), LadyMarina, Icons.talk), SpeakWithLadyMarinaNode);
		SpeakWithLadyMarinaNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		EnterAlchemyShopNode.addChild(new PositionChoice(Edric, "AlchemyShop.Door", Condition.exited),ExitAlchemyShopNode);
		ExitAlchemyShopNode.addChild(new PositionChoice(Edric, "City.Spawn", Condition.arrived), EnterCityNode);
		EnterCityNode.addChild(new ActionChoice(NodeLabels.Talk.toString(),LadyKasumi, Icons.talk), SpeakWithLadyKasumiNode);
		SpeakWithLadyKasumiNode.addChild(new SelectionChoice("\"[Good Option|Yes]\""), GoodOptionkasumiNode);
		SpeakWithLadyKasumiNode.addChild(new SelectionChoice("\"[Bad Option|No]\""), BadOptionkasumiNode);
		//Not sure if this actually works, will debug later
		GoodOptionkasumiNode.addChild(new SelectionChoice("\"[GoodOption|Teleport To Pier]\""), TeleportToPierNode);
		GoodOptionkasumiNode.addChild(new SelectionChoice("\"[BadOption|I don't trust you]\""), SayNoToPierNode);
		SayNoToPierNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		TeleportToPierNode.addChild(new PositionChoice(Edric, "Port.Spawn", Condition.arrived), EnterPortNode);
		EnterPortNode.addChild(new ActionChoice(NodeLabels.Talk.toString(), SoldierStani, Icons.talk), SpeakWithSoldierStaniNode);
		SpeakWithSoldierStaniNode.addChild(new SelectionChoice("\"[Yes|Yes]\""), ExitPierNode);
		//Not sure if this actually works, will debug later
		ExitPierNode.addChild(new PositionChoice(Edric, "City.Spawn", Condition.arrived), EnterCityNode);
		SpeakWithSoldierStaniNode.addChild(new SelectionChoice("\"[No|No]\""), DoNotLeavePierYetNode);
		DoNotLeavePierYetNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		EnterPortNode.addChild(new ActionChoice(NodeLabels.Talk.toString(), Roki, Icons.talk), SpeakWithRokiNode);
		SpeakWithRokiNode.addChild(new SelectionChoice("\"Good Option| Why are you in such a rush?]\""), GoodDialogFromRokiNode);
		SpeakWithRokiNode.addChild(new SelectionChoice("\"[Bad Option|Sorry Sir, I didn't notice]\""), BadDialogFromRokiNode);
		GoodDialogFromRokiNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		BadDialogFromRokiNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		EnterPortNode.addChild(new ActionChoice(NodeLabels.Talk.toString(), SoldierTyre, Icons.talk), SpeakwithSoldierTyreNode);
		SpeakwithSoldierTyreNode.addChild(new SelectionChoice("\"[GoodAnswer|What's going on with that frazzled guy?]\""), GetGoodOptionFromTyreForFirstQuestionNode);
		SpeakwithSoldierTyreNode.addChild(new SelectionChoice("\"[BadAnswer|Nothing, just looking around]\""), GetNeutralOptionFromTyreNode);
		GetGoodOptionFromTyreForFirstQuestionNode.addChild(new SelectionChoice("\"[Contininue|I'm trying to find out who killed a local shopkeeper. Do you have an idea who it could've been?]\""), GetFinalDialogFromTyreNode);
		GetNeutralOptionFromTyreNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		GetFinalDialogFromTyreNode.addChild(new ActionChoice(NodeLabels.AddCupToInventory.toString(), Edric, Icons.mug), AddCupToInventoryNode);
		EnterCityNode.addChild(new PositionChoice(Edric, "City.GreenHouseDoor", Condition.exited), CityToTavernNode);
		CityToTavernNode.addChild(new PositionChoice(Edric, "Tavern.Spawn", Condition.arrived), EnterTavernNode);
		EnterTavernNode.addChild(new ActionChoice(NodeLabels.Talk.toString(), Rimmons, Icons.talk), SpeakWithRimmonsNode);
		SpeakWithRimmonsNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		EnterTavernNode.addChild(new ActionChoice(NodeLabels.Talk.toString(), BartenderMeier, Icons.talk), SpeakToBarTenderNode);
		SpeakToBarTenderNode.addChild(new SelectionChoice("\"[Good Dialog|I'd like to ask about the muder that happened last night]\""), GoodOptionFromMeiserNode);
		SpeakToBarTenderNode.addChild(new SelectionChoice("\"[Bad Option|Give me your finest bourbon]\""), BadOptionFromMeiserNode);
		BadOptionFromMeiserNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		GoodOptionFromMeiserNode.addChild(new SelectionChoice("\"[GoodChoice|I've heard you have ways of getting information.]\""), GoodOptionFromGoodOptionFromMeiserNode);
		GoodOptionFromMeiserNode.addChild(new SelectionChoice("\"[BadChoice|Because I'll arrest you if you don't have information]\""), BadOptionFromGoodOptionNode);
		GoodOptionFromGoodOptionFromMeiserNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		BadOptionFromGoodOptionNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		EnterTavernNode.addChild(new PositionChoice(Edric, "Tavern.Door", Condition.exited), ExitTavernNode);
		ExitTavernNode.addChild(new PositionChoice(Edric, "City.Spawn", Condition.arrived), EnterCityNode);
		EnterCityNode.addChild(new PositionChoice(Edric, "City.GreenHouseDoor", Condition.exited), ExitCityToCollege);
		ExitCityToCollege.addChild(new PositionChoice(Edric, "Cottage.Spawn", Condition.arrived), EnterCottageNode);
		EnterCottageNode.addChild(new ActionChoice(NodeLabels.PickUpScroll.toString(), Scroll, Icons.scroll, "Read Scroll", true), PickUpScrollNode);
		PickUpScrollNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), CloseandPutDownScrollNode);
		EnterCottageNode.addChild(new ActionChoice(NodeLabels.PickUpPotionandAddToInventory.toString(), Edric, Icons.potion, "Add Potion To Inventory", true), PickUpPotionandAddToInventoryNode);
		EnterCottageNode.addChild(new PositionChoice(Edric, "Cottage.Door", Condition.exited), ExitCottageNode);
		ExitCottageNode.addChild(new PositionChoice(Edric, "City.Spawn", Condition.arrived), EnterCityNode);
		EnterCityNode.addChild(new ActionChoice(NodeLabels.Talk.toString(), GeneralEduart, Icons.talk), SpeakWithGeneralEduarttogivedecisionNode);
		SpeakWithGeneralEduarttogivedecisionNode.addChild(new SelectionChoice("\"[Yes|Yes]\""), YesToKnowingKillernode);
		SpeakWithGeneralEduarttogivedecisionNode.addChild(new SelectionChoice("\"[No|No]\""), SayNoToKnowingKillernode);
		SayNoToKnowingKillernode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		YesToKnowingKillernode.addChild(new SelectionChoice("\"[Correct|Roki]\""), Rokiisthekiller);
		YesToKnowingKillernode.addChild(new SelectionChoice("\"[BadOption1|Lady Marina(Apprenctice)]\""), Apprenticeisthekiller);
		YesToKnowingKillernode.addChild(new SelectionChoice("\"[BadOption2|Rival Shopkeeper]\""), Opponentshopkeeperisthekiller);
		Rokiisthekiller.addChild(new ActionChoice(NodeLabels.Give.toString(), GeneralEduart, Icons.mug), ShowCorrectEvidenceForRokiNode);
		Rokiisthekiller.addChild(new ActionChoice(NodeLabels.Give.toString(), GeneralEduart, Icons.potion), ShowIncorrectEvidenceForRokiGreenPotionNode);
		Rokiisthekiller.addChild(new ActionChoice(NodeLabels.Give.toString(), GeneralEduart, Icons.book), ShowIncorrectEvidenceForRokiBookNode);
		ShowIncorrectEvidenceForRokiGreenPotionNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		ShowIncorrectEvidenceForRokiBookNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		ShowCorrectEvidenceForRokiNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), OkayFromGeneralToGoodChoiceNode);
		OkayFromGeneralToGoodChoiceNode.addChild(new PositionChoice(Edric, "City.Fountain", Condition.exited), GoToDungeonGoodEndingInitialNode);
		GoToDungeonGoodEndingInitialNode.addChild(new PositionChoice(Edric, "Dungeon.Spawn", Condition.arrived), FillerNode);
		FillerNode.addChild(new ActionChoice(NodeLabels.Talk.toString(), GeneralEduart, Icons.talk), PromotionNode);
		Apprenticeisthekiller.addChild(new ActionChoice(NodeLabels.Give.toString(), GeneralEduart, Icons.mug), ShowIncorrectEvnidenceForApprenctice1MugNode);
		Apprenticeisthekiller.addChild(new ActionChoice(NodeLabels.Give.toString(), GeneralEduart, Icons.potion), ShowIncorrectEvidenceForApprenctice1GreenPotionNode);
		Apprenticeisthekiller.addChild(new ActionChoice(NodeLabels.Give.toString(),GeneralEduart, Icons.book), ShowCorrectEvidenceForApprenticeNodeNode);
		ShowIncorrectEvidenceForApprenctice1GreenPotionNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		ShowIncorrectEvnidenceForApprenctice1MugNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		ShowCorrectEvidenceForApprenticeNodeNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), DialogForCorrectEvidenceForApprencticeNode);
		DialogForCorrectEvidenceForApprencticeNode.addChild(new PositionChoice(Edric, "City.Fountain", Condition.exited), GoToDungeonBadEndingInitialNode);
		GoToDungeonBadEndingInitialNode.addChild(new PositionChoice(Edric, "Dungeon.DirtPile", Condition.arrived), FillerNode2);
		FillerNode2.addChild(new ActionChoice(NodeLabels.Talk.toString(), GeneralEduart, Icons.talk), BadEndingDialogNode);
		Opponentshopkeeperisthekiller.addChild(new ActionChoice(NodeLabels.Give.toString(), GeneralEduart, Icons.mug), ShowIncorrectEvidenceForOpponentSHopKeeperMug);
		Opponentshopkeeperisthekiller.addChild(new ActionChoice(NodeLabels.Give.toString(), GeneralEduart, Icons.potion),ShowCorrectEvidenceForOponentShopKeeperNode);
		Opponentshopkeeperisthekiller.addChild(new ActionChoice(NodeLabels.Give.toString(), GeneralEduart, Icons.book), ShowIncorrectEvidenceForOpponentShopKeeperBookNode);
		ShowIncorrectEvidenceForOpponentSHopKeeperMug.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		ShowCorrectEvidenceForOponentShopKeeperNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), ContinueNode);
		ShowCorrectEvidenceForOponentShopKeeperNode.addChild(new SelectionChoice("\"[Continue|Continue]\""), rightevidenceforothershopkeepernode);
		rightevidenceforothershopkeepernode.addChild(new PositionChoice(Edric, "City.Fountain", Condition.exited), GoToDungeonBadEndingInitialNode);
		//see how this works in actual testing
		
		
		//YesToKnowingKillernode.addChild(new SelectionChoice("\"[Correct|Roki]\""), ShowCorrectEvidenceForRokiNode);
		//YesToKnowingKillernode.addChild(new SelectionChoice("\"[BadOption1|Lady Marina(Apprenctice)]\""), ShowProofNode);
		//YesToKnowingKillernode.addChild(new SelectionChoice("\"[BadOption2|Rival Shopkeeper]\""), ShowProofNode);
		
		
		
		
		
		
		
		

		
		
		return root;
	}

	@Override
	public void getThings() {
		Edric = new Character(ThingNames.Tom.toString(), BodyType.C, Clothing.LightArmour, HairStyles.Short);
		Rimmons = new Character(ThingNames.Rimmons.toString(), BodyType.H, Clothing.Peasant, HairStyles.Short);
        GeneralEduart = new Character(ThingNames.GeneralEduart.toString(), BodyType.D, Clothing.HeavyArmour,HairStyles.Short);
        StarterPlace = new Place(ThingNames.Home.toString(), Place.Places.Bridge);
        CourtYard = new Place(ThingNames.CourtYard.toString(), Place.Places.Courtyard);
        Port = new Place(ThingNames.Port.toString(), Place.Places.Port);
        Tavern = new Place(ThingNames.Tavern.toString(), Place.Places.Tavern);
        Cottage1 = new Place(ThingNames.Cottage1.toString(), Place.Places.Cottage);
        Cottage2 = new Place(ThingNames.Cottage2.toString(), Place.Places.Cottage);
        Dungeon = new Place(ThingNames.Dungeon.toString(), Place.Places.Dungeon);
        City = new Place(ThingNames.City.toString(), Place.Places.City);
        AlchemyShop = new Place(ThingNames.AlchemyShop.toString(), Place.Places.AlchemyShop);
        SoldierFrye = new Character(ThingNames.SoldierFrye.toString(), BodyType.F, Clothing.HeavyArmour, HairStyles.Short);
        SoldierHale = new Character(ThingNames.SoldierHale.toString(), BodyType.H, Clothing.HeavyArmour, HairStyles.Short);
        SoldierTyre = new Character(ThingNames.SoldierTyre.toString(), BodyType.B, Clothing.HeavyArmour, HairStyles.Short);
        SoldierWinfred = new Character(ThingNames.SoldierWinfred.toString(), BodyType.F, Clothing.LightArmour, HairStyles.Short);
        SoldierStani = new Character(ThingNames.SoldierStani.toString(),BodyType.H, Clothing.LightArmour, HairStyles.Short);
        Roki = new Character(ThingNames.Roki.toString(), BodyType.B, Clothing.Bandit, HairStyles.Short);
        LadyMarina = new Character(ThingNames.LadyMarina.toString(), BodyType.C, Clothing.Priest, HairStyles.Long);
        LadyKasumi = new Character(ThingNames.LadyKasumi.toString(), BodyType.E, Clothing.Peasant, HairStyles.Ponytail);
        //SuspectHumphrey = new Character(ThingNames.SuspectHumphrey.toString());
        //CustomerAleksey = new Character(ThingNames.CustomerAleksey.toString());
        BartenderMeier = new Character(ThingNames.BartenderMeier.toString(),BodyType.B, Clothing.Merchant, HairStyles.Short);
        Soporific = new Item(ThingNames.GreenPotion.toString(), Items.GreenPotion);
        Skull = new Item(ThingNames.Skull.toString(), Items.Skull);
        Cup = new Item(ThingNames.Cup.toString(), Items.Cup);
        Ledger = new Item(ThingNames.OpenScroll.toString(), Items.OpenScroll);
        GreenPotion = new Item(ThingNames.GreenPotion.toString(), Items.GreenPotion);
        OpponentShopKeeper = new Character(ThingNames.OppopentShopKeeper.toString());
        Book = new Item(ThingNames.SpellBook.toString(), Items.SpellBook);
        Scroll = new Item(ThingNames.OpenScroll.toString(),Items.OpenScroll);
        

		
		
	}
	
	private ActionSequence getFillerNodeSequence() {
		var sequence = new ActionSequence();
		return sequence;
	}
	
	private ActionSequence getFiller2NodeSequence() {
		var sequence = new ActionSequence();
		return sequence;
	}
	
	private ActionSequence getFiller3NodeSequence() {
		var sequence = new ActionSequence();
		return sequence;
	}
	
	private ActionSequence getRokiisthekillerSequence() {
		var sequence = new ActionSequence();
		return sequence;
	}
	
	private ActionSequence getApprencticeisthekillerSequence() {
		var sequence = new ActionSequence();
		return sequence;
	}
	
	private ActionSequence getOtherShopKeeperisthekillerSequence() {
		var sequence = new ActionSequence();
		return sequence;
	}
	
	private ActionSequence getInitSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Edric));
		sequence.combineWith(new CharacterCreation(GeneralEduart));
		sequence.add(new Create<Place>(StarterPlace));
		sequence.add(new Position(Edric, StarterPlace));
		sequence.add(new Position(GeneralEduart, StarterPlace, "SouthEnd"));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getStartSequence() {
		var sequence=new ActionSequence();
		sequence.add(new ShowMenu(false));
		sequence.add(new EnableInput(true));
		return sequence;
	}
	
	private ActionSequence getSpeakToGuardSequence() {
		var sequence=new ActionSequence();
		sequence.add(new EnableInput(true));
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(GeneralEduart));
		sequence.add(new SetDialog("\"Greetings soldier, I have a task for you. There's been reports\n of a murder at the local alchemy shop.\n I've already sent a few men to check it out,\n and they're waiting for you to come check it out. Once you've figured out who the culprit is, you can find me at the City fountain.\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice1));
		return sequence;
	}
	
	
	private ActionSequence getTeleportToShopViaGeneralSequence() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new FadeOut());
		return sequence;
	}
	
	private ActionSequence getEnterAlchemyShopSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(SoldierHale));
		sequence.combineWith(new CharacterCreation(SoldierFrye));
		sequence.combineWith(new CharacterCreation(SoldierWinfred));
		sequence.combineWith(new CharacterCreation(LadyMarina));
		sequence.add(new Position(LadyMarina, AlchemyShop, "AlchemistTable.Center"));
		sequence.add(new Position(SoldierHale, AlchemyShop, "RightBookcase"));
		sequence.add(new Position(SoldierFrye, AlchemyShop, "Chest"));
		sequence.add(new Position(SoldierWinfred, AlchemyShop, "Cauldron"));
		sequence.add(new Position(Book, AlchemyShop, "Table.Left"));
		sequence.add(new Create<Place>(AlchemyShop));
		sequence.add(new Position(Edric, AlchemyShop));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		return sequence;
	}
	
	private ActionSequence getPickUpBookSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Pickup(Edric, Book, AlchemyShop.getFurniture("Table")));
		sequence.add(new Pocket(Edric, Book));
		return sequence;
	}
	
	private ActionSequence getAddBookToInventorySequence() {
		var sequence = new ActionSequence();
		sequence.add(new AddToList(Book, "A spellbook with many unique spells. It's quite heavy."));
		return sequence;
	}
	
	private ActionSequence getSpeakWithSoldierHaleSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierHale));
		sequence.add(new SetDialog("\"Greets Soldier, glad you could make it. We received reports of a murder happening\n at this shop early in the morning. We tried to get here as soon as we could, but then the shopkeeper was long gone. The only known person at the shop during the time of the murder was the apprentice, but we can't rule out the possibility of others being here.\n [ideal|Do you have any idea where I could look] [lazy|Okay, I'll take a look around]\""));
		//sequence.add(new SetDialog("\"There's a lady in a nearby alleyway who claims to have spotted who ran out the shop around the time of the murder.\n I'd suggest speaking with her to get more information.\""));
		//sequence.add(new SetDialog("\"Good luck.\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice2));
		//sequence.add(new EnableInput(true));
		return sequence;
	}
	
	private ActionSequence getIdealAnswerwithHaleSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"There's a lady in a nearby alleyway who claims to have spotted who ran out the shop around the time of the murder.\n I'd suggest speaking with her to get more information.[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getLessIdealAnswerwithHaleSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Good luck.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getContinueSequence() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		return sequence;
			
	}
	
	
	private ActionSequence getSpeakWithSoldierWinfredSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierWinfred));
		sequence.add(new SetDialog("\"Cruel world this is. Dying in your store. I'm glad the shopkeeper's apprentice called to report the situation, but she's the only one we know of who could've done it. Ironic, isn't it? [betteroption|Is the apprentice still in the shop?] [worseoption|Indeed]\""));
		//sequence.add(new SetDialog("\"Yes, you may speak with her if you'd like. You could get some useful information from her. Between you and me, I heard she would inherit the show if he ever passed.\n[Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Another place that could be worth exploring is the cottage of another shopkeeper. He's notorious for hating this guy. There's a posibility you could find something useful there.\n [Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Well, I wish you luck on your search for information.\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice3));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getBetterOptionWinfredSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Yes, you may speak with her if you'd like. You could get some useful information from her. Between you and me, I heard she would inherit the show if he ever passed.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getWorseOptionWinfredSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Well, I wish you luck on your search for information.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getContinueWinfredSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Another place that could be worth exploring is the cottage of another shopkeeper. He's notorious for hating this guy. There's a posibility you could find something useful there.\n [Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getSpeakWithSoldierFryeSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierFrye));
		sequence.add(new SetDialog("\"From what we can tell, the shopkeeper was killed with a blunt object, but we aren't sure what that object was.\n [GoodOption|Do you know of any places to look?] [BadOption|How are you that incompetent at your job?]\""));
		//sequence.add(new SetDialog("\"I'd suggest the tavern. The bartender knows a lot about the city. He might have information that could prove useful.\n[Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Careful now, insulting your superior is the fastest way to be fired.\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice4));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getGoodChoiceFryeSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"I'd suggest the tavern. The bartender knows a lot about the city. He might have information that could prove useful.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getBadChoiceFryeSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"Careful now, insulting your superior is the fastest way to be fired.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getSpeakWithLadyMarinaSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(LadyMarina));
		sequence.add(new SetDialog("\"I know how this looks, but I'm innocent. I was taking a stroll through the city last night, and I wanted to ask my boss something. When I entered the shop, he was dead! You've got to figure out who did it.\n[Continue|Continue]\""));
		sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice5));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getExitAlchemyShopViaTeleportSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, AlchemyShop.getFurniture("Door"), true));
		sequence.add(new FadeOut());
		return sequence;
	}
	
	private ActionSequence getEnterCitySequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(LadyKasumi));
		sequence.add(new Position(LadyKasumi, City, "Alley2"));
		sequence.add(new Position(GeneralEduart, City, "Fountain"));
		sequence.add(new Create<Place>(City));
		sequence.add(new Position(Edric, City));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		//sequence.add(new ShowMenu(true));
		return sequence;
	}
	
	private ActionSequence getSpeakWithLadyKasumiSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(LadyKasumi));
		sequence.add(new SetDialog("\"Hey there, are you one of the guards investigating the murder inside the shop? [Good Option|Yes] [Bad Option|No]\""));
		//sequence.add(new SetDialog("\"Then why are you here in the alley? If you don't leave, I'll get the guards to come arrest you.\n[Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Alright, I just wanted to make sure. Early in the morning, I saw someone running from the shop to the pier. He must've been the killer. You need to go after him!\n [GoodOption|Teleport To Pier] [BadOption|I don't trust you]\""));
		//sequence.add(new SetDialog("\"WHAT! Men these days, you idiots never believe anything a woman says.\n[Continue|Continue]\""));
		//Implement Exiting City for pier option later
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice6));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getGoodOptionKasumiSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Alright, I just wanted to make sure. Early in the morning, I saw someone running from the shop to the pier. He must've been the killer. You need to go after him!\n [GoodOption|Teleport To Pier] [BadOption|I don't trust you]\""));
		return sequence;
	}
	
	private ActionSequence getBadOptionKasumiSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Then why are you here in the alley? If you don't leave, I'll get the guards to come arrest you.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getTeleportToPierSequence() {
		var sequence = new ActionSequence();
		sequence.add(new FadeOut());
		sequence.add(new HideDialog());
		return sequence;
	}
	
	private ActionSequence getSayNoToPierSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"WHAT! Men these days, you idiots never believe anything a woman says.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getEnterPierSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Roki));
		sequence.combineWith(new CharacterCreation(SoldierStani));
		sequence.combineWith(new CharacterCreation(SoldierTyre));
		sequence.add(new Create<Place>(Port));
		sequence.add(new Position(Edric, Port));
		sequence.add(new Position(SoldierStani, Port, "SmallStall"));
		sequence.add(new Position(SoldierTyre, Port, "BigShip"));
		sequence.add(new Position(Roki, Port, "SmallShip"));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		return sequence;
	}
	

	private ActionSequence getSpeakWithSoliderStaniSequence() {
		var sequence = new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierStani));
		sequence.add(new SetDialog("\"Would you like to leave the pier? [Yes|Yes] [No|No]\""));
		sequence.add(new Position(Edric, City));
		sequence.add(new SetCameraFocus(Edric));
		return sequence;
	}
	
	private ActionSequence getDoNotLeavePierYetSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Alright, just let me know when you're ready to leave.[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getExitPierSequence() {
		var sequence = new ActionSequence();
		sequence.add(new FadeOut());
		return sequence;
	}
	
	private ActionSequence getSpeakWithRokiSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(Roki));
		sequence.add(new SetDialog("\"What do you want with me, can't you see I'm busy?\n [Good Option| Why are you in such a rush?] [Bad Option|Sorry Sir, I didn't notice]\""));
		//sequence.add(new SetDialog("\"Yeah, idiot.\n[Continue|Continue]\""));
		//sequence.add(new SetDialog("\"I'm not telling you anything. Why can't you guards just let me leave!\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice6));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	//map roki dialog
	
	private ActionSequence getGoodDialogRokiSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"I'm not telling you anything. Why won't you guards just let me leave!\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getBadDialogRokiSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"Yeah, idiot.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getSpeakWithSoldierTyreSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(SoldierTyre));
		sequence.add(new SetDialog("\"Good Morning, is there something you wanted to ask?\n [GoodAnswer|What's going on with that frazzled guy?] [BadAnswer|Nothing, just looking around]\""));
		//sequence.add(new SetDialog("\"Okay, I'll be here if you need to ask any questions.\n[Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Oh, Roki? I'm not sure, but he seems to be in quite the hurry to leave. When he came in he seemed drunk out of his mind.\n He keeps asking us for a boat, but we can't give him something he doesn't own.\n [Interesting]\""));
		//sequence.add(new SetDialog("\"Isn't it? Well, if that'll be all, have a nice day.\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice10));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	
	private ActionSequence getGoodAnswerFromTyreforfirstquestionSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"Oh, Roki? I'm not sure, but he seems to be in quite the hurry to leave. When he came in he seemed drunk out of his mind.\n He keeps asking us for a boat, but we can't give him something he doesn't own.\n [Contininue|I'm trying to find out who killed a local shopkeeper. Do you have an idea who it could've been?]\""));
		return sequence;
	}
	
	private ActionSequence getNeutralAnswerFromTyreSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"Okay, I'll be here if you need to ask any questions.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getFinalDialogFromTyreSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"I'm not exactly sure, but when Roki came in, he was holding a mug. Maybe it could help you out?\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getAddCupToInventorySequence() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new Give(SoldierTyre, Cup, Edric));
		sequence.add(new Pocket(Edric, Cup));
		sequence.add(new AddToList(Cup, "A mug obtained from the local tavern. Looks damaged at the bottom"));
		return sequence;

	}

	
	
	private ActionSequence getCityToTavernSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Enter(Edric, City.getFurniture("GreenHouseDoor"), true));
		return sequence;
	}
	
	private ActionSequence getEnterTavernSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(BartenderMeier));
		sequence.combineWith(new CharacterCreation(Rimmons));
		sequence.add(new Create<Place>(Tavern));
		sequence.add(new Create<Item>(Cup));
		sequence.add(new Position(Cup, Tavern, "Table.front"));
		sequence.add(new Position(Rimmons, Tavern, "BackLeftStool"));
		sequence.add(new Position(BartenderMeier, Tavern, "Bar.Behind"));
		sequence.add(new Position(Edric, Tavern));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		return sequence;
	}
	
	private ActionSequence getSpeakWithRimmonsSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(Rimmons));
		sequence.add(new SetDialog("\"Uhh....hhh..hhh.. ca...n't....t sp....e..a..k.......Mu.s....tF....i....n..d...K..a...r.e...n\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice7));
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getSpeakWithBartenderMeierSequence() {
		var sequence=new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1)); (remove these)
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(BartenderMeier));
		sequence.add(new SetDialog("\"Hi sir, what can I do for you?\n [Good Dialog|I'd like to ask about the muder that happened last night]\n [Bad Option|Give me your finest bourbon]\""));
//		sequence.add(new SetDialog("\"Sorry sir, we don't serve drinks this early. Only reason we're open is because that drunk bloat isn't able to leave. Please come back tonight.\\n[Continue|Continue]\""));
//		sequence.add(new SetDialog("\"Why do you think I'd know anything about that? [GoodChoice|I've heard you have ways of getting information.] [BadChoice|Because I'll arrest you if you don't have information]\""));
//		sequence.add(new SetDialog("\"Well, I may not know who directly caused it, but one of my patrons left this place last night particularly drunk. He always talks about how he used to be a sailor. Perhaps he might know something.\n[Continue|Continue]\""));
//		sequence.add(new SetDialog("\"Okay, I've heard enough. Get out of my shop, now!\n[Continue|Continue]\""));
		//sequence.add(new HideDialog());
		//sequence.add(new DisableIcon(actionChoice8)); (remove these)
		//sequence.add(new EnableInput(false));
		return sequence;
	}
	
	private ActionSequence getGoodOptionFromMeiserSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"Why do you think I'd know anything about that? [GoodChoice|I've heard you have ways of getting information.] [BadChoice|Because I'll arrest you if you don't have information]\""));
		return sequence;

	}
	
	private ActionSequence getGoodOptionFromGoodOptionFromMeiserSequence() {
		var sequence=new ActionSequence();
		sequence.add(new SetDialog("\"Well, I may not know who directly caused it, but one of my patrons left this place last night particularly drunk. He always talks about how he used to be a sailor. Perhaps he might know something.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getBadOptionFromMeiserSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Sorry sir, we don't serve drinks this early. Only reason we're open is because that drunk bloat isn't able to leave. Please come back tonight.\\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getBadOptionFromGoodOptionMeiserSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Okay, I've heard enough. Get out of my shop, now!\n[Continue|Continue]\""));
		return sequence;
	}
	
	
	private ActionSequence getExitTavernSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, Tavern.getFurniture("Door"), true));
		sequence.add(new FadeOut());
		return sequence;
	}

	private ActionSequence getTavernToCitySequence() {
		var sequence = new ActionSequence();
		sequence.add(new Position(Edric, City));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		return sequence;
	}
	
	private ActionSequence getExitCityToCollegeSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, City.getFurniture("GreenHouseDoor") , true));
		return sequence;
	}
	
	private ActionSequence getEnterCottageSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(Cottage1));
		sequence.add(new Position(Edric, Cottage1));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new Position(GreenPotion, Cottage1, "Table"));
		sequence.add(new Position(Scroll, Cottage1, "Shelf"));
		sequence.add(new FadeIn());
		return sequence;
	}

	private ActionSequence getPickUpScrollSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Pickup(Edric, Scroll));
		sequence.add(new ShowNarration());
		sequence.add(new SetNarration("\"Curses, my doctor told me this potion would calm my nerves, but all it does is make me crazy\n I don't know what to do anymore. I've become dependant on it. Severe pain strikes my body when I'm not under its influence.\n It's only a matter of time before I hurt someone.\n[Continue|Continue]\""));
		return sequence;

	}
	
//	private ActionSequence getReadScrollSequence() {
//		var sequence = new ActionSequence();
//		sequence.add(new ShowNarration());
//		sequence.add(new SetNarration("\"Curses, my doctor told me this potion would calm my nerves, but all it does is make me crazy\n I don't know what to do anymore. I've become dependant on it. Severe pain strikes my body when I'm not under its influence.\n It's only a matter of time before I hurt someone.\n[Continue|Continue]\""));
//		return sequence;
//	}
//	
	private ActionSequence getCloseandPutDownScrollSequence() {
		var sequence = new ActionSequence();
		sequence.add(new HideNarration());
		sequence.add(new PutDown(Edric, Scroll));
		return sequence;
	}
	
	private ActionSequence getPickUpPotionandAddtoInventorySequence() {
		var sequence = new ActionSequence();
		sequence.add(new Pickup(Edric, GreenPotion));
		sequence.add(new AddToList(GreenPotion, "\"Liquid with makes the drinker frenzied when consumed. Very addictive.\""));
		sequence.add(new Pocket(Edric, GreenPotion));
		return sequence;
	}
	
	
	private ActionSequence getExitCottageSequence() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Edric, Cottage1.getFurniture("Door"), true));
		return sequence;
	}
	
	private ActionSequence getSpeakWithGeneralEduartToGiveDecision() {
		var sequence = new ActionSequence();
		//sequence.add(new EnableIcon(actionChoice1));
		//sequence.add(new EnableInput(true));
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(GeneralEduart));
		sequence.add(new SetDialog("\"Have you figured out who killed the Shop Owner?\n[Yes|Yes] [No|No]\""));
		//sequence.add(new SetDialog("\"Then what are you doing here? Get to Work!\n[Continue|Continue]\""));
		//sequence.add(new SetDialog("\"Really now, who do you suppose is guilty?\n [BadOption1|Lady Marina(Apprenctice)] [Correct|Roki] [BadOption2|Rival Shopkeeper]\""));
		//sequence.add(new SetDialog("\"Before I arrest anyone, I'll need you to give me some evidence that proves their guilt. Do you have any?\n [Yes|Yes (Present Evidence)] [No|No]\""));
		//sequence.add(new SetDialog("\"Sorry, but I cannot arrest anyone without evidence. Come back when you do.\n[Continue|Continue]\""));
		//sequence.add(new ShowList(Edric));
		//sequence.add(new Give(Edric, Cup, GeneralEduart));
		//Write Description for Cup (acts as the explanation)
		//sequence.add(new SetDialog("\"This is sufficient, I'll send my men to the pier to arrest him. Thank you for your assistance.[Continue]\""));
		//sequence.add(new SetDialog("\"What? How on earth is this related to that individual? Quit wasting my time and get back to work[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getYesToKnowingKillerSequence() {
		var sequence = new ActionSequence();
		new SetDialog("\"Really now, who do you suppose is guilty?\n [BadOption1|Lady Marina(Apprenctice)] [Correct|Roki] [BadOption2|Rival Shopkeeper]\"");
		return sequence;
	}
	
	private ActionSequence getSayNoToKnowingKillerSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"Then what are you doing here? Get to Work!\n[Continue|Continue]\""));
		return sequence;
	}
	
//	private ActionSequence getShowProofSequence() {
//		var sequence = new ActionSequence();
//		sequence.add(new SetDialog("\"Before I arrest anyone, I'll need you to give me some evidence that proves their guilt. Do you have any?\n [Yes|Yes (Present Evidence)] [No|No]\""));
//		return sequence;
//	}
	
//	private ActionSequence getNoProofSequence() {
//		var sequence = new ActionSequence();
//		sequence.add(new SetDialog("\"Sorry, but I cannot arrest anyone without evidence. Come back when you do.\n[Continue|Continue]\""));
//		return sequence;
//	}
	
	private ActionSequence getShowCorrectEvidenceForRokiSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, Cup, GeneralEduart));
		sequence.add(new HideList());
		return sequence;
	}
	
	private ActionSequence getIncorrectEvidenceForRokiBookSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, Book, GeneralEduart));
		sequence.add(new HideList());
		return sequence;
	}
	
	private ActionSequence getIncorrectEvidenceForRokiGreenPotionSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, GreenPotion, GeneralEduart));
		sequence.add(new HideList());
		return sequence;
	}
	
	private ActionSequence getOkayFromGeneralToGoodChoiceSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(true));
		sequence.add(new SetDialog("\"This is sufficient, I'll send my men to the pier to arrest him. Thank you for your assistance.[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getGiveWrongItemForRightChoiceSequence() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("\"What? How on earth is this related to that individual? Quit wasting my time and get back to work[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getExitCityToDungeonGoodEndingInitialSequence() {
		var sequence = new ActionSequence();
		return sequence;
	}
	
	private ActionSequence getExitCityToDungeonBadEndingInitialSequence() {
		var sequence = new ActionSequence();
		return sequence;
	}
	
	private ActionSequence getExitCityToDungeonGoodEndingSequence() {
		var sequence = new ActionSequence();
		sequence.add(new FadeOut());
		sequence.add(new Position(Roki, Dungeon, "DirtPile"));
		sequence.add(new Create<Place>(Dungeon));
		sequence.add(new Position(Edric, Dungeon));
		sequence.add(new Position(GeneralEduart, Dungeon));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		return sequence;
	}
	
	private ActionSequence getPromotionSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(GeneralEduart));
		sequence.add(new SetDialog("\"Great Work Soldier, I'm glad you were able to determine the culpurit. For doing such a great job, I'm promoting you to the rank of general.\n[Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getendFadeSequence() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new FadeIn());
		return sequence;
	}
	
	private ActionSequence getShowCorrectEvidenceForOpponentShopKeeperSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, GreenPotion, GeneralEduart));
		return sequence;
	}
	
	private ActionSequence getShowIncorrectEvidenceForOpponentShopKeeperMugSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, Cup, GeneralEduart));
		return sequence;
	}
	
	private ActionSequence getShowIncorrectEvidenceForOpponentShopKeeperBookSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, Book, GeneralEduart));
		return sequence;
	}
	
	private ActionSequence getGiveRightEvidenceToEduartForShopKeeperSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(true));
		sequence.add(new SetDialog("\"Wow, I knew he hated the guy, but I didn't expect he could stoop so low. Alright, I'll go get the guards. Good work.\n [Continue|Continue]\""));
		return sequence;
	}
	

	
	private ActionSequence getTeleportToDungeonForBadEndingSequence() {
		var sequence = new ActionSequence();
		sequence.add(new FadeOut());
		sequence.add(new Create<Place>(Dungeon));
		sequence.add(new Position(Edric, Dungeon, "DirtPile"));
		sequence.add(new Position(GeneralEduart, Dungeon));
		sequence.add(new SetCameraFocus(Edric));
		sequence.add(new FadeIn());
		return sequence;
	}
	
	private ActionSequence getBadEndingSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(true));
		sequence.add(new SetLeft(Edric));
		sequence.add(new SetRight(GeneralEduart));
		sequence.add(new SetDialog("\"I cannot believe this. How could you get the wrong person! We arrested an innocent person because of your incomeptent. Not only are you fired, you will stay in the dungeon for one year as punishment.\n I hope you use this opportunity to reflect on your wrongdoings. [Continue|Continue]\""));
		return sequence;
	}
	
	private ActionSequence getShowCorrectEvidenceForApprenticeSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, Book, GeneralEduart));
		sequence.add(new HideList());
		return sequence;
	}
	
	private ActionSequence getShowIncorrectEvidenceForApprentice1MugSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, Cup, GeneralEduart));
		sequence.add(new HideList());
		return sequence;
	}
	
	private ActionSequence getShowIncorrectEvidenceForApprentice1GreenPotionSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(false));
		sequence.add(new HideDialog());
		sequence.add(new ShowList(Edric));
		sequence.add(new Give(Edric, GreenPotion, GeneralEduart));
		sequence.add(new HideList());
		return sequence;
	}
	
	private ActionSequence getDialogForCorrectEvidenceForApprenticeSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog(true));
		sequence.add(new SetDialog("\"A book to the head? I suppose that could've killed him. Alright, good work. I'll send my guards\n [Continue|Continue]\""));
		return sequence;
	}
	
	
	
	
	
	
	
	

}
