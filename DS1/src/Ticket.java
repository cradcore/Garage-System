import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Ticket {

	// Class variables
	private String ID;
	private Date startTime;
	private Date endTime;
	private double cost;
	private SimpleDateFormat sdf;
	
	// Default constructor
	public Ticket() {
		this.ID = createID();
		startTime = new Date();
		endTime = null;
		cost = 0;
		sdf = new SimpleDateFormat("E M/d/y - hh:mm a");
	}
	
	// Constructor for specifying ID, startTime, endTime, and cost
	public Ticket(String ID, Date startTime, Date endTime, double cost) {
		this.ID = ID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cost = cost;
		sdf = new SimpleDateFormat("E M/d/y - hh:mm a");
	}
	
	// Constructor when endTime is not set yet
	public Ticket(String ID, Date startTime, String endTime, double cost) {
		this.ID = ID;
		this.startTime = startTime;
		this.endTime = null;
		this.cost = cost;
		sdf = new SimpleDateFormat("E M/d/y - hh:mm a");
	}
	
	// Returns an 6 digit ID with random numbers
	private String createID() {
		String id = "";
		for (int i = 0; i < 6; i++) {
			Random random = new Random();
			id += Integer.toString(random.nextInt(10));
		}
		return id;
	}
	
	// Adds the current time to endTime
	public void closeTicket(double cost) {
		endTime = new Date();
		this.cost = cost;
	}
	
	public void closeTicketCalculateCost(double costPerHour) {
		endTime = new Date();
		double minutesStayed = timeStayed();
		cost = Math.ceil(minutesStayed / 60) * costPerHour;
		if (cost == 0)
			cost = costPerHour;
	}
	
	public double timeStayed() {
		if(endTime == null)
			return -1;
		else return ((getEndTime().getTime() - getStartTime().getTime()) / (1000 * 60));
	}
	
	// Updates the total cost of the ticket upon exiting garage
	public void updateCost(double cost) {
		this.cost = cost;
	}
	
	// To String
	public String toString() {
		if (endTime == null)
			return "ID: " + ID + "\nStart time: " + sdf.format(startTime);
		else 
			return "ID: " + ID + "\nStart time: " + sdf.format(startTime) + "\nEnd time: " + sdf.format(endTime);
	}

	// Ticket ID getter
	public String getID() {
		return ID;
	}
	
	// Ticket start time getter
	public Date getStartTime() {
		return startTime;
	}
	
	// Ticket end time getter
	public Date getEndTime() {
		return endTime;
	}

	// Returns start time in String format
	public String getStartTimeToString() {
		return sdf.format(startTime);
	}
	
	// Returns end time in String format
	public String getEndTimeToString() {
		if (endTime == null)
			return "";
		return sdf.format(endTime);
	}
	
	// Returns the price if closed, 0 if still open
	public double getPrice() {
		return cost;
	}

}
