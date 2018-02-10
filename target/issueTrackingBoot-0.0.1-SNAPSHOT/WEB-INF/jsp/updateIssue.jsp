<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!-- <!DOCTYPE html>
<html lang="en">
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Kumar Pumps Ticket Tracking System</title>

		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		bootstrap & fontawesome
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

		[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]

		inline styles related to this page

		ace settings handler
		<script src="assets/js/ace-extra.min.js"></script>

		[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]
	</head>

	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default  ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>KPTTS</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="blue ">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">HRMS<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-user"></i>
								      All Projects
									</a>
								</li>

								<li class="divider"></li>
								<div id="projects-list">
									<div class="projects-searchbox">
										<center><input class="search form-control input-md" placeholder="Search"></center>
									</div>
									</div>
        
        	
	
							</ul>
						</li>

						<li class="light-blue dropdown-modal">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
									Administator
								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-user"></i>
									My Account
									</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="#">
										<i class="ace-icon fa fa-rss-square orange"></i>
										RMS
									</a>
								</li>

								<li class="divider"></li>
								<li>
									<a href="#">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>/.navbar-container
		</div>

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div id="sidebar" class="sidebar sidebar-fixed responsive compact">
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

				<div class="sidebar-shortcuts sidebar-fixed sidebar-shortcuts-mini compact" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts 

				<ul class="nav nav-list">
					<li class="active">
						<a href="index.html">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> My View </span>
						</a>

						<b class="arrow"></b>
					</li>

					<li class="">
						<a href="#">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> View Issues </span>
						</a>
					</li>

					<li class="">
						<a href="#">
							<i class="menu-icon fa fa-pencil-square-o"></i>
							<span class="menu-text"> Report Issues </span>
						</a>
					</li>

					<li class="">
						<a href="#">
							<i class="menu-icon fa fa-list-alt"></i>
							<span class="menu-text">Change Log</span>
						</a>
					</li>

					<li class="">
						<a href="#">
							<i class="menu-icon fa fa-calendar"></i>
							<span class="menu-text">
								Summary
							</span>
						</a>
					</li>
					
				</ul><!-- /.nav-list 

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>
 -->
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs noprint" id="breadcrumbs">
			<c:if test="${not empty msg}">
				<div class="row">
					<div class="col-sm-4 col-sm-offset-4">
						<div class="form-group">
							<div class="msgcss alert alert-${cssMsg} fadeIn animated"
								style="text-align: center;">${msg}</div>
						</div>
					</div>
				</div>
			</c:if>
			<ul class="breadcrumb">
				<li><i class="fa fa-user home-icon active"></i> <a href="#">administator
						( Administator)</a> <span id="nav-search" class="nav-search"><span
						class="input-icon"><input type="text" name="bug_id"
							autocomplete="off" class="nav-search-input" placeholder="Issue #"><i
							class="ace-icon fa fa-search nav-search-icon"></i> </span> </span> </span></li>
			</ul>
		</div>


		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<div id="assigned" class="widget-box widget-color-blue2">
						<div class="widget-header widget-header-small">
							<h4 class="widget-title lighter">
								<i class="ace-icon fa fa-comments"></i> <a class="white"
									href="#">Updating Issue Information</a>
							</h4>

							<div class="widget-toolbar no-border hidden-xs">
								<div class="widget-menu">
									<a class="btn btn-primary btn-white btn-round btn-sm" href="#">Back
										To Issue</a>
								</div>
							</div>
						</div>

					<div style="display: block;" class="widget-body">
						<form:form action="updateIssue" method="post" modelAttribute="cissue" class="form-horizontal">
								<div class="widget-main no-padding">
									<div class="table-responsive">
										<table
											class="table table-bordered table-condensed table-striped table-hover">
											<tbody>

												<tr class="my-buglist-bug ">
													<td class="nowrap width-13">ID</td>

													<!-- <td><span>Project</span></td> -->

													<td><span>Category</span></td>

													<td><span>View Status</span></td>

													<td><span>Date Submitted</span></td>

													<td><span>Last Update</span></td>
												</tr>
											<%-- <c:forEach var="issue" items="${allReportIssues}"> --%>
												<tr class="my-buglist-bug ">
													<td class="nowrap width-13"> 
													<span > ${issueId} </span>
													
													</td>

													<!-- <td><span>HRMS</span></td> -->

													<td><form:hidden path="id"/>
														<form:select path="category" class="col-xs-10 col-sm-5 validate"
															onfocus="removeBorder(this.id)" style="width: 100%;">
