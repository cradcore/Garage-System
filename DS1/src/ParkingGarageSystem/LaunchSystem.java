package ParkingGarageSystem;


public class LaunchSystem {


	// Launch GUI's
	public static void main(String[] args) {
		Garage garage = new Garage(50);
		GUI g1 = new GUI(garage);
		GUI g2 = new GUI(garage);
		g1.register(garage);
		g2.register(garage);

		
	
	}

}
