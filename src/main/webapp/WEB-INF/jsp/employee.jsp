<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<div class="clearfix"></div>
	<ol class="breadcrumb">
		<li><a href="#">Home</a></li>
		<li>Employee Master</li>
	</ol>
	<div class="clearfix"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Employee List</h4>
						<div class="options">
							<a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
						</div>
					</div>
					<div class="panel-body collapse in">
					<input type="checkbox" class="form-check-input" onclick="inactiveData();" id="inActive"> <label class="form-check-label">Show Inactive List</label>
						<div class="table-responsive" id="tableId">
							<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered datatables" id="example">
								<thead><tr><th>Employee ID</th><th>User Name</th><th>firstname</th><th>Last Name</th> <th>Department</th><th>Designation</th><th></th></tr></thead>
								<tbody></tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
<!-- 		<a class="btn btn-info btn-lg"  onclick="PopupFillingStation();">Add Gas</a><br><br> -->
		<div class="row" id="moveTo">
			<div class="col-md-12 col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Add Employee</h4>
					</div>
					
					<form:form modelAttribute="userForm" action="employee" class="form-horizontal " method="Post">
	
					<div class="col-md-6"><br>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Username</label>
									<div class="col-md-6">
										<form:input path="username" class="form-control validate" placeholder="Enter Username"/>
									</div>
								</div>
								
								</div>
								<div class="col-md-6"><br>
								<div class="form-group" id="passwordDiv">
									<label class="col-md-3 control-label no-padding-right">Password</label>
									<div class="col-md-6">
										<form:password path="password" class="form-control validate" placeholder="Enter Password"/>
									</div>
								</div>
								
								</div>
								<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">First Name</label>
									<div class="col-md-6">
										<form:input path="firstname" class="form-control validate onlyCharacters" placeholder="Enter First Name"/>
									</div>
								</div></div>
								<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Last Name</label>
						<div class="col-md-6">
										<form:input path="lastname" class="form-control validate onlyCharacters" placeholder="Enter Last Name"/>
									</div>
								</div>
								</div>
								
								<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Mobile</label>
									<div class="col-md-6">
										<form:input path="mobilenumber" class="form-control validate numericOnly" placeholder="Enter Mobile Number"/>
									</div>
								</div></div>
								<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Email</label>
									<div class="col-md-6">
										<form:input path="email" class="form-control" placeholder="Enter Email"/>
									</div>
								</div></div>
								<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Designation</label>
									<div class="col-md-6">
										<form:select path="designation" class="form-control " >
											<form:option value="">-- Select Designation --</form:option>
											<form:options items="${roles}"/>
										</form:select>
									</div>
								</div></div>
								<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Department</label>
									<div class="col-md-6">
										<form:select path ="department" class="form-control validate" selected="selected" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Department --</form:option>
								     		<form:options  items="${departments}"/>
										</form:select>
									</div>
								</div></div>
								<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">ReportTo</label>
									<div class="col-md-6">
										<form:select path ="reportto" class="form-control" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Report to --</form:option>
								     		<form:options items="${userNames}"/>
										</form:select>
									</div>
								</div></div>
						<div class="panel-footer">
				      	<div class="row">
				      		<div class="col-sm-12">
				      			<div class="btn-toolbar text-center">
					      			<input type="submit" id="submit1" value="Submit" class="btn-primary btn"/>
					      			<input type="reset" value="Reset" class="btn-danger btn cancel"/>
				      			</div>
				      		</div>
				      	</div>
			      	</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
			<!-- container -->
