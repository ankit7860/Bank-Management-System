<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Your Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1 align="center">Your Transaction details are:</h1>

	<%-- <c:forEach var="item" items="${details}">
		<c:out value="${item.customerName}" />
	</c:forEach> --%>
	<%-- <c:if test="${not empty details}"> --%>
		<table>
			<c:forEach var="listValue" items="${details}">
				<%--<li>${listValue.description}</li>--%>
			<div class="container">
		
				<table class="table table-striped">
						<h2 align="center">********************************</h2>
					<thead>
						<tr>
							<th>Detail Name</th>
							<th>Details</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Transaction Type :</td>
							<td>${listValue.transactionType}</td>
						</tr>
						<tr>
							<td>Transaction Id :</td>
							<td>${listValue.transactionId}</td>
						</tr>
						<tr>
							<td>Account Balance :</td>
							<td>${listValue.accountBalance}</td>
						</tr>
						<tr>
							<td>Account Number :</td>
							<td>${listValue.accountNumber}</td>
						</tr>
						<%-- <tr>
							<td>Description :</td>
							<td>${listValue.description}</td>
						</tr> --%>
						</c:forEach>
							<%-- </c:if> --%>
					</tbody>
				</table>
			</div>
</body>
</html>
 