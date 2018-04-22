<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="header.jsp" />


<br>
<br>
<div class="container">
<form name="form" action="addItems.do" method="get">
	<div class="form-group">
		<label for="item_name">Item Name</label>
		<input type="text" class="form-control" id="item_name" placeholder="Item Name" name="name">
	</br>
	</div>
	<div class="form-group">
		<label for="item_description">Item Description</label>
		<textarea class="form-control" id="item_description" placeholder="Item Description" name="description"></textarea>
	</br>
	</div>
	<div class="form-group">
		<label for="rent">Item Rent</label>
		<input type="text" class="form-control" id="rent" placeholder="Item Rent" name="rent">
	</br>
	<jsp:include page="errorList.jsp" />
	</div>
	
<input type="submit" class="btn btn-success" value="submit"></input> 
<input type="reset" class="btn btn-success" value="Reset"></input>
</form>
</div>

<jsp:include page="successMessage.jsp" />

<jsp:include page="footer.jsp" />
