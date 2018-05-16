<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style type="text/css">
.fa-square:before {
    content: "\f0c8";
}
.fa-status-box {
    font-size: 1.8em;
    line-height: 0.73em;
    vertical-align: -25%;
}
.status-90-color {
    color: #c9ccc4 !important;
    background-color: #c9ccc4;
}
.status-10-color {
    color: #fcbdbd !important;
    background-color: #fcbdbd;
}
.status-80-color {
    color: #d2f5b0 !important;
    background-color: #d2f5b0;
}
.panel-body {

	border: 1px solid #4f8edc !important;
	padding: 0px !important;
}
.btn-white.btn-primary.active, .btn-white.btn-primary:active, .btn-white.btn-primary:focus, .btn-white.btn-primary:hover, .open>.btn-white.btn-primary.active.dropdown-toggle, .open>.btn-white.btn-primary.dropdown-toggle {
    background-color: #eaf2f8!important;
    border-color: #8aafce !important;
    color: #537c9f!important;
}
.widget-toolbox {
    background-color: #EEE;
}
.widget-toolbox.padding-8 {
    padding: 8px;
}

.widget-toolbox:first-child {
    padding: 2px;
    border-bottom: 1px solid #CCC;
}
.btn-sm {
	margin:8px;
	letter-spacing: 1px;
	line-height: 1.6;
}
th {
 background:#006699;color: #fff;
 }
</style>

<!-- Body starts here -->

	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><a href="dashBoard">Home</a></li>
					<li><a href="task">Task</a></li>
					<li>View Ticket</li>
				</ul><!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
				<div class="row">
				
				<!-- view-->
			<div class="container">
				<div class="col-md-12">
				<div class="panel panel-primary">
					<div style="margin:0 auto;" class="panel-heading">
						<h4><i class="ace-icon fa fa-bars"></i></i> View Task Details</h4>
						<div class="options">
							<a href="" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
						</div>
					</div>
					<div class="panel panel-body collapse in">
						<div class="widget-toolbox padding-8 clearfix noprint">
							<!-- <div class="btn-group pull-left">
							<a class="btn btn-primary  btn-round btn-sm" href="">Wiki</a><a class="btn btn-success  btn-round btn-sm" href="">Jump to Notes</a><a class="btn btn-warning  btn-round btn-sm" href="#history">Jump to History</a></div><div class="btn-group pull-right"></div></div><div class="clearfix"></div> -->
						<br>
						<div class="col-md-2"></div>
						<div class="col-md-8">
						<div class="table-responsive">
							<table class="table table-bordered table-condensed  table-striped table-hover" style=" ">
				<c:forEach var="cissue" items="${clist}">	
							<tr>
<th style="width:20%;">Task Number</th><td style="width:80%;">${cissue.taskno}</td></tr>
<tr><th>Summary</th><td>${cissue.subject}</td></tr>
<tr><th>Category</th><td>${cissue.category}</td></tr>
<tr><th>Priority</th><td>${cissue.severity}</td></tr>
<tr><th>Description</th><td>${cissue.description}</td></tr>
<tr><th>Assigned to </th><td>${cissue.assignto}</td></tr>
<tr><th>Assigned by </th><td>${cissue.assignby}</td></tr>
<tr><th>Task DeadLine</th><td>${cissue.taskdeadline}</td>
<tr><th>Attach Files</th><td>${cissue.uploadfile}</td></tr>
								
</c:forEach>


								</table>
			
</div>
</div>
	<div class="col-md-2"></div>
</div>

				</div>
							</div>
							<div align="center" style="margin-bottom:15px;" class="col-md-12">
							<button onclick="goBack()" class="btn btn-primary"> <i class="fa fa-step-backward"></i> Back  </button></div>
							</div>
						
				
                
                <div class="col-md-12" id="history">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4><i class="ace-icon fa fa-history"></i> Task History</h4>
						<div class="options">
							<a href="" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
						</div>
					</div>
					<div class="panel panel-body collapse in">
												<div class="table-responsive">
							<table class="table table-bordered table-condensed  table-striped table-hover" style=" ">
								<tr style="background:#006699;color: #fff;">
<th>Last Updated</th><th>User Name</th><th>Attachment</th><th>field</th><th>Change</th>
								</tr>
								
<c:forEach var="logs" items="${repeatLogs1}">								
								<tr>
<td> ${logs.createdTime}</td><td>${logs.changedby}</td>
<%-- <td>${logs.kpstatus}</td> --%>
<td>


<c:forTokens items="${logs.uploadfiles}" delims="*" var="mySplit">
     	<a class="attachments" target="_black" href="reportDocuments/${mySplit}"><i class="fa fa-download" title="${mySplit}"></i></a>
     	</c:forTokens>
  

</td><td>${logs.kpfield}</td>
</td><td>${logs.kpchange}</td>


</tr>

</c:forEach>
								</table>
			
</div>


</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content-inner -->
	</div>
	</div>
    
		       <!--view end-->
					<%-- <div class="col-md-12 col-xs-12">
						<div class="page-header">
							<h1>View Ticket</h1>
						</div>
						<div class="page-body">
							
							<div style="display: block;max-height:300px;overflow:auto;"  class="widget-body">
									<div class="widget-main no-padding">
										<div class="table-responsive">
											<table class="table table-bordered table-condensed table-striped table-hover fixed">
												<tbody >
													<tr  class="my-buglist-bug success ">
													
														<th class="nowrap width-8">Username</th>
														<th class="nowrap width-13">E-mail</th>
														<th class="nowrap width-13">Mobile</th>
														<th class="nowrap width-13">Designation</th>
														<th class="nowrap width-13">Department</th>
														<th class="nowrap width-13">Enabled</th>
													</tr>
												 <c:forEach var="issue" items="${cissue}">
													<tr class="my-buglist-bug ">
														<td class="nowrap width-8">${issue.id }</td>
														<td class="nowrap width-13">${issue.assignto }</td>
														<td class="nowrap width-13">${issue.category}</td>
														<td class="nowrap width-13">${issue.description}</td>
														<td class="nowrap width-13">${issue.priority}</td>
														<td class="nowrap width-13">${issue.severity}</td>
														<td class="nowrap width-13">${issue.subject}</td>
														<td class="nowrap width-13">${issue.uploadfile}</td>
														<td class="nowrap width-13">${issue.taskdeadline}</td>
														<td><span><a href="edit?id=${user.id}"><i class="fa fa-pencil bigger-130 padding-2 grey" title=Edit ></i></a></span> <span><a href="deleteUser/${user.id }"><i class="fa fa-trash bigger-130 padding-2 grey" title="Delete" ></i></a></span></td>
													</tr>
													</c:forEach> 
												</tbody>
											</table>
										</div>
									</div>
								</div>
								

												</div><!-- /.row -->
 --%>					</div><!-- /.page-content -->
								
								
						</div>
					</div>
				</div>
			<!-- /page-content -->
		</div>
		<!-- /.main-content-inner -->
	
	<!-- /.main-content -->

<!-- Body ends here -->

	<link rel="stylesheet" type="text/css" href="http://charvikent.com/mantis/css/dropzone-4.3.0.min.css" />
<script type="text/javascript">
$("#pageName").text("View Task Details");
$(".createTicketIssues").addClass("active");
$(".task").hide();
/* $(function(){
	 Dropzone.autoDiscover = false;
}); */


function goBack() {
    window.history.go(-1);
}


</script>