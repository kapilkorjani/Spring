
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Pizza Ordering System</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
<c:if test="${username == null && user == null}">
<c:redirect url="login.jsp"></c:redirect>
</c:if>	
<!-- Page Wrapper -->
  <div id="wrapper">
  	<!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
       

      

      <!-- Nav Item - Dashboard -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Hi ${username}</span>
        </a>
        <div id="collapseOne" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">  </h6>
            <a class="collapse-item" href="main.jsp?option=updateDetails"> Update Details </a>
            <a class="collapse-item" href="LogOut"> LogOut </a>
          </div>
        </div>
      </li>
      
      <c:if test="${user.type == 'Admin'}">
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Orders</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"> Options: </h6>
            <a class="collapse-item" href="OrderDetails">Orders Details</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Pizza</span>
        </a>
        <div id="collapseThree" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"> Options: </h6>
            <a class="collapse-item" href="PizzaDetails">Pizza Details</a>
            <a class="collapse-item" href="ToppingDetails">Topping Details</a>
            
          </div>
        </div>
      </li>
      </c:if>
      <c:if test="${user.type == 'Customer' }">
      	<li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Orders</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"> Options: </h6>
            <a class="collapse-item" href="SelectPizza">Place Order</a>
            <a class="collapse-item" href="OrderStatus">My Orders</a>
          </div>
        </div>
      </li>
      
      </c:if>
    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
	<c:out value="${msg}"></c:out>
      <!-- Main Content -->
    <div id="content">
    <c:if test="${param.option == 'updateDetails' }">
    	<form action="UpdateUser" method="post">
					<table>
					<c:if test="${username != 'admin' }">
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" id="username" value="${user.name}"></td>
					</tr>
					</c:if>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" id="password"}></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email" id="pass" value="${user.email}"></td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td><input type="hidden" name="userId" value="${user.userId}"/><input type="number" name="mobile" id="mobile" value="${user.mobile}"/></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address" id="address" value="${user.address}"/></td>
					</tr>
					<tr>
					<td rowspan="2">
					<input type="submit" value="Update Details">
					</td>
					</tr>
					</table>
					</form>
    
    </c:if>	
   	<c:if test="${param.option == 'selectPizza' }">
   	<div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Place Order</h6>
               </div>
               <div class="card-body">
   	<table border ="1">
   	<tr><th colspan="4" align ="center">Prize Chart</th></tr>
   	<tr>
   		<th>Name</th>
   		<th>Small</th>
   		<th>Medium</th>
   		<th>Large</th>
   	</tr>
   		<c:forEach items="${pizzas}" var="pizza">
   	<tr>
   		<td><c:out value="${pizza.pizzaName}"></c:out></td>
   		<td><c:out value="${pizza.pSmall}"></c:out></td>
   		<td><c:out value="${pizza.pMedium}"></c:out></td>
   		<td><c:out value="${pizza.pLarge}"></c:out></td>
   	</tr>
   		</c:forEach>
   	</table>
   	<form action="PlaceOrder" method="post">
   	<table>
		  <tr>
		    <th>Pizza Name</th>
		    <td><select name="pizza"><c:forEach items="${pizzas}" var="pizza"><option value="${pizza.pizzaId}"><c:out value="${pizza.pizzaName}"></c:out></option></c:forEach></select></td>
		  </tr>
		  <tr>
		  	<th>Size</th>
		  	<td><select name="size"><option value="small">Small</option><option value="medium">Medium</option><option value="large">Large</option></select></td>
		  </tr>
		  <tr>
		  	<th>Toppings</th>
		  	<td>
		  	<c:forEach items="${toppings}"  var="topping">
		  		<input type="checkbox" name="toppings" value="${topping.toppingId}"/> <c:out value="${topping.name}"></c:out><br/>
		  	</c:forEach>
		  	</td>
		  </tr>
		  <tr>
		  <td><input type="submit" name="order" value="Order Pizza"></td>
		  </tr>
		</table>
   	</form>
   	</div>
    </div>
   	</c:if>
    <c:if test="${param.option == 'pizzaDetails' }">
    <div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Pizza Details</h6>
               </div>
               <div class="card-body">
               
                <table>
                 <tr>
                 	<th>Pizza Name</th>
                 	<th>Small Price</th>
                 	<th>Medium Price</th>
                 	<th>Large Price</th>
                 	<th>Option</th>
               	</tr>
               	<tr>
               	 <form method= "post" action="AddUpdatePizza">
               		<td><input type = "text" name="name" ></td>
               		<td><input type ="number" name="psmall"></td>
               		<td><input type ="number" name="pmedium"></td>
               		<td><input type ="number" name="plarge"></td>
               		<td><input type="submit" name="option" value="add"></td>
               	</form>
               	</tr>
               	<c:if test="${not empty requestScope.pizzas }">
           		<c:forEach var ="pizza" items="${requestScope.pizzas}">
               	<tr>
                <form method= "post" action="AddUpdatePizza">
               		<td><input type="hidden" value="${pizza.pizzaId}" name="pid"><input type="text" name="name" value = "${pizza.pizzaName}"></td>
               		<td><input type="number" name="psmall" value = "${pizza.pSmall}"></td>
               		<td><input type="number" name="pmedium" value = "${pizza.pMedium}"></td>
               		<td><input type="number" name="plarge" value = "${pizza.pLarge}"></td>
               		<td><input type = "submit" value = "update" name ="option"></td>
               		<td><input type="submit" value="delete" name="option"></td>
               	</form>
               	</tr>
               	</c:forEach>
               	</c:if>
               	</table> 
               </div>
    </div>
    </c:if>
    <c:if test="${param.option == 'toppingDetails' }">
    <div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Topping Details</h6>
               </div>
               <div class="card-body">
               
                <table>
                 <tr>
                 	<th>Topping Name</th>
                 	<th>Price</th>
                 	<th>Option</th>
               	</tr>
               	<tr>
               	 <form method= "post" action="AddUpdateTopping">
               		<td><input type = "text" name="tname" ></td>
               		<td><input type ="number" name="tprice"></td>
               		<td><input type="submit" name="option" value="add"></td>
               	</form>
               	</tr>
               	<c:if test="${not empty requestScope.toppings }">
           		<c:forEach var ="topping" items="${requestScope.toppings}">
               	<tr>
                <form method= "post" action="AddUpdateTopping">
               		<td><input type="hidden" value="${topping.toppingId}" name="tid"><input type="text" name="tname" value = "${topping.name}"></td>
               		<td><input type="number" name="tprice" value = "${topping.price}"></td>
               		<td><input type = "submit" value = "update" name ="option"></td>
               		<td><input type="submit" value="delete" name="option"></td>
               	</form>
               	</tr>
               	</c:forEach>
               	</c:if>
               	</table> 
               </div>
    </div>
    </c:if>
    <c:if test="${param.option == 'orderDetail' }">
    <div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Order Details</h6>
               </div>
               <div class="card-body">
               
    
    <table border="1" align="center">
    <tr>
    	<th>Order Id</th>
    	<th>PizzaName</th>
    	<th>Size</th>
    	<th>Toppings</th>
    	<th>Total Amount </th>
    	<th>Status</th>
    </tr>
    	<c:forEach items="${orders}" var="order">
    <tr>
    	<td><c:out value="${ order.orderId}"></c:out></td>
    	<td><c:out value="${ order.pizza.pizzaName}"></c:out></td>
    	<td><c:out value="${ order.pizzaSize}"></c:out></td>
    	<td><c:forEach items="${order.toppings}" var="topping"><c:out value="${topping.name}"></c:out><br/></c:forEach></td>
    	<td><c:out value="${order.totalCost}"></c:out></td>
    	<td><c:out value="${order.status}"></c:out></td>
    </tr>
    	</c:forEach>
    </table>
    </div>
    </div>
    </c:if>
    <c:if test="${param.option == 'allOrderDetails' }">
    <div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Order Details</h6>
               </div>
               <div class="card-body">
               
   
      <table border="1" align="center">
    <tr>
    	<th>Order Id</th>
    	<th>PizzaName</th>
    	<th>Size</th>
    	<th>Toppings</th>
    	<th>Total Amount </th>
    	<th>Current Status</th>
    	<th>Status</th>
   		<th>Option</th>
    </tr>
    	<c:forEach items="${orders}" var="order">
    	<tr>
     	<form action="UpdateOrder" method="post">
    	<td><c:out value="${ order.orderId}"></c:out></td>
    	<td><c:out value="${ order.pizza.pizzaName}"></c:out></td>
    	<td><c:out value="${ order.pizzaSize}"></c:out></td>
    	<td><c:forEach items="${order.toppings}" var="topping"><c:out value="${topping.name}"></c:out><br/></c:forEach></td>
    	<td><c:out value="${order.totalCost}"></c:out></td>
    	<td><c:out value="${order.status}"></c:out></td>
    	<td><select name="status"><option>prepare</option><option>bake</option><option>cut</option><option>box</option></select></td>
    	<td><input type="hidden" name="oid" value="${order.orderId}"><input type="submit"></td>
   		</form>
    	</tr>
    </c:forEach>
    </table>    </div>
    </div>
    </c:if>
    </div>
    </div>
    </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/chart-area-demo.js"></script>
  <script src="js/demo/chart-pie-demo.js"></script>


</body>
</html>