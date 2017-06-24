<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<<html>
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
	<c:url value="/users_Processing" var="users" />
		<form:form action="${users}" method="POST" commandName="users">
		         <div class="form-group">
	    <label for="U_id">User Id</label>
	    <form:input type="text" class="form-control" path="U_id" placeholder="User ID"/>  
	  </div>
	          <div class="form-group">
	    <label for="U_name">Name</label>
	    <form:input type="text" class="form-control" path="U_name" placeholder="Name"/>  
	  </div>
	   <div class="form-group">
	    <label for="mobileno">Number</label>
	    <form:input type="text" class="form-control" path="U_phoneno" placeholder="Mobile-no" size="10" maxlength="10"/>
	  </div>
	  <div class="form-group">
	    <label for="email">Email address:</label>
	    <form:input type="email" class="form-control" path="U_email" placeholder="E-Mail id"/>
	  </div>
	  <div class="form-group">
	    <label for="pwd">Password:</label>
	    <form:input type="password" class="form-control" path="U_pwd" placeholder="Password"/>
	  </div>
	  <div class="form-group">
	    <label for="rpwd">Retype-Password:</label>
	    <input type="password" class="form-control" id="U_RPWD" placeholder="Retype-Password"/>
	  </div>

	  <a class="cursor" data-dismiss="modal" data-toggle="modal" data-target="#myModal">Already a member ? <b>Sign In</b></a>
	  <button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>
</body>
</html>