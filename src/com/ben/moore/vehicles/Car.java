package com.ben.moore.vehicles;

public class Car extends Vehicle {
	
	private int numberOfDoors;
	private String model;
	
	public Car() {
		numberOfDoors = 0;
		model = "";
	}
	
	public Car(int numberOfWheels, String manufacturer, int numberOfDoors, String model) {
		this.setNumberOfWheels(numberOfWheels);
		this.setManufacturer(manufacturer);
		this.setNumberOfDoors(numberOfDoors);
		this.setModel(model);
	}
	
	public int getNumberOfDoors() {
		return numberOfDoors;
	}
	
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

}
