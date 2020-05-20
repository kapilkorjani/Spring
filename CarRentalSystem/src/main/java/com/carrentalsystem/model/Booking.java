package com.carrentalsystem.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Booking {

	@Id @GeneratedValue
	private int bookingId;
	@OneToOne(fetch = FetchType.EAGER)
	private Car car;
	@OneToOne(fetch = FetchType.EAGER)
	private Customer customer;
	private LocalDate fromDate;
	private LocalDate toDate;
	private int bookingDays;
	private int bookingAmount;
	private int advanceAmount;
	@Enumerated(EnumType.STRING)
	private BookingStatus status;
	
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public int getBookingDays() {
		return bookingDays;
	}
	public void setBookingDays(int bookingDays) {
		this.bookingDays = bookingDays;
	}
	public int getBookingAmount() {
		return bookingAmount;
	}
	public void setBookingAmount(int bookingAmount) {
		this.bookingAmount = bookingAmount;
	}
	public int getAdvanceAmount() {
		return advanceAmount;
	}
	public void setAdvanceAmount(int advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	
	
}
