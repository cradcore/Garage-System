import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
		Scanner entryKeyboard = new Scanner(System.in);
		if (isGarageFull()) {
			System.out.println("Garage is full. Please try again later");
		}
		else {
			System.out.printf("Garage has availability! Ticket prices are $%.2f per hour\n", garage.getPrice());
			System.out.println("Don't lose your ticket! You must have it to exit the garage");
			
			entryKeyboard.nextLine();
			System.out.println(garage.getTicketDatabase().createTicket());
			System.out.println("Press enter once you have your ticket and the gate will open");
			entryKeyboard.nextLine();
			operateGate();
			System.out.println("Closing in 10 seconds");
			for (int i = 11; i > 0; i--) {
				System.out.print((i - 1) + " ");
				//try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			}
			operateGate();
		}
	}
	
	// Exit gate interface
	private void startExitGate() {
		Scanner exitKeyboard = new Scanner(System.in);
		System.out.println("Thank you for visiting! Please enter your ticket ID and press enter: ");
		String ID = null;
		ID = exitKeyboard.nextLine();
		while(!garage.getTicketDatabase().isTicketOpen(ID)) {
			if(ID.equals("-1"))
				break;
			System.out.println("Ticket ID is not valid. Please try again");
			ID = exitKeyboard.nextLine();
		}
		double amountOwed = 0;
		garage.getTicketDatabase().closeTicket(ID);
		Ticket t = garage.getTicketDatabase().getTicket(ID);
		double minutesStayed = (t.getEndTime().getTime() - t.getStartTime().getTime()) / (1000 * 60);
		amountOwed = Math.ceil(minutesStayed / 60) * garage.getPrice();
		if (amountOwed == 0)
			amountOwed = garage.getPrice();
		System.out.printf("Ticket start time: %s. Ticket end time: %s. Total time stayed: %s minutes\n", t.getEndTimeToString(), t.getStartTimeToString(), minutesStayed);
		System.out.printf("The amount owed is $%.2f\nEnter the amount you are putting in: \n", amountOwed);
		double payment = 0;
		payment = exitKeyboard.nextDouble();
		double changeOwed = 0;
		if (payment > amountOwed)
			changeOwed = payment - amountOwed;
		else {
			while(amountOwed - payment > 0) {
				System.out.printf("That is not enough. Please put in $%.2f more\n", amountOwed - payment);
				payment += exitKeyboard.nextDouble();;
			}
			if (payment > amountOwed)
				changeOwed = payment - amountOwed;
		}
		if (changeOwed > 0) 
			System.out.printf("You put in $%.2f. Your change is $%.2f, please take it from the dispenser and press enter to open the gate\n", payment, changeOwed);
		else System.out.printf("You put in $%.2f. Your change is $%.2f, press enter to open the gate\n", payment, changeOwed);
		exitKeyboard.nextLine();
		exitKeyboard.nextLine();
		System.out.println("Have a nice day!");
		operateGate();
		System.out.println("Closing in 10 seconds");
		for (int i = 11; i > 0; i--) {
			System.out.print((i - 1) + " ");
			//try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		}
		operateGate();	
	}
	
	// Opens gate if it is closed, and closes it if it is open
	private void operateGate() {
		if (state.equals("close")) {
			System.out.println("Gate opening...");
			state = "open";
			System.out.println("Gate opened");
		}
		else {
			System.out.println("Gate closing...");
			state = "close";
			System.out.println("Gate closed");
		}
		
	}

	// Checks to see if garage is full
	private boolean isGarageFull() {
		return garage.isFull();
	}
}











