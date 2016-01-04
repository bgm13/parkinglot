package com.ben.moore.utilities;

import com.ben.moore.parking.lot.ParkingLot;

public class Barrier extends Thread {

	private ParkingLot parkingLot;
	private String barrierType;
	private static int THREAD_NUMERATIONS;

	public Barrier(ParkingLot parkingLot, BarrierType barrierType) {
		super();
		this.parkingLot = parkingLot;
		this.barrierType = barrierType.getBarrierType();
		THREAD_NUMERATIONS = this.parkingLot.getCapacity() * 2;
		System.out.println(this.barrierType + " Barrier: " + this.getName() + " created in parking lot: "
				+ this.parkingLot.getName());
		this.start();
	}

	/**
	 * Interacts with the Parking Lot, by first checking the barrier type.
	 */
	public void run() {
		try {
			if (this.barrierType.equals(BarrierType.ENTRY.getBarrierType())) {
				System.out.println("Entry Barrier " + this.getName() + " opening.");
				for (int i = 0; i < THREAD_NUMERATIONS; i++) {
					this.parkingLot.vehicleEntry();
					System.out.println("Vehicle has entered via " + this.getName() + ", capacity: "
							+ this.parkingLot.getCapacity());
					System.out.println("Parking Lot Status: " + this.parkingLot.getStatus());
					Thread.sleep(1000);
				}
			} else if (this.barrierType.equals(BarrierType.EXIT.getBarrierType())) {
				System.out.println("Exit Barrier " + this.getName() + " opening.");
				for (int i = 0; i < THREAD_NUMERATIONS; i++) {
					this.parkingLot.vehicleExit();
					System.out.println("Vehicle has exited via " + this.getName() + ", capacity: "
							+ this.parkingLot.getCapacity());
					System.out.println("Parking Lot Status: " + this.parkingLot.getStatus());
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			System.out.println("The following thread was interrupted: " + this.getName());
		}
		System.out.println(this.getName() + " has stopped.");
	}

}
