package com.pizzaorderingsystem.controller;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.pizzaorderingsystem.model.Orders;
import com.pizzaorderingsystem.model.Pizza;
import com.pizzaorderingsystem.model.Topping;
import com.pizzaorderingsystem.model.UserDetails;
import com.pizzaorderingsystem.service.OrderService;
import com.pizzaorderingsystem.service.PizzaService;
import com.pizzaorderingsystem.service.ToppingService;
import com.pizzaorderingsystem.service.UserService;
import com.pizzaorderingsystem.util.PasswordManager;

@Controller
public class OperationController {

	@Autowired
	private UserDetails user;
	@Autowired
	private Orders order;
	@Autowired
	private Pizza pizza;
	@Autowired
	private Topping topping;
	@Autowired
	private UserService userService;
	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private ToppingService toppingService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/register")
	public String registerUser() {
		return "register.jsp";
	}
	
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(HttpServletRequest request,@RequestParam("name") String name, @RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("mobile") String mobile, @RequestParam("address") String address,@RequestParam("type") String type) throws Exception {
		
		ModelAndView mv  = new ModelAndView();
		
		user.setName(name);
		user.setEmail(email);
		user.setAddress(address);
		user.setMobile(mobile);
		user.setPassword(password);
		user.setType(type);
		if(userService.addUser(user))
		{
			request.getSession().setAttribute("user", userService.getUserByName(name));
			request.getSession().setAttribute("username", name);
			mv.setViewName("main.jsp");
		}
		else {
			mv.setViewName("login.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/LogOut")
	public String LogOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session  = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("username");
		session.invalidate();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		return "login.jsp";
		
	}
	
	@RequestMapping("/LoginUser")
	public ModelAndView loginUser(@RequestParam("name") String name, @RequestParam("password") String password,HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(userService.loginUser(name, password)) 
		{
			request.getSession().setAttribute("user", userService.getUserByName(name));
			request.getSession().setAttribute("username", name);
			mv.setViewName("main.jsp");
		}
		else {
			mv.setViewName("login.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/UpdateUser")
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new  ModelAndView();
		user = userService.getUserById(Integer.parseInt(request.getParameter("userId")));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setAddress(request.getParameter("address"));
		user.setMobile(request.getParameter("mobile"));
		user.setPassword(PasswordManager.getEncryptedPassword(request.getParameter("password"), user.getKey()));
		HttpSession session  = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("username");
		mv.setViewName("login.jsp");
		return mv;
	}
	
	@RequestMapping("/SelectPizza")
	public ModelAndView selectPizza() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("pizzas", pizzaService.getAllPizza());
		mv.addObject("toppings",toppingService.getAllToppings());
		mv.setViewName("main.jsp?option=selectPizza");
		return mv;
	}
	@RequestMapping("/PizzaDetails")
	public ModelAndView pizzaDetails() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("pizzas", pizzaService.getAllPizza());
		mv.setViewName("main.jsp?option=pizzaDetails");
		return mv;
		
	}
	@RequestMapping("/AddUpdatePizza")
	public ModelAndView addUpdatePizza(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String option = request.getParameter("option");
		if(option.equals("add")) {
			pizza.setPizzaName(request.getParameter("name"));
			pizza.setpSmall(Integer.parseInt(request.getParameter("psmall")));
			pizza.setpMedium(Integer.parseInt(request.getParameter("pmedium")));
			pizza.setpLarge(Integer.parseInt(request.getParameter("plarge")));
			if(pizzaService.addPizza(pizza)) {
				String msg= "added pizza successfully";
				mv.addObject("msg", msg);
				mv.setViewName("PizzaDetails");
			}
			else {
				String msg= "unable to add pizza";
				mv.addObject("msg", msg);
				mv.setViewName("PizzaDetails");
			}
			
		}
		else if(option.equals("update")){
			pizza = pizzaService.getPizzaById(Integer.parseInt(request.getParameter("pid")));
			pizza.setPizzaName(request.getParameter("name"));
			pizza.setpSmall(Integer.parseInt(request.getParameter("psmall")));
			pizza.setpMedium(Integer.parseInt(request.getParameter("pmedium")));
			pizza.setpLarge(Integer.parseInt(request.getParameter("plarge")));
			if(pizzaService.updatePizza(pizza)) {
				String msg= "updated pizza successfully";
				mv.addObject("msg", msg);
				mv.setViewName("PizzaDetails");
			}
			else {
				String msg= "unable to update pizza";
				mv.addObject("msg", msg);
				mv.setViewName("PizzaDetails");
			}
			
		}
		else if(option.equals("delete")) 
		{
			pizza = pizzaService.getPizzaById(Integer.parseInt(request.getParameter("pid")));
			if(pizzaService.deleteizza(pizza)) {
				String msg= "deleted pizza successfully";
				mv.addObject("msg", msg);
				mv.setViewName("PizzaDetails");
			}
			else {
				String msg= "unable to delete pizza";
				mv.addObject("msg", msg);
				mv.setViewName("PizzaDetails");
			}
		}
		else 
		{
			String msg = "Some error while deleting driver please try again";
			mv.addObject("msg", msg);
			mv.setViewName("PizzaDetails");
		}
		return mv;
	}
	@RequestMapping("ToppingDetails")
	public ModelAndView toppingDetails() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("toppings", toppingService.getAllToppings());
		mv.setViewName("main.jsp?option=toppingDetails");
		return mv;
	}
	@RequestMapping("/AddUpdateTopping")
	public ModelAndView addUpdateTopping(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String option = request.getParameter("option");
		if(option.equals("add")) {
			topping.setName(request.getParameter("tname"));
			topping.setPrice(Integer.parseInt(request.getParameter("tprice")));
			if(toppingService.addTopping(topping)) {
				String msg = "Added topping successfully";
				mv.addObject("msg", msg);
				mv.setViewName("ToppingDetails");
			}
			else
			{
				String msg = "Unable to add topping";
				mv.addObject("msg", msg);
				mv.setViewName("ToppingDetails");
			}
		}
		else if(option.equals("update")){
			topping = toppingService.getToppingById(Integer.parseInt(request.getParameter("tid")));
			topping.setName(request.getParameter("tname"));
			topping.setPrice(Integer.parseInt(request.getParameter("tprice")));
			if(toppingService.updateTopping(topping)) {
				String msg = "Updated topping successfully";
				mv.addObject("msg", msg);
				mv.setViewName("ToppingDetails");
			}
			else
			{
				String msg = "Unable to update topping";
				mv.addObject("msg", msg);
				mv.setViewName("ToppingDetails");
			}

		}
		else if(option.equals("delete")) 
		{
			topping = toppingService.getToppingById(Integer.parseInt(request.getParameter("tid")));
			if(toppingService.deletetopping(topping)) {
				String msg = "Deleted topping successfully";
				mv.addObject("msg", msg);
				mv.setViewName("ToppingDetails");
			}
			else
			{
				String msg = "Unable to delete topping";
				mv.addObject("msg", msg);
				mv.setViewName("ToppingDetails");
			}
		}
		else 
		{
			String msg = "Some error";
			mv.addObject("msg", msg);
			mv.setViewName("ToppingDetails");
		}
		return mv;
	}
	@RequestMapping("/PlaceOrder")
	public ModelAndView placeOrder(HttpServletRequest request, HttpServletResponse response) {
		int totalCost = 0;
		ModelAndView mv = new ModelAndView();
		pizza  = pizzaService.getPizzaById(Integer.parseInt(request.getParameter("pizza")));
		order.setPizza(pizza);
		List<Topping> toppings = new ArrayList<Topping>();
		String[] toppingsId = request.getParameterValues("toppings");
		for(String toppingId : toppingsId) {
			Topping topping = toppingService.getToppingById(Integer.parseInt(toppingId));
			toppings.add(topping);
			totalCost += topping.getPrice();
		}
		order.setToppings(toppings);
		order.setPizzaSize(request.getParameter("size"));
		switch (order.getPizzaSize()) {
			case "small":
				totalCost += order.getPizza().getpSmall();
				break;
			case "medium":
				totalCost += order.getPizza().getpMedium();
				break;
			case "large":
				totalCost += order.getPizza().getpLarge();
				break;
			default:
				totalCost = 0;	
		}
		order.setTotalCost(totalCost);
		HttpSession session = request.getSession();
		order.setCustomer((UserDetails)session.getAttribute("user"));
		order.setStatus("preparing");
		orderService.addOrder(order);
		mv.addObject("order", order);
		mv.addObject("msg", "order Placed successfully. Go to My order to get the status");
		mv.setViewName("main.jsp");
		return mv;
	}
	
	@RequestMapping("/OrderStatus")
	public ModelAndView orderStatus(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv=  new ModelAndView();
		List<Orders> orders = orderService.getAllOrdersByUser((UserDetails)session.getAttribute("user"));
		mv.addObject("orders", orders);
		mv.setViewName("main.jsp?option=orderDetail");
		return mv;
	}
	@RequestMapping("/OrderDetails")
	public ModelAndView orderDetails(HttpServletRequest request, HttpServletResponse  response) {
		ModelAndView mv = new  ModelAndView();
		List<Orders> orders = orderService.getAllOrders();
		mv.addObject("orders", orders);
		mv.setViewName("main.jsp?option=allOrderDetails");
		return mv;
	}
	@RequestMapping("/UpdateOrder")
	public String updateOrder(HttpServletRequest request) {
		order =orderService.getOrderById(Integer.parseInt(request.getParameter("oid")));
		order.setStatus(request.getParameter("status"));
		orderService.updateOrder(order);
		return "OrderDetails";
	}
	
}
