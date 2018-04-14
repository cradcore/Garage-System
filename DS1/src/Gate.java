import java.util.Scanner;

public class Gate {
	
	// Class variables
	private String gateType;
	private Garage garage;
	private String state;
	
	
	// Constructor
	public Gate(String gateType, Garage garage) {
		this.gateType = gateType;
		this.garage = garage;
		this.state = "close";
	}
	
	// Starts the gate interface
	public void startGate() {
		if (gateType.equals("entry"))
			startEntryGate();
		else startExitGate();
	}
	
	// Entry gate interface
	private void startEntryGate() {
		if (isGarageFull()) {
			System.out.println("Garage is full. Please try again later");
		}
		else {
			System.out.printf("Garage has availability! Ticket prices are $%.2f per hour\n", garage.getPrice());
			System.out.println("Press enter to receive your ticket. Lost tickets charge for a 12 hour stay, so don't lose it!");
			Scanner keyboard = new Scanner(System.in);
			keyboard.nextLine();
			System.out.println(garage.getTicketDatabase().createTicket());
			System.out.println("Press enter once you have your ticket and the gate will open");
			keyboard.nextLine();
			System.out.println("Gate opening...\nGate opened. Closing in 10 seconds");
			operateGate();
			for (int i = 11; i > 0; i--) {
				System.out.print((i - 1) + " ");
				try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			}
			System.out.println("\nGate closing...");
			operateGate();
			System.out.println("Gate closed");
		    keyboard.close();
		}
		
	}
	
	// Exit gate interface
	private void startExitGate() {
		System.out.println("Thank you for ");
	}
	
	// Opens gate if it is closed, and closes it if it is open
	private void operateGate() {
		if (state.equals("close"))
			state = "open";
		else state = "close";
		
	}

	// Checks to see if garage is full
	private boolean isGarageFull() {
		return garage.isFull();
	}
}











