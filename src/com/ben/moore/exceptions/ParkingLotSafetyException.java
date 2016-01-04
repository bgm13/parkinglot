package com.ben.moore.exceptions;

@SuppressWarnings("serial")
public class ParkingLotSafetyException extends RuntimeException {
	
	public ParkingLotSafetyException(){
        super();
    }

    public ParkingLotSafetyException(String message){
        super(message);
    }
}
