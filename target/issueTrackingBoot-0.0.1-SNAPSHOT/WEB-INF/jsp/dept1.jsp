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
					<li class="">Create Department</li>
				</ul><!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="page-header">
							<h1>Create Department</h1>
						</div>
						<div class="page-body">
							<form:form modelAttribute="deptf" action="dept" class="form-horizontal" method="Post" >
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Department Name</label>
									<div class="col-md-6">
										<form:input path="name" class="form-control validate" placeholder="Enter dept name"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Parent Department</label>
									<div class="col-md-6">
										<form:select path="parentDept" class="form-control" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Department --</form:option>
											<form:options items="${parents}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Description</label>
									<div class="col-md-6">
										<form:textarea path="description" class="form-control validate" placeholder="Enter Description"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-3 col-md-6">
										<input type="submit" id="submit1"  class="btn btn-success" value="Create"/>
										<input class="btn-danger btn cancel"  type="reset"  value="Reset" />
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

<script type="text/javascript">
$(".createDept").addClass("active");
</script>