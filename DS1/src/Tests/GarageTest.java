package Tests;

import org.junit.*;

import ParkingGarageSystem.AdminConsole;
import ParkingGarageSystem.Garage;

import static org.junit.Assert.*;


public class GarageTest {

	
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GarageTest.class);
	}


	@Test
	public void testGarage_1()
		throws Exception {
		int numParkingSpots = 50;
		Garage result = new Garage(numParkingSpots);
		assertNotNull(result);
		assertEquals(false, result.isFull());
		assertEquals(1.0, result.getPrice(), 1.0);
		assertEquals(50, result.getCapacity());
	}
	
	@Test
	public void testGarage_2()
		throws Exception {
		int numParkingSpots = 50;
		double ticketPrice = 1.0;
		Garage result = new Garage(numParkingSpots, ticketPrice);
		assertNotNull(result);
		assertEquals(false, result.isFull());
		assertEquals(1.0, result.getPrice(), 1.0);
		assertEquals(50, result.getCapacity());
	}

	@Test
	public void testGetAdminConsole_1()
		throws Exception {
		Garage fixture = new Garage(50, 1.0);
		AdminConsole result = fixture.getAdminConsole();
		assertNotNull(result);
		assertEquals(false, result.isGarageFull());
		assertEquals(34, result.getOccupancy());
	}

	@Test
	public void testGetCapacity_1()
		throws Exception {
		Garage fixture = new Garage(1, 1.0);
		int result = fixture.getCapacity();
		assertEquals(1, result);
	}

	@Test
	public void testGetPrice_1()
		throws Exception {
		Garage fixture = new Garage(1, 1.0);
		double result = fixture.getPrice();
		assertEquals(1.0, result, 0.1);
	}

	@Test
	public void testIsFull_1()
		throws Exception {
		Garage fixture = new Garage(50, 1.0);
		boolean result = fixture.isFull();
		assertEquals(false, result);
	}

	@Test
	public void testIsFull_2()
		throws Exception {
		Garage fixture = new Garage(50, 1.0);
		boolean result = fixture.isFull();
		assertEquals(false, result);
	}

	@Test
	public void testUpdatePrice_1()
		throws Exception {
		Garage fixture = new Garage(1, 1.0);
		double price = 1.0;
		fixture.updatePrice(price);

		
	}
}