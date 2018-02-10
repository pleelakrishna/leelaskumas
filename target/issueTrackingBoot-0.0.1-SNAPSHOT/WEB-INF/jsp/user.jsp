<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

    
    <div class="clearfix"></div>
	<ol class="breadcrumb">
		<li><a href="#">Home</a></li>
		<li>Employee Master</li>
	</ol>
	<div class="clearfix"></div>
<!-- Body starts here -->
	<!-- <div class="main-content"> -->
		<div class="main-content-inner">
       <div class="clearfix"></div>
		<br><br>
		<div class="col-md-12 col-xs-12">
			
				<%--<div class="page-content">
				<div class="row">
				 <div class="col-md-12 col-xs-12">
						<!-- <div class="page-header">
							<h1>Create User</h1>div
						</div> --><b></b>
						<div class="page-body">
							<form:form modelAttribute="userForm" action="createUser" class="form-horizontal" method="Post" >
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Username</label>
									<div class="col-md-6">
										<form:input path="username" class="form-control validate" placeholder="Enter Username"/>
									</div>
								</div>
								<div class="form-group" id="passwordDiv">
									<label class="col-md-3 control-label no-padding-right">Password</label>
									<div class="col-md-6">
										<form:password path="password" class="form-control validate" placeholder="Enter Password"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">First Name</label>
									<div class="col-md-6">
										<form:input path="firstname" class="form-control validate onlyCharacters" placeholder="Enter First Name"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Last Name</label>
						<div class="col-md-6">
										<form:input path="lastname" class="form-control validate onlyCharacters" placeholder="Enter Last Name"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Mobile</label>
									<div class="col-md-6">
										<form:input path="mobilenumber" class="form-control validate numericOnly" placeholder="Enter Mobile Number"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Email</label>
									<div class="col-md-6">
										<form:input path="email" class="form-control" placeholder="Enter Email"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Designation</label>
									<div class="col-md-6">
										<form:select path="designation" class="form-control validate" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Designation --</form:option>
											<form:options items="${roles}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Department</label>
									<div class="col-md-6">
										<form:select path ="department" class="form-control validate" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Department --</form:option>
								     		<form:options items="${departments}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">ReportTo</label>
									<div class="col-md-6">
										<form:select path ="reportto" class="form-control validate" onfocus="removeBorder(this.id)">
											<form:option value="">-- Select Report to --</form:option>
								     		<form:options items="${userNames}"/>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Enable</label>
									<div class="col-md-6">
										<form:checkbox  path="enabled" />
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
					</div> --%>
					
					<div class="col-md-12">
					<div class="panel panel-primary">
					<div class="panel-heading">
						<h4><i class="fa  fa-user-plus "> Add Employee</i>	</h4>
						<div class="options">
							<a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
						</div>
					</div>
					<div class="panel-body collapse in">
					
					<div class="page-body">
							<form:form modelAttribute="userForm" action="createUser" class="form-horizontal" method="Post" >
							<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Username</label>
									<div class="col-md-6">
										<form:input path="username" class="form-control validate" placeholder="Enter Username"/>
									</div>
								</div>
								
								</div>
								<div class="col-md-6">
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
								
								<%-- <div class="col-md-6">
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Enable</label>
									<div class="col-md-6">
										<form:checkbox  path="enabled" />
									</div>
								</div>
								</div> --%>
								
								<div class="col-md-12" style="text-align:right;">
								<div class="form-group">
									<div class="col-md-offset-3 col-md-6">
										<input type="submit" id="submit1"  class="btn btn-success" value="Create"/>
										<input class="btn-danger btn cancel"  type="reset"  value="Reset" />
									</div>
								</div></div>
								</form:form>
								</div>
								</div>
								
								</div>
					
					</div>
				</div>
			</div>
			<!-- /.page-content -->
		<!-- /.main-content-inner -->
	<!-- /.main-content -->
	
	<div class="main-content container">
		<div class="main-content-inner">
		<br>
			
			<div class="page-content">
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<!-- <div class="page-header">
							<h1>All Employees</h1>
							<a href="createUser" style="float: right;color: white;"> Add User</a>
						</div> -->
						<div class="panel panel-primary">
					<div class="panel-heading">
						<h4><i class="fa  fa-users "> Employee List</i>	</h4>
						<div class="options">
							<a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
						</div>
					</div>
					<div class="panel-body collapse in">
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
								<!-- <div class="widget-header widget-header-small">
									<h4 class="widget-title lighter"><i class="ace-icon fa fa-list-alt"></i>
										<a class="white" href="">Users List</a> 
									</h4>
									<div class="widget-toolbar">
										<a data-action="collapse" href="#">
											<i class="1 ace-icon fa bigger-125 fa-chevron-up"></i>
										</a>
									</div>
									<div class="widget-toolbar no-border hidden-xs">
										<div class="widget-menu">
											<a class="btn btn-primary btn-white btn-round btn-sm" href="createUser">Create User</a>
										</div>
									</div>
								</div> -->
								<div style="display: block;overflow:auto; padding: 20px;"  class="widget-body">
									<div class="widget-main no-padding">
										<div class="table-responsive">
											<table  cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered datatables" id="example">
												<thead >
													<tr  class="">
													
														<th class="nowrap width-8">Username</th>
														<th class="nowrap width-13">E-mail</th>
														<th class="nowrap width-13">Mobile</th>
														<th class="nowrap width-13">Designation</th>
														<th class="nowrap width-13">Department</th>
														 <th class="nowrap width-13">Report To</th> 
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
														<td class="nowrap width-13">${user.designationName}</td>
														<td class="nowrap width-13">${user.departmentName}</td>
														 <td class="nowrap width-13">${user.reportto}</td> 
														<td class="nowrap width-13">${user.enabled}</td>
														<td><span><a onclick='editEmployeeDetails(${user.id})' ><i class="fa fa-pencil bigger-130 padding-2 black" title=Edit ></i>Edit</a></span> </td>
														
														
														<c:if test="${user.status eq '1'}">
													 <td><span><a onclick="deleteEmployeeDetails(${user.id},'0')">Deactive</a></span></td>
														</c:if>
														<c:if test="${user.status eq '0'}">
													 <td><span><a onclick="deleteEmployeeDetails(${user.id},'1')">Active</a></span></td>
														</c:if>
														<%-- 
														<c:choose>
														  <c:when test="${user.enabled} == '1' ">
														 
														  </c:when> 
														  <c:otherwise>
														  <td><span><a onclick="deleteEmployeeDetails(${user.id},'1')">Active</a></span></td>
														  </c:otherwise>
														</c:choose> --%>
														
														
														<%--<td><span><a href="edit?id=${user.id}"><i class="fa fa-pencil bigger-130 padding-2 grey" title=Edit ></i></a></span> <span><a href="deleteUser/${user.id }"><i class="fa fa-trash bigger-130 padding-2 grey" title="Delete" ></i></a></span></td>  --%>
													</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>	
						</div></div></div>
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

