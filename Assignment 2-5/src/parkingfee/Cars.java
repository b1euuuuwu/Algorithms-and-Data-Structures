package parkingfee;

import java.util.*;

public class Cars {
	protected String carModel;
	protected int parkTime;
	protected final int parkRate = 2000;

	//constructor
	public Cars() {
		carModel = "";
		parkTime = 0;
	}

	public Cars(String carModel, int parkTime) {
		this.carModel = carModel;
		this.parkTime = parkTime;
	}

	public int getParkTime() {
		return parkTime;
	}

	public void setParkTime(int parkTime) {
		this.parkTime = parkTime;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int calculateParkingFee() {
		int parkFee = getParkTime() * parkRate;
		return parkFee;
	}

	public void printParkingFee() {
		System.out.println(getCarModel() + " has parked for " + getParkTime() + " hours = Rp" + calculateParkingFee());
	}
}
