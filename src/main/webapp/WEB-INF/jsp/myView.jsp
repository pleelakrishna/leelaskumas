<!-- Body starts here -->
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
					<li class="">View Users</li>
				</ul><!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="page-header">
							<h1>Reported By Me  
							</h1>
<!-- 							<a href="createUser" style="float: right;color: white;"> Add User</a> -->
						</div>
						<div class="page-body">
			            	<div id="assigned" class="widget-box widget-color-blue2">
								<div class="widget-header widget-header-small">
									<h4 class="widget-title lighter"><i class="ace-icon fa fa-list-alt"></i>
										<a class="white" href="">Reported By Me</a> 
									</h4>
									<div class="widget-toolbar">
										<a data-action="collapse" href="#">
											<i class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
										</a>
									</div>
									<div class="widget-toolbar no-border hidden-xs">
										<div class="widget-menu">
											<a class="btn btn-primary btn-white btn-round btn-sm" href="createTicketIssues">Create Issue</a>
										</div>
									</div>
								</div>
								<div style="display: block;" class="widget-body">
									<div class="widget-main no-padding">
										<div class="table-responsive">
											<table class="table table-bordered table-condensed table-striped table-hover">
												<tbody>
													<tr class="my-buglist-bug ">
													    <th class="nowrap width-13">Issue ID</th>
													    <th class="nowrap width-13">AssignTo</th>
														<!-- <th class="nowrap width-13">Created Time</th> -->
														<!-- <th class="nowrap width-13">Category</th> -->
														<th class="nowrap width-13">Severity</th>
														<th class="nowrap width-13">Priority</th>
														<th class="nowrap width-13">Attachment</th>
														<th class="nowrap width-13">Subject</th>
														<!-- <th class="nowrap width-13">UpdatedTime</th> -->
														<!-- <th class="nowrap width-13">Options</th> -->
													</tr>
												
													<c:forEach var="issue" items="${reportedByMe}">
													<tr class="my-buglist-bug ">
														<td class="nowrap width-13">${issue.id  }</td>
														<td class="nowrap width-13">${issue.assignto }</td>
														<td class="nowrap width-13">${issue.severity}</td>
														<td class="nowrap width-13">${issue.priority}</td>
														<td class="nowrap width-13">${issue.uploadfile}</td>
														<td class="nowrap width-13">${issue.subject}</td>
													</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>	
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="page-header">
							<h1>Assigned to Me  
							</h1>
<!-- 							<a href="createUser" style="float: right;color: white;"> Add User</a> -->
						</div>
						<div class="page-body">
			            	<div id="assigned" class="widget-box widget-color-blue2">
								<div class="widget-header widget-header-small">
									<h4 class="widget-title lighter"><i class="ace-icon fa fa-list-alt"></i>
										<a class="white" href="">Assigned  to Me</a> 
									</h4>
									<div class="widget-toolbar">
										<a data-action="collapse" href="#">
											<i class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
										</a>
									</div>
									<div class="widget-toolbar no-border hidden-xs">
										<div class="widget-menu">
											<a class="btn btn-primary btn-white btn-round btn-sm" href="createTicketIssues">Create Issue</a>
										</div>
									</div>
								</div>
								<div style="display: block;" class="widget-body">
									<div class="widget-main no-padding">
										<div class="table-responsive">
											<table class="table table-bordered table-condensed table-striped table-hover">
												<tbody>
													<tr class="my-buglist-bug ">
													    <th class="nowrap width-13">Issue ID</th>
													    <th class="nowrap width-13">AssignBy</th>
														<!-- <th class="nowrap width-13">Created Time</th> -->
														<!-- <th class="nowrap width-13">Category</th> -->
														<th class="nowrap width-13">Severity</th>
														<th class="nowrap width-13">Priority</th>
														<th class="nowrap width-13">Attachment</th>
														<th class="nowrap width-13">Subject</th>
														<!-- <th class="nowrap width-13">UpdatedTime</th> -->
														<!-- <th class="nowrap width-13">Options</th> -->
													</tr>
												
													<c:forEach var="issue" items="${assignToMe}">
													<tr class="my-buglist-bug ">
														<td class="nowrap width-13">${issue.id  }</td>
														<td class="nowrap width-13">${issue.assignby }</td>
														<td class="nowrap width-13">${issue.severity}</td>
														<td class="nowrap width-13">${issue.priority}</td>
														<td class="nowrap width-13">${issue.uploadfile}</td>
														<td class="nowrap width-13">${issue.subject}</td>
													</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>	
						</div>
					</div>
				</div>
			</div>
			<!-- /.page-content -->
			<div class="row">
							<div class="col-lg-7 col-xs-12">
							<div id="assigned" class="widget-box widget-color-blue2">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-list-alt"></i>
