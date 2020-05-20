package com.carrentalsystem.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carrentalsystem.model.Booking;
import com.carrentalsystem.model.Car;
import com.carrentalsystem.model.CarStatus;
import com.carrentalsystem.model.Customer;
import com.carrentalsystem.model.CustomerStatus;
import com.carrentalsystem.model.Payment;
import com.carrentalsystem.model.PaymentStatus;
import com.carrentalsystem.model.User;
import com.carrentalsystem.services.BookingService;
import com.carrentalsystem.services.CarService;
import com.carrentalsystem.services.CustomerService;
import com.carrentalsystem.services.PaymentService;
import com.carrentalsystem.services.PaymentServiceImpl;
import com.carrentalsystem.services.UserService;

@Controller
public class ApplicationController {

	@Autowired
	UserService userService;

	@Autowired
	CustomerService customerService;

	@Autowired
	CarService carService;

	@Autowired
	BookingService bookingService;

	@Autowired
	PaymentServiceImpl paymentService;

	@Autowired
	Payment payment;

	@Autowired
	User user;

	@Autowired
	Customer customer;

	@Autowired
	Car car;

	@Autowired
	Booking booking;

	@RequestMapping("/LoginUser")
	public ModelAndView loginUser(@RequestParam("name") String name, @RequestParam("password") String password,
			HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (userService.loginUser(name, password)) {
			request.getSession().setAttribute("user", userService.getUserByName(name));
			request.getSession().setAttribute("username", name);
			mv.setViewName("main");
		} else {
			mv.setViewName("login");
		}
		return mv;
	}

