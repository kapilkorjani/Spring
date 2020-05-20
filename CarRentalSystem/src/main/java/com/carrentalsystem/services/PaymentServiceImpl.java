package com.carrentalsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.PaymentDaoImpl;
import com.carrentalsystem.model.Payment;

@Service
@Component
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentDaoImpl paymentDao;
	@Override
	public boolean addPayment(Payment payment) {
		paymentDao.addPayment(payment);
		return true;
	}

	@Override
	public boolean updatePayment(Payment payment) {
		paymentDao.updatePayment(payment);
		return true;
	}

	@Override
	public boolean deletePayment(Payment payment) {
		paymentDao.deletePayment(payment);
		return true;
	}

	@Override
	public Payment getPaymentById(int id) {
		return paymentDao.getPaymentById(id);
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentDao.getAllPayments();
	}

	
}
