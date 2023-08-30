package com.communication;

import java.util.Scanner;
import com.utility.Event;

public class Listener extends Thread{
	private static Listener listener;
	public Event<String> listeners;
	private Listener() {
		listeners=new Event<>();
	}
	
	public static Listener get() {
		if(listener==null) {
			listener=new Listener();
			listener.start();
		}
		return listener;
	}
	
	public static void Stop() {
		listener.interrupt();
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);

		while (!isInterrupted()) {
			String input = scanner.nextLine();
			if(input!="") {
				listeners.Notify(input);
			}
			
		}
		
		scanner.close();
	}
}
