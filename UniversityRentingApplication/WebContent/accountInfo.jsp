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
<title>My Account Information</title>
</head>
<body>
<p>
<table class="table table-bordered table-striped">
    <thead class="thead-dark">
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email id</th>
        <th>Password</th>
        <th>Phone Number</th>
      </tr>
    </thead>
    <tbody>
		<tr>
			<td>${customer.getFirstName()}</td>		
			<td>${customer.getLastName()}</td>
			<td>${customer.getEmail()}</td>
			<td>${customer.getPassword()}</td>
			<td>${customer.getPhoneNumber()}</td>
		</tr>
	</tbody>
</table>
</p>

<br>
<br>
<br>
<div style= "float: right; padding-right:30px;">
	<a href= "editInfo.jsp">
		<button >
			<h5>
				Edit Information
			</h5>	
		</button>
	</a>
</div>


<jsp:include page="footer.jsp" />

</body>
</html>