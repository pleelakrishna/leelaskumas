<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- Body starts here -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="">Edit Ticket</li>
				</ul><!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="page-header">
							<h1>Edit Ticket</h1>
						</div>
						<div class="page-body">
							<form:form  action="updateIssue" method="post"  modelAttribute="cissue" class="form-horizontal" id="formEdit" enctype="multipart/form-data">
							<form:hidden path ="id"/> 
							 <input type="hidden" name="pagname" value=${pagname}>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Category </label> 
									<div class="col-sm-9">
										<form:select path="category"  class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)" >
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
										<form:select path="severity"  class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)">
										<form:option value="" label="--- Select ---" />
										 <form:options items="${severity}"/>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Priority </label>
									<div class="col-sm-9">
										<form:select path="priority"   class="col-xs-10 col-sm-5" id="form-field-select-1">
											<form:option value="" label="--- Select ---" />
											<form:options items="${priority}"></form:options>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> Assigned to </label>
									<div class="col-sm-9">
										<form:select path="assignto"  class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)">
											<form:option value="" label="--- Select ---" />
										 	<form:options items="${userNames}"/>
										</form:select>
									</div>
								</div>
								<%-- <div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-4">Department</label>
									<div class="col-sm-9">
										<form:select path="priority" disabled="true" class="col-xs-10 col-sm-5" id="form-field-select-1">
											<form:option value=""></form:option>
											<form:options items="${departments}"></form:options>
										</form:select>
									</div>
								</div> --%>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-5">Summary</label>
									<div class="col-sm-9">
										<form:input path="subject"    placeholder="Summary" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-5">Description</label>
									<div class="col-sm-9">
										<form:textarea path="description"   class="col-xs-10 col-sm-5" rows="4"></form:textarea>
									</div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> Status </label>
									<div class="col-sm-9">
										<form:select path="kstatus"  class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)">
											<form:option value="" label="--- Select ---" />
										 	<form:options items="${kpstatuses}"/>
										</form:select>
									</div>
								</div>
								<div class="space-2"></div>
								<!-- <div class="form-group">
									<label class="ace-file-input ace-file-multiple col-sm-3 control-label no-padding-right">Attach File(s)</label>
									<div class="col-md-9">
										<input type="file" name="file" id="file" class="col-sm-9">
									</div>
									<div> <img src=${cissue.uploadfile} alt="car_image" width="150" height="100"/> </div>
								</div> -->
								<div class="space-2"></div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-5">Add Note</label>
									<div class="col-sm-9">
										<form:textarea path="additionalinfo"  placeholder="write about your changes" class="col-xs-10 col-sm-5 validate" rows="4"></form:textarea>
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
										<input type="submit" id="submit1"  class="btn btn-success" value="Update"/>
										<input class="btn-danger btn cancel"  type="reset"  value="Reset" />
									</div>
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

	<link rel="stylesheet" type="text/css" href="http://charvikent.com/mantis/css/dropzone-4.3.0.min.css" />
<script type="text/javascript">
$(".createTicketIssues").addClass("active");
$(function(){
// 	 Dropzone.autoDiscover = false;
});

$('#kstatus').on('change',function() {
	
	var loginid=${cacheUserBean.id};
	var tassignby=${cissue.assignby};
	
	if($('#kstatus').val()=='1')
		{
		
	if( tassignby!= loginid)
		{
		
		alert("you are not authorized to close ticket");
		$('#kstatus').css('border-color', 'red');
		$('#kstatus').val("");
		return false;
		}
		}
});



$(document).ready(function() { 

	$('#formEdit')
	.each(function(){
		var x=$("#formEdit").serializeArray();
		$(this).data('serialized', $(this).serialize())
	})
    .on('change', function(){
    	var sub =$.trim($('#subject').val());
    	var des =$.trim($('#description').val());
    	var additionalinfo =$.trim($('#additionalinfo').val());
    	$('#subject').val(sub);
    	$('#description').val(des);
    	$('#additionalinfo').val(additionalinfo);
        $(this)				
           .find('#submit1')
                .attr('disabled', $(this).serialize() == $(this).data('serialized'));
     })
	.find('#submit1')
		.attr('disabled', true);

     
	 
	
});

</script>