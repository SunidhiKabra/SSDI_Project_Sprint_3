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
					<th>Add to Wishlist</th>
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
										
						<td valign="middle">
						 <c:choose>
						<c:when test="${item.isWishedItem() == true}">
								
								 <a
							href="addToWishList.do?itemId=${item.getItemId()}"
							class="btn btn-outline-info disabled" role="button" >Add To Wishlist </a>
									
							</c:when>
							<c:otherwise> 
							
								 <input id = "AddToWishlist${item.getId()}" type="button" class="btn btn-outline-info" 
						 value="Add To Wishlist" 
						  onclick="AddToWishlist(${item.getId()})">
							 </c:otherwise>

						</c:choose></td>
						 
						
						
						<%-- <a
							href="addToWishList.do?itemId=${item.getItemId()}"
							class="btn btn-outline-info" role="button">Add To Wishlist </a> --%>
						 <%--  <input id = "AddToWishlist${item.getId()}" type="button" class="btn btn-outline-info" 
						 value="Add To Wishlist" 
						  onclick="AddToWishlist(${item.getId()})"> --%>
						 				
								
				
						
						
					</tr>
					
				</c:forEach>
			</tbody>
		</table>
	</div>


<jsp:include page="footer.jsp" />