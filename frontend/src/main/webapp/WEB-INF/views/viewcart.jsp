<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
  <br><br>
  <center>${msg}</center>

	<div class="row">
	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Check Out</li>
    </ul>
	<div class="well well-small">
		<h1>Check Out <small class="pull-right"> ${items} Items are in the cart </small></h1>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>IMAGE</th>
                  <th>NAME</th>
				  <th>	PRICE </th>
                  <th>Remove/Buy now</th>
                  <th>Total</th>	
				</tr>
              </thead>
              <tbody>
                 <c1:forEach items="${cartItem}" var="pro">
      <tr>
        <td><img src="<c:url value='/resource/images/${pro.getProduct().getP_id()}.jpg'/>",width=50px, height=20px></td>
        <td>${pro.getProduct().getP_name() }</td>
        <td>${pro.getProduct().getP_c()}</td>
<%--         <td>${pro.getProduct().getDes()}</td> --%>
        <td><a href="<c1:url value='/Remove/${pro.getCartItem_Id()}'/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Remove</a>
        <a href="<c1:url value='/Buy/${pro.getProduct().getP_id()}/${pro.getCartItem_Id()}'/>" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Buy now</a>
        </td>
      </tr>
      </c1:forEach>
                </tbody>

  </table>
  <center>Total price=${gtotal}</center>
<center> <a href="<c:url value='/Removeall'/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Remove All</a>
<a href="<c1:url value='/Buyall/${pro.getProduct().getP_id()}'/>" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Buy All </a>
  </center></div>
				
</body>
</html>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="validator.js"></script>
<script src="contact.js"></script>


