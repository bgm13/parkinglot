package com.ben.moore.utilities;

public enum ParkingLotStatus {
	OPEN("Open"), CLOSED("Closed");
	
	private String status;

	private ParkingLotStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public String toString() {
		return this.status;
	}

}
