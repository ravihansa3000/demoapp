<%@page import="com.wso2.demoapp.model.Customer"%>
<%@page import="java.util.List"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DemoApp | Customer Details</title>
</head>
<body>	

	<div align="center">
		<h1>Customer Details</h1>		

		<table border="1">			
			<th>Customer ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>

			<c:forEach var="cust" items="${customerList}" varStatus="status">
				<tr>
					<td>${cust.custId}</td>
					<td>${cust.firstName}</td>
					<td>${cust.lastName}</td>					
					<td>${cust.email}</td>
					<td><a href="/customer/view/${cust.custId}">View</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="/customer/delete/${cust.custId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>