<a class="white" href="#">Assigned to Me </a> <span class="badge">    </span>		</h4>
		<div class="widget-toolbar">
			<a data-action="collapse" href="#">
				<i class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
			</a>
		</div>
		<div class="widget-toolbar no-border hidden-xs">
			<div class="widget-menu">
				<a class="btn btn-primary btn-white btn-round btn-sm" href="#">View Issues</a>			</div>
		</div>
	</div>

	<div style="display: block;" class="widget-body">
		<div class="widget-main no-padding">
			<div class="table-responsive">
				<table class="table table-bordered table-condensed table-striped table-hover">
<tbody>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">Sl.No		</td>

		<td>
		<span><a href="#">All Fields</a></span>
        </td>
</tr>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">
		1</td>

		<td>
		<span><a href="#">All Fields</a></span>	</td>
</tr>
<tr class="my-buglist-bug ">
		<td class="nowrap width-13">Sl.No		</td>

		<td>
		<span><a href="#">All Fields</a></span>
        </td>
</tr>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">
		1</td>

		<td>
		<span><a href="#">All Fields</a></span>	</td>
</tr>


</tbody>
</table>
</div>
</div>
</div>
</div>	

<div class="space-10"></div>


<div id="assigned" class="widget-box widget-color-blue2">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-list-alt"></i>
<a class="white" href="#">Reported By Me</a> <span class="badge">   </span>		</h4>
		<div class="widget-toolbar">
			<a data-action="collapse" href="#">
				<i class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
			</a>
		</div>
		<div class="widget-toolbar no-border hidden-xs">
			<div class="widget-menu">
				<a class="btn btn-primary btn-white btn-round btn-sm" href="#">View Issues</a>			</div>
		</div>
	</div>

	<div style="display: block;" class="widget-body">
		<div class="widget-main no-padding">
			<div class="table-responsive">
				<table class="table table-bordered table-condensed table-striped table-hover">
<tbody>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">Sl.No		</td>

		<td>
		<span><a href="#">All Fields</a></span>
        </td>
</tr>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">
		1</td>

		<td>
		<span><a href="#">All Fields</a></span>	</td>
</tr>
<tr class="my-buglist-bug ">
		<td class="nowrap width-13">Sl.No		</td>

		<td>
		<span><a href="#">All Fields</a></span>
        </td>
</tr>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">
		1</td>

		<td>
		<span><a href="#">All Fields</a></span>	</td>
</tr>


</tbody>
</table>
</div>
</div>
</div>
</div>
<div class="space-10"></div>


<div id="assigned" class="widget-box widget-color-blue2">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-list-alt"></i>
<a class="white" href="#">Monitored by Me</a> <span class="badge">   </span>		</h4>
		<div class="widget-toolbar">
			<a data-action="collapse" href="#">
				<i class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
			</a>
		</div>
		<div class="widget-toolbar no-border hidden-xs">
			<div class="widget-menu">
				<a class="btn btn-primary btn-white btn-round btn-sm" href="#">View Issues</a>			</div>
		</div>
	</div>

	<div style="display: block;" class="widget-body">
		<div class="widget-main no-padding">
			<div class="table-responsive">
				<table class="table table-bordered table-condensed table-striped table-hover">
<tbody>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">Sl.No		</td>

		<td>
		<span><a href="#">All Fields</a></span>
        </td>
</tr>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">
		1</td>

		<td>
		<span><a href="#">All Fields</a></span>	</td>
</tr>
<tr class="my-buglist-bug ">
		<td class="nowrap width-13">Sl.No		</td>

		<td>
		<span><a href="#">All Fields</a></span>
        </td>
</tr>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">
		1</td>

		<td>
		<span><a href="#">All Fields</a></span>	</td>
</tr>


