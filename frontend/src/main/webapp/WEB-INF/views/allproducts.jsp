<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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

<br>
<div class="container ">
<div id="" class="col-md-2 box-shadow">

<h3 class="list-head">CATEGORIES</h3>
	<ul class="nav nav-list nav-left">
		<c1:forEach items="${categories}" var="cat">
					
      <li><a href="<c1:url value="/dispcategory/${cat.getC_id()}"/>"><span class="icon-chevron-right"></span> ${cat.getC_name()}</a></li>
					

         </c1:forEach>
	
<!-- 		<li style="border:0"> &nbsp;</li> -->
<!-- 		<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li> -->
	</ul>


<h3 class="list-head">SORT BY PRICE</h3>
	<ul class="nav nav-list nav-left">
		
					
      <li><a href="<c1:url value="/disrate/"/>"><span class="icon-chevron-right"></span>100 - 500 </a></li>
		<li><a href="<c1:url value="/disrate1/"/>"><span class="icon-chevron-right"></span>500 - 1500 </a></li>
		<li><a href="<c1:url value="/disrate2/"/>"><span class="icon-chevron-right"></span>1500 - 2500 </a></li>			

         
	
<!-- 		<li style="border:0"> &nbsp;</li> -->
<!-- 		<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li> -->
	</ul>

</div>		
		

	<div class="col-md-10">
	
<!--
New Products
-->

	<h3>New Products </h3>
	<hr class="soften"/>
		<div class="row">
			  <ul class="thumbnails">
			  <c1:forEach var="pro" items="${products}">
				<div class="col-md-3 col-sm-4">
				<div class="thumbnail">
				
					<a class="zoomTool" href="<c1:url value="/addtocart/${pro.getP_id()}"/>" title="add to cart"><i class="fa fa-shopping-cart"></i> Add to cart</a>
					<a href="#" class="tag"></a>
					<a href="<c1:url value="/viewpro/${pro.getP_id()}"/>" title="quick view">
					<img src="<c1:url value='/resource/images/${pro.getP_id()}.jpg'/>" alt="bootstrap-ring"></a>
					<h3>${pro.getP_name()}            &nbsp;  &nbsp;  &nbsp; ${pro.getP_c()}</h3>
					
				</div>
				</div>
				</c1:forEach>
	
			  </ul>
			

<!-- 		  <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a>Cycling of images -->
<!--             <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a> -->
		  </div>

				</div>

</div><!-- container end -->



</body>
</html>