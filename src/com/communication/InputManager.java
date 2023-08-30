package com.communication;

import com.utility.Event;

public class InputManager implements Receiver{
	private static InputManager instance;
	private InputManager() {
		var listener=Listener.get();
		listener.listeners.Subscribe(t->React(t));
		subscribers=new Event<>();
	}

	public Event<String> subscribers;
	public static InputManager getInstance() {
		if(instance==null)
			instance=new InputManager();
		return instance;
	}
	@Override
	public void React(String msg) {
			if(msg.startsWith("input")) {
				System.out.println("Received: "+msg);
				subscribers.Notify(msg);
			}
	}

}
