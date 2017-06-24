<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="headder">
		<b>Snapd4eal-2</b>
	</div>
	
	<nav class="navbar navbar-default" style="color: white;">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/"/>"
					style="color: white;">WebSiteName</a>
				<form class="navbar-form navbar-right visible-sm visible-xs">
					<div class="form-group">
						<input type="text" class="form-control"
							placeholder="Product, Category & Brand">
					</div>
					<button type="submit" class="btn btn-default">
						<i class="fa fa-search"></i>Search
					</button>

				</form>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
			<c1:if test="${pageContext.request.userPrincipal.name!=null}">
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<ul class="nav navbar-nav">
					<li style="color: white;"><a
						href="<c:url value="/category"/>">Add Category</a></li>
					<li style="color: white;"><a
						href="<c:url value="/addproduct"/>">Add Product</a></li>
					<li style="color: white;"><a
						href="<c:url value="/supplier"/>">Add Supplier</a></li>
<!-- 					<li style="color: white;"><a -->
<%-- 						href="<c:url value="/addcard"/>">Add Card</a></li> --%>
						
				</ul>
				</security:authorize>
				</c1:if>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/viewcart"/>"><i class="fa fa-shopping-cart"></i>
							Cart</a></li>
							
					<li class="dropdown"><a href="#" class="dropbtn"><span
							class="fa fa-sign-in"></span> 
							<c1:if test="${pageContext.request.userPrincipal.name==null}"> Login </c1:if>
							 <c1:if test="${pageContext.request.userPrincipal.name!=null}">  Logout</c1:if></a>

						<div class="dropdown-content">
							<a href="#">your account</a> 
							<a href="#">your orders</a> 
							<c1:if test="${pageContext.request.userPrincipal.name==null}">

							<a href="<c:url value="/users"/>" class="hvr-reg-bordertop" > new user ?<br>
							<b>register</b></a>
<%-- <a href="<c:url value="/login"/>"><button type="button" class="btn btn-danger" style="width: 90%; margin: 10px;">Login</button></a> --%>
							<button type="button" class="btn btn-danger" data-toggle="modal"
								data-target="#myModal" style="width: 90%; margin: 10px;">Login</button>
								</c1:if>
								
								<c1:if test="${pageContext.request.userPrincipal.name!=null}">
					<a href="<c:url value="/j_spring_security_logout"/>"><button type="button" class="btn btn-danger" >Logout</button></a>
								</c1:if>
						</div></li>

				</ul>
				<form class="navbar-form navbar-right hidden-sm hidden-xs">
					<div class="form-group">
						<input type="text" class="form-control"
							placeholder="Product, Category & Brand">
					</div>
					<button type="submit" class="btn btn-default">
						<i class="fa fa-search"></i>Search
					</button>

				</form>

			</div>
		</div>
	</nav>


	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Login</h4>
				</div>
				<div class="modal-body">
				<c1:url value="/j_spring_security_check" var="a"/>
					<form role="form" method="post" action="${a} ">
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
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>