<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
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
<link rel="stylesheet" href="${res}/css/font-awesome/css/font-awesome.min.css" />

</head>
<body>
	<%@include file="navbar.jsp"%>
	<br>
	<div class="container box-shadow border-radius">

	<div class="row">

	<div class="col-md-4 col-sm-4 col-xs-12 billing-add">
		<h3 class="text-center">Billing Address</h3>
		<div class="col-md-6 col-sm-6 b-r"><b>Name :</b></div><div class="col-md-6 col-sm-6">${user.getU_name()} </div>
		<div class="col-md-6 col-sm-6 b-r"><b>Email :</b></div><div class="col-md-6 col-sm-6">${user.getU_email()}</div>
		<div class="col-md-6 col-sm-3 b-r"><b>Mobile :</b></div><div class="col-md-6 col-sm-6">${user.getU_phoneno()}</div>
		<div class="col-md-6 col-sm-6 b-r"><b>Address:</b></div><div class="col-md-6 col-sm-6">${billing.getHouse_no()}<br>
		${billing.getStreet_name()}<br>${billing.getCity()}<br>${billing.getState()}<br>${billing.getCountry()}<br>
		${billing.getPincode()}<br>
		</div>
	
	</div>


	<div class="col-md-8 shipping col-sm-8 col-xs-12">
		<h3 class="text-center">shipping Address</h3>

		<hr>
	<c:url value="/orderConfirm" var="a"/>
		<form:form action="${a}" method="post" commandName="shippingAddress">
		
	
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="first_name" id="first_name" class="form-control input-sm" placeholder="Name" path="Ship_name" value="${user.getU_name()}"/> 
			</div>
		</div>
		

		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="first_name" id="first_name" class="form-control input-sm" placeholder="Email id" path="Ship_email" value="${user.getU_email()}"/> 
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="Mobile_no" class="form-control input-sm" placeholder="Mobile no" path="Ship_mono" value="${user.getU_phoneno()}"/> 
		</div>
</div>
		<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="form-group">
				<form:input type="text" class="form-control input-sm" placeholder="House number" path="Ship_houseno" value="${billing.getHouse_no()}"/>                                                
                                           
			</div>
		</div>
<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="last_name" id="last_name" class="form-control input-sm" placeholder="Street Name"  value="${billing.getStreet_name()}" path="Ship_streetname"/> 
			</div>
		</div>
		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text"	class="form-control input-sm" placeholder="city" path="Ship_city" value="${billing.getCity()}"/> 
			</div>
		</div>
		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text"	class="form-control input-sm" placeholder="State" path="Ship_state" value="${billing.getState()}"/> 
			</div>
		</div>
		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text"	class="form-control input-sm" placeholder="country" path="Ship_country" value="${billing.getCountry()}"/>
			</div>
		</div>
		
		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text" class="form-control input-sm" placeholder="pincode" path="Ship_pincode" value="${billing.getPincode()}"/> 
			</div>
		</div>

	<div class="col-md-12">
		<input type="submit" class="btn btn-primary pull-right" value="Continue">
	</div>
   </form:form>
  
</div>
</div>
 <br>
</div>
<!--
Footer
-->

<!-- /container -->

<div class="copyright">
<div class="container">
	
	<span>Copyright &copy; 2013<br> bootstrap ecommerce shopping template</span>
</div>
</div>
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>

  </body>
</html>
