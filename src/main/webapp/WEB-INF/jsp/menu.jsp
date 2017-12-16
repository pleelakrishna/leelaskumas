<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Side Menu starts here -->
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
					<span class="btn btn-success"></span>myView
					<span class="btn btn-info"></span>
					<span class="btn btn-warning"></span>
					<span class="btn btn-danger"></span>
				</div>
			</div><!-- /.sidebar-shortcuts -->
      
			<ul class="nav nav-list">
				<li class="myView">
					<a href="myView">
						<i class="menu-icon fa fa-tachometer"></i>
						<span class="menu-text">My View</span>
					</a>
					<b class="arrow"></b>
				</li>
				<li class="summary">
					<a href="summary">
						<i class="menu-icon fa fa-bar-chart-o"></i>
						<span class="menu-text">Summary</span>
						<b class="arrow fa fa-angle-down"></b>
					</a>
				</li>
				<li class="viewReportIssues">
					<a href="viewReportIssues">
						<i class="menu-icon fa fa-list"></i>
						<span class="menu-text">View Issues</span>
					</a>
				</li>
				
				<li class="createTicketIssues">
					<a href="createTicketIssues">
						<i class="menu-icon fa fa-pencil-square-o"></i>
						<span class="menu-text">Create Issue</span>
					</a>
				</li>
				<c:if test="${cacheUserBean.designation == 1}">
				<li class="viewUsers">
					<a href="viewUsers">
						<i class="menu-icon fa fa-users"></i>
						<span class="menu-text">View Users</span>
					</a>
				</li>
				<li class="createUser">
					<a href="createUser">
						<i class="menu-icon fa fa-user"></i>
						<span class="menu-text">Create User</span>
					</a>
				</li>
				</c:if>
			</ul><!-- /.nav-list -->

			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>
		
<!-- Side Menu ends here -->






