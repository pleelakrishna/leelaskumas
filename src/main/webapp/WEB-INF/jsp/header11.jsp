<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<title>Kumar Pumps Ticket Management System</title>

<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${baseurl}/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts.googleapis.com.css" />

		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!--[if !IE]> -->
		<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.min.js"></script>
		<![endif]-->
		
		<!-- ace settings handler -->
		<script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>

		<!--[if lte IE 8]>
		<script src="${pageContext.request.contextPath}/assets/js/html5shiv.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/respond.min.js"></script>
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
<body class="no-skin">
	<div id="navbar" class="navbar navbar-default ace-save-state" style="position: fixed;
    width: 100%;
    z-index: 1000;">
		<div class="navbar-container ace-save-state" id="navbar-container">
			<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"><img src="img/kumar_logo.png" style="height: 26px;"/></a>
			</div>
			<div >
				<a href="#" class="navbar-brand">Kumar Pumps - Ticket Management System</a>
			</div>

			<div class="navbar-buttons navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="blue "><a href="createTicketIssues">Create Ticket</a></li>
					<li class="blue">
						<a data-toggle="dropdown" href="#" class="dropdown-toggle">
							Hi ${cacheUserBean.username}<i class="ace-icon fa fa-caret-down"></i>
						</a>

						<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="profile"><i class="ace-icon fa fa-user"></i>Profile</a></li>
							<li class="divider"></li>
							<li><a href="logoutHome"><i class="ace-icon fa fa-power-off"></i>Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div><!-- /.navbar-container -->
	</div>
<!-- Header ends here -->





