package com.carrentalsystem.model;

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
public class Payment {

	@Id
	@GeneratedValue
	private int paymentId;
	@OneToOne(fetch = FetchType.EAGER)
	private Booking booking;
	private int distanceTravelled;
	private int totalAmount;
	@Enumerated(EnumType.STRING)
	private PaymentType type;
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public int getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(int distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

}
