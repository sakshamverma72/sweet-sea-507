package com.masai.DTO;

import java.time.LocalDateTime;

public class BusImpl implements Bus {
	private int busId;
	private String busname;
	private String source;
	private String destination;
	private String busType;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private int totalSeats;

	public BusImpl(int busId, String busname, String source, String destination, String busType, LocalDateTime departureTime,
			LocalDateTime arrivalTime, int totalSeats) {
		this.busId = busId;
		this.busname = busname;
		this.source = source;
		this.destination = destination;
		this.busType = busType;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeats = totalSeats;
	}

	@Override
	public String toString() {
		return "Bus Number = " + busId +" Busname = " + busname + ", Source = " + source + ", Destination = " + destination + ", busType = "
				+ busType + ", Departure Time = " + departureTime + ", Arrival Time = " + arrivalTime + ", Total Available Seats = "
				+ totalSeats + "\n";
	}

	public int getBusId() {
		return busId;
	}
	
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusname() {
		return busname;
	}


	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public String getBusType() {
		return busType;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setBusname(String busname) {
		this.busname = busname;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

}
