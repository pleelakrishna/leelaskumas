<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- <style>
.table > tbody > tr > td, .table > tbody > tr > th, .table > thead > tr > td, .table > thead > tr > th {
	border-top: none;
}
</style>
 -->
<!-- Body starts here -->
<div class="dashboard-wrapper">
	<div class="top-bar clearfix">
		<div class="row gutter">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="page-title">
					<h4>Raise a Ticket</h4>
				</div>
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
			<form:form action="createTicketIssues" method="post" modelAttribute="createTicketIssues" enctype="multipart/form-data">
				<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 col-lg-offset-2">
					<table class="table table-bordered table-condensed">
						<thead>
							<tr class="primary">
								<th colspan="2">Enter Ticket Details</th>
							</tr>
						</thead>
<!-- 						<tbody> -->
							<tr>
								<td class="info">Category</td>
								<td class="default"><form:select path="category" class="form-control validate" onfocus="removeBorder(this.id)" >
										<form:option value="" label="--- Select ---" />
										 <form:options items="${category}"/>
										<%-- <form:option value="functional" label="Functional Defect" />
										<form:option value="performance" label="Performance Defect" />
										<form:option value="security" label="Security Defect" />
										<form:option value="user" label="User Interface Defect" /> --%>
									</form:select></td>
							</tr>
							<tr>
								<td class="info">Severity</td>
								<td class="default"><form:select path="severity" class="form-control validate" onfocus="removeBorder(this.id)">
										<form:option value="" label="--- Select ---" />
										 <form:options items="${severity}"/>
										<%-- <form:option value="feature" label="feature" />
										<form:option value="trivial" label="trivial" />
										<form:option value="text" label="text" />
										<form:option value="minor" label="minor" />
										<form:option value="major" label="major" />
										<form:option value="crash" label="crash" />
										<form:option value="block" label="block" /> --%>
									</form:select></td>
							</tr>
							<tr>
								<td class="info">Priority</td>
								<td class="default"><form:select path="priority" class="form-control validate" onfocus="removeBorder(this.id)">
										<form:option value="" label="--- Select ---" />
										<form:options items="${priority}"/>
										<%-- <form:option value="" label="none" />
										<form:option value="low" label="low" />
										<form:option value="normal" label="normal" />
										<form:option value="high" label="high" />
										<form:option value="urgent" label="urgent" />
										<form:option value="immediate" label="immediate" /> --%>
									</form:select></td>
							</tr>

							<tr>
								<td class="info">Assign To</td>
								<td class="default"><form:select path="assignto" class="form-control validate" onfocus="removeBorder(this.id)">
										<%-- <form:option value="" label="-- Admins ----"/>
										<form:options value="" items="${adminNames}"/> --%>
										<form:option value="" label="-- Assign To --"/>
										 <form:options items="${userNames}"/>
									</form:select></td>
							</tr>

							<tr>
								<td class="info">Subject</td>
								<td class="default"><form:input path="subject" class="form-control validate"/></td>
							</tr>


							<tr>
								<td class="info">Description</td>
								<td class="default"><form:input path="description" class="form-control validate" /></td>
							</tr>

							<tr>
								<td class="info">Upload Files</td>
								<td class="default"><input type="file" name="file" id="documents" /></td>
							</tr>

							<!-- <tr class="default">
								<td></td>
								<td>
									<div style="float: right;">
										<input class="btn btn-success" type="submit" id="submit1" value="Submit" />
										<input class="btn btn-danger cancel" type="reset" value="Reset" />
									</div>
								</td>
							</tr> -->
							<tr class="primary">
								<td></td>
								<td><input type="submit" id="submit1" class="btn btn-danger" value="Create"/>
								<input class="btn-danger btn cancel" type="reset" value="Reset" /></td>
							</tr>
						<!-- 						</tbody> -->
					</table>
				</div>
			</form:form>
		</div>
	</div>
</div>
<!-- Body ends here -->

<script type="text/javascript">
$(".createTicketIssues").addClass("active");
</script>