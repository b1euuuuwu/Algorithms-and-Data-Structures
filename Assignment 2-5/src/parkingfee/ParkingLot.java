package parkingfee;

import java.util.*;

public class ParkingLot extends Cars {
	String car;
	int time;
	int carAmount;
	LinkedList<Cars> parkingLot = new LinkedList<Cars>();
	Scanner sc = new Scanner(System.in);

	public ParkingLot(String carModel, int parkTime) {
		super(carModel, parkTime);
	}

	public void askCar() {
		System.out.print("How many cars? ");
		carAmount = sc.nextInt();

		//for loop to automatically create new objects and put it into parkingLot linked list
		for (int i = 0; i < carAmount; i++) {
			System.out.print("What car? ");
			car = sc.next();
			System.out.print("How long have you parked?(hours) ");
			time = sc.nextInt();
			parkingLot.add(i, new Cars(car, time));
		}
	}

	public void printParkingLot() {
		for (int i = 0; i < carAmount; i++) parkingLot.get(i).printParkingFee();
	}
}
