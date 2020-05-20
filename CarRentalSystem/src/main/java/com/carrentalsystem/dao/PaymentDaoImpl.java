package com.carrentalsystem.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.model.Payment;

@Component
@Repository
@Transactional
public class PaymentDaoImpl implements PaymentDao{

	@Autowired
	SessionFactory factory;
	
	@Override
	public void addPayment(Payment payment) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(payment);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updatePayment(Payment payment) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(payment);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deletePayment(Payment payment) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(payment);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Payment getPaymentById(int id) {
		Session session = factory.openSession();
		Payment payment = session.get(Payment.class, id);
		session.close();
		return payment;
	}

	@Override
	public List<Payment> getAllPayments() {
		Session session = factory.openSession();
		String hql = "from Payment";
		@SuppressWarnings("unchecked")
		List<Payment> payments = session.createQuery(hql).list();
		session.close();
		return payments;
	}

	
}
