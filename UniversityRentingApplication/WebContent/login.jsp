
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>University Rental Application</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style>
.carousel-inner img {
	width: 100%;
	height: 100%;
}

.line {
	border-left: 3px solid #343a40;
	height: 500px;
	padding-top: 5%;
}

.lineWhite {
	border-left: 1px solid white;
	padding: 2px 10px;
}

a {
	color: #f8f9fa;
}

.loginImage {
	max-width: 100%;
	max-height: 100%;
	padding-top: 5%;
	border-color: black;
}
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px; /* Height of the footer */
}
</style>
</head>
<body>



	<nav class="navbar navbar-expand-sm bg-dark navbar-dark text-white">
		<a class="navbar-brand" href="index.jsp"> <img src="logo.jpg"
			alt="logo" style="width: 40px;">
		</a>

		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item">
				<h1 class="w3-text-white">University Renting Application</h1>
			</li>
		</ul>
	</nav>



	<jsp:include page="successMessage.jsp" />

	<div class="container">
		<div class=row>
			<div class="col-md-5">
				<form name="form" action="login.do" method="post">
					<br>

					<div class="form-group">
						<h1 class="display1">LOG IN</h1>

					</div>
					<div class="form-group">
						<label for="Email">Email</label> <input type="text"
							class="form-control" id="email" placeholder="Email" name="email">


					</div>
					<div class="form-group">
						<label for="Password">Password</label> <input type="password"
							class="form-control" id="password" placeholder="Password"
							name="password"> 
						<jsp:include page="errorList.jsp" />
					</div>
					<input type="submit" class="btn btn-success" value="Submit"></input>
					<input type="reset" class="btn btn-success" value="Reset"></input>

				</form>
			</div>
			<div class="col-md-1" style="padding-top: 2%;">
				<div class="line"></div>
			</div>
			<div class="col-md-6">
				<img src="loginImage.jpg" class="loginImage" alt="logo image">
			</div>
		</div>
	</div>


	<jsp:include page="footer.jsp" />