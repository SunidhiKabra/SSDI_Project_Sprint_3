<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="header.jsp" />

<jsp:include page="errorList.jsp" />

<hr />
<br />
<p>
<table class="table table-bordered table-striped">
    <thead class="thead-dark">
      <tr>
        <th>Name</th>
        <th>Email-ID</th>
        <th>Contact Number</th>
      </tr>
    </thead>
    <tbody>
	<tr>
	<!--  	<td valign="top">Name</td>  -->
		<td valign="top">${renter.getFirstName()} ${renter.getLastName()} </td>
		<td valign="top">${renter.getEmail()}</td>
		<td valign="top">${renter.getPhoneNumber()}</td>
	</tr>
<!--  	<tr>
		<td valign="top">Email ID</td>
		<td valign="top">${renter.getEmail()}</td>
	</tr>

	<tr>
		<td valign="top">Phone Number</td>
		<td valign="top">${renter.getPhoneNumber()}</td>
	</tr>  -->
	</tbody>
</table>
</p>



<jsp:include page="footer.jsp" />