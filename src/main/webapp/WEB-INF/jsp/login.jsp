<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url var="loginAction" value="/loginAction"></spring:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>KPTMS</title>
    <link rel="shortcut icon" href="img/klogo.png"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="assets/css/styles.css">
<!--     <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600' rel='stylesheet' type='text/css'> -->
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries. Placeholdr.js enables the placeholder attribute -->
    <!--[if lt IE 9]>
        <script type="text/javascript" src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.1.0/respond.min.js"></script>
        <script type="text/javascript" src="assets/plugins/charts-flot/excanvas.min.js"></script>
    <![endif]-->

    <!-- The following CSS are included as plugins and can be removed if unused-->

<link rel='stylesheet' type='text/css' href='assets/plugins/charts-morrisjs/morris.css' /> 
<link rel='stylesheet' type='text/css' href='assets/plugins/codeprettifier/prettify.css' /> 
<link rel='stylesheet' type='text/css' href='assets/plugins/form-toggle/toggles.css' /> 
<link rel='stylesheet' type='text/css' href='assets/plugins/datatables/dataTables.css' />

<style type="text/css">
.alert-success, .alert-warning, .alert-danger{color: white !important;}
.alert-success{background-color: #4CAF50 !important;}
.alert-warning{background-color: #ff6600 !important;}
.alert-danger{background-color: #d43f3a !important;}

.your-class::-webkit-input-placeholder {color: #e73d4a !important;}
.your-class::-moz-placeholder {color: #e73d4a !important;}

.default-class::-webkit-input-placeholder {color: #e73d4a !important;}
.default-class::-moz-placeholder {color: #e73d4a !important;}
</style>

<script type='text/javascript' src='assets/js/jquery-1.10.2.min.js'></script>
<script type="text/javascript">
window.setTimeout(function() {
    $(".msgcss").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 5000);
</script>

</head>

<body class="focusedform">
<div class="verticalcenter">
<div><img src="assets/img/klogo.png" class="img-responsive"></div>
<!-- 	<h1 align="center">KHAIBAR GAS</h1> -->
	<div class="panel panel-primary">
		<form:form modelAttribute="adminForm" action="${loginAction}" class="form-horizontal" method="POST"  style="margin-bottom: 0px !important;">
		<div class="panel-body">
			<h4 class="text-center" style="margin-bottom: 25px;">Login to get started</h4>
			<c:if test="${not empty msg}">
				<div class="col-sm-12" style="margin-bottom: -1.3em;">
					<div class="form-group">
						<div class="msgcss fadeIn animated alert alert-danger" style="text-align: center;">${msg}</div>
					</div>
				</div>
			</c:if>
			<div class="form-group">
				<div class="col-sm-12">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<form:input path="name" class="form-control validate"  placeholder="Username"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<form:password path="password" class="form-control validate"  placeholder="Password"/>
					</div>
				</div>
			</div>
			<!-- <div class="clearfix">
				<div class="pull-right"><label><input type="checkbox" style="margin-bottom: -5px;"> Remember Me</label></div>
			</div> -->
		</div>
		<div class="panel-footer">
			<div class="pull-right">
				<input type="reset" value="Reset" class="btn btn-default cancel"/>
				<input type="submit" value="Login" id="submit1" class="btn btn-primary">
			</div>
		</div>
		</form:form>
	</div>
</div>
<script type='text/javascript' src='js/customValidation.js'></script> 
</body>
</html>