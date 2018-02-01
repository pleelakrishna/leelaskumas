<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- Body starts here -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="">View Ticket</li>
				</ul><!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="page-header">
							<h1>View Ticket</h1>
						</div>
						<div class="page-body">
							<form:form  action="myView" modelAttribute="cissue" class="form-horizontal" enctype="multipart/form-data">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Category </label>
									<div class="col-sm-9">
										<form:select path="category" disabled="true" class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)" >
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
										<form:select path="severity" disabled="true" class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)">
										<form:option value="" label="--- Select ---" />
										 <form:options items="${severity}"/>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Priority </label>
									<div class="col-sm-9">
										<form:select path="priority"  disabled="true" class="col-xs-10 col-sm-5" id="form-field-select-1">
											<form:option value=""></form:option>
											<form:options items="${priority}"></form:options>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> Assigned to </label>
									<div class="col-sm-9">
										<form:select path="assignto" disabled="true" class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)">
											<form:option value="" />
										 	<form:options items="${userNames}"/>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<%-- <div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-4">Department</label>
									<div class="col-sm-9">
										<form:select path="department" disabled="true" class="col-xs-10 col-sm-5" id="form-field-select-1">
											<form:option value=""></form:option>
											<form:options items="${departments}"></form:options>
										</form:select>
									</div>
								</div> --%>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-5">Summary</label>
									<div class="col-sm-9">
										<form:input path="subject"  readonly="true"  placeholder="Summary" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-5">Description</label>
									<div class="col-sm-9">
										<form:textarea path="description"  readonly="true" class="col-xs-10 col-sm-5" rows="4"></form:textarea>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> Status </label>
									<div class="col-sm-9">
										<form:select path="kstatus"  disabled="true"  class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)">
											<form:option value="" />
										 	<form:options items="${kpstatuses}"/>
										</form:select>
									</div>
								</div>
								<!-- <div class="form-group">
									<label class="ace-file-input ace-file-multiple col-sm-3 control-label no-padding-right">Attach File(s)</label>
									<div class="col-md-9">
										<input type="file" name="file" id="file" class="col-sm-9">
									</div>
									<div> <img src=${cissue.uploadfile} alt="car_image" width="150" height="100"/> </div>
								</div> -->
								<div class="space-2"></div>
									<div class="col-md-offset-3 col-md-9">
							<input type="submit" id="submit1" class="btn btn-info" value="Back"/>
										
								</div>

							</form:form>
							
								

						<div class="row">
							<div class="col-lg-12 col-xs-12">
							<div id="assigned" class="widget-box widget-color-blue2">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-history"></i>
<a class="white" href="#">Issue History</a> 		</h4>
		<div class="widget-toolbar">
			<a data-action="collapse" href="#">
				<i class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
			</a>
		</div>
		<div class="widget-toolbar no-border hidden-xs">
			<div class="widget-menu">
     		</div>
		</div>
	</div>

	<div style="display: block;" class="widget-body">
		<div class="widget-main no-padding">
			<div class="table-responsive">
				<table class="table table-bordered table-condensed table-striped table-hover">
<tbody>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">Date Modified</td>
        <td class="nowrap width-13">User Name</td>
        <td class="nowrap width-13">Attachment</td>
        <td class="nowrap width-13">Change</td>
</tr>
<c:forEach var="logs" items="${repeatLogs}">
<tr class="my-buglist-bug ">
		

		<td>
     	<span><a href="#">${logs.statustime}</a></span>	</td>
     	<td class="nowrap width-13">${logs.issueid}</td>
     	<td class="nowrap width-13">
     	<c:forTokens items="${logs.uploadfiles}" delims="*" var="mySplit">
     	<a class="attachments" target="_blank" href="leeladocs/${mySplit}"><i class="fa fa-paperclip fa-lg grey" title="${mySplit}"></i></a>
     	</c:forTokens>
     	</td>
     	
     	<td class="nowrap width-13">  ${logs.description}</td>
     	
</tr>
  </c:forEach>
</tbody>
</table>
</div>
</div>
</div>
</div>	


							</div>





							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
								
								
						</div>
					</div>
				</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content-inner -->
	
	<!-- /.main-content -->

<!-- Body ends here -->

	<link rel="stylesheet" type="text/css" href="http://charvikent.com/mantis/css/dropzone-4.3.0.min.css" />
<script type="text/javascript">
$(".createTicketIssues").addClass("active");
/* $(function(){
	 Dropzone.autoDiscover = false;
}); */

</script>