<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    

<!-- Body starts here -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="">View Tickets</li>
				</ul><!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="page-header">
							<h1>Tickets List</h1>
<!-- 							<a href="createUser" style="float: right;color: white;"> Add User</a> -->
						</div>
						<div class="page-body">
							<c:if test="${not empty msg}">
								<div class="row">
									<div class="col-sm-4 col-sm-offset-4">
					                	<div class="form-group">
					                    	<div class="msgcss alert alert-${cssMsg} fadeIn animated" style="text-align: center;">${msg}</div>
					                    </div>
									</div>
								</div>
				            </c:if>
			            	<div id="assigned" class="widget-box widget-color-blue2">
								<div class="widget-header widget-header-small">
									<h4 class="widget-title lighter"><i class="ace-icon fa fa-list-alt"></i>
										<a class="white" href="">Issues List</a> 
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
														<th class="nowrap width-13">Category</th>
														<th class="nowrap width-13">Severity</th>
														<th class="nowrap width-13">Priority</th>
														<th class="nowrap width-13">AssignTo</th>
														<th class="nowrap width-13">Attachment</th>
														<th class="nowrap width-13">Summary</th>
														<th class="nowrap width-13">CreatedTime</th>
														<th class="nowrap width-13">UpdatedTime</th>
														<th class="nowrap width-13"></th>
													</tr>
													<c:forEach var="issue" items="${allReportIssues}">
													<tr class="my-buglist-bug ">
														<td class="nowrap width-13">${issue.id }</td>
														
														<td class="nowrap width-13">${issue.category}</td>
														<td class="nowrap width-13">${issue.severity}</td>
														<td class="nowrap width-13">${issue.priority}</td>
														<td class="nowrap width-13">${issue.assignto}</td>
														<td class="nowrap width-13">${issue.uploadfile}</td>
														<td class="nowrap width-13">${issue.subject}</td>
														<td class="nowrap width-13">${issue.createdTime }</td>
														<td class="nowrap width-13">${issue.updatedTime }</td>
												<c:if test="${cacheUserBean.designation == 1}">	<td><span><a href="editIssue?id=${issue.id}"><i class="fa fa-pencil bigger-130 padding-2 grey"></i></a></span> </c:if> <%-- <span><a href="deleteUser/${user.id }">Delete</a></span> --%></td>
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
		</div>
		<!-- /.main-content-inner -->
	</div>
	<script type="text/javascript">
$(".viewReportIssues").addClass("active");
</script>

<%--   
<div class="dashboard-wrapper">
	<div class="top-bar clearfix">
		<div class="row gutter">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="page-title pull-left"><h4>View Tickets</h4></div>
			</div>
		</div>
	</div>
	<div class="main-container">
		<div class="row gutter">
		<c:if test="${not empty msg}">
				<div class="row">
					<div class="col-sm-4 col-sm-offset-4">
	                	<div class="form-group">
	                    	<div class="msgcss alert alert-${cssMsg} fadeIn animated" style="text-align: center;">${msg}</div>
	                    </div>
					</div>
				</div>
            </c:if>
			<table class="table table-bordered table-hover specialCollapse">
				<thead>
					<tr class="primary">
						<th colspan="7">Tickets List <a href="createTicketIssues" style="float: right;color: white;"> Create Ticket</a></th>
<!-- 						<th colspan="6"><a href="/createTicketIssues" style="float: right;"> Create Ticket</a></th> -->
					</tr>
				</thead>
				<tbody>
					<tr>
		<th width="80"> Sno</th>
		<!-- <th width="80"> createdTime</th> -->
		<th width="120"> category</th>
		<th width="120">severity</th>
		<th width="60">priority</th>
		<th width="60">assignto</th>
		<th width="120">subject</th>
		<th width="120">description</th>
		<!-- <th width="120">uploadfile</th> -->
		<!-- <th width="80"> updatedTime</th> -->
	</tr>
<tbody>
 <c:forEach var="issue" items="${allReportIssues}">
 <tr>
 <td>${issue.id }</td>
 <td>${issue.createdTime}</td>
 <td>${issue.category }</td>
 <td>${issue.severity }</td>
 <td>${issue.priority }</td>
 <td>${issue.assignto}</td>
 <td>${issue.subject}</td>
 <td>${issue.description}</td>
 <td>${issue.uploadfile}</td>
 <td>${issue.updatedTime}</td>
 </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript">
$(".viewReportIssues").addClass("active");
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    

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
							<h1>Issues List</h1>
