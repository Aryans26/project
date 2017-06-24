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
		<c:url value="/addcard_Processing" var="addcrd" />
		<form:form action="${addcrd}" method="POST" commandName="addcard">
		<div class="form-group">
				<label for="Card_id">Card_id </label>
				<form:input type="text" class="form-control" path="Card_id" />
			</div>
			<div class="form-group">
				<label for="Card_no">Card_no </label>
				<form:input type="text" class="form-control" path="Card_no" />
			</div>
			<div class="form-group">
				<label for="Holder_name">Holder_name</label>
				<form:input type="text" class="form-control" path="Holder_name" />
			</div>
			<div class="form-group">
				<label for="Exp_date">Exp_date </label>
				<form:input type="number" class="form-control" path="Exp_date" />
			</div>
			<div class="form-group">
				<label for="Exp_month">Exp_month </label>
				<form:input type="number" class="form-control" path="Exp_month" />
			</div>
			<div class="form-group">
				<label for="Exp_year">Exp_year</label>
				<form:input type="number" class="form-control" path="Exp_year" />
			</div>
			<button type="submit" class="btn btn-success" value="save">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form:form>
		
		<div class="container">
  <div class="row">
  <div class="col-md-2 col-sm-2 " ><b>Card Id</b></div>
  <div class="col-md-3 col-sm-3 " ><b>Card Number</b></div>
  <div class="col-md-3 col-sm-3 " ><b>Holder Name</b></div>
   <div class="col-md-2 col-sm-2 " ><b>Expiry Date</b></div>
  <div class="col-md-1 col-sm-1 " >
  <b></b>
  </div>
  <div class="col-md-1 col-sm-1 " >
  <b></b>
  </div>
  </div><!-- row end -->
  <c1:forEach items="${cards}" var="card">
  <div class="row">
  <div class="col-md-2 col-sm-2 " ><b>${card.getCard_id()}</b></div>
  <div class="col-md-3 col-sm-3 " ><b>${card.getCard_no()}</b></div>
  <div class="col-md-3 col-sm-3 " ><b>${card.getHolder_name()}</b></div>
  <div class="col-md-2 col-sm-2 " ><b>${card.getExp_date()} / ${card.getExp_month()} / ${card.getExp_year()}</b></div>
  <div class="col-md-1 col-sm-1 " >
  <a href="<c1:url value="/edit_Card/${card.getCard_id()}"/>" class="btn btn-primary">Edit</a>
  </div>
  <div class="col-md-1 col-sm-1 " >
  <a href="<c1:url value="/delete_Card/${card.getCard_id()}"/>"  class="btn btn-primary" >Delete</a>
  </div>
  </div><!-- row end -->
    </c1:forEach>
  </div>
  
	</div>
</body>
</html>
