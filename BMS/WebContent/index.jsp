<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="/BaseCodeSlice_BankManagementSystem/pages/custom.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Management System</title>
</head>

<body
	background="/BaseCodeSlice_BankManagementSystem/pages/Images/A.jpg">

<div>
<%@ include file = "/WEB-INF/static/html/Header.html" %>
</div>

	<table>

		<marquee behavior="scrolling" direction="left">
			<span class="morquee1"> MORE THAN JUST MONEY.</span></b>
			</h2>
		</marquee>

		<div style="margin-left: 200px">



			<tr>
				<td>
					<div style="width: 700px" align="left" class="imageSlider">

						<img class="mySlides"
							src="/BaseCodeSlice_BankManagementSystem/pages/Images/Homepageslider/1.jpg"></a>
						<img class="mySlides"
							src="/BaseCodeSlice_BankManagementSystem/pages/Images/Homepageslider/2.jpg"></a>
						<img class="mySlides"
							src="/BaseCodeSlice_BankManagementSystem/pages/Images/Homepageslider/3.jpg"></a>
						<img class="mySlides"
							src="/BaseCodeSlice_BankManagementSystem/pages/Images/Homepageslider/4.jpg"></a>

					</div> <script>
						var myIndex = 0;
						carousel();

						function carousel() {
							var i;
							var x = document.getElementsByClassName("mySlides");
							for (i = 0; i < x.length; i++) {
								x[i].style.display = "none";
							}
							myIndex++;
							if (myIndex > x.length) {
								myIndex = 1
							}

							x[myIndex - 1].style.display = "block";
							setTimeout(carousel, 2000);

						}
					</script>
				</td>



				<td align=""></td>
			</tr>
		</div>
		<tr>
			</html>
		</tr>
	</table>
</body>


<div>
<%@ include file = "/WEB-INF/static/html/Footer.html" %>
</div>

</html>