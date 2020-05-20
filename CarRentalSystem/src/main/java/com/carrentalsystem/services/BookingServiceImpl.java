package com.carrentalsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.BookingDaoImpl;
import com.carrentalsystem.model.Booking;

@Service
@Component
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingDaoImpl bookingDao;

	@Override
	public boolean addBooking(Booking booking) {
		bookingDao.addBooking(booking);
		return true;
	}

	@Override
	public boolean updateBooking(Booking booking) {
		bookingDao.updateBooking(booking);
		return true;
	}

	@Override
	public boolean deleteBooking(Booking booking) {
		bookingDao.deleteBooking(booking);
		return true;
	}

	@Override
	public Booking getBookingById(int id) {
		return bookingDao.getBookingById(id);
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingDao.getAllBookings();
	}

}
