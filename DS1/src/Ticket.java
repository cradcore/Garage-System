import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Ticket {

	// Class variables
	private String ID;
	private Date startTime;
	private Date endTime;
	SimpleDateFormat sdf;
	
	// Default constructor
	public Ticket() {
		this.ID = createID();
		startTime = new Date();
		endTime = null;
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
	public void closeTicket() {
		endTime = new Date();
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
		return sdf.format(endTime);
	}

}
