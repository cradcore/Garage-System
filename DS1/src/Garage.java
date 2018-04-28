
public class Garage {

	// Class variables
	private int numParkingSpots;
	private int numVehicles;
	private double ticketPrice;
	private TicketDatabase ticketDatabase;
	private AdminConsole ac;
	
	// Default constructor
	public Garage(int numParkingSpots) {
		this(numParkingSpots, 1.0);
	}
	
	// Constructor if you want to set a hourly price
	public Garage(int numParkingSpots, double ticketPrice) {
		this.numParkingSpots = numParkingSpots;
		this.ticketPrice = ticketPrice;
		this.numVehicles = 0;
		this.ticketDatabase = new TicketDatabase();
		this.ac = new AdminConsole(this);
	}
	
	
	// Checks to see if the garage is full, returns boolean
	public boolean isFull() {
		return numParkingSpots >= ticketDatabase.getNumOpenTickets();
	}
	
	// Returns the current ticket price (per hour)
	public double getPrice() {
		return ticketPrice;
	}
	
	// Updates spots available
	public void updateSpots(int spots) {
		numParkingSpots = spots;
	}
	
	// Updates the price per hour
	public void updatePrice(double price) {
		ticketPrice = price;
	}
	
	// Returns ticket database
	public TicketDatabase getTicketDatabase() {
		return ticketDatabase;
	}
	
	// Returns capacity of garage
	public int getCapacity() {
		return numParkingSpots;
	}
	
	// Returns ac
	public AdminConsole getAdminConsole() {
		return ac;
	}
}
