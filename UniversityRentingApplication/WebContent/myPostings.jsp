<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="header.jsp" />



<jsp:include page="errorList.jsp" />

<hr />
<br />


<div class="container">

	<table class="table table-bordered table-striped center" >
		<thead class="thead-dark" >
			<tr>
				<th>Item</th>
				<th>Description</th>
				<th>Rent</th>
				<th>Availability</th>
				<th>Delete Item</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">

				<tr>
					<td valign="top">${item.getName()}</td>

					<td valign="top">${item.getDescription()}</td>

					<td valign="top">$ ${item.getRent()}</td>
					<td valign="top" align="center" class="checkbox"><c:choose>
							<c:when test="${item.getAvailability()== true}">
								
								 <input id="UpdatePosting${item.getId()}"  type="checkbox" data-toggle="toggle" data-on="Available"
									data-off="Unavailable"  onchange="UpdatePosting('${item.getId()}','${item.getName()}');" checked  data-onstyle="success" data-offstyle="warning">
									
							</c:when>
							<c:otherwise>
							
								 <input id="UpdatePosting${item.getId()}" type="checkbox"  data-toggle="toggle" data-on="Available" 
									 onchange="UpdatePosting('${item.getId()}','${item.getName()}');"  data-off="Unavailable" data-onstyle="success" data-offstyle="warning"> 

							</c:otherwise>

						</c:choose></td>
						<td valign="middle" align="center">
						  <%-- <input id = "DeletePosting${item.getId()}" type="button" class="btn btn-danger" value="Delete" 
						  onclick="DeletePosting(${item.getId()})">
						 --%>
						
						<a
							href="deleteItem.do?itemId=${item.getId()}"
							class="btn btn-danger" role="button">Delete </a></td>

				</tr>

			</c:forEach>
		</tbody>
	</table>
</div>


<jsp:include page="footer.jsp" />
