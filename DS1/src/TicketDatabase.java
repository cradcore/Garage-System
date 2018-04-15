import java.util.ArrayList;

public class TicketDatabase {
	
	// Class variables
	private ArrayList<Ticket> tickets;
	
	// Default constructor
	public TicketDatabase() {
		tickets = new ArrayList<Ticket>();
	}
	
	// Adds a ticket to the database
	private boolean addTicket(Ticket t) {
		for(int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getID().equals(t.getID()))
				return false;
		}
		tickets.add(t);
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
	public void closeTicket(String ID) {
		if (isTicketOpen(ID)) {
			for(int i = 0; i < tickets.size(); i++) {
				if(tickets.get(i).getID().equals(ID) && tickets.get(i).getEndTime() == null) {
					tickets.get(i).closeTicket();
				}
			}
		}
		else System.out.println("Ticket not open!");
		
	}
	
	// Updates the price of the ticket upon leaving the garage
	public void updateTicketPrice(String ID, double price) {
		for(int i = 0; i < tickets.size(); i++) {
			if(tickets.get(i).getID().equals(ID)) {
				double cost = Math.ceil((tickets.get(i).getEndTime().getTime() - tickets.get(i).getStartTime().getTime()) / (1000 * 60) / 60) * price;
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


}
