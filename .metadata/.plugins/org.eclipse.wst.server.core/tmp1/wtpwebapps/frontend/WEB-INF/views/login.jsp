<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container">
<c1:url value="j_spring_security_check" var="a"/>
					<form role="form" method="post" action="${a} }">
						<div class="form-group">
				<label for="email">Email address:</label> 
				<input type="email" class="form-control" id="email" name="j_username" placeholder="Email Id">
						</div>
						<div class="form-group">
				<label for="pwd">Password:</label>
				 <input type="password" class="form-control" id="pwd" name="j_password" placeholder="Password">
						</div>
						<div class="checkbox">
							<label><input type="checkbox"> Remember me</label>
						</div>
						<a class="cursor" data-dismiss="modal" data-toggle="modal"
							data-target="#myModal1">new User ? <b>register</b></a>
						<button type="submit" class="btn btn-success">Submit</button>
					</form>
	</div>
</body>
</html>