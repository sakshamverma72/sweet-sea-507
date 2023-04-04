package com.masai.DTO;

import java.time.LocalDateTime;

public interface Bus {
	public int getBusId();
	
	public void setBusId(int busId);


	public String getBusname();

	public String getSource();

	public String getDestination();

	public String getBusType();

	public LocalDateTime getDepartureTime();

	public LocalDateTime getArrivalTime();

	public int getTotalSeats();

	public void setSource(String source);

	public void setDestination(String destination);

	public void setBusType(String busType);

	public void setDepartureTime(LocalDateTime departureTime);

	public void setArrivalTime(LocalDateTime arrivalTime);

	public void setTotalSeats(int totalSeats);

}
