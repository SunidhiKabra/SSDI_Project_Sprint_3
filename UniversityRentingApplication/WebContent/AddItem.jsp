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
	<center>
		<h1 class="display1"> Home Page </h1> 
	</center>
<div class="w3">
	<div>
		<a href = "viewItems.do">
			<button>
				<h4>View Item</h4>
			</button>
 		</a>
		<a href = "AddItem.jsp">
			<button>
				<h4>Add Item</h4>
			</button>
 		</a>
	</div>
</div>
<br>
<br>
<div class="container">
<form name="form" action="ItemController" method="get">
	<div class="form-group">
		<label for="ItemName">Item Name</label>
		<input type="text" class="form-control" id="itemName" placeholder="Item Name" name="itemName">
	</br>
	</div>
	<div class="form-group">
		<label for="itemDescription">Item Description</label>
		<textarea class="form-control" id="itemDescription" placeholder="Item Description" name="itemDescription"></textarea>
	</br>
	</div>
	<div class="form-group">
		<label for="itemRent">Item Rent</label>
		<input type="text" class="form-control" id="itemRent" placeholder="item Rent(per day)" name="itemRent">
	</br>
	</div>
<input type="submit" class="btn btn-success" value="submit"></input> 
<input type="reset" class="btn btn-success" value="Reset"></input>
</form>
</div>


</body>
</html>
