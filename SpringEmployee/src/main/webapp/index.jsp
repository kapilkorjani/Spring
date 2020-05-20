<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head><title>Employee Service</title></head>
<body>

	<table>
		<tr>
			<th>Employee Name</th>
			<th>Salary</th>
			<th>Designation</th>
			<th colspan="2">Operation</th>
		</tr>
		<tr>
		<form action="addEmployee" method="post">
			<td><input type="text" name="ename">
			<td><input type="text" name="salary"></td>
			<td><input type="text" name="designation"></td>
			<td><input type="submit" name="add"></td>
		</form> 
		</tr>
		<c:forEach items="${requestScope.employees}" var="employee">
		<tr>
		<form action="updateDeleteEmployee" method="post">
			<td><input type="text" name="ename" value="${employee.name}"></td>
			<td><input type="text" name="salary" value="${employee.salary}"></td>
			<td><input type="text" name="designation" value="${employee.designation}"></td>
			<td><input type="hidden" name="id" value="${employee.empId}"><input type="submit" name="option" value="update"></td> 
			<td><input type="submit" name="option" value="delete"></td>
		</form>  
		</tr>
		</c:forEach>
	
	
	</table>





</body>
</html>
