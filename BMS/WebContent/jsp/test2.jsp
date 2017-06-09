<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<link
	href="/BaseCodeSlice_BankManagementSystem/static/lib/bootstrap/css/custom.css"
	rel="stylesheet" />


<script
	src="/BaseCodeSlice_BankManagementSystem/static/lib/bootstrap/js/custom.js"></script>
</head>
<body>

	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="#" style="font-size: 17px;">Do Transactions</a> <a href="#"
			style="font-size: 17px;">View Transactions</a>
	</div>
	<div id="main">
		<span onclick="openNav()" class="openNav">&#9776;</span>
		<div class="container">
			<div class="row">
				<div class="col-sm-offset-2 col-sm-8">
					<form class="form-horizontal" action="hello" onsubmit=""
						method="POST">
						<br>
						<div class="form-group">
							<label class="control-label col-sm-5" for="account number">
								Customer Name: </label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="customerName"
									placeholder="Enter Customer Name" name="customerName">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-5" for="account number">
								Account Number: </label>
							<div class="col-sm-5">
								<input type="text"
									value="<%=request.getParameter("accountNumber") != null ? request.getParameter("accountNumber") : ""%>"
									class="form-control" id="accountNumber"
									placeholder="Enter Account Number" name="accountNumber">
								<p style="color: red;">
									<c:out value="${errors}" />
								</p>
								<div class="danger">${errors.accountNumber}</div>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5" for="sel1">Transaction
								Type:</label>
							<div class="col-sm-5">
								<select id="transactionType" name="transactionType">
									<option>Select</option>
									<option>Withdrawl</option>

									<option>Deposit</option>

								</select>
							</div>
						</div>
						<br />
						<div class="form-group">
							<label class="control-label col-sm-5" for="tid">
								Transaction Amount: </label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="transactionAmount"
									placeholder="Enter Transaction Amount" name="transactionAmount">
							</div>
						</div>

						<div class="form-group">
							<label for="description" class="control-label col-sm-5">Description:</label>
							<div class="col-sm-5">
								<textarea class="form-control" rows="5" id="description"
									name="description" placeholder="Enter Description"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class=" col-sm-5"></div>
							<div class=" col-sm-2">
								<button type="submit" class="btn btn-default">Submit</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