</tbody>
</table>
</div>
</div>
</div>
</div>
							</div>
                            
                            
                            <div class="col-lg-5 col-xs-12">
							<div id="assigned" class="widget-box widget-color-blue2">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-list-alt"></i>
<a class="white" href="#">Resolved</a> <span class="badge">    </span>		</h4>
		<div class="widget-toolbar">
			<a data-action="collapse" href="#">
				<i class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
			</a>
		</div>
		<div class="widget-toolbar no-border hidden-xs">
			<div class="widget-menu">
				<a class="btn btn-primary btn-white btn-round btn-sm" href="#">View Issues</a>			</div>
		</div>
	</div>

	<div style="display: block;" class="widget-body">
		<div class="widget-main no-padding">
			<div class="table-responsive">
				<table class="table table-bordered table-condensed table-striped table-hover">
<tbody>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">Sl.No		</td>

		<td>
		<span><a href="#">All Fields</a></span>
        </td>
</tr>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">
		1</td>

		<td>
		<span><a href="#">All Fields</a></span>	</td>
</tr>
<tr class="my-buglist-bug ">
		<td class="nowrap width-13">Sl.No		</td>

		<td>
		<span><a href="#">All Fields</a></span>
        </td>
</tr>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">
		1</td>

		<td>
		<span><a href="#">All Fields</a></span>	</td>
</tr>


</tbody>
</table>
</div>
</div>
</div>
</div>	

<div class="space-10"></div>


<div id="assigned" class="widget-box widget-color-blue2">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-list-alt"></i>
<a class="white" href="#">Recently Modified(30 days) </a> <span class="badge">    </span>		</h4>
		<div class="widget-toolbar">
			<a data-action="collapse" href="#">
				<i class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
			</a>
		</div>
		<div class="widget-toolbar no-border hidden-xs">
			<div class="widget-menu">
				<a class="btn btn-primary btn-white btn-round btn-sm" href="#">View Issues</a>			</div>
		</div>
	</div>

	<div style="display: block;" class="widget-body">
		<div class="widget-main no-padding">
			<div class="table-responsive">
				<table class="table table-bordered table-condensed table-striped table-hover">
<tbody>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">Sl.No		</td>

		<td>
		<span><a href="#">All Fields</a></span>
        </td>
</tr>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">
		1</td>

		<td>
		<span><a href="#">All Fields</a></span>	</td>
</tr>
<tr class="my-buglist-bug ">
		<td class="nowrap width-13">Sl.No		</td>

		<td>
		<span><a href="#">All Fields</a></span>
        </td>
</tr>

<tr class="my-buglist-bug ">
		<td class="nowrap width-13">
		1</td>

		<td>
		<span><a href="#">All Fields</a></span>	</td>
</tr>


</tbody>
</table>
</div>
</div>
</div>
</div>

<div class="space-10"></div>


<div id="assigned" class="widget-box widget-color-blue2">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-list-alt"></i>
<a class="white" href="#">Timeline</a> <span class="badge">   </span>		</h4>
		<div class="widget-toolbar">
			<a data-action="collapse" href="#">
				<i class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
			</a>
		</div>
		<div class="widget-toolbar no-border hidden-xs">
			<div class="widget-menu">
				<a class="btn btn-primary btn-white btn-round btn-sm" href="#">View Issues</a>			</div>
		</div>
	</div>

	<div style="display: block;" class="widget-body">
		<div class="widget-main no-padding">
			<div class="table-responsive">
		
				<table class="table table-bordered table-condensed table-striped table-hover">
				<thead>
				<tr>
				<th>Days</th>
				<th>Open</th>
				
				</tr>
				
				</thead>
<tbody>

<c:forEach var="issue" items="${gapAndCount}">
<tr class="my-buglist-bug ">
		<td class="nowrap width-13">${issue.key} 
		</td>
		<td>
		<span><a href="#">${issue.value }</a></span>
        </td>
    
</tr>
</c:forEach>


</tbody>
</table>
</div>
</div>
</div>
</div>
							</div>





							</div>
		</div>
		<!-- /.main-content-inner -->
	</div>

<script type="text/javascript">
$(".myView").addClass("active");
$(document).ready(function(){
$('.myView').on('click', function(){
	alert('onclick is working.');
	console.log("write your code hee") 
	console.log("cacheUserBean") 
});
});

</script>