<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ERROR FOUND</title>
<head>
<title>Login</title>
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
	src="/BaseCodeSlice_BankManagementSystem/pages/js/performTransactionValidations.js"></script>

</head>
<div>
	<%@ include file="/WEB-INF/static/html/Header.html"%>
</div>
<body
	background="/BaseCodeSlice_BankManagementSystem/pages/Images/A.jpg">
	<div class="has-danger" align="center" style="padding-top: 80px">
		<h1>${errorMsg}</h1>
	</div>
</body>
</html>