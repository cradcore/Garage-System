// Corey Craddock
// CS 414


public class main {
	
	public static void main(String[] args) {
		Garage garage = new Garage(50);
		Gate entryGate = new Gate("entry", garage);
		Gate exitGate = new Gate("exit", garage);
		entryGate.startGate();
		
	
	}

}
