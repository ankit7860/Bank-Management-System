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
<body
	background="/BaseCodeSlice_BankManagementSystem/pages/Images/A.jpg">
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
<body class="main"
	background="/BaseCodeSlice_BankManagementSystem/pages/Images/A.jpg">

	<div class="container">
		<div style="color: red;">
			<h3>
				<table>
					<tr>
						<c:set var="message" value="${message}" />
						<c:if test="${message != null}">
							<p>

								<c:out value="${message}" />
							<p>
						</c:if>

					</tr>
					<tr>
						<c:set var="warning" value="${warning}" />
						<c:if test="${warning != null}">
							<p>

								<c:out value="${warning}" />
							<p>
						</c:if>

					</tr>
				</table>
			</h3>
		</div>



		<form class="form-horizontal form1" name="myform"
			onsubmit="return ValidateMyForm()"
			action="/BaseCodeSlice_BankManagementSystem/performtransaction"
			method="post">
			<div class="form-group row">
				<h1 style="margin-bottom: 1cm" align="center">Enter Your
					details</h1>
				<label class="control-label col-sm-4" for="accountNumber">Account
					Number*:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="accountNumber"
						value="<%=request.getParameter("accountNumber") != null ? request.getParameter("accountNumber") : ""%>"
						maxlength="16" name="accountNumber"
						placeholder="Enter Account Number" required>
					<div class="danger" style="color: red">${errors.accountNumber}
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-sm-4" for="customerName">Customer
					Name*:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="customerName"
						name="customerName" placeholder="Enter Customer Name"
						value="<%=request.getParameter("customerName") != null ? request.getParameter("customerName") : ""%>"
						required>
					<div class="danger" style="color: red">${errors.customerName}
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-sm-4" for="transactionType">Transaction
					Type*:</label>
				<div class="col-sm-6">
					<select
						class="selectpicker show-menu-arrow form-control custom-select"
						" id="transactionType" name="transactionType"
						value="<%=request.getParameter("transactionType") != null ? request.getParameter("transactionType") : ""%>"
						required>
						<div style="color: red">${errors.transactionType}</div>
						<option selected>Select</option>
						<option>Deposit</option>
						<option>Withdrawal</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-sm-4" for="transactionAmount">Transaction
					Amount*:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="transactionAmount"
						name="transactionAmount" placeholder="Enter Transaction Amount"
						value="<%=request.getParameter("transactionAmount") != null ? request.getParameter("transactionAmount") : ""%>"
						maxlength="15" required>
					<div class="danger" style="color: red">${errors.transactionAmount}
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-sm-4" for="description">Description::</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="description"
						name="description" placeholder="Enter Description:" required>
				</div>
			</div>
			<div class="col-sm-offset-0 col-sm-4" align="right">
				<p class="text-danger">* fields are mandatory.</p>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-0 col-md-2">
					<button type="submit" class="btn btn-primary">Submit</button>
					<button type="reset" class="btn" name="reset" value="reset">reset</button>
				</div>
				<div class="col-sm-offset-0 col-sm-4">
					<a
						href="/BaseCodeSlice_BankManagementSystem/jsp/viewTransaction.jsp"><button
							type="button" class="btn btn-primary">View Transaction
							Details</button> </a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>

