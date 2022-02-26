package com.company;

public class Main {		//encapsulation

    public static void main(String[] args) {

		// Create objects for each type
		Eat carnivore = new Carnivore();
		Eat herbivore = new Herbivore();
		Eat omnivore = new Omnivore();

		// Call the methods to print
		carnivore.animalEats();
		herbivore.animalEats();
		omnivore.animalEats();

    }
}
