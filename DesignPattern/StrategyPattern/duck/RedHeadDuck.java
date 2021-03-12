package com.duck;

public class RedHeadDuck extends Duck {
	
	public RedHeadDuck() {
		quackBehavior = new Squack();
	    flyBehavior = new FlyWithWings();
	}
	@Override
	public void display() {
		System.out.println("looks like a redhead duck");
	}
}
