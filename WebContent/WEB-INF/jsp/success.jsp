<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

</head>


<body background="Images/A.jpg">




	<div>
		<p align="center" style="color: red">

			<tr>
				<td>your output is</td>
				<td><c:out value="${message}" /></td>

			</tr>
		</p>
		<br />
	</div>
</head>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/BaseCodeSlice_BankManagementSystem/pages/custom.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>






<body class="main">

	<div class="container">

		<h1 style="margin-top: 2cm" align="center">Enter Your details</h1>
		<br> <br>

		<div>
			<p align="center" style="color: red">
<h2>
				<tr>
					<c:set var="msg" value="${message}" />
					<c:if test="${msg != null}">
						<p>

							<c:out value="${msg}" />
						<p>
					</c:if>

				</tr>
	</h2>
			</p>
		</div>



		<form class="form-horizontal form1" action="performtransaction"
			method="post">
			<div class="form-group row">
				<label class="control-label col-sm-4" for="accountNumber">Account
					Number*:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="accountNumber"
						name="accountNumber" placeholder="Enter Account Number" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-sm-4" for="transactionId">Transaction
					Id*:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="transactionId"
						name="transactionId" placeholder="Enter Transaction Id" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-sm-4" for="customerName">Customer
					Name*:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="customerName"
						name="customerName" placeholder="Enter Customer Name" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-sm-4" for="transactionType">Transaction
					Type*:</label>
				<div class="col-sm-6">
					<select
						class="selectpicker show-menu-arrow form-control custom-select"
						" id="transactionType" name="transactionType" required>
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
						required>
				</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-sm-4" for="description">Description:</label>
				<div class="col-sm-6">
					<td><textarea class="form-group" id="description"
							name="description" style="margin-left: 2px; width: 535px;"
							placeholder="Enter Description"></textarea></td>
				</div>
			</div>
			<div class="form-group ">
				<div class="col-sm-offset-2 col-sm-6">
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
					</div>
				</div>
			</div>
			<div class="col-sm-offset-0 col-sm-4" align="right">
				<p class="text-danger">* fields are mandatory.</p>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Submit</button>
					<button type="reset" class="btn" name="reset" value="reset">reset</button>
				</div>
			</div>

		</form>
	</div>
</body>
</html>

