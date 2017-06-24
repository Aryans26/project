<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
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
	<h3 class="head3">ADD CATEGORY</h3>
	<div class="form-fill">
		<c:url value="/category_Processing" var="cat" />
		<form:form action="${cat}" method="POST" commandName="category">
			<div class="form-group">
				<label for="C_id">Category ID</label>
				<form:input type="text" class="form-control" path="C_id" />
			</div>
			<div class="form-group">
				<label for="C_name">Category Name</label>
				<form:input type="text" class="form-control" path="C_name" />
			</div>
			<button type="submit" class="btn btn-success" value="save">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form:form>
		</div>

 
  <div class="container form-list-table">
  <div class="row items-list-head">
  <div class="col-md-4 col-sm-4 col-xs-6" ><b>Category Id</b></div>
  <div class="col-md-4 col-sm-4 col-xs-6" ><b>Category Name</b></div>
  <div class="col-md-2 col-sm-2 col-xs-6" >
  <b></b>
  </div>
  <div class="col-md-2 col-sm-2 col-xs-6" >
  <b></b>
  </div>
  </div><!-- row end -->
  <c1:forEach items="${catogories}" var="cate">
  <div class="row items-list">
  <div class="col-md-4 col-sm-4 col-xs-6" ><b>${cate.getC_id()}</b></div>
  <div class="col-md-4 col-sm-4 col-xs-6" ><b>${cate.getC_name()}</b></div>
  <div class="col-md-2 col-sm-2 col-xs-6" >
  <a href="<c1:url value="/edit_Category/${cate.getC_id()}"/>" class="btn btn-primary">Edit</a>
  </div>
  <div class="col-md-2 col-sm-2 col-xs-6" >
  <a href="<c1:url value="/delete_Category/${cate.getC_id()}"/>"  class="btn btn-primary" >Delete</a>
  </div>
  </div><!-- row end -->
    </c1:forEach>
  </div>


	</div>
</body>
</html>
