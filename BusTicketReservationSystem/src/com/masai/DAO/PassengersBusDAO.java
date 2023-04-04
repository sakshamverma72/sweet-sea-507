package com.masai.DAO;

import java.util.List;

import com.masai.DTO.Bus;
import com.masai.DTO.Customer;
import com.masai.Exception.ExceptionInPassengers;

public interface PassengersBusDAO {
	public void addPassengers(Customer customer) throws ExceptionInPassengers;
	public boolean loginPassengers(Customer customer) throws ExceptionInPassengers;
	public List<Bus> showAvailableBuse() throws ExceptionInPassengers;
	public void bookTicketByBussNumber(int busId) throws ExceptionInPassengers;
	public List<Bus> bookingHistory() throws ExceptionInPassengers;
	public void deleteAccount(String oldPassword)throws ExceptionInPassengers;
}
