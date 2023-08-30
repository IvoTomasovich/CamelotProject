package com.actions;

/**
 * To start Camelot for the player, you must first use ShowMenu. This changes the screen from the loading screen to the main menu.
 * When the player clicks on Start in the main menu, Camelot sends the message: "input Selected Start".
 * Create an instance of SelectionChoice to wait for this message.
 * The experience manager waits for the success of this action.
 * @author Alireza Shirvani
 * @see com.playerInput.SelectionChoice
 */
public class ShowMenu implements IAction {
	boolean show;
	/**
	 * Shows or hide the main menu.
	 * @param show If true, shows the menu, otherwise, it will hide it.
	 */
	public ShowMenu(boolean show) {
		this.show=show;
	}
	/**
	 * @return "ShowMenu" or "HideMenu"
	 */
	@Override
	public String getName() {
		return show? "ShowMenu":"HideMenu";
	}
	/**
	 * @return true
	 */
	@Override
	public boolean getShouldWait() {
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s()", getName());
	}

}
