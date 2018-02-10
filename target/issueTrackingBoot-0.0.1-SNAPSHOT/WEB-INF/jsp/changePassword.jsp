<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

    
    <div class="clearfix"></div>
	<ol class="breadcrumb">
		<li><a href="#">Home</a></li>
		<li>Change Password</li>
	</ol>
	<div class="clearfix"></div>
<!-- Body starts here -->
	<!-- <div class="main-content"> -->
		<div class="main-content-inner">
       <div class="clearfix"></div>
		<br><br>
		<div class="col-md-12 col-xs-12">
			
				<%--<div class="page-content">
				<div class="row">
				 <div class="col-md-12 col-xs-12">
						<!-- <div class="page-header">
							<h1>Create User</h1>div
						</div> --><b></b>
						<div class="page-body">
							<form:form modelAttribute="userForm" action="createUser" class="form-horizontal" method="Post" >
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Username</label>
									<div class="col-md-6">
										<form:input path="username" class="form-control validate" placeholder="Enter Username"/>
									</div>
								</div>
								<div class="form-group" id="passwordDiv">
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
					</div> --%>
					
					<div class="col-md-12">
					<div class="panel panel-primary">
					<div class="panel-heading">
						<h4><i class="fa  fas fa-key "> Change Password</i>	</h4>
						<div class="options">
							<a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
						</div>
					</div>
					<div class="panel-body collapse in">
					
					<div class="page-body">
							<form:form  modelAttribute="changePassword" action="/changePassword" class="form-horizontal" method="Post"  >
							
										<div class="col-md-6">
											<div class="form-group" id="passwordDiv">
												<label class="col-md-3 control-label no-padding-right">Current
													Password</label>
												<div class="col-md-6">
													<form:password path="password"
														class="form-control validate" placeholder="Enter Password" />
												</div>
											</div>

										</div>
										<div class="col-md-6">
											<div class="form-group" id="passwordDiv">
												<label class="col-md-3 control-label no-padding-right">New
													Password</label>
												<div class="col-md-6">
													<form:password path="npassword"
														class="form-control validate"
														placeholder="Enter  New Password" />
												</div>
											</div>

										</div>
										<div class="col-md-6">
											<div class="form-group" id="passwordDiv">
												<label class="col-md-3 control-label no-padding-right">Confirm
													New Password</label>
												<div class="col-md-6">
													<form:password path="cpassword"
														class="form-control validate"
														placeholder="Re-Enter New Password" />
												</div>
											</div>

										</div>
								
								
								<div class="col-md-12" style="text-align:right;">
								<div class="form-group">
									<div class="col-md-offset-3 col-md-6">
										<input type="submit" id="submit3"  class="btn btn-success" value="Submit"/>
										<input class="btn-danger btn cancel"  type="reset"  value="Reset" />
									</div>
								</div></div>
								</form:form>
								</div>
								</div>
								
								</div>
					
					</div>
				</div>
			</div>
			<!-- /.page-content -->
		<!-- /.main-content-inner -->
	<!-- /.main-content -->
	
	<!-- /.main-content -->

<!-- Body ends here -->
<script type="text/javascript">
$("#submit3").click(function(e){
var npassword =$("#npassword").val();
var cpassword =$("#cpassword").val();
	if(npassword != cpassword){
		
		
		alert("Password Miss Matched");
		return false;
		 e.preventDefault();	
		 
	}
	validation = true;
	$.each(idArray, function(i, val) {
		var value = $("#" + idArray[i]).val();
		var placeholder = $("#" + idArray[i]).attr('placeholder');
		if (value == null || value == "" || value == "undefined") {
			$('style').append(styleBlock);
			$("#" + idArray[i] ).attr("placeholder", placeholder);
			$("#" + idArray[i] ).css('border-color','#e73d4a');
			$("#" + idArray[i] ).css('color','#e73d4a');
			$("#" + idArray[i] ).addClass('placeholder-style your-class');
			 var id11 = $("#" + idArray[i]+"_chosen").length;
			if ($("#" + idArray[i]+"_chosen").length)
			{
				$("#" + idArray[i]+"_chosen").children('a').css('border-color','#e73d4a');
			}
//			$("#" + idArray[i] + "Error").text("Please " + placeholder);
			validation = false;
		} 
	});
	if(validation) {
		$("#submit1").attr("disabled",true);
		$("#submit1").val("Please wait...");
		$("form").submit();											
		event.preventDefault();
	}else {
		return false;
		event.preventDefault();
	}
	
});
</script>
