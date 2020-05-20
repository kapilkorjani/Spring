package com.carrentalsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carrentalsystem.model.Booking;

@Component
@Repository
@Transactional
public class BookingDaoImpl implements BookingDao{

	@Autowired
	SessionFactory factory;
	
	@Override
	public void addBooking(Booking booking) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(booking);
		session.getTransaction().commit();
		session.close();	
	}

	@Override
	public void updateBooking(Booking booking) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(booking);
		session.getTransaction().commit();
		session.close();	
		
	}

	@Override
	public void deleteBooking(Booking booking) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(booking);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Booking getBookingById(int id) {
		Session session = factory.openSession();
		Booking booking = session.get(Booking.class, id);
		session.close();
		return booking;
	}

	@Override
	public List<Booking> getAllBookings() {
		Session session = factory.openSession();
		String hql = "from Booking";
		List<Booking> bookings = session.createQuery(hql).list();
		session.close();
		return bookings;
	}

}
