package com.ben.moore.parking.lot;

import java.util.ArrayList;
import java.util.List;

import com.ben.moore.vehicles.Car;

public class ParkingLotSimulation {
	
	private static int QUEUE_SIZE = 40;

	public static void main(String[] args) {
		List<Car> queue = new ArrayList<Car>();
		for (int i = 0; i < QUEUE_SIZE; i++) {
			Car c = new Car();
			queue.add(c);
		}
		// Constant Parking Lot demand determines Parking Lot size
		int parkingLotDemand = queue.size() / 2;
		ParkingLot parkingLotSim = new ParkingLot("Parking Lot Simulation", 4, 2, parkingLotDemand);
		// Starts the barrier threads
		parkingLotSim.powerOnBarriers();
	}

}
