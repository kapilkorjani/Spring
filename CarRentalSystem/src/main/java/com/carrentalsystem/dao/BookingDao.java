package com.carrentalsystem.dao;

import java.util.List;

import com.carrentalsystem.model.Booking;

public interface BookingDao {

	public void addBooking(Booking booking);
	public void updateBooking(Booking booking);
	public void deleteBooking(Booking booking);
	public Booking getBookingById(int id);
	public List<Booking> getAllBookings();
	
}
