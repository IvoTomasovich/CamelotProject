package com.sequences;

import java.util.ArrayList;

import com.actions.ActionSequence;
import com.actions.EnableIcon;
import com.playerInput.*;

public class EnablePlayerOptionsSequence extends ActionSequence{
	public EnablePlayerOptionsSequence(ArrayList<IPlayerChoice> options) {
		for(var option:options) {
			if(option instanceof ActionChoice)
				add(new EnableIcon((ActionChoice)option));
		}
	}
	
}
