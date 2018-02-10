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
							<h1>Create Ticket</h1>
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
										<form:select path="priority" class="col-xs-10 col-sm-5 validate" id="form-field-select-1">
											<<form:option value="" label="--- Select ---" />
											<form:options items="${priority}"></form:options>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> Assigned to </label>
									<div class="col-sm-9">
										<form:select path="assignto" class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)">
											<form:option value="" label="--- Select ---" />
										 	<form:options items="${userNames}"/>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-5">Summary</label>
									<div class="col-sm-9">
										<form:input path="subject"  placeholder="Summary" class="col-xs-10 col-sm-5 validate" />
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-5">Description</label>
									<div class="col-sm-9">
										<form:textarea path="description" class="col-xs-10 col-sm-5 validate" rows="4"></form:textarea>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="ace-file-input ace-file-multiple col-sm-3 control-label no-padding-right" >Attach File(s)</label>
									<div class="col-md-9">
										<input type="file" name="file" id="file" class="col-sm-9" multiple="multiple">
									</div>
								</div>
								<div class="space-2"></div>
								<div class="clearfix form-actions">
									<div class="form-group">
									<div class="col-md-offset-3 col-md-6">
										<input type="submit" id="submit1"  class="btn btn-success" value="Create"/>
										<input class="btn-danger btn cancel"  type="reset"  value="Reset" />
									</div>
								</div>
								</div>
								
											<input type="hidden" name="max_file_size" value="5000000" />
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






</script>