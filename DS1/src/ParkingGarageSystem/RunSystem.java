package ParkingGarageSystem;
import java.util.Scanner;

public class RunSystem {
	
	public static void main(String[] args) {
		Garage garage = new Garage(50);
		Gate entryGate = new Gate("entry", garage);
		Gate exitGate = new Gate("exit", garage);
		AdminConsole adminConsole = new AdminConsole(garage);
		boolean keepRunning = true;
		
		for(int i = 0; i < 43; i++) {
			entryGate.startGate();
		}
		
		// Main menu
		while(keepRunning) {
			for(int i = 0; i < 50; i++)
				System.out.println();
			System.out.println("Welcome to the parking garage!\n--------------------------------");
			if (garage.isFull())
				System.out.println("Garage is currently full. Please try again later. (Current occupancy: " + garage.getTicketDatabase().getNumOpenTickets() + " out of " + garage.getCapacity() + ")");
			else System.out.println("Garage has spots available! (Current occupancy: " + garage.getTicketDatabase().getNumOpenTickets() + " out of " + garage.getCapacity() + ")");
			System.out.println("\nPlease select an option below:\n[1] Enter garage\n[2] Exit garage\n[3] (Admin only) Open Admin Reports Console\n[4] (Admin only) Change settings\n[5] Exit system");
			Scanner keyboard = new Scanner(System.in);
			int choice = keyboard.nextInt();
			switch(choice) {
			case 1:
				entryGate.startGate();
				break;
			case 2:
				exitGate.startGate();
				break;
			case 3:
				adminConsole.DataMenu();
				break;
			case 4:
				adminConsole.changeSettings();
				break;
			case 5:
				keepRunning = false;
				break;
			default: 
				System.out.println("This is not a valid option. Please try again.");
			}
			try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
			
		}
	}
}
