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
	<div class="container" style="padding: 2cm">
		<h1>${message}</h1>
	</div>
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

