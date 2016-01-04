package com.ben.moore.parking.lot.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ben.moore.exceptions.ParkingLotSafetyException;
import com.ben.moore.parking.lot.ParkingLot;

public class ParkingLotUnitTest {
	
	@Test(expected = ParkingLotSafetyException.class)
	public void testParkingLotMinimumRequirements() {
		new ParkingLot("testParkingLotMinimumRequirements", 0, 0, 0);
		fail();
	}
	
	@Test(expected = ParkingLotSafetyException.class)
	public void testParkingLotNegativeScenario() {
		new ParkingLot("testParkingLotNegativeScenario", -1, -1, -1);
		fail();
	}
	
	@Test
	public void testCapacityIsSet() {
		ParkingLot parkingLot = new ParkingLot("testCapacityIsSet", 1, 1, 1);
		assertEquals(parkingLot.getCapacity(), 1);
	}
	
	@Test
	public void testEntryAndExitSimulation() {
		ParkingLot pl = new ParkingLot("testEntryAndExitSimulation", 1, 1, 10);
		pl.vehicleEntry();
		pl.vehicleEntry();
		pl.vehicleEntry();
		assertEquals(pl.getCapacity(), 7);
		pl.vehicleExit();
		pl.vehicleExit();
		assertEquals(pl.getCapacity(), 9);
	}
	
	@Test
	public void testParkingLotStatus() {
		ParkingLot pl = new ParkingLot("testParkingLotStatus", 2, 2, 1);
		assertEquals(pl.getStatus(), "Open");
		assertEquals(pl.getCapacity(), 1);
		pl.vehicleEntry();
		assertEquals(pl.getCapacity(), 0);
		assertEquals(pl.getStatus(), "Closed");
		pl.vehicleExit();
		assertEquals(pl.getCapacity(), 1);
		assertEquals(pl.getStatus(), "Open");		
	}

}
