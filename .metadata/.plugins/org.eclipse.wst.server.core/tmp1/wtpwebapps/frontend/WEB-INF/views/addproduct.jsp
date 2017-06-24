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
	<h3 class="head3">ADD PRODUCT</h3>
	<div class="form-fill">
		<c:url value="/addproduct_Processing" var="pro" />
		<form:form action="${pro}" method="POST" commandName="addproduct" enctype="multipart/form-data">
			<div class="form-group">
				<label for="p_id">Product ID</label>
				<form:input type="text" class="form-control" path="p_id" />
			</div>
			<div class="form-group">
				<label for="p_name">Product Name</label>
				<form:input type="text" class="form-control" path="p_name" />
			</div>
			<div class="form-group">
				<label for="p_q">Product Quantity</label>
				<form:input type="text" class="form-control" path="p_q" />
			</div>
			<div class="form-group">
				<label for="p_c">Product Cost</label>
				<form:input type="text" class="form-control" path="p_c" />
			</div>
			<div class="form-group">
				<label for="des">Product Description</label>
				<form:input type="content" class="form-control" path="des" />
			</div>
			<div class="form-group">
				<label for="des">Product Category</label>
				<form:select type="content" class="form-control" path="category.C_id"  multiple="false">
				<c1:forEach items="${categorylist}" var="categoryDropDown">
				<form:option value="${categoryDropDown.getC_id()}" label="${categoryDropDown.getC_name()}"/>
				</c1:forEach>
				</form:select>
			</div>
			
				<div class="form-group">
				<label for="des">Product Supplier</label>
				<form:select type="content" class="form-control" path="supplier.S_id"  multiple="false">
				<c1:forEach items="${supplierlist}" var="supplierDropDown">
				<form:option value="${supplierDropDown.getS_id()}" label="${supplierDropDown.getS_name()}"/>
				</c1:forEach>
				</form:select>
			</div>
			<div class="form-group">
				<label for="des">Product Image</label>
			<form:input path="pimg" type="file" name="image" value="upload file"/>
			</div>
			
			<button type="submit" class="btn btn-success" value="save">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form:form>
		
		</div>

 
 <div class="container form-list-table">
  <div class="row items-list-head">
  <div class="col-md-2 col-sm-2 " ><b>Product Id</b></div>
  <div class="col-md-2 col-sm-2 " ><b>Product Name</b></div>
   <div class="col-md-2 col-sm-2 " ><b>Product Quantity</b></div>
    <div class="col-md-2 col-sm-2 " ><b>Product Cost</b></div>
  <div class="col-md-2 col-sm-2 " >
  <b></b>
  </div>
  <div class="col-md-2 col-sm-2 " >
  <b></b>
  </div>
  </div><!-- row end -->
  <c1:forEach items="${products}" var="pro">
  <div class="row">
  <div class="col-md-2 col-sm-2 " ><b>${pro.getP_id()}</b></div>
  <div class="col-md-2 col-sm-2 " ><b>${pro.getP_name()}</b></div>
  <div class="col-md-2 col-sm-2 " ><b>${pro.getP_q()}</b></div>
  <div class="col-md-2 col-sm-2 " ><b>${pro.getP_c()}</b></div>
  <div class="col-md-2 col-sm-2 col-xs-6" >
  <a href="<c1:url value="/edit_Product/${pro.getP_id()}"/>" class="btn btn-primary">Edit</a>
  </div>
  <div class="col-md-2 col-sm-2 col-xs-6" >
  <a href="<c1:url value="/delete_Product/${pro.getP_id()}"/>"  class="btn btn-primary" >Delete</a>
  </div>
  </div><!-- row end -->
    </c1:forEach>
  </div>
  
	</div>
</body>
</html>