<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfrom Transaction</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

</head>
<div>
	<%@ include file="/WEB-INF/static/html/Header.html"%>
</div>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/BaseCodeSlice_BankManagementSystem/pages/custom.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="/BaseCodeSlice_BankManagementSystem/pages/js/performTransactionValidations.js"></script>
</head>
<body background="/BaseCodeSlice_BankManagementSystem/pages/Images/A.jpg">
	<table class="table table-striped" border="4" cellpadding="5"
		width="85%" height="100">
		<caption><h1 align="center">Your Transaction details are:</h1></caption>

		<tr>
			<th>Account Number</th>
			<th>Account Holder Name</th>
			<th>Transaction Type</th>
			<th>Transaction Id</th>
			<th>Transaction Amount</th>
			<th>Account Balance</th>
		</tr>
		<c:forEach var="listValue" items="${transactionDetails}">
			<tr>
				<td>${listValue.accountNumber}</td>
				<td>${listValue.userVO.accountHolderName}</td>
				<td>${listValue.transactionType}</td>
				<td>${listValue.transactionId}</td>
				<td>${listValue.transactionAmount}</td>
				<td>${listValue.userVO.accountBalance}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a
			href="/BaseCodeSlice_BankManagementSystem/jsp/performTransaction.jsp">
			<button type="button" style="font-size: 1cm" class="btn btn-primary btn-sm btn-block">
				Make Another Transaction</button>
		</a>
	</div>
	<div>
		<a
			href="/BaseCodeSlice_BankManagementSystem/jsp/viewTransaction.jsp">
			<button type="button" style="font-size: 1cm" class="btn btn-default btn-sm btn-block glyphicon glyphicon-search">
				View Your Transactions</button>
		</a>
	</div>
</body>
</html>