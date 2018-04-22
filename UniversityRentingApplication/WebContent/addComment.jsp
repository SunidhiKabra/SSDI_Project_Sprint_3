<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="header.jsp" />
<jsp:include page="errorList.jsp" />

<hr />
<br />
<table class="table table-bordered table-striped">
    <thead class="thead-dark">
      <tr>
        <th>Item Name</th>
        <th>Rent</th>
        <th>Description</th>
        <th>Comment</th>
      </tr>
    </thead>
    <tbody>
	<tr>
		<td valign="top">${item.getname()}</td>
		<td valign="top">${item.getdescription()}</td>
		<td valign="top">${item.getrent()}</td>
		<td valign="top">${item.getcomment()}</td>
	</tr>
	</tbody>
</table>

<div class="container">
	<form name="form" action="addComment.do" method="get">
		<div class="form-group">
  			<label for="comment">Comment:</label>
  			<textarea class="form-control" rows="5" id="comment"></textarea>
		</div>
		<input type="submit" class="btn btn-success" value="Save"></input> 
		<input type="reset" class="btn btn-success" value="Reset"></input>
	</form>
</div>	




<jsp:include page="footer.jsp" />