<%-- 															<form:option    value="${category}"  /> --%>
															<form:options selected="selected" items="${categories}" /> 
														</form:select>
														<!-- <select tabindex="1" id="category_id" name="category_id" class="input-sm">
																<option value="1">[All Projects] Functional Defect</option>
																<option value="3" selected="selected">[All Projects] Performance Defect</option>
																<option value="4">[All Projects] Security Defect</option>
																<option value="2">[All Projects] User Interface	Defect</option>
														</select> -->
													</td>

													<td><span>2017-09-05 11:04</span></td>

													<td><span>2017-09-05 11:04</span></td>
												</tr>

												<tr class="my-buglist-bug ">
													<td class="nowrap width-13">Reporter</td>

													<td>Sai Kumari [<a href="#reporter_edit"
														class="click-url"
														url="bug_update_page.php?bug_id=9&amp;reporter_edit=true">Edit</a>]
													</td>

													<td><span>Assigned To</span></td>

													<td>
													
													<form:select path="assignto" name="severity"
															class="col-xs-10 col-sm-8 validate"
															onfocus="removeBorder(this.id)" style="width: 100%;">
<%-- 															<form:option    value="${assignto}"  /> --%>
															<form:options selected="selected" items="${userNames}" /> 
														</form:select>
													
													<!-- <select tabindex="3" id="handler_id"
														name="handler_id" class="input-sm"><option
																value="0"></option>
															<option value="1" selected="selected">Administrator</option>
															<option value="4">Bhavani Prasad</option>
															<option value="6">Kotaiah</option>
															<option value="3">Raju</option>
															<option value="5">Nitun</option>
															<option value="8">Pavan</option>
															<option value="7">Srinivas</option>
													</select>
													 -->
													</td>


													<td colspan="2"><span></span></td>
												</tr>

												<tr class="my-buglist-bug ">
													<td class="nowrap width-13">Priority</td>

													<td>
													<form:select path="priority" name="priority"
															class="col-xs-10 col-sm-8 validate"
															onfocus="removeBorder(this.id)" style="width: 100%;">
<%-- 															<form:option    value="${priority}"  />d --%>
															<form:options selected="selected" items="${priorities}" /> 
														</form:select>
													
													<!-- <select tabindex="4" id="priority" name="priority"
														class="input-sm">
															<option value="10">none</option>
															<option value="20">low</option>
															<option value="30" selected="selected">normal</option>
															<option value="40">high</option>
															<option value="50">urgent</option>
															<option value="60">immediate</option>
													</select> --></td>

													<td><span> Severity</span></td>

													<td>
													
														<form:select path="severity" name="severity"
															class="col-xs-10 col-sm-8 validate"
															onfocus="removeBorder(this.id)" style="width: 100%;">
<%-- 															<form:option    value="${severity}"  /> --%>
															<form:options selected="selected" items="${severityOptions}" /> 
														</form:select>
													
													
													<!-- <select tabindex="5" id="severity" name="severity"
														class="input-sm">
															<option value="10">feature</option>
															<option value="20">trivial</option>
															<option value="30">text</option>
															<option value="40">tweak</option>
															<option value="50" selected="selected">minor</option>
															<option value="60">major</option>
															<option value="70">crash</option>
															<option value="80">block</option>
													</select> -->
													
													</td>

													<!-- <td><span> Reproducibility</span></td>

													<td><select tabindex="6" id="reproducibility"
														name="reproducibility" class="input-sm">
															<option value="10">always</option>
															<option value="30">sometimes</option>
															<option value="50">random</option>
															<option value="70" selected="selected">have not
																tried</option>
															<option value="90">unable to reproduce</option>
															<option value="100">N/A</option>
													</select></td> -->
													
<!-- 													<tr class="my-buglist-bug "> -->
													<td class="nowrap width-13">Status</td>

													<td class="status-50-color"><select class="input-sm"
														tabindex="7" id="status" name="status" style="width: 100%;">
															<option value="10">new</option>
															<option value="20">feedback</option>
															<option value="30">acknowledged</option>
															<option value="40">confirmed</option>
															<option value="50" selected="selected">assigned</option>
															<option value="80">resolved</option>
															<option value="90">closed</option>
													</select></td>

												
