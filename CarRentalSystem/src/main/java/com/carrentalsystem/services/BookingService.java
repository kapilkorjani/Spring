package com.carrentalsystem.services;

import java.util.List;

import com.carrentalsystem.model.Booking;

public interface BookingService {

	public boolean addBooking(Booking booking);
	public boolean updateBooking(Booking booking);
	public boolean deleteBooking(Booking booking);
	public Booking getBookingById(int id);
	public List<Booking> getAllBookings();
	
}
