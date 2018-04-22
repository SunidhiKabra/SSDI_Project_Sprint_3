<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<jsp:include page="errorList.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Account Information</title>
</head>
<body>
<p>
<jsp:include page="successMessage.jsp" />

<div class="container">
<form name="form" action="editInfo.do" method="post">
	</br>
	<center>
		<h1 class="display1"> Edit Account Information </h1> 
	</center>
	<div class="form-group">
		<label for="FirstName">First Name</label>
		<input type="text" class="form-control" id="firstName" value="${loggedInUser.getFirstName()}" placeholder="${loggedInUser.getFirstName()}" name="firstName">
	</br>
	</div>
	<div class="form-group">
		<label for="LastName">Last Name</label>
		<input type="text" class="form-control" id="lastName" value="${loggedInUser.getLastName()}" placeholder="${loggedInUser.getLastName()}" name="lastName">
	</br>
	</div>
	<div class="form-group">
		<label for="Email">Email</label>
		<input type="email" class="form-control" id="email" value="${loggedInUser.getEmail()}" placeholder="${loggedInUser.getEmail()}" name="email">
	</br>
	</div>
	<div class="form-group">
		<label for="Password">Password</label>
		<input type="password" class="form-control" id="password" value="${loggedInUser.getPassword()}" placeholder="${loggedInUser.getPassword()}" name="password">
	</br>
	</div>
	<div class="form-group">
		<label for="PhoneNumber">Phone Number</label>
		<input type="tel" class="form-control" id="phoneNumber" value="${loggedInUser.getPhoneNumber()}" placeholder="${loggedInUser.getPhoneNumber()}" name="phoneNumber">
	</br>
	</div>
<input type="submit" class="btn btn-success" value="Submit"></input> 
<input type="reset" class="btn btn-success" value="Reset"></input>
</form>
</div>


<jsp:include page="footer.jsp" />

</body>
</html>
