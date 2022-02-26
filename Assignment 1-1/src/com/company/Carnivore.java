package com.company;

public class Carnivore extends Eat{		//inheritance

	public Carnivore() {
		super();
	}

	@Override
	public void animalEats() { //polymorphism
		System.out.println("A Carnivore eats meat");
	}
}
