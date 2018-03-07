<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url var="loginAction" value="/loginAction"></spring:url>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/img/favicon.ico">
<title>Kumar Ticket Tracking System</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/fonts/icomoon/icomoon.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.min.js"></script>
<script type ="text/javascript">
window.setTimeout(function() {
		    $(".msgcss").fadeTo(500, 0).slideUp(500, function(){
		        $(this).remove(); 
		    });
		}, 2000);
</script>
</head>
<body class="login-bg">

<form:form modelAttribute="adminForm" action="${loginAction}" class="form-horizontal" method="POST" >
  <div class="login-wrapper">
    <div class="login">
      <div class="login-header">
        <div class="logo"><img src="${pageContext.request.contextPath}/img/klogo.png" alt="Logo"></div>
        <h5>Login to access to your dashboard.</h5>
      </div>
      <c:if test="${not empty msg}">
								<div class="row">
									<div class="col-sm-4 col-sm-offset-4">
					                	<div class="form-group">
					                    	<div class="msgcss alert alert-${cssMsg} fadeIn animated" style="text-align: center;">${msg}</div>
					                    </div>
									</div>
								</div>
		</c:if>
      <div class="login-body">
     
        <div class="form-group">
          <label for="emailID">User Name</label>
          <form:input path="name" class="form-control" placeholder="user Name"/>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <form:password path="password" class="form-control" placeholder="Password"/>
        </div>
        <button class="btn btn-danger btn-block" type="submit">Sign in</button>
      </div>
       
     <!--  <div class="checkbox no-margin">
        <input type="checkbox" id="remember" checked="checked">
        <label for="remember">Remember me</label>
      </div> -->
    </div>
  </div>
</form:form>
</body>
</html>