<!-- 							<a href="createUser" style="float: right;color: white;"> Add User</a> -->
						</div>
						<div class="page-body">
							<c:if test="${not empty msg}">
								<div class="row">
									<div class="col-sm-4 col-sm-offset-4">
					                	<div class="form-group">
					                    	<div class="msgcss alert alert-${cssMsg} fadeIn animated" style="text-align: center;">${msg}</div>
					                    </div>
									</div>
								</div>
				            </c:if>
			            	<div id="assigned" class="widget-box widget-color-blue2">
								<div class="widget-header widget-header-small">
									<h4 class="widget-title lighter"><i class="ace-icon fa fa-list-alt"></i>
										<a class="white" href="">Issues List</a> 
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
														<th class="nowrap width-13">Category</th>
														<th class="nowrap width-13">Severity</th>
														<th class="nowrap width-13">Priority</th>
														<th class="nowrap width-13">AssignTo</th>
														<th class="nowrap width-13">Attachment</th>
														<th class="nowrap width-13">Summary</th>
														<th class="nowrap width-13">UpdatedTime</th>
														<th class="nowrap width-13">CreatedTime</th>
														<th class="nowrap width-13"></th>
													</tr>
													<c:forEach var="issue" items="${allReportIssues}">
													<tr class="my-buglist-bug ">
														<td class="nowrap width-13">${issue.id }</td>
														
														<td class="nowrap width-13">${issue.category}</td>
														<td class="nowrap width-13">${issue.severity}</td>
														<td class="nowrap width-13">${issue.priority}</td>
														<td class="nowrap width-13">${issue.assignto}</td>
														<td class="nowrap width-13">${issue.uploadfile}</td>
														<td class="nowrap width-13">${issue.subject}</td>
														<td class="nowrap width-13">${issue.createdTime }</td>
														<td class="nowrap width-13">${issue.updatedTime }</td>
												<c:if test="${cacheUserBean.designation == 1}">	<td><span><a href="editIssue?id=${issue.id}">Edit</a></span> </c:if> <%-- <span><a href="deleteUser/${user.id }">Delete</a></span> --%></td>
													</tr>
													<%-- </c:forEach> --%>
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
		</div>
		<!-- /.main-content-inner -->
	</div>
	<script type="text/javascript">
$(".viewReportIssues").addClass("active");
</script>

<%--   
<div class="dashboard-wrapper">
	<div class="top-bar clearfix">
		<div class="row gutter">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="page-title pull-left"><h4>View Tickets</h4></div>
			</div>
		</div>
	</div>
	<div class="main-container">
		<div class="row gutter">
		<c:if test="${not empty msg}">
				<div class="row">
					<div class="col-sm-4 col-sm-offset-4">
	                	<div class="form-group">
	                    	<div class="msgcss alert alert-${cssMsg} fadeIn animated" style="text-align: center;">${msg}</div>
	                    </div>
					</div>
				</div>
            </c:if>
			<table class="table table-bordered table-hover specialCollapse">
				<thead>
					<tr class="primary">
						<th colspan="7">Tickets List <a href="createTicketIssues" style="float: right;color: white;"> Create Ticket</a></th>
<!-- 						<th colspan="6"><a href="/createTicketIssues" style="float: right;"> Create Ticket</a></th> -->
					</tr>
				</thead>
				<tbody>
					<tr>
		<th width="80"> Sno</th>
		<!-- <th width="80"> createdTime</th> -->
		<th width="120"> category</th>
		<th width="120">severity</th>
		<th width="60">priority</th>
		<th width="60">assignto</th>
		<th width="120">subject</th>
		<th width="120">description</th>
		<!-- <th width="120">uploadfile</th> -->
		<!-- <th width="80"> updatedTime</th> -->
	</tr>
<tbody>
 <c:forEach var="issue" items="${allReportIssues}">
 <tr>
 <td>${issue.id }</td>
 <td>${issue.createdTime}</td>
 <td>${issue.category }</td>
 <td>${issue.severity }</td>
 <td>${issue.priority }</td>
 <td>${issue.assignto}</td>
 <td>${issue.subject}</td>
 <td>${issue.description}</td>
 <td>${issue.uploadfile}</td>
 <td>${issue.updatedTime}</td>
 </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript">
$(".viewReportIssues").addClass("active");
>>>>>>> 05d305e1a8096529f9a8b933c88cac8565dbe0ea
</script> --%>