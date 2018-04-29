package Tests;

import javax.swing.JFrame;
import org.junit.*;

import ParkingGarageSystem.GUI;
import ParkingGarageSystem.Garage;

import static org.junit.Assert.*;


public class GUITest {

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GUITest.class);
	}
	
	@Test
	public void testGUI_1()
		throws Exception {
		Garage garage = new Garage(1);
		GUI result = new GUI(garage);
		assertNotNull(result);
	}

	@Test
	public void testRegister_1()
		throws Exception {
		GUI fixture = new GUI(new Garage(1));
		fixture.frmParkingGarageGui = new JFrame();
		Garage garage = new Garage(1);
		fixture.register(garage);
	}
}