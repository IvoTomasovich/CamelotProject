package com.actions;
import com.entities.Character;

public class WalkToSpot implements IAction{
	private Character character;
	private int X;
	private int Y;
	private int Z;
	
	public WalkToSpot(int X, int Y, int Z) {
		this.X = X;
		this.Y = Y;
		this.Z = Z;
	}
	
	@Override
	public String getName() {
		return "WalkToSpot";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}

	public String toString() {
		return String.format("%s(%s, %s, %s)", getName(), this.X, this.Y, this.Z);
	}
}