<!-- Body ends here -->

<script type="text/javascript">
$("#pageName").text("Employee Master");
$(".createUser").addClass("active");
var alldata = ${allOrders1};
//var username=$('#username').val();

$('#username').blur(function() {
var username=$(this).val();

$.ajax({
			type : "GET",
			url : "getUserName",
			data : {"username":username},
			dataType : "text",
			beforeSend : function() {
	             $.blockUI({ message: 'Please wait' });
	          }, 
			success : function(data) {
				if(data ==='true')
					{
					//alert("username already exists")
 					$('#username').css('border-color', 'red');
					 $('#submit1').prop('disabled', true);
					}
				else
					{
					$('#username').css('border-color', 'none');
					$('#submit1').prop('disabled', false);
					}
				
			},
			complete: function () {
	            
	            $.unblockUI();
	       },
			error :  function(e){$.unblockUI();console.log(e);}
			
		});

	}); 
	
/* $('#designation').blur(function() {
	var role=$(this).val();
	if(role ===  '1')
		$('#reportto').prop('disabled', true);
	else
		$('#reportto').prop('disabled', false);
	
	
}); */
var allUsers =${allOrders1};
if(allUsers !=""){
// 	allUsers = JSON.stringify(allUsers);
	displayTable(allUsers);
}
 
function displayTable(allUsers){
	serviceUnitArray = {};
$.each(allUsers,function(i, orderObj) {
	serviceUnitArray[orderObj.id] = orderObj;
});
}
function editEmployeeDetails(id)
{	
	$("#passwordDiv").css("display","none");
// 	var user=JSON.parse(user);
// 	console.log(user);
	$("#username").val(serviceUnitArray[id].username);
	$("#firstname").val(serviceUnitArray[id].firstname);
	$("#lastname").val(serviceUnitArray[id].lastname);
	$("#mobilenumber").val(serviceUnitArray[id].mobilenumber);
	$("#email").val(serviceUnitArray[id].email);
	$("#designation").val(serviceUnitArray[id].designation);
	$("#department").val(serviceUnitArray[id].department);
	$("#reportto").val(serviceUnitArray[id].reportId);
//  	$("#enabled").val(serviceUnitArray[id].enabled);
	$("#submit1").val("Update");
	$(window).scrollTop($('body').offset().top);
}
function deleteEmployeeDetails(id,enabled){
	var checkstr=null;
	if(enabled == 0){
		
		checkstr = confirm("Are You Sure, You Want to De-Activate The Employeee?");
	}else{
		checkstr = confirm("Are You Sure, You Want to Activate The Employeee?");

	}
	if(checkstr==true){
		
		var formData = new FormData();
	    formData.append('id', id);
	    formData.append('enabled', enabled);
	    
	    
	    $.fn.makeMultipartRequest('POST', 'deleteUser', false, formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			window.location.reload();
			var alldata = jsonobj.allOrders1;
			console.log(jsonobj.allOrders1);
			displayTable(alldata);
		});
		
		/* $.ajax({
			type:"POST",
			url:"deleteUser",
			data:"id="+id+"&enabled="+enabled,
			success:function(response){
				console.log(reponse);
				window.location.reload();
			}
			
		}) */
	}
	
}


	
	
</script>