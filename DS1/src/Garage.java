
public class Garage {

	// Class variables
	private int numParkingSpots;
	private int numVehicles;
	private double ticketPrice;
	private TicketDatabase ticketDatabase;
	
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
	}
	
	
	// Checks to see if the garage is full, returns boolean
	public boolean isFull() {
		return numParkingSpots == numVehicles;
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
}
