<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script
	src="/BaseCodeSlice_BankManagementSystem/pages/js/viewtransationvalidation.js"></script>

</head>
<div>
	<%@ include file="/WEB-INF/static/html/Header.html"%>
</div>
<body class="main"
	background="/BaseCodeSlice_BankManagementSystem/pages/Images/A.jpg">
	<div class="container">

		<h1 style="margin-top: 2cm" align="center">Enter Your details</h1>
		<br> <br>
		<form class="form-horizontal form1" action="viewTransaction"
			onsubmit="return ValidateMyForm()" name="viewform" method="get">
			<div class="form-group row" style="margin-top: 1cm">
				<label class="control-label col-sm-4" for="accountNumber">Account
					Number:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="accountNumber"
						maxlength="16" name="accountNumber"
						placeholder="Enter Account Number">
				</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-sm-4" for="transactionId">Transaction
					Id:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="transactionId"
						maxlength="10" name="transactionId"
						placeholder="Enter Transaction Id">
				</div>
			</div>
			<div class="form-group ">
				<div class="col-sm-offset-4 col-sm-6">
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-10">
					<button type="submit" class="btn btn-primary">Get Loan
						Details</button>
					&nbsp;&nbsp;&nbsp;
					<button type="reset" class="btn" name="reset" value="reset">Reset</button>
				</div>
			</div>
		</form>
	</div>


</body>
</html>

