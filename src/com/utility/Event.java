package com.utility;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Event<T>{
	ArrayList<Consumer<T>> subscribers;
	public Event() {
		subscribers=new ArrayList<>();
	}
	public void Subscribe(Consumer<T> subscriber) {
		subscribers.add(subscriber);
	}
	public void Unsubscribe(Consumer<T> subscriber) {
		subscribers.remove(subscriber);
	}
	public void Notify(T t) {
		for(var subscriber: subscribers) {
			subscriber.accept(t);
		}
	}
	
}
