package com.carrentalsystem.services;

import java.util.List;

import com.carrentalsystem.model.Payment;

public interface PaymentService {

	public boolean addPayment(Payment payment);
	public boolean updatePayment(Payment payment);
	public boolean deletePayment(Payment payment);
	public Payment getPaymentById(int id);
	public List<Payment> getAllPayments();
	
}
