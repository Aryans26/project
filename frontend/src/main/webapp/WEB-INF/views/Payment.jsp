<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html><head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script>
 var app = angular.module('myApp', []);
 app.controller('myCtrl', function($scope, $http){
	 $http.get("http://localhost:8080/frontend/SendEmail")
	 });
 </script>
 

<body>		
<div class="container">
  <h2 class="text-center">Pay ment method</h2>
  <div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Cash on Delivery</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse in">
        <div class="panel-body">
        <c:url value="/payment" var="pa"/>
         <form:form action="${pa}" method="post" id="myForm">
<!--          <div class="checkbox"> -->
<!--   			<label>  -->
<!--           <input type="checkbox" value="1" name="payb" data-toggle="collapse" data-parent="#accordion" aria-expanded="true" aria-controls="collapseOne">Cash on Delivery -->
<!--           </label> -->
<!-- </div> -->
          
           <div class="form-group">
    <div class="checkbox">
        <label data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
            <input type="checkbox" value="1" name="payb" />Cash on Delivery
        </label>
    </div>
</div>
<div id="collapseOne" aria-expanded="false" class="collapse">
    <div class="well">Your one time password has been sent to your registered mail id.</div>
    Enter the otp:<input ng-app="myApp" ng-controller="myCtrl" type="text" name="otp">
</div>
<a href="<c:url value="/payment"/>"><input type="submit" class="subscribe btn btn-success btn-lg btn-block"  value="pay"></a>
		</form:form>
</div></div>
		</div>
      </div>
    </div>
    

             



</body>
</html>