<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<div class="clearfix"></div>
<ol class="breadcrumb">
	<li><a href="dashBoard">Home</a></li>
	<li>Hierarchical</li>
</ol>
<div class="clearfix"></div>

<div class="container" style="padding:40px;">
	<ul class="nav nav-tabs navtabs" style=" border:1px solid #ccc; border-bottom:1px solid #ccc;">
		<li class="active"><a data-toggle="tab" href="#dept1">Hierarchical</a></li>
		<li><a data-toggle="tab" href="#hier">Hierarchical Design</a></li><br>
	</ul>
	<div class="tab-content">
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
							<!-- <input type="checkbox" class="form-check-input"
								onclick="inactiveData();" id="inActive"> <label
								class="form-check-label">Show Inactive List</label> -->
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
			<!-- 		<a class="btn btn-info btn-lg"  onclick="PopupFillingStation();">Add Gas</a><br><br> -->
			<div class="row" id="moveTo">
				<div class="col-md-12 col-sm-12" style=" border:1px solid #ccc;" style="margin-top:10px;">
				
					<div class="panel panel-primary" >
						<div class="panel-heading">
							<h4>New Hierarchical</h4>
						</div>
						<form:form class="form-horizontal" commandName="orgDeptf"	role="form" id="fillingstation-form" action="orgDept"	method="post">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<form:hidden path="id" />
											<label for="focusedinput" class="col-md-6 control-label">Organization
												<span class="impColor">*</span>
											</label>
											<div class="col-md-5">
												<form:select path="org" class="form-control validate"
													onfocus="removeBorder(this.id)">
													<form:option value="">-- Select Organization --</form:option>
													<form:options items="${orgs}" />
												</form:select>
												<span class="hasError" id="stationnameError"></span>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="focusedinput" class="col-md-6 control-label">Department
												<span class="impColor">*</span>
											</label>
											<div class="col-md-5">
												<form:select path="dept" class="form-control validate"	onfocus="removeBorder(this.id)" onchange="deptValidation(this.value)">
													<form:option value="">-- Select Department --</form:option>
													<form:options items="${depts}" />
												</form:select>
												<span class="hasError" id="stationnameError"></span>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="focusedinput" class="col-md-6 control-label">Parent
												Department <span class="impColor">*</span>
											</label>
											<div class="col-md-5">
												<form:select path="parentDept" class="form-control"
													onfocus="removeBorder(this.id)">
													<form:option value="">-- Select Parent Department --</form:option>
													<form:options items="${depts}" />
												</form:select>
												<span class="hasError" id="stationnameError"></span>
											</div>
										</div>
									</div>


								</div>

								<!-- Modal Starts here-->
								<!-- Modal Ends here-->

							</div>
							<div class="panel-footer">
								<div class="row">
									<div class="col-sm-12">
										<div class="btn-toolbar text-center">
											<input type="submit" id="submit1" value="Submit"
												class="btn-primary btn" /> <input type="reset"
												value="Reset" class="btn-danger btn cancel" />
										</div>
									</div>
								</div>
							</div>
						</form:form>
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

	var listOrders1 = ${allOrders1};
	if (listOrders1 != "") {
		displayTable(listOrders1);
	}
	function displayTable(listOrders) {
		$('#tableId').html('');
		var tableHead = '<table id="example" class="table table-striped table-bordered datatables">'
				+ '<thead><tr><th>Organization</th><th>Department</th><th>Parent Department</th><th style="text-align: center;">Options</th></tr></thead><tbody></tbody></table>';
		$('#tableId').html(tableHead);
		serviceUnitArray = {};
		$.each(listOrders, function(i, orderObj) {
			if (orderObj.status == "1") {
				var deleterow = "<a class='deactivate' onclick='deleteorg("
						+ orderObj.id + ",0)'><i class='fa fa-eye'></i></a>"
			} else {
				var deleterow = "<a class='activate' onclick='deleteorg("
						+ orderObj.id
						+ ",1)'><i class='fa fa-eye-slash'></i></a>"
			}
			var edit = "<a class='edit editIt' onclick='editCylinder("
					+ orderObj.id + ")'><i class='fa fa-edit'></i></a>"
			serviceUnitArray[orderObj.id] = orderObj;
			var tblRow = "<tr>" + "<td title='"+orderObj.org+"'>"
					+ orderObj.org + "</td>" + "<td title='"+orderObj.dept+"'>"
					+ orderObj.dept + "</td>"
					+ "<td title='"+orderObj.parentDept+"'>"
					+ orderObj.parentDept + "</td>"
					+ "<td style='text-align: center;white-space: nowrap;'>"
					+ edit + "&nbsp;&nbsp;" + deleterow + "</td>" + "</tr>";
			$(tblRow).appendTo("#tableId table tbody");
		});
		if (isClick == 'Yes')
			$('.datatables').dataTable();

	}

	function editCylinder(id) {
		console.log(serviceUnitArray[id].org);
		$("#id").val(serviceUnitArray[id].id);
		$("#org").val(serviceUnitArray[id].orgid);
		$("#dept").val(serviceUnitArray[id].deptid);
		$("#parentDept").val(serviceUnitArray[id].parentDeptId);
		$("#submit1").val("Update");
		$(window).scrollTop($('#moveTo').offset().top);
	}

	function deleteorg(id, status) {
		var checkstr = null;
		if (status == 0) {
			checkstr = confirm('Are you sure you want to Deactivate?');
		} else {
			checkstr = confirm('Are you sure you want to Activate?');
		}
		if (checkstr == true) {
			var formData = new FormData();
			formData.append('id', id);
			formData.append('status', status);
			$.fn.makeMultipartRequest('POST', 'deleteorgDept', false, formData,
					false, 'text', function(data) {
						var jsonobj = $.parseJSON(data);
						var alldata = jsonobj.allOrders1;
						displayTable(alldata);
						toolTips()
					});
		}
	}

	
	 function deptValidation(value) {
						var deptval = value;
						var orgval = $('#org').val();
						if (orgval !="") {
							var formData = new FormData();
							formData.append('dept', deptval);
							formData.append('org', orgval);
							$.fn.makeMultipartRequest('POST','existOrNot',false,formData,false,'text',function(data) {
												alert(data);
												if (data === 'true') {
													alert("selected department is already exists");
													$('#dept').val("");

													return true
												}
											});

						}

						else {
							alert("please select orgnization");
							$("#dept").val("");
// 							$('#dept').val("");

						}
					}

	$('#parentDept').blur(function() {
		if ($('#parentDept').val() != 0) {

			if ($('#dept').val() == $('#parentDept').val()) {

				alert("please select valid Parent Department");
				$('#parentDept').val("");
				return false;

			}
		}

	})

	function validate(id, errorMessage) {
		var styleBlock = '.placeholder-style.placeholder-style::-moz-placeholder {color: #cc0000;} .placeholder-style::-webkit-input-placeholder {color: #cc0000;}';
		if ($('#' + id).val() == null || $('#' + id).val() == ""
				|| $('#' + id).val() == "undefined") {
			$('style').append(styleBlock);
			$('#' + id).css('border-color', '#cc0000');
			$('#' + id).css('color', '#cc0000');
			$('#' + id).attr('placeholder', errorMessage);
			$('#' + id).addClass('placeholder-style your-class');
			//			$('#'+id).css('color','#cc0000');
			//			$('#'+id+'Error').text(errorMessage);
		} else {
			$('#' + id).css('border-color', '');
			$('#' + id).removeClass('placeholder-style your-class');
			//			$('#'+id).css('color','');
			//			$('#'+id+'Error').text("");
		}

	}

	function inactiveData() {
		var status = "0";
		if ($('#inActive').is(":checked") == true) {
			status = "0";
		} else {
			status = "1";
		}
		var formData = new FormData();
		formData.append('status', status);

		$.fn.makeMultipartRequest('POST', 'inActiveFillingStation', false,
				formData, false, 'text', function(data) {
					var jsonobj = $.parseJSON(data);
					var alldata = jsonobj.allOrders1;
					displayTable(alldata);
					console.log(jsonobj.allOrders1);
				});

	}

	var testData = ${hierarchical};
	$(function() {
		org_chart = $('#orgChart').orgChart({
			data : testData
		});
	});

	$("#pageName").text(" Hierarchical Master");
	$(".orgDept").addClass("active");
</script>