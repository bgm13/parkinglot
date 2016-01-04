package com.ben.moore.parking.lot;

import java.util.concurrent.atomic.AtomicInteger;

import com.ben.moore.exceptions.ParkingLotSafetyException;
import com.ben.moore.utilities.Barrier;
import com.ben.moore.utilities.BarrierType;
import com.ben.moore.utilities.ParkingLotStatus;

public class ParkingLot {

	/**
	 * AtomicInteger is being used as it is thread safe.
	 */
	private static final AtomicInteger currentCapacity = new AtomicInteger();

	private String name;
	private int numberOfEntries;
	private int numberOfExits;
	private static int MAX_CAPACITY;
	private String status = ParkingLotStatus.OPEN.getStatus();

	public ParkingLot(String name, int numberOfEntries, int numberOfExits, int parkingLotCapacity) {
		this.setName(name);
		this.setNumberOfEntries(numberOfEntries);
		this.setNumberOfExits(numberOfExits);
		safetyCheck(numberOfEntries, numberOfExits, parkingLotCapacity);
		MAX_CAPACITY = parkingLotCapacity;
		setCapacity(parkingLotCapacity);
	}

	public int getNumberOfEntries() {
		return numberOfEntries;
	}

	private void setNumberOfEntries(int numberOfEntries) {
		this.numberOfEntries = numberOfEntries;
	}

	public int getNumberOfExits() {
		return numberOfExits;
	}

	private void setNumberOfExits(int numberOfExits) {
		this.numberOfExits = numberOfExits;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return currentCapacity.get();
	}

	private void setCapacity(int capacity) {
		currentCapacity.set(capacity);
	}

	/**
	 * Vehicle exits, make spaces available by incrementing the current capacity
	 * by one.
	 */
	public synchronized void vehicleExit() {
		if (spacesCanBeVacated()) {
			currentCapacity.getAndIncrement();
		}
		setStatus();
	}

	/**
	 * Vehicle enters, reduce available spaces by decrementing the current
	 * capacity by one.
	 */
	public synchronized void vehicleEntry() {
		if (spacesAreAvailable()) {
			currentCapacity.getAndDecrement();
		}
		setStatus();
	}

	/**
	 * Creates the barriers associated with this parking lot.
	 */
	public void powerOnBarriers() {
		generateEntries(this.numberOfEntries);
		generateExits(this.numberOfExits);
	}

	private void generateEntries(int numberOfEntries) {
		for (int i = 0; i < numberOfEntries; i++) {
			new Barrier(this, BarrierType.ENTRY);
		}
	}

	private void generateExits(int numberOfExits) {
		for (int i = 0; i < numberOfExits; i++) {
			new Barrier(this, BarrierType.EXIT);
		}
	}

	/**
	 * Returns the status
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	private void setStatus() {
		boolean spacesAvailable = spacesAreAvailable();
		this.status = spacesAvailable ? ParkingLotStatus.OPEN.getStatus() : ParkingLotStatus.CLOSED.getStatus();
	}

	private void safetyCheck(int numberOfEntries, int numberOfExits, int capacity) {
		if (numberOfEntries < 1 || numberOfExits < 1 || capacity < 1) {
			throw new ParkingLotSafetyException("A parking lot must meet a minimum set of safety requirements.");
		}
	}

	private boolean spacesAreAvailable() {
		boolean spacesAreAvailable = currentCapacity.get() <= MAX_CAPACITY && currentCapacity.get() > 0;
		return spacesAreAvailable;
	}

	private boolean spacesCanBeVacated() {
		boolean spacesCanBeVacated = currentCapacity.get() < MAX_CAPACITY && currentCapacity.get() >= 0;
		return spacesCanBeVacated;
	}

}
