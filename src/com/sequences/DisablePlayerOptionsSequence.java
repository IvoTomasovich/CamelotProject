package com.sequences;

import java.util.ArrayList;

import com.actions.ActionSequence;
import com.actions.DisableIcon;
import com.playerInput.*;

public class DisablePlayerOptionsSequence extends ActionSequence{
	public DisablePlayerOptionsSequence(ArrayList<IPlayerChoice> options) {
		for(var option:options) {
			if(option instanceof ActionChoice)
				add(new DisableIcon((ActionChoice)option));
		}
	}
	
}
