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
	<%@include file="allproducts.jsp"%>
</body>
</html>