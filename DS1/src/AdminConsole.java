import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

// Interface for the admin console

public class AdminConsole {

	// Class variables
	private Garage garage;
	private ArrayList<Ticket> tickets;

	public AdminConsole(Garage garage) {
		this.garage = garage;
		this.tickets = garage.getTicketDatabase().getTickets();
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
		System.out.println("Please select an option for viewing payment info:\n[1] By hour\n[2] By day\n[3] By month");
		Scanner pimKeyboard = new Scanner(System.in);
		int choice = pimKeyboard.nextInt();
		switch(choice) {

		case 1:
			hourMenu("payment");
			break;
		case 2:
			dayMenu("payment");
			break;
		case 3:
			monthMenu("payment");
			break;
		default:
			System.out.println("Not a valid option. Please try again");
		}
	}

	// Starts a menu to get total occupancy for a given time
	private void occupancyInfoMenu(ArrayList<Ticket> t) {
		System.out.println("Please select an option for viewing payment info:\n[1] By hour\n[2] By day\n[3] By month");
		Scanner oimKeyboard = new Scanner(System.in);
		int choice = oimKeyboard.nextInt();

		switch(choice) {
		case 1:
			hourMenu("occupancy");
			break;
		case 2:
			dayMenu("occupancy");
			break;
		case 3:
			monthMenu("occupancy");
			break;
		default:
			System.out.println("Not a valid option. Please try again");
		}

	}

	// Hour menu
	private void hourMenu(String type) {
		boolean payment;
		if (type.equals("payment"))
			payment = true;
		else payment = false;
		System.out.println("Enter the hour you wold like " + type + " info on. NOTE: You must enter the date in the exact format listed below\nFormat: mm/dd/yyyy hh a\nExample: 4/15/2018 12PM");
		Scanner hmKB = new Scanner(System.in);
		String d = hmKB.nextLine();
		DateFormat f = new SimpleDateFormat("M/d/y hha");
		Date date = null;
		try {date = f.parse(d);} catch (ParseException e) {System.out.println("Date entered incorrectly. Please try again");e.printStackTrace();}
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		System.out.println();

		// Print payment info
		if (payment) {
			double pay = 0;
			for(int i = 0; i < tickets.size(); i++) {
				Date tdEnd = tickets.get(i).getEndTime();
				Calendar tcEnd = GregorianCalendar.getInstance();
				if (tdEnd != null)
					tcEnd.setTime(tdEnd);
				else continue;
				if (c.get(Calendar.MONTH) == tcEnd.get(Calendar.MONTH) && c.get(Calendar.DATE) == tcEnd.get(Calendar.DATE) && c.get(Calendar.HOUR) == tcEnd.get(Calendar.HOUR)) 
					pay += tickets.get(i).getPrice();
			}
			System.out.printf("Total payments for specified hour: $%.2f", pay);
		}
		
		// Print occupancy info
		else {
			int occNum = 0;
			int endOccNum = 0;
			for(int i = 0; i < tickets.size(); i++) {
				Date td = tickets.get(i).getStartTime();
				Calendar tc = GregorianCalendar.getInstance();
				Date tdEnd = tickets.get(i).getEndTime();
				Calendar tcEnd = GregorianCalendar.getInstance();
				tc.setTime(td);
				if (tdEnd != null)
					tcEnd.setTime(tdEnd);
				if (c.get(Calendar.MONTH) == tc.get(Calendar.MONTH) && c.get(Calendar.DATE) == tc.get(Calendar.DATE) && c.get(Calendar.HOUR) == tc.get(Calendar.HOUR)) 
					occNum++;
				if (c.get(Calendar.MONTH) == tcEnd.get(Calendar.MONTH) && c.get(Calendar.DATE) == tcEnd.get(Calendar.DATE) && c.get(Calendar.HOUR) == tcEnd.get(Calendar.HOUR)) 
					endOccNum++;
			}
			System.out.println("Total number of tickets started: " + occNum + " tickets\nTotal number of tickets closed: " + endOccNum + " tickets");
		}
	}

