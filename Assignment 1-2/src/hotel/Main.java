package hotel;
import java.util.*;

public class Main {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Almas' Hotel!");
		System.out.print("Please enter your name: ");
		String name = sc.nextLine();

		// set new Objects for each room manually
		Room room = new Room(false, name);

		//call functions in Room class to reserve a room
		room.reserve();
		room.whichRoom();
		room.printReservation();
    }
}
