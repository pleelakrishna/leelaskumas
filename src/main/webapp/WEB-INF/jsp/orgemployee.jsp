<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<style>
.btn-toolbar {
	margin-top:7px;
}
.panel {
   margin:0px;
    border-radius: 1px;
}
div.orgChart td {
    text-align: center;
    vertical-align: top;
     padding: 0px !important;
}
div.orgChart div.node {
    cursor: default;
    border: 1px solid #e7e7e7;
    display: inline-block;
    padding: 5px;
    width:auto !important;
    height: auto !important;
    }
</style>
<div class="clearfix"></div>
<ol class="breadcrumb">
	<li><a href="dashBoard">Home</a></li>
	<li>Hierarchical</li>
</ol>
<div class="clearfix"></div>

<div class="container" style="padding:40px;">
	<!-- <ul class="nav nav-tabs navtabs" style=" border:1px solid #ccc; border-bottom:1px solid #ccc;">
		<li class="active"><a data-toggle="tab" href="#dept1">Hierarchical</a></li>
		<li><a data-toggle="tab" href="#hier">Hierarchical Design</a></li><br>
	</ul> -->
	<!-- <div class="tab-content">
		<div id="dept1" class="tab-pane fade in active" >
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary" style="/* margin-top:5px; */" >
						<div class="panel-heading">
							<h4>Hierarchical List</h4>
							<div class="options">
								<a href="javascript:;" class="panel-collapse"><i
									class="fa fa-chevron-down"></i></a>
							</div>
						</div>
						<div class="panel-body collapse in">
							<input type="checkbox" class="form-check-input"
								onclick="inactiveData();" id="inActive"> <label
								class="form-check-label">Show Inactive List</label>
							<div class="table-responsive" id="tableId">
								<table cellpadding="0" cellspacing="0" border="0"
									class="table table-striped table-bordered datatables"
									id="example">
									<thead>
										<tr>
											<th>Org-Dept ID</th>
											<th>Organization</th>
											<th>Department</th>
											<th>Parent Department</th>
											<th></th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
					<a class="btn btn-info btn-lg"  onclick="PopupFillingStation();">Add Gas</a><br><br>
			<div class="row" id="moveTo">
				<div class="col-md-12 col-sm-12" style=" border:1px solid #ccc;" style="margin-top:10px;">
				
					<div class="panel panel-primary" >
						<div class="panel-heading">
							<h4>New Hierarchical</h4>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		
		<div id="hier" class="tab-pane fade" style=" border:1px solid #ccc;" style="margin-top:10px;">
		<div class="panel panel-primary" >
						<div class="panel-heading">
			<h4>Department Hierarchical</h3></div></div>
			<div class="table-responsive" style=" background:#c3bbbb42; padding:20px; margin:15px; " >
				<div id="orgChartContainer">
					<div id="orgChart"></div>
				</div>
			</div>
		</div>
		</div> -->
		<div >
		<div class="panel panel-primary" >
						<div class="panel-heading">
			<h4>Employee Chart</h3></div></div>
			<div class="table-responsive" style=" background:#c3bbbb42;  " >
				<div id="orgChartContainer">
					<div id="orgChart"></div>
				</div>
			</div>
		</div>
</div>


<!-- container -->


</body>
<%-- <script type='text/javascript' src='${baseurl }/js/custemValidation.js'></script>  --%>
<script type='text/javascript' src='${baseurl }/assets/js/jquery.orgchart.js'></script>
<%-- <script type='text/javascript' src='${baseurl }/assets/js/jquery.orgchart.css'></script> --%>
<link rel='stylesheet' type='text/css' href='${baseurl }/assets/js/jquery.orgchart.css' /> 
<script type="text/javascript">
	/* $(document).ready(function() {
	 var table = $('#example').DataTable();
	
	 $('#example tbody').on('click', 'tr', function () {
	 var data = table.row( this ).data();
	 alert( 'You clicked on '+data[0]+'\'s row' );
	 } );
	 }); */

	

	var testData = ${hierarchical};
	$(function() {
		org_chart = $('#orgChart').orgChart({
			data : testData
		});
	});

	$("#pageName").text(" Employees Chart");
	$(".empchart").addClass("active");
</script>