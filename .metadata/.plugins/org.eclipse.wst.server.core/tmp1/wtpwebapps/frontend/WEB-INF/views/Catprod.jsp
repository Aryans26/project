<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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

<div id="" class="col-md-2">
<div class="well well-small">
<h3>CATEGORIES</h3>
	<ul class="nav nav-list">
		<c1:forEach items="${categories}" var="cat">
					
      <li><a href="<c1:url value="/dispcategory/${cat.getC_id()}"/>"><span class="icon-chevron-right"></span> ${cat.getC_name()}</a></li>
					

         </c1:forEach>
	
<!-- 		<li style="border:0"> &nbsp;</li> -->
<!-- 		<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li> -->
	</ul>
</div>
<div class="well well-small">
<h3>SORT BY PRICE</h3>
	<ul class="nav nav-list">
		
					
      <li><a href="<c1:url value="/disrate/"/>"><span class="icon-chevron-right"></span>100 - 500 </a></li>
		<li><a href="<c1:url value="/disrate1/"/>"><span class="icon-chevron-right"></span>500 - 1500 </a></li>
		<li><a href="<c1:url value="/disrate2/"/>"><span class="icon-chevron-right"></span>1500 - 2500 </a></li>			

         
	
<!-- 		<li style="border:0"> &nbsp;</li> -->
<!-- 		<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li> -->
	</ul>
</div>
</div>	
	<div class="col-md-10">
	
	<div class="well well-small" >
	<h3>New Products </h3>
	<hr class="soften"/>
		<div class="row-fluid">
		<div id="newProductCar" class="carousel slide">
            <div class="carousel-inner">
			<div class="item active">
			  <ul class="thumbnails">
			  <c1:forEach var="pro" items="${pro}">
				<li class="span3">
				<div class="thumbnail">
				
 		<a class="zoomTool" href="<c:url value="/addtocartC/${pro.getP_id()}"/>" title="add to cart"><span class="icon-shopping-cart"></span> Add to cart</a> 
					<a href="#" class="tag"></a> 
 					<a href="<c1:url value="/viewpro/${pro.getP_id()}"/>" title="quick view"> 
 					<img src="<c1:url value='/resource/images/${pro.getP_id()}.jpg'/>" alt="bootstrap-ring"></a> 
					<h3>${pro.getP_name()}            &nbsp;  &nbsp;  &nbsp; ${pro.getP_c()}</h3>
					
				</div>
				</li>
				</c1:forEach>
				
			  </ul>
			  </div>		
				</div>
		   </div>
		  <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a><!-- Cycling of images-->
            <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
		  </div>
		  </div>
				</div>
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/jquery.easing-1.3.min.js"></script>
    <script src="${js}/jquery.scrollTo-1.4.3.1-min.js"></script>
    <script src="${js}/shop.js"></script>
  </body>
</html>