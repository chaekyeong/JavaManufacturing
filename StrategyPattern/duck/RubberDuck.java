package com.duck;

public class RubberDuck extends Duck {
	
	public RubberDuck() {
		quackBehavior = new Quack();
	    flyBehavior = new FlyNoWAY();
	}
	@Override
	public void display() {
		System.out.println("looks like a Rubber duck");
	}
}
