
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

  <title>Car Rental Service</title>

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
      <c:if test="${user.type == 'admin'}">
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
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Customers</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"> Options: </h6>
            <a class="collapse-item" href="CustomerDetails">Customer Details</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Car</span>
        </a>
        <div id="collapseThree" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"> Options: </h6>
            <a class="collapse-item" href="CarDetails">Car Details</a>
          </div>
        </div>
      </li>
      	<li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Booking</span>
        </a>
        <div id="collapseFour" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"> Options: </h6>
            <a class="collapse-item" href="BookCar">Book Car</a>
            <a class="collapse-item" href="GetPayments">Return Car</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Booking Details</span>
        </a>
        <div id="collapseFive" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"> Options: </h6>
            <a class="collapse-item" href="BookedCars">Booked Cars</a>
          </div>
        </div>
      </li>
    </ul>
      </c:if>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
	<c:out value="${msg}"></c:out>
      <!-- Main Content -->
    <div id="content">
    <c:if test="${param.option == 'updateDetails' }">
    	<form action="UpdateUser" method="post">
					<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" id="username" value="${user.name}"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" id="password"></td>
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
					<td rowspan="2">
					<input type="submit" value="Update Details">
					</td>
					</tr>
					</table>
					</form>
    
    </c:if>
    <c:if test="${option == 'customerDetails' }">
    <div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Customer Details</h6>
               </div>
               <div class="card-body">
               
                <table>
                 <tr>
                 	<th>Name</th>
                 	<th>Address</th>
                 	<th>Email</th>
                 	<th>Mobile</th>
                 	<th>Status</th>
                 	<th>Option</th>
               	</tr>
               	<tr>
               	 <form method= "post" action="AddUpdateCustomer">
               		<td><input type = "text" name="customerName" ></td>
               		<td><input type ="text" name="address"></td>
               		<td><input type ="email" name="email"></td>
               		<td><input type ="text" name="mobile"></td>
               		<td><select id="status" name="status"><option value="BLOCKED">BLOCKED</option><option value="UNBLOCKED">UNBLOCKED</option></select></td>
               		<td><input type="submit" name="option" value="add"></td>
               	</form>
               	</tr>
               	<c:if test="${not empty requestScope.customers }">
           		<c:forEach var ="customer" items="${requestScope.customers}">
               	<tr>
                <form method= "post" action="AddUpdateCustomer">
               		<td><input type="hidden" value="${customer.customerId}" name="customerId"><input type = "text" name="customerName" value = "${customer.customerName}"></td>
               		<td><input type ="text" name="address" value = "${customer.address}"></td>
               		<td><input type ="email" name="email" value = "${customer.email}"></td>
               		<td><input type ="text" name="mobile" value = "${customer.mobile}"></td>
               		<c:if test="${customer.status == 'BLOCKED'}">
               		<td><select id="status" name="status"><option value="BLOCKED" selected="selected">BLOCKED</option><option value="UNBLOCKED">UNBLOCKED</option></select></td>
               		</c:if>
               		<c:if test="${customer.status == 'UNBLOCKED'}">
               		<td><select id="status" name="status"><option value="BLOCKED">BLOCKED</option><option value="UNBLOCKED" selected="selected">UNBLOCKED</option></select></td>
               		</c:if>
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
    <c:if test="${option == 'carDetails' }">
    <div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Customer Details</h6>
               </div>
               <div class="card-body">
               
                <table>
                 <tr>
                 	<th>Name</th>
                 	<th>Charge per KM</th>
                 	<th>Type</th>
                 	<th>Status</th>
                 	<th>Option</th>
               	</tr>
               	<tr>
               	 <form method= "post" action="AddUpdateCar">
               		<td><input type = "text" name="cName" ></td>
               		<td><input type ="text" name="chargePerKm"></td>
               		<td><select id="type" name="type">
               		<option value="SUV">SUV</option>
               		<option value="HATCHBACK">HATCHBACK</option>
               		<option value="SEDAN">SEDAN</option>
               		<option value="EV">EV</option>
               		<option value="HATCHBACK_AC">HATCHBACK_AC</option>
               		<option value="SEDAN_AC">SEDAN_AC</option>
               		</select></td>
               		<td><select id="status" name="status"><option value="INUSE">INUSE</option><option value="NOTINUSE">NOTINUSE</option></select></td>
               		<td><input type="submit" name="option" value="add"></td>
               	</form>
               	</tr>
               	<c:if test="${not empty requestScope.cars }">
           		<c:forEach var ="car" items="${requestScope.cars}">
               	<tr>
                <form method= "post" action="AddUpdateCar">
               		<td><input type="hidden" value="${car.cId}" name="cId"><input type = "text" name="cName" value = "${car.cName}"></td>
               		<td><input type ="text" name="chargePerKm" value = "${car.chargePerKm}"></td>
               		<td><select id="type" name="type">
               		<c:choose>
               			<c:when test="${car.type == 'SUV' }"><option value="SUV" selected="selected">SUV</option></c:when>
               			<c:otherwise><option value="SUV">SUV</option> </c:otherwise>
               		</c:choose>
               		<c:choose>
               			<c:when test="${car.type == 'HATCHBACK' }"><option value="HATCHBACK" selected="selected">HATCHBACK</option></c:when>
               			<c:otherwise><option value="HATCHBACK">HATCHBACK</option> </c:otherwise>
               		</c:choose>
               		<c:choose>
               			<c:when test="${car.type == 'SEDAN' }"><option value="SEDAN" selected="selected">SEDAN</option></c:when>
               			<c:otherwise><option value="SEDAN">SEDAN</option> </c:otherwise>
               		</c:choose>
               		<c:choose>
               			<c:when test="${car.type == 'EV' }"><option value="EV" selected="selected">EV</option></c:when>
               			<c:otherwise><option value="EV">EV</option> </c:otherwise>
               		</c:choose>
               		<c:choose>
               			<c:when test="${car.type == 'HATCHBACK_AC' }"><option value="HATCHBACK_AC" selected="selected">HATCHBACK_AC</option></c:when>
               			<c:otherwise><option value="EV">HATCHBACK_AC</option> </c:otherwise>
               		</c:choose>
               		<c:choose>
               			<c:when test="${car.type == 'SEDAN_AC' }"><option value="SEDAN_AC" selected="selected">SEDAN_AC</option></c:when>
               			<c:otherwise><option value="EV">EV</option> </c:otherwise>
               		</c:choose>
               		</select></td>
               		<c:if test="${car.status == 'INUSE'}">
               		<td><select id="status" name="status"><option value="INUSE" selected="selected">INUSE</option><option value="NOTINUSE">NOTINUSE</option></select></td>
               		</c:if>
               		<c:if test="${car.status == 'NOTINUSE'}">
               		<td><select id="status" name="status"><option value="INUSE">INUSE</option><option value="NOTINUSE" selected="selected">NOTINUSE</option></select></td>
               		</c:if>
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
    <c:if test="${option == 'book car' }">
    <div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Book Car</h6>
                 <h6>The cars are booked with a daily charge of 500/- and each car has its own cost per KM which will be calculated when the car is returned on the basis of distance travelled  </h6>
               </div>
               <div class="card-body">
               <form method= "post" action="BookingCar">
                <table>
                 <tr>
                 	<th>Select Car</th>
                 	<td><select id ="carId" name="carId">
                 	<c:forEach var ="car" items="${bookingCars}">
                 	<option value="${car.cId}"><c:set var="optionCar" value="${car.cName} - ${car.type} (Rs${car.chargePerKm}/km"></c:set><c:out value="${optionCar}"></c:out></option>
                 	</c:forEach>
                 	</select></td>
               	</tr>
               	<tr>
                 	<th>Select customer</th>
                 	<td><select id ="customerId" name="customerId">
                 	<c:forEach var ="customer" items="${bookingCustomers}">
                 	<option value="${customer.customerId}"><c:set var="optionCustomer" value="${customer.customerName} - ${customer.mobile}"></c:set><c:out value="${optionCustomer}"></c:out></option>
                 	</c:forEach>
                 	</select></td>
               	</tr>
               	<tr>
               		<th>From Date</th>
               		<td><input type="date" id="fromDate" name="fromDate"></td>
               	</tr>
               	<tr>
               		<th>To Date</th>
               		<td><input type="date" id="toDate" name="toDate"></td>
               	</tr>
               	<tr>
               		<td colspan="2"><input type="submit" value= "book" name="book_car" id="book_car"></td>
               	</tr>
               	</table> 
               	</form>
               </div>
    </div>
    </c:if>
    <c:if test="${option == 'makePayment' }">
    <div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Payment Page</h6>
               </div>
               <div class="card-body">
               <form method= "post" action="BookingPayment">
                <table>
                <tr>
                	<th>Amount</th>
                	<td><input type="hidden" value="${payment.paymentId}" id="paymentId" name="paymentId"><c:out value="${payment.booking.advanceAmount}"></c:out></td>
                </tr>
                <tr>
                	<th>Payment Status</th>
                	<td><c:out value="${payment.status}"></c:out></td>
                </tr>
                <tr>
                	<th>Payment Type</th>
                	<td><select id="type" name="type">
                	<option value="CARD">CARD</option>
                	<option value="CASH">CASH</option>
                	<option value="UPI">UPI</option>
                	</select></td>
                </tr>
               	<tr>
               		<td colspan="2"><input type="submit" value= "pay" name="pay_book" id="book_car"></td>
               	</tr>
               	</table> 
               	</form>
               </div>
    </div>
    </c:if>
    <c:if test="${option == 'select payment' }">
    <div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Select Boooking</h6>
               </div>
               <div class="card-body">
               <form method= "post" action="ReturnCar">
                <table>
                 <tr>
                 	<th>Booking ID</th>
                 	<th>Customer Name</th>
                 	<th>Car Name</th>
                 	<th>Distance travelled</th>
                 	<th>option</th>
               	</tr>
               	<c:forEach var="payment" items="${payments}">
               	<tr>
               		<form action="ReturnCar" method="post">
                 	<td><input type="hidden" value="${payment.paymentId}" name="paymentId" id="paymentId"><c:out value="${payment.booking.bookingId}"></c:out></td>
                 	<td><c:out value="${payment.booking.customer.customerName}"></c:out></td>
                 	<td><c:out value="${payment.booking.car.cName}"></c:out></td>
                 	<td><input type="text" id="distance" name="distance"></td>
               		<td colspan="2"><input type="submit" value= "Return" name="return_car" id="return_car"></td>
               		</form>
               	</tr>
                 </c:forEach>
               	</table> 
               	</form>
               </div>
    </div>
    </c:if>
    <c:if test="${option == 'makeReturnPayment' }">
    <div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Payment Page</h6>
               </div>
               <div class="card-body">
               <form method= "post" action="ReturningCar">
                <table>
                <tr>
                	<th>Amount</th>
                	<td><input type="hidden" value="${payment.paymentId}" id="paymentId" name="paymentId"><c:out value="${amount}"></c:out></td>
                </tr>
                <tr>
                	<th>Payment Status</th>
                	<td><c:out value="${payment.status}"></c:out></td>
                </tr>
                <tr>
                	<th>Payment Type</th>
                	<td><select id="type" name="type">
                	<option value="CARD">CARD</option>
                	<option value="CASH">CASH</option>
                	<option value="UPI">UPI</option>
                	</select></td>
                </tr>
               	<tr>
               		<td colspan="2"><input type="submit" value= "pay" name="pay_return" id="return_car"></td>
               	</tr>
               	</table> 
               	</form>
               </div>
    </div>
    </c:if>
        <c:if test="${option == 'bookingDetails' }">
    <div class="card shadow mb-4">
               <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">Booking Details</h6>
               </div>
               <div class="card-body">
               <form method= "post" action="ReturningCar">
                <table border="1">
                <tr>
                	<th>Booking Id</th>
                	<th>Car Name</th>
                	<th>Customer Name</th>
                	<th>Booked Till</th>
                	<th>Advance Paid</th>
                </tr>
                <c:forEach var="payment" items="${payments}">
                <tr>
                	<td><c:out value="${payment.booking.bookingId}"></c:out></td>
                	<td><c:out value="${payment.booking.car.cName}"></c:out></td>
                	<td><c:out value="${payment.booking.customer.customerName}"></c:out></td>
                	<td><c:out value="${payment.booking.toDate}"></c:out></td>
                	<td><c:out value="${payment.booking.advanceAmount}"></c:out></td>
                </c:forEach>
               	</table> 
               	</form>
               </div>
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