<!-- 
													<td><span>Resolution</span></td>

													<td><select tabindex="8" id="resolution"
														name="resolution" class="input-sm">
															<option value="10" selected="selected">open</option>
															<option value="20">fixed</option>
															<option value="30">reopened</option>
															<option value="40">unable to reproduce</option>
															<option value="50">not fixable</option>
															<option value="60">duplicate</option>
															<option value="70">no change required</option>
															<option value="80">suspended</option>
															<option value="90">won't fix</option>
													</select></td> -->

													<td colspan="2"><span></span></td>


												</tr>

												<!-- <tr class="my-buglist-bug ">
													<td class="nowrap width-13">Platform</td>

													<td><input type="" name=""></input></td>

													<td><span>OS</span></td>

													<td><input type="" name=""></input></td>


													<td><span>OS Version</span></td>

													<td><input type="" name=""></input></td>


												</tr> -->

												<tr class="my-buglist-bug ">
													<td class="nowrap width-13">Summary</td>

													<td colspan="5"><input tabindex="12" type="text"
														id="summary" name="summary" size="105" maxlength="128"
														value=${summary}></td>
												</tr>

												<tr class="my-buglist-bug ">
													<td class="nowrap width-13">Description</td>

													<td colspan="5"><textarea class="form-control"
															tabindex="13" cols="80" rows="10" id="description"
															name="description">  ${description} </textarea>
													</td>
												</tr>

												<!-- <tr class="my-buglist-bug ">
													<td class="nowrap width-13">Steps To Reproduce</td>

													<td colspan="5"><textarea class="form-control"
															tabindex="13" cols="80" rows="10" id="description"
															name="description"></textarea></td>
												</tr>
 -->
												<tr class="my-buglist-bug ">
													<td class="nowrap width-13">Additional Information</td>

													<td colspan="5"><textarea class="form-control"
															tabindex="13" cols="80" rows="10" id="description"
															name="description"> </textarea></td>
												</tr>

												<!-- <tr class="my-buglist-bug ">
													<td class="nowrap width-13">Defect Type</td>

													<td colspan="5"><select tabindex="16"
														id="custom_field_1" name="custom_field_1" size="5">
															<option value="Functional">Functional</option>
															<option value="Regression">Regression</option>
															<option value="Performance" selected="selected">
																Performance</option>
															<option value="User Interface">User Interface</option>
															<option value="Security">Security</option>
															<option value=""></option>
													</select> <input type="hidden" name="custom_field_1_presence"
														value="1"></td>
												</tr> -->
<!-- 
												<tr class="my-buglist-bug ">
													<td class="nowrap width-13">Add Note</td>

													<td colspan="5"><textarea class="form-control"
															tabindex="13" cols="80" rows="10" id="description"
															name="description"></textarea></td>
												</tr>

												<tr class="my-buglist-bug ">
													<td class="nowrap width-13">private</td>

													<td colspan="5"><label><input tabindex="18"
															type="checkbox" class="ace" id="private" name="private">
															<span class="lbl"></span> </label></td>
												</tr> -->

												<tr class="my-buglist-bug ">
													<td colspan="6"><input type="submit"
														class="btn btn-primary btn-white btn-round"
														value="Update Information"></td>


													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</form:form>
						</div>
					</div>

					<div class="space-10"></div>


					<div id="assigned" class="widget-box widget-color-blue2">
						<div class="widget-header widget-header-small">
							<h4 class="widget-title lighter">
								<i class="ace-icon fa fa-comments"></i> <a class="white"
									href="#"></a>Activities
							</h4>
							<div class="widget-toolbar">
								<a data-action="collapse" href="#"> <i
									class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
								</a>
							</div>
							<div class="widget-toolbar no-border hidden-xs">
								<div class="widget-menu"></div>
							</div>
						</div>

						<div style="display: block;" class="widget-body">
							<div class="widget-main no-padding">
								<div class="table-responsive">
									<table
										class="table table-bordered table-condensed table-striped table-hover">
										<tbody>

											<tr class="my-buglist-bug ">
												<td style="text-align: center;"><span>There are
														no notes attached to this issue.</span></td>
											</tr>




										</tbody>
									</table>

								</div>
							</div>
						</div>
					</div>
					<div class="space-10"></div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	</div>
</div>
<script>
var priority =${priority};
var category =${category};
var severity =${severity};
var assignto =${assignto};
var id=${issueId}

$( document ).ready(function() {
	//if(add !=""){
		$("#priority").val(priority);
		$("#category").val(category);

		$("#severity").val(severity);

		$("#assignto").val(assignto);
		$("#id").val(id);
		
	//}
	
});




</script>