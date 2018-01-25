<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%--  --%><spring:url var="viewUsers" value="/viewUsers"></spring:url>
    
<!-- Body starts here -->
	<div class="main-content">
		<div class="main-content-inner">
			<!-- <div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="">View Users</li>
				</ul>/.breadcrumb
			</div> -->
			
			<div class="page-content">
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="page-header">
							<h1>Users List</h1>
<!-- 							<a href="createUser" style="float: right;color: white;"> Add User</a> -->
						</div>
						<div class="page-body" style="padding: 15px;">
							<c:if test="${not empty msg}">
								<div class="row">
									<div class="col-sm-4 col-sm-offset-4" >
					                	<div class="form-group">
					                    	<div class="msgcss alert alert-${cssMsg} fadeIn animated" style="text-align: center;">${msg}</div>
					                    </div>
									</div>
								</div>
				            </c:if>
				           <!--<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered datatables">
				            <thead>
				               <tr><th>Username</th>
				            <th>E-mail</th>
				            <th>Mobile</th>
				            <th>Designation</th>
				            <th>Department</th>
				            <th>Enabled</th>
				            <th>Options</th>
				            </tr>
				            </thead>
				            <tbody>
				            <tr>
				            <td title="admin">admin</td>
				            <td title="leelakrishnacce@gmail.com">leelakrishnacce@gmail.com</td>
				            <td title="9293139394">9293139394</td>
				            <td title="ADMIN">ADMIN</td>
				            <td title="HR">HR</td>
				            <td title="true">true</td>
				            <td style="text-align: center;">fsdfds</td>
				            </tr> </tbody></table>-->
			            	<div id="assigned" class="widget-box widget-color-blue2">
								<div class="widget-header widget-header-small">
									<!-- <h4 class="widget-title lighter"><i class="ace-icon fa fa-list-alt"></i>
										<a class="white" href="">Users List</a> 
									</h4> -->
									<!-- <div class="widget-toolbar">
										<a data-action="collapse" href="#">
											<i class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
										</a>
									</div> -->
									
									<div class="widget-toolbar no-border hidden-xs" align="right"   >
										<div class="widget-menu"  >
											<a class="btn btn-primary btn-white btn-round btn-sm" href="createUser"><i class="fa fa-user-plus">Create User</i></a>
										</div><br>
									</div>
								</div>
									<div class="widget-main no-padding">
										<div class="box-content nopadding w3-animate-zoom"  id="tableId">
										
										
						<!-- 					
						<table id="dynamic-table" class="table table-striped table-bordered table-hover">
					<thead>	<tr><th>Username</th><th>E-mail</th><th>Mobile</th><th>Designation</th><th>Department</th><th>Enabled</th><th>Options</th>
								<th></th></tr></thead><tbody></tbody></table>  -->
											
											 <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered datatables">
												<thead >
													<tr  class="my-buglist-bug success ">
													
														<th class="nowrap width-8">Username</th>
														<th class="nowrap width-13">E-mail</th>
														<th class="nowrap width-13">Mobile</th>
														<th class="nowrap width-13">Designation</th>
														<th class="nowrap width-13">Department</th>
														<th class="nowrap width-13">Enabled</th>
														<th class="nowrap width-13">Options</th>
													</tr>
													</thead>
													<tbody>
													<c:forEach var="user" items="${allUsers}">
													<tr class="my-buglist-bug ">
														<td class="nowrap width-8">${user.username }</td>
														<td class="nowrap width-13">${user.email }</td>
														<td class="nowrap width-13">${user.mobilenumber}</td>
														<td class="nowrap width-13">${user.designation}</td>
														<td class="nowrap width-13">${user.department}</td>
														<td class="nowrap width-13">${user.enabled}</td>
														<td><span><a href="edit?id=${user.id}"><i class="fa fa-pencil bigger-130 padding-2 grey" title=Edit ></i></a></span> <span><a href="deleteUser/${user.id }"><i class="fa fa-trash bigger-130 padding-2 grey" title="Delete" ></i></a></span></td>
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
			<!-- /.page-content -->
		</div>
		<!-- /.main-content-inner -->
	</div>
	<!-- /.main-content -->

<!-- Body ends here -->

<script type="text/javascript">
$(".viewUsers").addClass("active");



</script>

