<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Body starts here -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="">Edit Users</li>
				</ul><!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="page-header">
							<h1>Edit User</h1>
						</div>
						<div class="page-body">
							<form:form action="editUser" method="post" modelAttribute="users" class="form-horizontal" >
							<form:hidden path ="id"/> 
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Username</label>
									<div class="col-md-6">
										<form:input path="username" readonly="true"  class="form-control validate" placeholder="Enter Username"/>
									</div>
								</div>
									<c:if test="${cacheUserBean.designation != 1}">
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Current Password</label>
									<div class="col-md-6">
										<form:password path="password" class="form-control" placeholder="Enter Password"/>
									</div>
								</div>
								</c:if>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">New Password</label>
									<div class="col-md-6">
										<form:password path="npassword" class="form-control validate" placeholder="Enter new Password"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Conform Password</label>
									<div class="col-md-6">
										<form:password path="cpassword" class="form-control validate" placeholder="Enter conform Password"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">First Name</label>
									<div class="col-md-6">
										<form:input path="firstname"  readonly="${flag}" class="form-control validate onlyCharacters" placeholder="Enter First Name"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Last Name</label>
									<div class="col-md-6">
										<form:input path="lastname" readonly="${flag}" class="form-control validate onlyCharacters" placeholder="Enter Last Name"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Mobile</label>
									<div class="col-md-6">
										<form:input path="mobilenumber" readonly="${flag}" class="form-control validate numericOnly" placeholder="Enter Mobile Number"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Email</label>
									<div class="col-md-6">
										<form:input path="email" readonly="${flag}"  class="form-control" placeholder="Enter Email"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Designation</label>
									<div class="col-md-6">
										<form:select path="designation" disabled="${flag}"  class="form-control validate" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Designation --</form:option>
											<form:options items="${roles}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Department</label>
									<div class="col-md-6">
										<form:select path ="department"  disabled="${flag}" class="form-control validate" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Department --</form:option>
								     		<form:options items="${departments}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Report to</label>
									<div class="col-md-6">
										<form:select path ="reportto"  disabled="${flag}" class="form-control validate" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Reportto --</form:option>
								     		<form:options items="${userNames}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Enable</label>
									<div class="col-md-6">
										<form:checkbox  path="enabled" disabled="${flag}" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-3 col-md-6">
										<input type="submit" id="submit1" class="btn btn-success" value="Update"/>
										<input class="btn-danger btn cancel" type="reset"  value="Reset" />
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
var cuid=$('#id').val();
$('#password').blur(function() {
var cpwd=$(this).val();

$.ajax({
			type : "GET",
			url : "getCurrentpwd",
			data : {"cpwd":cpwd, "cuid":cuid},
			dataType : "text",
			beforeSend : function() {
	             $.blockUI({ message: 'Please wait' });
	          }, 
			success : function(data) {
				console.log(data);
				
				if(data!=cpwd)
					{
					alert("Enter valid password")
 					$('#password').css('border-color', 'red');
				$('#password').val("");
					}
				
			},
          complete: function () {
	            
	            $.unblockUI();
	       },
			error :  function(e){$.unblockUI();console.log(e);}
			
		});

	}); 
	
	
$('#cpassword').blur(function() {
	if($('#npassword').val()!=$('#cpassword').val())
		{
		alert("Conform password and new password doesn't match")
		$('#cpassword').css('border-color', 'red');
		$('#npassword').css('border-color', 'red');
		$('#cpassword').val("");
		$('#npassword').val("");
		
		}
})
	

	
	
	</script>
