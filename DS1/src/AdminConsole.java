import java.util.ArrayList;
import java.util.Scanner;

// Interface for the admin console

public class AdminConsole {

	// Class variables
	private Garage garage;

	public AdminConsole(Garage garage) {
		this.garage = garage;
	}

	// Returns the current occupancy of the garage
	public int getOccupancy() {
		return garage.getTicketDatabase().getNumOpenTickets();
	}

	// Returns a boolean referencing whether the garage is full or not
	public boolean isGarageFull() {
		return garage.isFull();
	}

	// Starts a menu to get total payments or occupancy for a given time
	public void DataMenu() {
		ArrayList<Ticket> t = garage.getTicketDatabase().getTickets();
		Scanner dataMenuKeyboard = new Scanner(System.in);
		for (;;) {
			System.out.println("Welcome to the Data Menu! Please select an option:\n[1] View payment information\n[2] View occupancy information");
			int choice = dataMenuKeyboard .nextInt();
			if (choice == 1) {
				paymentInfoMenu(t);
				break;
			}
			else if (choice == 2) {
				occupancyInfoMenu(t);
				break;
			}
			else System.out.println("This is not a valid choice. Please enter the number of the option you want to choose");
		}
		dataMenuKeyboard.close();
	}

	// Starts a menu to get total payments for a given time
	private void paymentInfoMenu(ArrayList<Ticket> t) {
		System.out.println("Please select an option for viewing payment info:\n[1] By hour\n[2] By day [3] By week [4] By month");
		Scanner pimKeyboard = new Scanner(System.in);
		int choice = pimKeyboard.nextInt();
		switch(choice) {
		
		case 1:

		case 2:
			
		case 3:
			
		case 4:
			
		default:
			
		}
	}
	
	

	// Starts a menu to get total occupancy for a given time
	private void occupancyInfoMenu(ArrayList<Ticket> t) {
		System.out.println("Please select an option for viewing payment info:\n[1] By hour\n[2] By day [3] By week [4] By month");
		Scanner oimKeyboard = new Scanner(System.in);
		int choice = oimKeyboard.nextInt();
		
		switch(choice) {
		case 1:

		case 2:
			
		case 3:
			
		case 4:
			
		default:
			
		}

	}
}
