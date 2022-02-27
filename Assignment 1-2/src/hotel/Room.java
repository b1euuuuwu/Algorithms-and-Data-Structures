package hotel;
import java.util.*;

public class Room {
	protected boolean isReserved;
	protected int roomNumber;
	protected String reserveName;
	Scanner sc = new Scanner(System.in);

	//constructor
	public Room(boolean reserved, String reserveName) {
		this.isReserved = reserved;
		this.reserveName = reserveName;
	}

	//setters and getters
	public boolean isReserved() {
		return isReserved;
	}

	public String getReserveName() {
		return reserveName;
	}

	public void setReserveName(String reserver) {
		reserveName = reserver;
	}

	public void setReserved(boolean reserved) {
		isReserved = reserved;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	//functions
	public void whichRoom() {
		System.out.print("Which room (1-10): ");
		int roomNum = sc.nextInt();
		setRoomNumber(roomNum);
	}

	public void reserve() {
		System.out.print("Would you like to reserve?(yes/no) ");
		String choice = sc.nextLine();

		if (choice.equals("yes")) {
			setReserved(true);
			setReserveName(this.reserveName);
			setRoomNumber(this.roomNumber);
		}
		else {
			setReserved(false);
			setReserveName(this.reserveName);
		}
	}

	public void printReservation() {
		if (isReserved()) {
			System.out.println(getReserveName() + " has reserved room " + getRoomNumber());
		}
		else {
			System.out.println("Room is free");
		}
	}
}
