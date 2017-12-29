<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script> -->
<!-- Body starts here -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="">Create Users</li>
				</ul><!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="page-header">
							<h1>Create User</h1>
						</div>
						<div class="page-body">
							<form:form modelAttribute="userForm" action="createUser" class="form-horizontal" method="Post" >
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Username</label>
									<div class="col-md-6">
										<form:input path="username" class="form-control validate" placeholder="Enter Username"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Password</label>
									<div class="col-md-6">
										<form:password path="password" class="form-control validate" placeholder="Enter Password"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">First Name</label>
									<div class="col-md-6">
										<form:input path="firstname" class="form-control validate onlyCharacters" placeholder="Enter First Name"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Last Name</label>
									<div class="col-md-6">
										<form:input path="lastname" class="form-control validate onlyCharacters" placeholder="Enter Last Name"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Mobile</label>
									<div class="col-md-6">
										<form:input path="mobilenumber" class="form-control validate numericOnly" placeholder="Enter Mobile Number"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Email</label>
									<div class="col-md-6">
										<form:input path="email" class="form-control" placeholder="Enter Email"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Designation</label>
									<div class="col-md-6">
										<form:select path="designation" class="form-control validate" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Designation --</form:option>
											<form:options items="${roles}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Department</label>
									<div class="col-md-6">
										<form:select path ="department" class="form-control validate" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Department --</form:option>
								     		<form:options items="${departments}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">ReportTo</label>
									<div class="col-md-6">
										<form:select path ="reportto" class="form-control validate" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Report to --</form:option>
								     		<form:options items="${userNames}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Enable</label>
									<div class="col-md-6">
										<form:checkbox  path="enabled" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-3 col-md-6">
										<input type="submit" id="submit1"  class="btn btn-success" value="Create"/>
										<input class="btn-danger btn cancel"  type="reset"  value="Reset" />
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content-inner -->
	</div>
	<!-- /.main-content -->

<!-- Body ends here -->

<script type="text/javascript">
$(".createUser").addClass("active");

//var username=$('#username').val();

$('#username').blur(function() {
var username=$(this).val();

$.ajax({
			type : "GET",
			url : "getUserName",
			data : {"username":username},
			dataType : "text",
			success : function(data) {
				if(data ==='true')
					{
					alert("username already exists")
 					$('#username').css('border-color', 'red');
					 $('#submit1').prop('disabled', true);
					}
				else
					{
					$('#username').css('border-color', 'none');
					$('#submit1').prop('disabled', false);
					}
				
			}
			
		});

	}); 
	
$('#designation').blur(function() {
	var role=$(this).val();
	if(role ===  '1')
		$('#reportto').prop('disabled', true);
	else
		$('#reportto').prop('disabled', false);
	
	
});
	
	
</script>