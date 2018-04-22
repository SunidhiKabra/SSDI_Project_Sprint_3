<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner img {
      width: 100%;
      height: 100%;
  }
  </style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark text-white">
  <a class="navbar-brand" href="index.jsp">
    <img src="logo.jpg" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <h1 class="w3-text-white">University Renting Application</h1>
    </li>
  </ul>
</nav>
<br>
<br>
<br>
<br>
<br>
<br>

<jsp:include page="successMessage.jsp" />

<div style="text-align:center" class="w3">
	<div>
		<a href = "signUp.do">
			<button>
				<h2>SIGN UP</h2>
			</button>
 		</a>
		<a href = "login.do">
			<button>
				<h2>LOGIN</h2>
			</button>
 		</a>
	</div>
</div>


</body>
</html>
