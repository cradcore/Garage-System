import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TicketDatabase {
	
	// Class variables
	private ArrayList<Ticket> tickets;
	private String file;
	
	// Default constructor
	public TicketDatabase() {
		tickets = new ArrayList<Ticket>();
		file = "ticketDatabaseInfo.txt";
		readDataFromFile(file);
	}
	
	private void readDataFromFile(String fileName) {
		try {
			Scanner inFile = new Scanner(new File(fileName));
			while(inFile.hasNextLine()) {
				String line = inFile.nextLine();
				String[] l = line.split(",");
				DateFormat f = new SimpleDateFormat("E M/d/y - hh:mm a");
				if(l[2].length() == 0)
					tickets.add(new Ticket(l[0], f.parse(l[1]), "", Double.parseDouble(l[3])));
				else
					tickets.add(new Ticket(l[0], f.parse(l[1]), f.parse(l[2]), Double.parseDouble(l[3])));
			}
			
		} 
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (NumberFormatException e) {e.printStackTrace();} 
		catch (ParseException e) {e.printStackTrace();}
		
	}
	
	private void writeDataToFile(String fileName) {
		try {
			FileWriter fw = new FileWriter(new File(fileName));
			for(int i = 0; i < tickets.size(); i++) {
				Ticket t = tickets.get(i);
				fw.write(t.getID() + "," + t.getStartTimeToString() + "," + t.getEndTimeToString() + "," + t.getPrice() + "\n");
			}
			fw.close();
		} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	// Adds a ticket to the database
	private boolean addTicket(Ticket t) {
		for(int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getID().equals(t.getID()))
				return false;
		}
		tickets.add(t);
		writeDataToFile(file);
		return true;
	}
	
	// Creates ticket, adds it to the database and returns it
	public Ticket createTicket() {
		Ticket t = new Ticket();
		for(;;) {
			if (addTicket(t))
				break;
		}
		return t;
	}

	// Returns the number of open tickets in the database
	public int getNumOpenTickets() {
		int ret = 0;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getEndTime() == null)
				ret++;
		}
		return ret;
	}
	
	// Returns true if the ticket ID is in the database and open
	public boolean isTicketOpen(String ID) {
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getID().equals(ID) && tickets.get(i).getEndTime() == null)
				return true;
		}
		return false;
	}
	
	// Adds the current time to the end time of the specified ticket and updates cost
	public void closeTicket(String ID, double cost) {
		if (isTicketOpen(ID)) {
			for(int i = 0; i < tickets.size(); i++) {
				if(tickets.get(i).getID().equals(ID) && tickets.get(i).getEndTime() == null) {
					tickets.get(i).closeTicket(cost);
				}
			}
		}
		else System.out.println("Ticket not open!");
		writeDataToFile(file);
		
	}
	
	// Updates the price of the ticket upon leaving the garage
	public void updateTicketPrice(String ID, double price) {
		for(int i = 0; i < tickets.size(); i++) {
			if(tickets.get(i).getID().equals(ID)) {
				Date d = new Date();
				double cost = Math.ceil((d.getTime() - tickets.get(i).getStartTime().getTime()) / (1000 * 60) / 60) * price;
				if(cost == 0)
					cost = price;
				tickets.get(i).updateCost(cost);
			}
		}
		
	}
	
	// Returns the ticket object given the ticket ID
	public Ticket getTicket(String ID) {
		for(int i = 0; i < tickets.size(); i++) {
			if(tickets.get(i).getID().equals(ID))
				return tickets.get(i);
		}
		return null;
	}

	// Tickets getter
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

}
