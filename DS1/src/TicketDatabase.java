import java.util.ArrayList;

public class TicketDatabase {
	
	// Class variables
	ArrayList<Ticket> tickets;
	
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

}
