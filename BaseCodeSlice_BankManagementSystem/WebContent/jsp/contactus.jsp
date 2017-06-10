<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>

<div>
	<%@ include file="/WEB-INF/static/html/Header.html"%>
</div>

<h1 style="background-color: red">XYZ Bank</h1>

<img src="C:\Users\577618\Desktop\ContactUS.jpg" alt="Contact Us"
	style="width: 600px; height: 228px;">
<br>
<h2 style="background-color: rgb(0, 0, 0); color: white">Contact Us</h2>
<br>
</head>
<body>
	<ul style="list-style-type: circle">
		<li><a href="atm.jsp">ATMs</a></li>
		<li><a href="branches.jsp">Branches and Extension Counters</a></li>
		<li><a href="f2.jsp">Regional Offices</a></li>
		<li><a href="NRI.jsp">NRI Division</a></li>
	</ul>

	<h2 style="background-color: red">Corporate Office</h2>
	<br>

	<p>
		XYZ Bank Ltd.<br> Head office T.B Road, Mission Quarters,
		Thrissur 680 001,Kerala, India<br> Telephone Nos:
		+91-587-2960020, 2360058, 2410553<br> Email:
		sbciorporate@sbc.co.in<br>
	</p>






	<div>
		<%@include file="/WEB-INF/static/html/Footer.html"%>
	</div>
</body>
</html>