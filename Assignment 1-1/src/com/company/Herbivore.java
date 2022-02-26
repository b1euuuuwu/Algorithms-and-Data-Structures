package com.company;

public class Herbivore extends Eat {	//inheritance

	public Herbivore() {
		super();
	}

	@Override
	public void animalEats() {	//polymorphism
		System.out.println("A Herbivore eats plants");
	}
}
