package com.masai.DAO;

import java.time.LocalDate;

import com.masai.DTO.Bus;
import com.masai.Exception.ExceptionInBus;

public interface BusDAO {
public void addBus(Bus bus) throws ExceptionInBus;
public void updateBus(Bus bus, int busId) throws ExceptionInBus;
public void deleteBus(int busId) throws ExceptionInBus;
public int viewBookingsForADateRange(LocalDate startingDate, LocalDate endingDate) throws ExceptionInBus;
public int viewBookingsByBusName(String busName) throws ExceptionInBus;
}
