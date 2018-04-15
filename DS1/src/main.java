// Corey Craddock
// CS 414


public class main {
	
	public static void main(String[] args) {
		Garage garage = new Garage(50);
		Gate entryGate = new Gate("entry", garage);
		Gate exitGate = new Gate("exit", garage);
		for (int i = 1; i < 50; i++) {
			garage.addVehicle();
		}
		entryGate.startGate();
		System.out.println("\n\n\n");
		exitGate.startGate();
		entryGate.startGate();
	}

}
