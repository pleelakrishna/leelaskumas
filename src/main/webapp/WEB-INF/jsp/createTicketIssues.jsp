<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<!-- Body starts here -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="">Create Ticket</li>
				</ul><!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
				<div class="row">
					<c:if test="${not empty msg}">
						<div class="row">
							<div class="col-sm-4 col-sm-offset-4">
			                	<div class="form-group">
			                    	<div class="msgcss alert alert-${cssMsg} fadeIn animated" style="text-align: center;">${msg}</div>
			                    </div>
							</div>
						</div>
		            </c:if>
					<div class="col-md-12 col-xs-12">
						<div class="page-header">
							<h1>Create User</h1>
						</div>
						<div class="page-body">
							<form:form action="createTicketIssues" method="post" modelAttribute="createTicketIssues" class="form-horizontal" enctype="multipart/form-data">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Category </label>
									<div class="col-sm-9">
										<form:select path="category" class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)" >
											<form:option value="" label="--- Select ---" />
											<form:options items="${category}"/>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<!-- <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Reproductability </label>
										<div class="col-sm-9">
											<select class="col-xs-10 col-sm-5" id="form-field-select-1" >
												<option value="">-- Select --</option>
												<option value="">Admin</option>
												<option value="">Manager</option>
												<option value="">Sales Man</option>
												<option value="">Technician</option>
												<option value="">Office Staff</option>
												<option value="">Others</option>
											</select>
										</div>
								</div> -->
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Severity </label>
									<div class="col-sm-9">
										<form:select path="severity" class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)">
										<form:option value="" label="--- Select ---" />
										 <form:options items="${severity}"/>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Priority </label>
									<div class="col-sm-9">
										<form:select path="priority" class="col-xs-10 col-sm-5" id="form-field-select-1">
											<form:option value=""></form:option>
											<form:options items="${priority}"></form:options>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> Assigned to </label>
									<div class="col-sm-9">
										<form:select path="assignto" class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)">
											<form:option value="" />
										 	<form:options items="${userNames}"/>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-4">Department</label>
									<div class="col-sm-9">
										<form:select path="priority" class="col-xs-10 col-sm-5" id="form-field-select-1">
											<form:option value=""></form:option>
											<form:options items="${departmentNames}"></form:options>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-5">Summary</label>
									<div class="col-sm-9">
										<input type="text" id="form-field-1" placeholder="Summary" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-5">Description</label>
									<div class="col-sm-9">
										<form:textarea path="description" class="col-xs-10 col-sm-5" rows="4"></form:textarea>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="ace-file-input ace-file-multiple col-sm-3 control-label no-padding-right">Attach File(s)</label>
									<div class="col-md-9">
										<input type="file" name="file" id="file" class="col-sm-9">
									</div>
									<!-- <div class="col-md-9">
										<label class="ace-file-input ace-file-multiple " id="ace-file-multiple"> 
											<input type="file" id="documents" class="col-sm-9">
											<span class="ace-file-container" data-title="Drop files here or click to choose">
												<span class="ace-file-name" data-title="No File ...">
													<i class=" ace-icon ace-icon fa fa-cloud-upload"></i>
												</span>
											</span>
											<a class="remove" href="#"><i class=" ace-icon fa fa-times"></i></a>
										</label>
									</div> -->
								</div>
								<div class="space-2"></div>
								<div class="clearfix form-actions">
									<div class="col-md-offset-3 col-md-9">
<!-- 										<button class="btn btn-info" type="button"> -->
<!-- 											<i class="ace-icon fa fa-check bigger-110"></i> Submit -->
<!-- 										</button> -->
							<input type="submit" id="submit1" class="btn btn-danger" value="Submit"/>
										&nbsp; &nbsp; &nbsp;
										<button class="btn" type="reset">
											<i class="ace-icon fa fa-undo bigger-110"></i> Reset
										</button>
									</div>
								</div>
								
											<input type="hidden" name="max_file_size" value="5000000" />
			<!-- <div class="dropzone center" data-force-fallback="false"
	data-max-filesize="5"
	data-accepted-files=""
	data-default-message="Drop files here to upload (or click)"
	data-fallback-message="Your browser does not support drag'n'drop file uploads."
	data-fallback-text=""
	data-file-too-big="File is too big ({{filesize}}MiB). Max filesize: {{maxFilesize}}MiB."
	data-invalid-file-type="You cannot upload files of this type."
	data-response-error="Server responded with {{statusCode}} code."
	data-cancel-upload="Cancel upload"
	data-cancel-upload-confirmation="Are you sure you want to cancel this upload?"
	data-remove-file="Remove file"
	data-remove-file-confirmation=""
	data-max-files-exceeded="You cannot upload any more files."
	data-dropzone-not-supported="Dropzone.js does not support older browsers!">
				<i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i><br>
				<span class="bigger-150 grey">Drop files here to upload (or click)</span>
				<div id="dropzone-previews-box" class="dropzone-previews dz-max-files-reached"></div>
			</div>
			<div class="fallback">
				<div class="dz-message" data-dz-message></div>
			<input tabindex="15" id="ufile[]" name="ufile[]" type="file" size="60" />
			</div> -->
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

	<link rel="stylesheet" type="text/css" href="http://charvikent.com/mantis/css/dropzone-4.3.0.min.css" />
<script type="text/javascript">
$(".createTicketIssues").addClass("active");
$(function(){
	 Dropzone.autoDiscover = false;
})
</script>