<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="header.jsp" />
<jsp:include page="errorList.jsp" />
<jsp:include page="successMessage.jsp" />

<hr />
<br />

<div class="container">
	
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Item</th>
					<th>Description</th>
					<th>Rent</th>
					<th>Owner Details</th>
					<th>Delete</th>
					<!-- 
					<th></th>
					<th>Add to Wishlist</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${items}">
					
					<tr>

						<td valign="middle" >${item.getName()}</td>

						<td valign="middle" >${item.getDescription()}</td>

						<td valign="middle">${item.getRent()}</td>

						<td valign="middle"><a
							href="viewRenter.do?customerId=${item.getCustomerId()}"
							class="btn btn-outline-info" role="button">Contact Renter </a></td>
							
						<td valign="middle"><a
							href="deleteItemFromWishlist.do?id=${item.getId()}"
							class="btn btn-outline-info" role="button">Delete Item from Wishlist </a>
						</td>
						 			
						
						
					</tr>
					
				</c:forEach>
			</tbody>
		</table>
	</div>


<jsp:include page="footer.jsp" />