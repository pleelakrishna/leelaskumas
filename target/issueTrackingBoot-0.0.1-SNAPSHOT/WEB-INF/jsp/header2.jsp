<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <spring:url var="viewUsers" value="/viewUsers"></spring:url>   --%>
<%-- <spring:url var="viewReportIssues" value="/viewReportIssues"></spring:url>
<spring:url var="summary" value="/summary"></spring:url>
 --%>  
<!-- Header starts here -->
<%

	String baseurl =  request.getScheme() + "://" + request.getServerName() +  ":" +   request.getServerPort() +  request.getContextPath();
	session.setAttribute("baseurl", baseurl);

				 	HttpSession sess = request.getSession(false);
					 
					if (sess.getAttribute("cacheUserBean") == null) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/");
						dispatcher.forward(request, response);
					}
					/* else{
						 String testId = (String)sess.getAttribute("rolId");
						int rolid22 = Integer.parseInt(testId);
						 if (rolid22 != 1) {
							RequestDispatcher dispatcher = request.getRequestDispatcher("/HomePage");
							dispatcher.forward(request, response);
						}  
					} */
			%>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Kumar Ticket Tracking System</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/fonts/icomoon/icomoon.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<!--[if lt IE 9]>
			<script src="js/html5shiv.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->
<style type="text/css">
.impColor{color:red;}

.edit, .delete, .activate, .deactivate {cursor: pointer;}

span.has-error,span.hasError
{
  font-weight:normal;
  border-color: #e73d4a;
  color:red;
  margin-top: -3px;
  display: block !important;
  position: absolute;
}

.error{color: red; font-weight: bold;}

.alert-success, .alert-warning, .alert-danger{color: white !important;}
.alert-success{background-color: #4CAF50 !important;}
.alert-warning{background-color: #ff6600 !important;}
.alert-danger{background-color: #d43f3a !important;}

.your-class::-webkit-input-placeholder {color: #e73d4a !important;}
.your-class::-moz-placeholder {color: #e73d4a !important;}

.default-class::-webkit-input-placeholder {color: #e73d4a !important;}
.default-class::-moz-placeholder {color: #e73d4a !important;}
</style>
	<script>
		window.setTimeout(function() {
		    $(".msgcss").fadeTo(500, 0).slideUp(500, function(){
		        $(this).remove(); 
		    });
		}, 5000);
		$(document).ready(function(){
			$('.edit').attr('data-toggle','tooltip');
			$('.edit').attr('data-original-title','Edit');
			$('.delete').attr('data-toggle','tooltip');
			$('.delete').attr('data-original-title','Delete');
			$('.activate').attr('data-toggle','tooltip');
			$('.activate').attr('data-original-title','Activate');
			$('.deactivate').attr('data-toggle','tooltip');
			$('.deactivate').attr('data-original-title','Deactivate');
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
</head>
<body>
<header><a href="#" class="logo"><h2>KPTTS</h2></a>
  <ul id="header-actions" class="clearfix">
    <li class="list-box user-admin dropdown">
      <a id="drop4" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Admin</a>
      <ul class="dropdown-menu sm">
        <li class="dropdown-content">
        <a href="#">Edit Profile</a>
        <a href="#">Change Password</a>
        <a href="logoutHome">Logout</a></li>
      </ul>
    </li>
  </ul>
</header>
<div class="container-fluid">
  <nav class="navbar navbar-default">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapse-navbar" aria-expanded="false"><span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
    </div>
    <div class="collapse navbar-collapse" id="collapse-navbar">
      <ul class="nav navbar-nav">
        <li class="dashboard"><a href=""><i class="icon-blur_on"></i>Dashboard</a></li>
        <li class="users"><a href="viewUsers""><i class="icon-subtitles"></i>Users</a></li>
        <li class="tickets"><a href="viewReportIssues"><i class="icon-terrain"></i>Tickets</a></li>
        <li class="summary"><a href="summary"><i class="icon-business_center"></i>Summary</a></li>
        <!-- <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="icon-subtitles"></i>User <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/createUser">create user</a></li>
            <li><a href="/viewUsers">view users</a></li>
            <li><a href="#">Button sub</a></li>
          </ul>
        </li> -->
      </ul>
    </div>
  </nav>
</div>
  <!-- Header ends here -->