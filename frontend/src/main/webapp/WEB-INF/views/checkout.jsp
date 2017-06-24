<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <%@ include file="nav.jsp"%> --%>
  <br><br>
  <center>${msg}</center>

	<div class="row">
	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Check Out</li>
    </ul>
	<div class="well well-small">
		<h1>Check Out <small class="pull-right"> 2 Items are in the cart </small></h1>
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
                  <c:forEach items="${cartItem}" var="pro">
                <tr>
                  <td><img src="<c:url value='${img}/${pro.getProduct().getP_id()}.jpg'/>"></td>
                  <td>${pro.getProduct().getP_Name() }</td>
                  <td> ${pro.getProduct().getPrice()} </td>
                  <td><span class="shopBtn"><span class="icon-ok"></span></span> </td>
                  
                  <td>
					<a href="<c:url value='/Remove/${pro.getCi_id()}'/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Remove</a>/<a href="<c1:url value='/Buy/${pro.getCi_id()}'/>" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Buy now</a>
        </td>
                  
                </tr>
                </c:forEach>
                </tbody>

  </table>
  <center>Total price=${gtotal}</center>
<center> <a href="<c:url value='/Removeall'/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Remove All</a>/<a href="<c1:url value='/Buyall/${pro.getProduct().getP_id()}'/>" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Buy All </a>
  </center></div>
				
</body>
</html>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="validator.js"></script>
<script src="contact.js"></script>


