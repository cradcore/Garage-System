import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Ticket {

	// Class variables
	private String ID;
	private Date startTime;
	private Date endTime;
	
	// Default constructor
	public Ticket() {
		this.ID = createID();
		startTime = new Date();
		endTime = null;
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
	
	// To String
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("E M/d/y - h:m a");
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



}
