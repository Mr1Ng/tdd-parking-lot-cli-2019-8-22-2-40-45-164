package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
    	if(parkingLot.getAvailableParkingPosition() == 0) {
    		this.lastErrorMessage = "The parking lot is full.";
    		return null;
    	}
    	this.lastErrorMessage = null;
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingLot.parkCar(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket ticket) {
    	if(ticket == null) {
    		this.lastErrorMessage = "Please provide your parking ticket.";
    		return null;
    	}
    	Car car = parkingLot.getCarByTicket(ticket);
    	if(car == null) {
    		this.lastErrorMessage = "Unrecognized parking ticket.";
    		return null;
    	}
        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}