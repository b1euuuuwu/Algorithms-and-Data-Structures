package com.company;

public class Omnivore extends Eat{ 		//inheritance

	public Omnivore() {
		super();
	}

	@Override
	public void animalEats() {	//polymorphism
		System.out.println("An Omnivore eats meat and plants");
	}
}