</body>
<script type="text/javascript">
var listOrders1 = ${allOrders1};
if (listOrders1 != "") {
	displayTable(listOrders1);
}
function displayTable(listOrders) {
	$('#tableId').html('');
	var tableHead = '<table id="example" class="table table-striped table-bordered datatables">'
			+ '<thead><tr><th>Employee Id</th><th>User Name</th><th>First Name</th><th>Last Name</th><th>Department</th><th>Designation</th><th>Mobile Number</th><th style="text-align: center;"></th></tr></thead><tbody></tbody></table>';
	$('#tableId').html(tableHead);
	serviceUnitArray = {};
	$.each(listOrders,function(i, orderObj) {
		if(orderObj.status == "1"){
			var deleterow = "<a class='deactivate' onclick='deleteEmployee("+ orderObj.id+ ",0)'><i class='fa fa-eye'></i></a>"
		}else{  
			var deleterow = "<a class='activate' onclick='deleteEmployee("+ orderObj.id+ ",1)'><i class='fa fa-eye-slash'></i></a>"
		}
		var edit = "<a class='edit editIt' onclick='editEmployee("	+ orderObj.id+ ")'><i class='fa fa-edit'></i></a>"
		serviceUnitArray[orderObj.id] = orderObj;
		var tblRow = "<tr>"
			+ "<td title='"+orderObj.id+"'>"+ orderObj.id + "</td>"
			+ "<td title='"+orderObj.username+"'>"+ orderObj.username + "</td>"
			+ "<td title='"+orderObj.firstname+"'>"+ orderObj.firstname + "</td>"
			+ "<td title='"+orderObj.lastname+"'>"+ orderObj.lastname + "</td>"
			+ "<td title='"+orderObj.departmentName+"'>"+ orderObj.departmentName + "</td>"
			+ "<td title='"+orderObj.designationName+"'>"+ orderObj.designationName + "</td>"
			+ "<td title='"+orderObj.mobilenumber+"'>"+ orderObj.mobilenumber + "</td>"
			+ "<td style='text-align: center;white-space: nowrap;'>" + edit + "&nbsp;&nbsp;" + deleterow + "</td>" 
			+ "</tr>";
		$(tblRow).appendTo("#tableId table tbody");
	});
	if(isClick=='Yes') $('.datatables').dataTable();
	
}


function editEmployee(id) {
	$("#id").val(serviceUnitArray[id].id);
	$("#username").val(serviceUnitArray[id].username);
	$("#password").val(serviceUnitArray[id].password);
	$("#firstname").val(serviceUnitArray[id].firstname);
	$("#lastname").val(serviceUnitArray[id].lastname);
	$("#mobilenumber").val(serviceUnitArray[id].mobilenumber);
	$("#designation").val(serviceUnitArray[id].designation);
	$("#department").val(serviceUnitArray[id].department);
	$("#reportto").val(serviceUnitArray[id].reportId);
	$("#email").val(serviceUnitArray[id].email);
	$("#submit1").val("Update");
	$(window).scrollTop($('#moveTo').offset().top);
}

function deleteEmployee(id,status){
	var checkstr=null;
	if(status == 0){
		 checkstr = confirm('Are you sure you want to Deactivate?');
	}else{
		 checkstr = confirm('Are you sure you want to Activate?');
	}
	if(checkstr == true){
		var formData = new FormData();
	    formData.append('id', id);
	    formData.append('status', status);
		$.fn.makeMultipartRequest('POST', 'deleteUser', false, formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			window.location.reload();
			var alldata = jsonobj.allOrders1;
			displayTable(alldata);
		});
	}
}









/* function validate(id, errorMessage)
{
	var styleBlock = '.placeholder-style.placeholder-style::-moz-placeholder {color: #cc0000;} .placeholder-style::-webkit-input-placeholder {color: #cc0000;}';
	if($('#'+id).val() ==  null || $('#'+id).val() == ""  || $('#'+id).val()=="undefined" ) {
		$('style').append(styleBlock);
		$('#'+id).css('border-color','#cc0000');
		$('#'+id).css('color','#cc0000');
		$('#'+id).attr('placeholder',errorMessage);
		$('#'+id).addClass('placeholder-style your-class');
//			$('#'+id).css('color','#cc0000');
//			$('#'+id+'Error').text(errorMessage);
	}else{
		$('#'+id).css('border-color','');
		$('#'+id).removeClass('placeholder-style your-class');
//			$('#'+id).css('color','');
//			$('#'+id+'Error').text("");
	}
	
}

function inactiveData() {
	var status="0";
	if($('#inActive').is(":checked") == true){
		status="0";
	}else{
		status="1";
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
 */
 $("#pageName").text("Employee Master");
$(".employee").addClass("active"); 
</script>