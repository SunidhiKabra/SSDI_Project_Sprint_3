<!DOCTYPE html>
<html lang="en">
<head>
<title>University Rental Application</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

<script type="text/javascript">
	function UpdatePosting(itemId, itemName) {
		var element = document.getElementById("UpdatePosting" + itemId);
		$.ajax({
			type : "POST",
			url : "updatePosting.do?itemId=" + itemId + "&statusId="
					+ element.checked + "&itemName=" + itemName,

			data : {
				id : itemId
			},
			success : function(result) {
				alert(result);
			},

			error : function(result) {
				alert(result);
			}

		});

	}

	function DeletePosting(itemId) {
		var element = document.getElementById("DeletePosting" + itemId);
		$.ajax({
			type : "POST",
			url : "deleteItem.do?itemId=" + itemId,

			data : {
				id : itemId
			},
		/* success : function(result) {
			alert(result);
		},

		error : function(result) {
			alert(result);
		} */

		});

	}
	
	function AddToWishlist(itemId)
	{
		var element = document.getElementById("AddToWishlist" + itemId);
		$.ajax({
			type : "POST",
			url : "addToWishList.do?itemId=" + itemId,

			data : {
				id : itemId
			},
		 success : function(result) {
			 alert(result);
			 /* var message = document.getElementById("successMessage");
			 message.innerHTML = result; */
			 element.disabled = true;
		},
		/*
		error : function(result) {
			alert(result);
		} */

		});
	}
</script>

<style>
.carousel-inner img {
	width: 100%;
	height: 100%;
}
.btn-default {
	color: #212529 !important;
	background-color: #212529 !important;
	border-color: #c69500 !important;

	/* 	color: #fff !important;
	background-color: #6c757d !important;
	border-color: #6c757d !important; */
}

.lineWhite {
	border-left: 1px solid white;
	padding: 2px 10px;
}

a {
	color: #f8f9fa;
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
	<br>

	<div class="w3">
		<div>
			<a href="viewItems.do">
				<button>
					<h4>View Item</h4>
				</button>
			</a> <a href="addItems.jsp">
				<button>
					<h4>Add Item</h4>
				</button>
			</a>
			<a href="myPostings.do">
				<button>
					<h4>My Postings</h4>
				</button>
			</a>	
			<a href="viewWishlist.do">
				<button>
					<h4>My Wishlist</h4>
				</button>
			</a>	
			<div style="float: right; padding-right:20px;">
			<ul>
				<ul><span> Hi ${loggedInUser.getFirstName()} ${loggedInUser.getLastName()} </span></ul>
				<ul><span><a href="accountInfo.do" style="color:blue;"> My Account </a></span></ul>
				<ul><span><a href="logout.do" style="color:blue;"> Logout </a></span></ul>
			</ul>
			</div>
		</div>
	</div>