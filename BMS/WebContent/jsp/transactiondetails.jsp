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
<body>
	<table>
			<div class="container">
				<table class="table table-striped">
				<caption><h1 align="center">Your Transaction details are:</h1></caption>
				<c:forEach var="listValue" items="${details}">
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
						</c:forEach>
					</tbody>
				</table>
			</div>
</body>
</html>
