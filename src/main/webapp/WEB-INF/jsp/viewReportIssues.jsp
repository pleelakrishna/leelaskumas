<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
    
    

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
								<div style="display: block;max-height:300px;overflow:auto;" class="widget-body">
									<div class="widget-main no-padding">
										<div class="table-responsive">
											<table class="table table-bordered table-condensed table-striped table-hover">
												<tbody>
													<tr class="my-buglist-bug success">
													    <th class="nowrap width-13">Issue ID</th>
														<th class="nowrap width-13">Summary</th>
														<th class="nowrap width-13">Category</th>
														<th class="nowrap width-13">Severity</th>
														<th class="nowrap width-13">Priority</th>
														<th class="nowrap width-16">Assigned</th>
														<th class="nowrap width-13">Attachment</th>
														<th class="nowrap width-13">CreatedTime</th>
														<th class="nowrap width-13">UpdatedTime</th>
														<th class="nowrap width-13"></th>
													</tr>
													<c:forEach var="issue" items="${allReportIssues}">
													<tr class="my-buglist-bug ">
														<td class="nowrap width-13">${issue.id }</td>
														<td class="nowrap width-13">${issue.subject}</td>
														<td class="nowrap width-13">${issue.category}</td>
														<td class="nowrap width-13">${issue.severity}</td>
														<td class="nowrap width-13">${issue.priority}</td>
														<td class="nowrap width-16">${issue.assignto}</td>
														<td class="nowrap width-16"> <c:forTokens items="${issue.uploadfile}" delims="*" var="mySplit">
                                                            <c:out value="${mySplit}"/> </c:forTokens></td>
                                                            
                                                            
														<%-- <td class="nowrap width-13"><c:set var="str" value="${issue.uploadfile}" />
														    ${fn:substringAfter(str,",")}</td> --%>
														<td class="nowrap width-13">${issue.createdTime }</td>
														<td class="nowrap width-13">${issue.updatedTime }</td>
														<td><c:if test="${cacheUserBean.designation == 1}"><form action="editIssue?id=${issue.id}&pgn=2" method="post">
            <button type="submit" title="Edit" class="btn-link fa fa-pencil  bigger-130 padding-2 grey"></button>
            </form></c:if></td> <%-- <span><a href="deleteUser/${user.id }">Delete</a></span> --%></td>
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

/* $("a").click(function(event) {
	var href=$(this).attr('href');
	alert(href);
	event.preventDefault();
	
	$.ajax({
		type : "POST",
		url : "postEdit",
		data : {"href":href},
		dataType : "text",
		success : function(data) {
			window.location="/editIssue"
			alert(data);
			
			
		}
		
	});
}); */
</script>

