package com.carrentalsystem.dao;

import java.util.List;

import com.carrentalsystem.model.Payment;

public interface PaymentDao {


	public void addPayment(Payment payment);
	public void updatePayment(Payment payment);
	public void deletePayment(Payment payment);
	public Payment getPaymentById(int id);
	public List<Payment> getAllPayments();
	
}
