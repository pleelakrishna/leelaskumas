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
														<%-- <td><span><a href="edit?id=${user.id}"><i class="fa fa-pencil bigger-130 padding-2 grey" title=Edit ></i></a></span> <span><a href="deleteUser/${user.id }"><i class="fa fa-trash bigger-130 padding-2 grey" title="Delete" ></i></a></span></td>
									 --%>				</tr>
													</c:forEach> 
												</tbody>
											</table>
										</div>
									</div>
								</div>
								

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