	// Day menu
	private void dayMenu(String type) {
		boolean payment;
		if (type.equals("payment"))
			payment = true;
		else payment = false;
		System.out.println("Enter the day you wold like " + type + " info on. NOTE: You must enter the date in the exact format listed below\nFormat: mm/dd/yyyy\nExample: 4/15/2018");
		Scanner hmKB = new Scanner(System.in);
		String d = hmKB.nextLine();
		DateFormat f = new SimpleDateFormat("M/d/y");
		Date date = null;
		try {date = f.parse(d);} catch (ParseException e) {System.out.println("Date entered incorrectly. Please try again");e.printStackTrace();}
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		System.out.println();

		// Print payment info
		if (payment) {
			double pay = 0;
			for(int i = 0; i < tickets.size(); i++) {
				Date tdEnd = tickets.get(i).getEndTime();
				Calendar tcEnd = GregorianCalendar.getInstance();
				if (tdEnd != null)
					tcEnd.setTime(tdEnd);
				else continue;
				if (c.get(Calendar.MONTH) == tcEnd.get(Calendar.MONTH) && c.get(Calendar.DATE) == tcEnd.get(Calendar.DATE)) 
					pay += tickets.get(i).getPrice();
			}
			System.out.printf("Total payments for specified day: $%.2f", pay);
		}
		
		// Print occupancy info
		else {
			int occNum = 0;
			int endOccNum = 0;
			for(int i = 0; i < tickets.size(); i++) {
				Date td = tickets.get(i).getStartTime();
				Calendar tc = GregorianCalendar.getInstance();
				Date tdEnd = tickets.get(i).getEndTime();
				Calendar tcEnd = GregorianCalendar.getInstance();
				tc.setTime(td);
				if (tdEnd != null)
					tcEnd.setTime(tdEnd);
				if (c.get(Calendar.MONTH) == tc.get(Calendar.MONTH) && c.get(Calendar.DATE) == tc.get(Calendar.DATE)) 
					occNum++;
				if (c.get(Calendar.MONTH) == tcEnd.get(Calendar.MONTH) && c.get(Calendar.DATE) == tcEnd.get(Calendar.DATE)) 
					endOccNum++;
			}
			System.out.println("Total number of tickets started: " + occNum + " tickets\nTotal number of tickets closed: " + endOccNum + " tickets");
		}
	}

	// Month menu
	private void monthMenu(String type) {
		boolean payment;
		if (type.equals("payment"))
			payment = true;
		else payment = false;
		System.out.println("Enter the month you wold like " + type + " info on. NOTE: You must enter the date in the exact format listed below\nFormat: mm/yyyy\nExample: 4/2018");
		Scanner hmKB = new Scanner(System.in);
		String d = hmKB.nextLine();
		DateFormat f = new SimpleDateFormat("M/y");
		Date date = null;
		try {date = f.parse(d);} catch (ParseException e) {System.out.println("Date entered incorrectly. Please try again");e.printStackTrace();}
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		System.out.println();

		// Print payment info
		if (payment) {
			double pay = 0;
			for(int i = 0; i < tickets.size(); i++) {
				Date tdEnd = tickets.get(i).getEndTime();
				Calendar tcEnd = GregorianCalendar.getInstance();
				if (tdEnd != null)
					tcEnd.setTime(tdEnd);
				else continue;
				if (c.get(Calendar.MONTH) == tcEnd.get(Calendar.MONTH)) 
					pay += tickets.get(i).getPrice();
			}
			System.out.printf("Total payments for specified month: $%.2f", pay);
		}
		
		// Print occupancy info
		else {
			int occNum = 0;
			int endOccNum = 0;
			for(int i = 0; i < tickets.size(); i++) {
				Date td = tickets.get(i).getStartTime();
				Calendar tc = GregorianCalendar.getInstance();
				Date tdEnd = tickets.get(i).getEndTime();
				Calendar tcEnd = GregorianCalendar.getInstance();
				tc.setTime(td);
				if (tdEnd != null)
					tcEnd.setTime(tdEnd);
				if (c.get(Calendar.MONTH) == tc.get(Calendar.MONTH)) 
					occNum++;
				if (c.get(Calendar.MONTH) == tcEnd.get(Calendar.MONTH)) 
					endOccNum++;
			}
			System.out.println("Total number of tickets started: " + occNum + " tickets\nTotal number of tickets closed: " + endOccNum + " tickets");
		}
	}







}
