package com.ben.moore.vehicles;

public class Vehicle {
	
	private int numberOfWheels;
	private String manufacturer;
	
	public Vehicle() {
		numberOfWheels = 0;
		manufacturer = "";
	}
	
	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
