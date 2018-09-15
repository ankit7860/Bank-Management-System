<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style>
.danger {
	color: red;
}

td {
	vertical-align: top;
}
</style>
<title>User Add</title>
<script src='<spring:url value="/static/js/user/user.js"/>'>
	
</script>

</head>
<body>
	<h3>Enter User Info:</h3>
	<form method="POST" action="save">
		<table>
			<tr>
				<td>Account Holder Name</td>
				<td><input type="text" name="accountHolderName"
					value="<%=request.getParameter("accountHolderName") != null ? request.getParameter("accountHolderName") : ""%>" />
					<div class="danger">${errors.accountHolderName}</div></td>
			</tr>
			<tr>
				<td>Account Type</td>
				<td><select name="accountType">
						<option value=""></option>
						<option value="SAVING"
							<%=("SAVING".equals(request.getParameter("accountType"))) ? "selected='selected'" : ""%>>Saving</option>
						<option value="CURRENT"
							<%=("CURRENT".equals(request.getParameter("accountType"))) ? "selected='selected'" : ""%>>Current</option>
				</select>
					<div class="danger">${errors.accountType}</div></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input type="date" name="dob" />
					<div class="danger">${errors.dob}</div></td>
			</tr>
			<tr>
				<td><button type="submit">Add</button></td>
				<td><a href="/">Cancel</a></td>
			</tr>
		</table>
	</form>
</body>
</html>