	@RequestMapping("/LogOut")
	public String LogOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("username");
		session.invalidate();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		return "login";

	}

	@RequestMapping("/")
	public String appliationStart() {
		return "login";
	}

	@RequestMapping("/UpdateUser")
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		user = userService.getUserById(Integer.parseInt(request.getParameter("userId")));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setMobile(request.getParameter("mobile"));
		user.setPassword(request.getParameter("password"));
		// user.setPassword(PasswordManager.getEncryptedPassword(request.getParameter("password"),
		// user.getKey()));
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping("/CustomerDetails")
	public ModelAndView pizzaDetails() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customers", customerService.getAllCustomers());
		mv.addObject("option", "customerDetails");
		mv.setViewName("main");
		return mv;

	}

	@RequestMapping("/AddUpdateCustomer")
	public ModelAndView addUpdateCustomer(@ModelAttribute Customer customer, @RequestParam String option) {
		ModelAndView mv = new ModelAndView();
		System.out.println(customer.getCustomerName());
		if (option.equals("add")) {
			if (customerService.addCustomer(customer)) {
				String msg = "added customer successfully";
				mv.addObject("msg", msg);
			} else {
				String msg = "unable to add customer";
				mv.addObject("msg", msg);
			}

		} else if (option.equals("update")) {
			if (customerService.updateCustomer(customer)) {
				String msg = "updated customer successfully";
				mv.addObject("msg", msg);
			} else {
				String msg = "unable to update customer";
				mv.addObject("msg", msg);
			}

		} else if (option.equals("delete")) {
			if (customerService.deleteCustomer(customer)) {
				String msg = "deleted customer successfully";
				mv.addObject("msg", msg);
			} else {
				String msg = "unable to delete customer";
				mv.addObject("msg", msg);
			}
		} else {
			String msg = "Some error while deleting customer please try again";
			mv.addObject("msg", msg);
		}
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/CarDetails")
	public ModelAndView carDetails() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("cars", carService.getAllCars());
		mv.addObject("option", "carDetails");
		mv.setViewName("main");
		return mv;

	}

	@RequestMapping("/AddUpdateCar")
	public ModelAndView addUpdateCar(@ModelAttribute Car car, @RequestParam String option) {
		ModelAndView mv = new ModelAndView();
		if (option.equals("add")) {
			if (carService.addCar(car)) {
				String msg = "added car successfully";
				mv.addObject("msg", msg);
			} else {
				String msg = "unable to car customer";
				mv.addObject("msg", msg);
			}

		} else if (option.equals("update")) {
			if (carService.updateCar(car)) {
				String msg = "updated car successfully";
				mv.addObject("msg", msg);
			} else {
				String msg = "unable to update car";
				mv.addObject("msg", msg);
			}

		} else if (option.equals("delete")) {
			if (carService.deleteCar(car)) {
				String msg = "deleted car successfully";
				mv.addObject("msg", msg);
			} else {
				String msg = "unable to delete car";
				mv.addObject("msg", msg);
			}
		} else {
			String msg = "Some error while deleting car please try again";
			mv.addObject("msg", msg);
		}
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/BookCar")
	public ModelAndView bookCar() {
		ModelAndView mv = new ModelAndView();
		if (!carService.getAllCars().stream().anyMatch(car -> CarStatus.NOTINUSE.equals(car.getStatus()))) {
			mv.addObject("msg", "We dont have any cars available at present");
		} else {
			mv.addObject("bookingCars", carService.getAllCars().stream()
					.filter(car -> CarStatus.NOTINUSE.equals(car.getStatus())).collect(Collectors.toList()));
			mv.addObject("bookingCustomers",
					customerService.getAllCustomers().stream()
							.filter(customer -> CustomerStatus.UNBLOCKED.equals(customer.getStatus()))
							.collect(Collectors.toList()));
			mv.addObject("option", "book car");
		}
		mv.setViewName("main");
		return mv;

	}

	@RequestMapping("/BookingCar")
	public ModelAndView bookCar(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam("carId") int carId,@RequestParam("customerId") int cId) {
		ModelAndView mv = new ModelAndView();
		LocalDate d1 = LocalDate.parse(fromDate);
				booking.setFromDate(d1);
		LocalDate d2 = LocalDate.parse(toDate);
				booking.setToDate(d2);
		int bookingAmount = Period.between(d1,d2).getDays() * 500;
		booking.setCustomer(customerService.getCustomerById(cId));
		booking.setCar(carService.getCarById(carId));
		booking.setBookingAmount(bookingAmount);
		booking.setAdvanceAmount(bookingAmount);
		if (bookingService.addBooking(booking)) {
			String msg = "car booked successfully";
			mv.addObject("msg", msg);
			customer = booking.getCustomer();
			customer.setStatus(CustomerStatus.BLOCKED);
			customerService.updateCustomer(customer);
			car = booking.getCar();
			car.setStatus(CarStatus.INUSE);
			carService.updateCar(car);
			booking.setCustomer(customer);
			booking.setCar(car);
			payment.setBooking(booking);
			payment.setStatus(PaymentStatus.PENDING);
			paymentService.addPayment(payment);
			mv.addObject("payment", payment);
			mv.addObject("option", "makePayment");
		} else {
			String msg = "unable to book car";
			mv.addObject("msg", msg);
		}
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/BookingPayment")
	public ModelAndView bookingPayment(@RequestParam("paymentId") int paymentId) {
		payment= paymentService.getPaymentById(paymentId);
		ModelAndView mv = new ModelAndView();
		payment.setStatus(PaymentStatus.BOOKED);
		
		if (paymentService.updatePayment(payment)) {
			String msg = "payment done successfully";
			mv.addObject("msg", msg);
		} else {
			String msg = "unable to do the payment";
			mv.addObject("msg", msg);
		}
		mv.setViewName("main");
		
		return mv;
	}

	@RequestMapping("/GetPayments")
	public ModelAndView getpayments() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("payments", paymentService.getAllPayments().stream()
				.filter(p -> PaymentStatus.BOOKED.equals(p.getStatus())).collect(Collectors.toList()));
		mv.addObject("option", "select payment");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/ReturnCar")
	public ModelAndView returncar(@RequestParam("paymentId") int id ,@RequestParam("distance") int distance) {
		ModelAndView mv = new ModelAndView();
		payment= paymentService.getPaymentById(id);
		payment.setDistanceTravelled(distance);
		int totalAmount = payment.getBooking().getAdvanceAmount()
				+ payment.getDistanceTravelled() * payment.getBooking().getCar().getChargePerKm();
		payment.setTotalAmount(totalAmount);
		paymentService.updatePayment(payment);
		mv.addObject("option", "makeReturnPayment");
		mv.addObject("amount", totalAmount - payment.getBooking().getAdvanceAmount());
		mv.addObject("payment",payment);
		mv.setViewName("main");
		return mv;

	}

	@RequestMapping("/ReturningCar")
	public ModelAndView returningCar(@RequestParam("paymentId") int id) {
		ModelAndView mv = new ModelAndView();
		payment = paymentService.getPaymentById(id);
		payment.setStatus(PaymentStatus.RETURNED);
		if(paymentService.updatePayment(payment)) {
			customer = payment.getBooking().getCustomer();
			customer.setStatus(CustomerStatus.UNBLOCKED);
			customerService.updateCustomer(customer);
			car = payment.getBooking().getCar();
			car.setStatus(CarStatus.NOTINUSE);
			carService.updateCar(car);
			String msg = "payment done successfully";
			mv.addObject("msg", msg);
		} else {
			String msg = "unable to do the payment";
			mv.addObject("msg", msg);
		}
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("BookedCars")
	public ModelAndView getBookingDetails() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("payments", paymentService.getAllPayments().stream().filter(p->PaymentStatus.BOOKED.equals(p.getStatus())).collect(Collectors.toList()));
		mv.addObject("option", "bookingDetails");
		mv.setViewName("main");
		return mv;
	}
}
