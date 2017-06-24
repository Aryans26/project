<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> --%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<c:url value="/resource" var="res" />

<!-- <link rel="stylesheet" ref="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${res}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${res}/css/style.css" />

</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container">
	<h3 class="head3">ADD SUPPLIER</h3>
	<div class="form-fill">
		<c:url value="/supplier_Processing" var="sup" />
		<form:form action="${sup}" method="POST" commandName="supplier">
			<div class="form-group">
				<label for="s_id">Supplier ID</label>
				<form:input type="text" class="form-control" path="S_id" />
			</div>
			<div class="form-group">
				<label for="s_name">Supplier Name</label>
				<form:input type="text" class="form-control" path="S_name" />
			</div>
			<div class="form-group">
				<label for="s_num">Supplier Number</label>
				<form:input type="text" class="form-control" path="S_num" maxlength="10"/>
			</div>

			<button type="submit" class="btn btn-success" value="save">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form:form>
		</div>
			
	<div class="container form-list-table">
  <div class="row items-list-head">
  <div class="col-md-3 col-sm-3 " ><b>Supplier ID</b></div>
  <div class="col-md-3 col-sm-3 " ><b>Supplier Name</b></div>
  <div class="col-md-3 col-sm-3 " ><b>Supplier Number</b></div>

  <div class="col-md-1 col-sm-1 " >
  <b></b>
  </div>
  <div class="col-md-1 col-sm-1 " >
  <b></b>
  </div>
  </div><!-- row end -->
  <c1:forEach items="${suppliers}" var="supp">
  <div class="row items-list">
  <div class="col-md-3 col-sm-3 " ><b>${supp.getS_id()}</b></div>
  <div class="col-md-3 col-sm-3 " ><b>${supp.getS_name()}</b></div>
  <div class="col-md-3 col-sm-3 " ><b>${supp.getS_num()}</b></div>

  <div class="col-md-1 col-sm-1 " >
  <a href="<c1:url value="/edit_Supplier/${supp.getS_id()}"/>" class="btn btn-primary">Edit</a>
  </div>
  <div class="col-md-1 col-sm-1 " >
  <a href="<c1:url value="/delete_Supplier/${supp.getS_id()}"/>"  class="btn btn-primary" >Delete</a>
  </div>
  </div><!-- row end -->
    </c1:forEach>
  </div>
		
	</div>
</body>
</html>
