<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
<link  href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"/>
<style>
.table-bordered > tbody > tr > th, .table-bordered > tfoot > tr > th, .table-bordered > thead > tr > td, .table-bordered > tbody > tr > td, .table-bordered > tfoot > tr > td {
    border: 1px solid #ccc;
    width: 155px;
}

button.dt-button, div.dt-button, a.dt-button {
       color: #fff !important;
    background: #337ab7 !important;
    border-color: #2e6da4 !important;
    padding:6px 12px;
    position: relative;
    display: inline-block;
    box-sizing: border-box;
    margin-right: 0.333em;
    margin-bottom: 0.933em !important;
    padding: 0.5em 1em;
    border: 1px solid #999;
    border-radius: 2px;
    cursor: pointer;
    font-size: 0.88em;
    line-height: 1.6em;
    color: black;
    white-space: nowrap;
    overflow: hidden;
    /* background-color: #e9e9e9; */
    /* background-image: -webkit-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -moz-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -ms-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -o-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: linear-gradient(to bottom, #fff 0%, #e9e9e9 100%);
    filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,StartColorStr='white', EndColorStr='#e9e9e9'); */
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    text-decoration: none;
    outline: none;
}

.dt-button:hover {
    color: #fff !important;
    background-color: #204d74 !important;
    border-color: #122b40 !important;
    }
.form0 {
	margin-top:20px;
}
.lrt{
	float:right;
	margin-top:8px;
}
.imp{
	color:#FF0000;
}
.sbtn0 .btn-success {
	margin-top:20px;
	float:right;
	margin-right:10px;
}
.wrapper{
  width:100%;
}

/* td, th{
	font-size: 12px;
} */
.dispnone {
    display: none;
}
@media (max-width: 767px) {
	.lrt{
		float:left;
	}
	.sbtn0 .btn-success {
		margin-right:15px;
	}
}
@media (min-width: 768px) and (max-width: 991px) {
	.itp{
		margin-top: 20px;
	}
	.sbtn0 .btn-success {
		margin-right:125px;
	}
}
.btn-toolbar {
	margin-top:7px;
}
label {
	float: left;
}
.lrt {
	float:right !important;
	margin-top:7px;
}
.col-sm-1 h3 {
	float:right;
}
@media screen and (max-width: 767px) {
	.mobi {
		margin-left:16px;
	}
	.mobi0 {
		margin-left:24px;
	}
	.mobi1 {
		margin-left:10px;
	}
}

@media screen and (max-width: 767px) {
.add {
width:65%;
}
@media screen and (max-width: 767px) {
.add1 {
margin-right:8px;
}
}
@media screen and (max-width: 767px) {
.add2 {
margin-right:8px;
}
}
@media screen and (max-width: 767px) {
.add3 {
margin-right:8px;
}
}

</style>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
<script type="text/javascript" src="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/a549aa8780dbda16f6cff545aeabc3d71073911e/src/js/bootstrap-datetimepicker.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/a549aa8780dbda16f6cff545aeabc3d71073911e/build/css/bootstrap-datetimepicker.css">
	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css">
<!--extra scripts  -->
<!-- <script type='text/javascript' src='https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js'></script> -->
<!-- <script type='text/javascript' src='https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js'></script> -->
	
	<!--  extra scripts closed-->
	<div class="clearfix"></div>
	<ol class="breadcrumb">
		<li><a href="dashBoard">Home</a></li>
		<li>Task Reports</li>
	</ol>
	<security:authorize access="hasRole('ROLE_ADMIN')">
	                       <div class="clearfix"></div><br>
	                       <form>
	                        <div class="row">
	                        <div class="container">
	                        <div class="col-md-12">
  		<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  			<div class="panel panel-primary">
    			<div class="panel-heading active" role="tab" id="headingOne">
      				<h4 class="panel-title"><a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne" class=""><i class="fa fa-filter"></i> Filters</a></h4>
    			</div>
    			<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne" aria-expanded="true" style="">
      			<div class="panel-body">
      			<form>
                    <div class="table">
                        <table class="table table-bordered table-stipped table-responsive">
                            <tbody>
                                <tr>
                                    <th><a href="#stayhere" id="reporter" class="openinput">Assigned by</a></th>
                                    <th><a href="#stayhere" id="assigned" class="openinput">Assigned to</a></th>
                                    <th><a href="#stayhere" id="prior" class="openinput">Priority</a></th>
                                    <th><a href="#stayhere" id="view" class="openinput">Status by</a></th>
                                </tr>
                                <tr>
                                    <td><span class="reporter_text">Any</span>
                                       
									
										
										<select id="assignedbyid"  class="form-control validate1 mobi dispnone reporter_input" onfocus="removeBorder(this.id)"  >
											<option value="0">All </option>
											<c:forEach var="list" items="${userNames}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
                                    </td>
                                    <td><span class="assigned_text">Any</span>
										
										<select id="assignedtoid"  class="form-control validate1 mobi dispnone assigned_input" onfocus="removeBorder(this.id)"  >
											<option value="0">All </option>
											<c:forEach var="list" items="${userNames}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
										
										
                                    </td>
                                   
                                     
                                    <td><span class="prior_text">Any</span>
                                        
                                        <select id="priorityid"  class="form-control validate1 mobi dispnone prior_input" onfocus="removeBorder(this.id)"  >
											<option value="0">All </option>
											<c:forEach var="list" items="${severity}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
                                        
                                    </td>
                                    
                                    <td><span class="view_text">Any</span>
                                        
                                        
                                         <select id="kstatusid"  class="form-control validate1 mobi dispnone view_input" onfocus="removeBorder(this.id)"  >
											<option value="0">All </option>
											<c:forEach var="list" items="${kpstatuses}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
                                    </td>
                                   
                                </tr>
                                <tr>
                                    <th><a href="#stayhere" id="cate" class="openinput">Category</a></th>
                                    <th><a href="#stayhere" id="hide" class="openinput">Department</a></th>
                                    <th colspan=""><a href="#stayhere" id="filt" class="openinput">Filter by Date Submitted</a></th>
                                    <th colspan=""><a href="#stayhere" id="filter" class="openinput">Filter by last updated Date</a></th>
                                </tr>
                                <tr>
                                    <td><span class="cate_text">Any</span>
                                        
                                         <select id="categoryid"  class="form-control validate1 mobi dispnone cate_input" onfocus="removeBorder(this.id)"  >
											<option value="0">All </option>
											<c:forEach var="list" items="${category}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
                                    </td>
                                    <td><span class="hide_text">Any</span>
                                        <select id="deptid"  class="form-control validate1 mobi dispnone hide_input" onfocus="removeBorder(this.id)"  >
											<option value="0">All </option>
											<c:forEach var="list" items="${departmentNames}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
                                    </td>
                                   
                                    <td colspan=""><span class="filt_text">Any</span>
                                        <input name="dateFrom" id="dateFrom" type="text" style="margin-bottom:5px;" class="form-control dateFrom dispnone filt_input" placeholder="select from date"/>
                                         <input name="sdateFrom" id="sdateFrom" type="text" class="form-control dateFrom dispnone filt_input" placeholder="select to date"/>
                                    </td>
                                    <td colspan=""><span class="filter_text">Any</span>
                                       
                                       <input name="dateTo" id="dateTo" type="text" style="margin-bottom:5px;" class="form-control dateTo dispnone filter_input"  placeholder="select from date"/>
                                        <input name="udateTo" id="udateTo" type="text" class="form-control dateTo dispnone filter_input"  placeholder="select to date"/>
                                    </td>
                                </tr>
                                <!-- <tr>
                                
                                </tr> -->
                            </tbody>
                        </table>
                    </div></form>
      			</div>
                <div class="panel-footer">
                    <div class="col-md-6 col-xs-6">
                        <!-- <div class="col-sm-5">
                            <input type="text" class="form-control"  placeholder="search"> 
                        </div>-->
                        <div class="col-sm-3">
                            <a href="#headingOne" id="searchpanel" class="btn btn-primary">Search</a>
                        </div>
                        <div class="col-sm-4">
                        </div><div class="clearfix"></div>
                    </div>
                    <div class="col-md-6">
                        <div class="col-sm-5">
                        </div>
                        <div class="col-sm-4">
                            <!-- <a href="#" class="btn btn-info">Save Current Filter</a> -->
                        </div>
                        <div class="col-sm-3">
                             <a href="#" id="frset" class="btn btn-danger">Reset</a>
                           <!--  <button  id="frset" class="">Reset</button> -->
                        </div>
                    </div><div class="clearfix"></div>
                </div>
    		</div>
  		</div>
  	</div>
  </div></div>
                    		<div class="col-md-4">
                    			<%-- <div class="form-horizontal">
									<label for="focusedinput" class="col-md-6 control-label" style="padding-top:2px;">Tasks Types <span class="impColor">*</span></label>
									<select id="ttype"  class="col-xs-10 col-sm-5 " >
											<c:forEach var="list" items="${tasksSelection}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
                    			</div> --%>
                    		</div>
                    		 <%-- <div class="col-md-4">
                    			<div class="form-horizontal">
									<label for="focusedinput" class="col-md-6 control-label" style="padding-top:2px;">Department  <span class="impColor">*</span></label>
									<select id="deptid"  class="col-xs-10 col-sm-5 " >
											<c:forEach var="list" items="${departmentNames}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
                    			</div>
                    		</div>  --%>
                    		</div>
                    		</form>
                    		</security:authorize>
                    		<br>
                    		<!-- <div class="col-md-6">
                    		</div>
                    		<div class="form-group col-md-6">
  <div class="input-group">
  	<div class="col-sm-1">
  		<h3><i class="fa fa-calendar" aria-hidden="true"></i></h3>
  	</div>
    <div class="col-sm-5">
    	<div class="col-xs-4">
    		<label class="lrt"><b>From :</b></label>
    	</div>
    	<div class="col-xs-8">
      		<input name="DATEFROM" id="dateFrom" type="text" class="form-control" placeholder="select from date"/>
    	</div><div class="clearfix"></div>
    </div>
     <div class="col-sm-5">
    	<div class="col-xs-4">
    		<label class="lrt"><b>To :</b></label>
    	</div>
    	<div class="col-xs-8">
      		<input name="DATEFROM" id="dateTo" type="text" class="form-control"  placeholder="select to date"/>
    	</div><div class="clearfix"></div>
    </div>
     <div class="col-sm-1">
    <button type="button"  id="getdatabydates" class="btn btn-success">Go</button>
    </div>
  </div>
</div> -->
                    		
	<div class="clearfix"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12" >
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Task List</h4>
						<div class="options">
							<a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
						</div>
					</div>
					<div class="panel-body collapse in">
					<!--  <input type="checkbox" class="form-check-input" onclick="inactiveData();" id="inActive"> <label class="form-check-label">Show Inactive List</label>-->
						<div class="table-responsive" id="tableId">
							<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered datatables" id="example">
								<thead><tr><th>Dept ID</th><th>Name</th><th>Description</th><th>Status</th><th></th></tr></thead>
								<tbody></tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
										<div id="file1"></div>
				</div>
	
	
	<!-- Task History Modal Starts here-->
<div class="modal fade" id="myModal" data-backdrop="static" data-keyboard="false" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header"  style="background: #4f8edc;">
				<button style="color:#fff;opacity:100 !important;" type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"> Task History </h4>
        	</div>
        	<div class="modal-body">
				<div class="row">
				<div class="table-responsive" id="HtableId">
							<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered datatables" id="example5">
								<thead><tr class="info"><th>Date Modified</th><th>User Name</th><th>Attachment</th><th>Change</th></tr></thead>
								<tbody></tbody>
							</table>
						</div>
				</div>
			</div>
      	</div>
    </div>
</div>
<!-- Modal Ends here-->



<!-- Task History 2 Modal Starts here-->
<div class="modal fade" id="myModal2" data-backdrop="static" data-keyboard="false" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header"  style="background: #4f8edc;">
				<button style="color:#fff;opacity:100 !important;" type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 style="color:#fff;" class="modal-title"> Task History  </h4>
        	</div>
        	<div class="modal-body">
				<div class="row">
				<div class="table-responsive" id="HtableId2">
							<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered datatables" id="example2">
								<thead><tr class="info"><th>Date Modified</th><th>User Name</th><th>Attachment</th><th>Field</th><th>Change</th></tr></thead>
								<tbody></tbody>
							</table>
						</div>
				</div>
			</div>
      	</div>
    </div>
</div>
<!-- Modal Ends here-->
			
			
			
			
			
<!-- add comment Modal Starts here-->
<div class="modal fade" id="formModal" data-backdrop="static" data-keyboard="false" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="background: #2973cf;">
				<button style="color:#fff; opacity: 100 !important;" type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" style="color: white;"> Add Comment </h4>
        	</div>
        	<div class="modal-body">
					<form class="form-horizontal">
					<div class="panel-body">
						<div class="row">
                    		<div class="col-md-12">
                    			<div class="form-group">
                    				<!-- <input type=hidden path="id"/> -->
                    				
                    				<input type="hidden" name="issueid" id="issueid" value="50">
                    				<input type="hidden" name="id" id="id" value="">
                    				
									<div class="col-md-2"></div>
<label for="focusedinput" class="col-md-2" style="
    margin-left: 8px;
">Status  <span class="impColor">*</span></label>
										<select  name="kpstatus" id="kpstatus" class="col-sm-3  validate2 " style="margin-top:6px">
											<option value="">--select-- </option>
											<c:forEach var="list" items="${kpstatuses}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
                    			</div>
                    		</div>
                    		<div class="col-md-12">
    <div class="col-md-1"></div>		
                    		
                    		<div class="col-md-3 col-xs-3">
									<label class="ace-file-input ace-file-multiple add2" style="
    margin-left: 10px;
">Attach File(s)</label>
									</div>
										<div class="col-md-6 col-xs-6">
										<input type="file" name="fileupload[]" id="fileupload" class="add3" multiple="" style="margin: 8px 0px 0px -8px;" placeholder="">
									</div>
							 
						
							</div>
							</div>
							<br>
							<div class="row" style="border-radius: 0px;">
                    		<div class="col-md-12">
                    			<div class="form-group">
                    				<div class="col-md-2"></div>
                                      <div class="col-md-2">
										<label for="focusedinput" class="control-label add1" style="margin-left: -15px;">Comment <span class="impColor">*</span></label>
                    				</div>
									<div class="col-md-6" style="margin-left: -9px;">
									<input type="text" name="commet" id="commet" onkeyup="removeBorder(this.id)" class="form-control validate2 add" placeholder="Enter comment" style="margin-left: 5px;">
									<span class="hasError" id="stationnameError"></span>
								    </div>
                    			</div>
                    		</div>
                    		
                    		</div>
                    		
                    		
                    		<div class="panel-footer">
				      	<div class="row">
				      		<div class="col-sm-12">
				      			<div class="btn-toolbar text-center">
					      			<input type="button" id="modelSubmit" value="Submit" onclick="submitCommet()" class="btn-primary btn">
					      			<input type="reset" value="Reset" class="btn-danger btn cancel1">
				      			</div>
				      		</div>
				      	</div>
			      	</div>
                    		</div>
					
                    		</form>
                    		
				</div> 
					
				</div> 
				
			</div>  
      	</div> <!--  add comment model close here-->

<!--  Count Down timer model--> 

<div class="modal fade" id="timeModal" data-backdrop="static"
	data-keyboard="false" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="background: #2973cf;">
				<button style="color:#fff; opacity:100 !important;" type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" style="color: white;">Task Count Down</h4>
			</div>
			<div> </div>	<div class="modal-body">
			<p id="demo"></p>
			
			</div>
		</div>
	</div>
	</div>   <!-- deadline Model ends here -->
	
	
	


<script type="text/javascript">
/* $(function() {
	$(window).scrollTop($('#severity').offset().top);
}); */



$("#taskdeadline").keypress(function(){
	return false;
})


var documentMessage ="KPTMS";

 $(function(){
	 $('.datatables').dataTable({
         dom: 'lBfrtip',
         
         
         buttons: [
{
    extend: 'csv',
    title: documentMessage,
    filename: documentMessage
  }, 
                   {
                                extend: 'pdfHtml5',
                                orientation : 'landscape',
				                pageSize : 'LEGAL',
//                                 title : documentMessage,
                                                        exportOptions: {columns: [0,1,2,3,4,5,6,7,8,9]},
                                customize: function ( doc ) {/* 
                                                                doc.content.splice( 1, 0, {
                                                                        margin: [ 0, 0, 0, 12 ], 
                                                                        alignment: 'center'
                                                                                 });*/
                                                        }
                            }, {
      extend: 'excel',
      title: documentMessage,
      filename: documentMessage
    }, 
    {
extend: 'print',
customize: function ( win ) {
    $(win.document.body)
        .css( 'font-size', '10pt' )
       
       
    $(win.document.body).find( 'table' )
        .addClass( 'compact' )
        .css( 'font-size', 'inherit' );
}
}]

});
}); 


function makeEmpty()
{
	
	$('#taskdeadline').val(" ");
	$('#subject').val(" ");
	$('#category').val("");
	$('#priority').val("");
	$("#severity").val("");
	$("#assignto").val("");
	$("#description").val("");
	
	}

$(document).ready(function () {
	//$("#taskdeadline").attr("disabled", "disabled"); 
	
	
	
// 	$("#taskdeadline").attr('readonly', 'readonly');
	 	 

	  $('#dateFrom').datepicker({
		dateFormat: "yy-mm-dd",
	    orientation: "top",
	    autoclose: true
	  });
	  $('#sdateFrom').datepicker({
			dateFormat: "yy-mm-dd",
		    orientation: "top",
		    autoclose: true
		  });
	  	 
	  
	  $('#dateTo').datepicker({
		  dateFormat: "yy-mm-dd",
		    orientation: "top",
		    autoclose: true
		  });

	  $('#udateTo').datepicker({
		  dateFormat: "yy-mm-dd",
		    orientation: "top",
		    autoclose: true
		  });
	  
	  
	  
	  
});
 

// $("#taskdeadline").prop("readonly", true);


var loginUserDId =${objuserBean.designation};
var cuserid =${objuserBean.id};
var listOrders1 = ${allOrders1};
if (listOrders1 != "") {
	displayTable(listOrders1)
}



function displayTable(listOrders) {
	$('#tableId').html('');
	var tableHead = '<table id="example" class="table table-striped table-bordered datatables">'
			+ '<thead><tr><th>Task No</th><th>Department</th><th>Category</th><th>Assigned To</th><th>Assigned By</th><th>Task Subject</th><th>Description</th><th>Priority</th><th>Created Time</th><th>Task Status</th><th>Task DeadLine</th><th>Notifications Frequency</th></tr></thead><tbody></tbody></table>';
	$('#tableId').html(tableHead);
	serviceUnitArray = {};
	
	$.each(listOrders,function(i, orderObj) {
		if(loginUserDId == "1")
			{
		if(orderObj.status == "1"){
			var deleterow = "<a class='deactivate' onclick='deletetask("+ orderObj.id+ ",0)'><i class='fa fa-eye'></i></a>"
		}else{  
			var deleterow = "<a class='activate' onclick='deletetask("+ orderObj.id+ ",1)'><i class='fa fa-eye-slash'></i></a>"
		}
		
		
			}
		else
		{
			deleterow =" ";
		}
		
		if(orderObj.assignbyid == cuserid)
		{
		var edit = "<a class='edit editIt' onclick='editTask("	+ orderObj.id+ ")'><i class='fa fa-edit'></i></a>"
		var createDuplicate = "<a class='clone cloneIt' onclick='createDuplicate("	+ orderObj.id+ ")'><i class='fa fa-clone'></i></a>"
		}
		else
			{
		var	edit =" ";
		var createDuplicate =" ";
			}
		var view = "<a class='view viewIt' onclick='viewTask("	+ orderObj.id+ ")'>"+ orderObj.taskno+ "</a>"
		var history2 = "<a class='history historyit' onclick='viewTask2("	+ orderObj.id+ ")'> <i class='fa fa-history'></i></a>"
		var view2 = "<a class='view viewIt' href='viewTicket?id="	+ orderObj.id+ "&pgn=0'>"+ orderObj.taskno+ "</a>"
		var comment = "<a class='comment commentIt' onclick='addComment("	+ orderObj.id+ ")'>   <i class='fa fa-comments'></i></a>"
		var time = "<a class='time timeIt' onclick='showdeadline("	+ orderObj.id+ ")'> <i class='fa fa-hourglass-half'></i> </a>"
		var history = "<a class='history historyit' onclick='viewTask("	+ orderObj.id+ ")'> <i class='fa fa-history'></i></a>"
		
		serviceUnitArray[orderObj.id] = orderObj;
		var tblRow = "<tr>"
			+ "<td title='"+orderObj.taskno+"'>"+ view2 + "</td>"
			+ "<td title='"+orderObj.departmentname+"'>"+ orderObj.departmentname + "</td>"
			+ "<td title='"+orderObj.category+"'>"+ orderObj.category + "</td>"
			+ "<td title='"+orderObj.assignto+"'>"+ orderObj.assignto + "</td>"
			+ "<td title='"+orderObj.assignby+"'>"+ orderObj.assignby + "</td>"
			+ "<td title='"+orderObj.subject+"'>"+ orderObj.subject + "</td>"
			+ "<td title='"+orderObj.description+"'>"+ orderObj.description + "</td>"
			+ "<td title='"+orderObj.severity+"'>"+ orderObj.severity + "</td>"
			+ "<td title='"+orderObj.strcreatedTime+"'>"+ orderObj.strcreatedTime + "</td>"
			+ "<td title='"+orderObj.kstatus+"'>"+ orderObj.kstatus + "</td>"
			/* + "<td title='"+orderObj.createdTime+"'>"+ new Date(orderObj.createdTime).toDateString() + "</td>" */
			+ "<td title='"+orderObj.taskdeadline+"'>"+ orderObj.taskdeadline + "</td>"
			
			+ "<td title='"+orderObj.notificationsfrequency+"'>"+ orderObj.notificationsfrequency + "</td>"
			/*+ "<td style='text-align: center;white-space: nowrap;'>" + edit + "&nbsp;&nbsp;" + deleterow + "&nbsp;&nbsp;" + comment + "&nbsp;&nbsp;" + time +  "&nbsp;&nbsp;"+history2+ "&nbsp;&nbsp;"+createDuplicate+"</td>" */
			+ "</tr>";
		$(tblRow).appendTo("#tableId table tbody");
	});
// 	if(isClick=='Yes') $('#example').dataTable();
 if(isClick=='Yes'){
$('.datatables').dataTable({
         dom: 'lBfrtip',
         
         
         buttons: [
{
    extend: 'csv',
    title: documentMessage,
    filename: documentMessage
  }, 
                   {
                                extend: 'pdfHtml5',
//                                 title : documentMessage,
						orientation : 'landscape',
							                pageSize : 'LEGAL',
                                                        exportOptions: {columns: [0,1,2,3,4,5,6,7,8,9]},
                                customize: function ( doc ) {/* 
                                                                doc.content.splice( 1, 0, {
                                                                        margin: [ 0, 0, 0, 12 ], 
                                                                        alignment: 'center'
                                                                                 });*/
                                                        }
                            }, {
      extend: 'excel',
      title: documentMessage,
      filename: documentMessage
    }, 
    {
extend: 'print',
customize: function ( win ) {
    $(win.document.body)
        .css( 'font-size', '10pt' )
       
        
    $(win.document.body).find( 'table' )
        .addClass( 'compact' )
        .css( 'font-size', 'inherit' );
}
}]

});
 }
 
}
	




/* $(function(){
	
	$('#example tfoot th').each( function () {
	        var title = $(this).text();
	        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
	    } );
	 
	    // DataTable
	    var table = $('#example').DataTable();
	 
	    // Apply the search
	    table.columns().every( function () {
	        var that = this;
	 
	        $( 'input', this.footer() ).on( 'keyup change', function () {
	            if ( that.search() !== this.value ) {
	                that
	                    .search( this.value )
	                    .draw();
	            }
	        } );
	    } );

	}); */

function createDuplicate(id) {
	
	//alert("Create Duplicte block");
	$("#subject").val(serviceUnitArray[id].subject);
	$("#category").val(serviceUnitArray[id].categoryid);
	$("#severity").val(serviceUnitArray[id].severityid);
	$("#priority").val(serviceUnitArray[id].priorityid);
	$("#assignby").val(serviceUnitArray[id].assignbyid);
	$("#assignto").val(serviceUnitArray[id].assigntoid);
	$("#uploadfile").val(serviceUnitArray[id].uploadfile);
	$("#description").val(serviceUnitArray[id].description);
	$("#notificationsfrequency").val(serviceUnitArray[id].notificationsfrequencyid);
	//$("#taskdeadline").val(serviceUnitArray[id].taskdeadline);
	$("#submit1").val("Update");
	$(window).scrollTop($('#severity').offset().top);
}

/* Create Duplicate Task */
function editTask(id) {
	$("#id").val(serviceUnitArray[id].id);
	$("#subject").val(serviceUnitArray[id].subject);
	$("#category").val(serviceUnitArray[id].categoryid);
	$("#severity").val(serviceUnitArray[id].severityid);
	$("#priority").val(serviceUnitArray[id].priorityid);
	$("#assignby").val(serviceUnitArray[id].assignbyid);
	$("#assignto").val(serviceUnitArray[id].assigntoid);
	$("#uploadfile").val(serviceUnitArray[id].uploadfile);
	$("#description").val(serviceUnitArray[id].description);
	$("#taskdeadline").val(serviceUnitArray[id].taskdeadline);
	$("#notificationsfrequency").val(serviceUnitArray[id].notificationsfrequencyid);
	$("#submitMainForm").val("Update");
	$(window).scrollTop($('#severity').offset().top);
}

/* view task history */

function viewTask(id){
		var formData = new FormData();
	    formData.append('id', id);
		$.fn.makeMultipartRequest('POST', 'viewTask', false, formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			var alldata = jsonobj.list;
			$('#HtableId').html('');
			var tableHead = '<table id="example" class="table table-striped table-bordered datatables">'
				+ '<thead><tr><th>Date Modified</th><th>User Name</th><th>Status</th><th>Attachment</th><th>Comment</th></tr></thead><tbody></tbody></table>';
		$('#HtableId').html(tableHead);
		$.each(alldata,function(i, orderObj) {
			if(orderObj.uploadfiles==undefined) orderObj.uploadfiles='';
			else
				{
					var list=orderObj.uploadfiles.split('*');
					var uploadfiles='';
					for(var i=0;i<list.length;i++)
					{
						uploadfiles=uploadfiles+'<a href="reportDocuments/'+list[i]+'" target="_blank" title="'+list[i]+'"><i class="fa fa-paperclip fa-lg grey"></i></a>';
					}
					orderObj.uploadfiles=uploadfiles;
				}
			var tblRow = "<tr>"
				+ "<td title='"+orderObj.statustime+"'>"+ orderObj.statustime + "</td>"
				+ "<td title='"+orderObj.issueid+"'>"+ orderObj.issueid + "</td>"
				+ "<td title='"+orderObj.kpstatus+"'>"+ orderObj.kpstatus + "</td>"
				+ "<td title='"+orderObj.uploadfiles+"'>"+ orderObj.uploadfiles + "</td>"
				+ "<td title='"+orderObj.comment+"'>"+ orderObj.comment + "</td>"
				+ "</tr>";
			$(tblRow).appendTo("#HtableId table tbody");
			
		});
			$("#myModal").modal();
		});


}



function viewTask2(id){
	var formData = new FormData();
    formData.append('id', id);
	$.fn.makeMultipartRequest('POST', 'viewTask2', false, formData, false, 'text', function(data){
		var jsonobj = $.parseJSON(data);
		var alldata = jsonobj.list;
		$('#HtableId2').html('');
		var tableHead = '<table id="example2" class="table table-striped table-bordered datatables">'
			+ '<thead><tr><th>Date Modified</th><th>User Name</th><th>Attachment</th><th>Field</th><th>Change</th></tr></thead><tbody></tbody></table>';
	$('#HtableId2').html(tableHead);
	$.each(alldata,function(i, orderObj) {
		if(orderObj.uploadfiles==undefined) orderObj.uploadfiles='';
		else
			{
				var list=orderObj.uploadfiles.split('*');
				var uploadfiles='';
				for(var i=0;i<list.length;i++)
				{
					uploadfiles=uploadfiles+'<a href="../reportDocuments/'+list[i]+'" target="_blank" title="'+list[i]+'"><i class="fa fa-paperclip fa-lg grey"></i></a>';
				}
				orderObj.uploadfiles=uploadfiles;
			}
		var tblRow = "<tr>"
			+ "<td title='"+orderObj.createdTime+"'>"+ orderObj.createdTime + "</td>"
			+ "<td title='"+orderObj.changedby+"'>"+ orderObj.changedby + "</td>"
			+ "<td title='"+orderObj.uploadfiles+"'>"+ orderObj.uploadfiles + "</td>"
			+ "<td title='"+orderObj.kpfield+"'>"+ orderObj.kpfield + "</td>"
			+ "<td title='"+orderObj.kpchange+"'>"+ orderObj.kpchange + "</td>"
			+ "</tr>";
		$(tblRow).appendTo("#HtableId2 table tbody");
		
	});
		$("#myModal2").modal();
	});


}





var cissueid =0;
function addComment(id){
	
	cissueid=id;
	$("#issueid").val(id);
	$("#formModal").modal();
	
	//alert(serviceUnitArray[id].kstatusid);

	$("#kpstatus").val(serviceUnitArray[id].kstatusid);
	
	
	
}

var countDownDate;

var x =0;

function showdeadline(id){
	
	
	//$('#timeModal').html('');
	countDownDate=serviceUnitArray[id].taskdeadline
	
	  var count = new Date(countDownDate).getTime();
	/*  x=setInterval(function() {clearInterval();}); */

	// Update the count down every 1 second
	if(x == 0)
		{
	 x = setInterval(function() {
	    // Get todays date and time
	    var now = new Date().getTime();
	    
	    // Find the distance between now an the count down date
	    var distance = count - now;
	    
	    document.getElementById("demo").innerHTML='';    
	    
	    // Time calculations for days, hours, minutes and seconds
	    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
	    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
	   // var seconds = Math.floor((distance % (1000 * 60)) / 1000);
	   var seconds ="";
	    document.getElementById("demo").innerHTML='';
	    // Output the result in an element with id="demo"
	    document.getElementById("demo").innerHTML = days + "d " + hours + "h "
	    + minutes + "m " + seconds + " ";
	    
	    
	    // If the count down is over, write some text 
	    if (distance < 0) {
	        document.getElementById("demo").innerHTML = "EXPIRED";
	        showdeadline();
	    }
	}, 1000);
	 
	 $("#timeModal").modal();
		}
	else
		{
		clearInterval(x);
		  document.getElementById("demo").innerHTML=''; 
		
		x = setInterval(function() {
		    // Get todays date and time
		    var now = new Date().getTime();
		    
		    // Find the distance between now an the count down date
		    var distance = count - now;
		    
		    document.getElementById("demo").innerHTML='';    
		    
		    // Time calculations for days, hours, minutes and seconds
		    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
		    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
		    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
		  //  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
		  var seconds ="";
		    document.getElementById("demo").innerHTML='';
		    // Output the result in an element with id="demo"
		    document.getElementById("demo").innerHTML = days + "d " + hours + "h "
		    + minutes + "m " + seconds + " ";
		    
		    
		    // If the count down is over, write some text 
		    if (distance < 0) {
		        document.getElementById("demo").innerHTML = "EXPIRED";
		        showdeadline();
		    }
		}, 1000);
		$("#timeModal").modal();
		 
		
		}
		
	
	
	
	
	
}

	
$('#ttype').on('change', function() {
	  var ttype=$('#ttype').val();
	  var formData = new FormData();
	    formData.append('ttypeid', ttype);
	$.fn.makeMultipartRequest('POST', 'setdata', false, formData, false, 'text', function(data){
		var jsonobj = $.parseJSON(data);
		var alldata = jsonobj.list;
			displayTable(alldata);
			toolTips()
			makeEmpty()
				
	 });
	})
	
	
	
	
	var idArrayCmt11 = null;
	
	function submitCommet()
	{
	 idArrayCmt11 = $.makeArray($('.validate2').map(function() {
		return this.id;
		}));
	validation = true;
	$.each(idArrayCmt11, function(i, val) {
		var value = $("#" + idArrayCmt11[i]).val();
		var placeholder = $("#" + idArrayCmt11[i]).attr('placeholder');
		if (value == null || value == "" || value == "undefined") {
			$('style').append(styleBlock);
			$("#" + idArrayCmt11[i] ).attr("placeholder", placeholder);
			$("#" + idArrayCmt11[i] ).css('border-color','#e73d4a');
			$("#" + idArrayCmt11[i] ).css('color','#e73d4a');
			$("#" + idArrayCmt11[i] ).addClass('placeholder-style your-class');
			 var id11 = $("#" + idArrayCmt11[i]+"_chosen").length;
			if ($("#" + idArrayCmt11[i]+"_chosen").length)
			{
				$("#" + idArrayCmt11[i]+"_chosen").children('a').css('border-color','#e73d4a');
			}
//			$("#" + idArray[i] + "Error").text("Please " + placeholder);
			validation = false;
		} 
	});
	if(validation) {
		
	}else {
		return false;
	}
			var kpstatus=$('#kpstatus').val();
		    var commet=$('#commet').val();
		    var issueid=$('#issueid').val();
		    var id=$('#id').val();
			   
			   var formData = new FormData();
			   
			   formData.append('commet', commet);
			   formData.append('kpstatus', kpstatus);
			   formData.append('issueid', issueid);
			   formData.append('id',id);
			   
			   
			   
	    	var ins = document.getElementById('fileupload').files.length;
	    	
	    	for(var i=0; i< ins; i++)
	    	{	
	    	var portfolio_values = document.getElementById('fileupload').files[i];
			formData.append('file[]', portfolio_values);
			}
	    	
	    	
	 		$.ajax({
				type:"post",
				enctype: 'multipart/form-data',
			  	url: "subTask", 
			  	data:formData,
			  	processData: false,  // tell jQuery not to process the data
				contentType: false,  // tell jQuery not to set contentType
			  	
			  	success: function(result){
			  		if(result !="" && result != null){
			  			
			  		alert(result)
			  		}
			  	    location.reload();
			  		$('#kpstatus').val("");
			  		$('#commet').val("");
			  		$('#fileupload').val("");
			  		 $('#formModal').modal('toggle');
			  	
			    },
			    error: function (e) {
		            console.log(e.responseText);
		        }
					    
			});
		
	}
		
	
	
	
	
	
	



function deletetask(id,status){
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
		$.fn.makeMultipartRequest('POST', 'deleteTask', false, formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			var alldata = jsonobj.allOrders1;
			var result=$.parseJSON(alldata);
			displayTable(result);
		});
	}
}


$('#kpstatus').on('change',function() {
	var issueCreatedBY =(serviceUnitArray[cissueid].assignbyid);
	var loginid=${objuserBean.id}
	
	if($('#kpstatus').val()=='1')
	{
	
	if( issueCreatedBY!= loginid)
		{
		
		alert("you are not authorized to close ticket");
		$('#kpstatus').css('border-color', 'red');
		$('#kpstatus').val("");
		$('#modelSubmit').prop('disabled',true)
		}
	else
		{
		
		$('#modelSubmit').prop('disabled',false);
		}
	}
	else {
		$('#modelSubmit').prop('disabled',false);
		$('#kpstatus').css('border-color', 'black');
	}
	
		
});




 

/* function inactiveData() {
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
		
} */

// main form validation

var idArrayCmt1 = $.makeArray($('.validate1').map(function() {
	return this.id;
}));
$('#submitMainForm').click(function(event) {
	validation = true;
	$.each(idArrayCmt1, function(i, val) {
		var value = $("#" + idArrayCmt1[i]).val();
		var placeholder = $("#" + idArrayCmt1[i]).attr('placeholder');
		if (value == null || value == "" || value == "undefined") {
			$('style').append(styleBlock);
			$("#" + idArrayCmt1[i] ).attr("placeholder", placeholder);
			$("#" + idArrayCmt1[i] ).css('border-color','#e73d4a');
			$("#" + idArrayCmt1[i] ).css('color','#e73d4a');
			$("#" + idArrayCmt1[i] ).addClass('placeholder-style your-class');
			 var id11 = $("#" + idArrayCmt1[i]+"_chosen").length;
			if ($("#" + idArrayCmt1[i]+"_chosen").length)
			{
				$("#" + idArrayCmt1[i]+"_chosen").children('a').css('border-color','#e73d4a');
			}
//			$("#" + idArray[i] + "Error").text("Please " + placeholder);
			validation = false;
		} 
	});
	if(validation) {
		$("#submitMainForm").attr("disabled",true);
		$("#submitMainForm").val("Please wait...");
		$("#taskf").submit();											
		event.preventDefault();
	}else {
		return false;
		event.preventDefault();
	}
});


$(".cancel1").click(function()
		{
			$("#id").val(0);
			$.each( idArrayCmt11, function(i, val)
			{
				var value = $("#" +  idArrayCmt11[i]).val();
				if ($("#" + idArrayCmt11[i]+"_chosen").length)
				{
					$("#" + idArrayCmt11[i]).val("");
					$("#" + idArrayCmt11[i]).trigger("chosen:updated");
				}
//				$("form")[0].reset();
				$("#"+ idArrayCmt11[i]).val('');
				$("#"+ idArrayCmt11[i]).prop('readonly',false);
				$("#"+ idArrayCmt11[i]).css('border-color','');
				$("#"+ idArrayCmt11[i]).css('color','black');
				$("#"+ idArrayCmt11[i]).removeClass('placeholder-style your-class default-class');
				if ($("#" +  idArrayCmt11[i]+"_chosen").length)
				{
					$("#" +  idArrayCmt11[i]+"_chosen").children('a').css('border-color','black');
				}
			});
		});

$(".cancel2").click(function()
		{
			$("#id").val(0);
			$.each( idArrayCmt1, function(i, val)
			{
				var value = $("#" +  idArrayCmt1[i]).val();
				if ($("#" + idArrayCmt1[i]+"_chosen").length)
				{
					$("#" + idArrayCmt1[i]).val("");
					$("#" + idArrayCmt1[i]).trigger("chosen:updated");
				}
//				$("form")[0].reset();
				$("#"+ idArrayCmt1[i]).val('');
				$("#"+ idArrayCmt1[i]).prop('readonly',false);
				$("#"+ idArrayCmt1[i]).css('border-color','');
				$("#"+ idArrayCmt1[i]).css('color','black');
				$("#"+ idArrayCmt1[i]).removeClass('placeholder-style your-class default-class');
				if ($("#" +  idArrayCmt1[i]+"_chosen").length)
				{
					$("#" +  idArrayCmt1[i]+"_chosen").children('a').css('border-color','black');
				}
			});
		});
		
		
document.getElementById("file1").onchange = function () {
    var reader = new FileReader();
    if(this.files[0].size>528385){
        alert("file Size should not be greater than 528Kb");
        $("#file1").attr("src","blank");
       // $("#file1").hide();  
        $('#file1').wrap('<form>').closest('form').get(0).reset();
        $('#file1').unwrap();     
        return false;
    }
    /* if(this.files[0].type.indexOf("image")==-1){
        alert("Invalid Type");
        $("#file1").attr("src","blank");
        //$("#file1").hide();  
       $('#file1').wrap('<form>').closest('form').get(0).reset();
      //  $('#file1').unwrap();         
        return false;
    }    */
    reader.onload = function (e) {
        // get loaded data and render thumbnail.
        document.getElementById("menu_image").src = e.target.result;
        $("#file1").show(); 
    };

    // read the image file as a data URL.
    reader.readAsDataURL(this.files[0]);
};


$("#getdatabydates").click(function(){
	
	var fromdateval =	$("#dateFrom").val();
	var todateval =	$("#dateTo").val();
	
	if(fromdateval == "")
		{
		alert("select From Date")
		return false;
		}
	if(todateval == "")
	{
	alert("select Too Date")
	return false;
	}
	
	
	
	
	$.ajax({
		type : "GET",
		url : "getDataByDates",
		data : "fromdateval="+fromdateval+"&todateval="+todateval,
		dataType : "text",
		beforeSend : function() {
             $.blockUI({ message: 'Please wait' });
          }, 
		success : function(data) {
			var parsejson = JSON.parse(data);
			var list =parsejson.listByDates;
			displayTable(list);
			
			
		},
		complete: function () {
            
            $.unblockUI();
       },
		error :  function(e){$.unblockUI();console.log(e);}
		
	});


	
});

 $("#print").click(function(){
$("#example").printThis({
	 debug: false,               // show the iframe for debugging
	  importCSS: true,            // import page CSS
	  importStyle: false,         // import style tags
	  printContainer: true, 
	  pageTitle: "hi leelakrishna", 
	  removeInline: false
	 
 });
});
 

$("#pageName").text("ViewTasks");
$(".taskfilter").addClass("active"); 
</script> 
<script type="text/javascript">
		 $('.panel-collapse').on('show.bs.collapse', function () {
    $(this).siblings('.panel-heading').addClass('active');
  });

  $('.panel-collapse').on('hide.bs.collapse', function () {
    $(this).siblings('.panel-heading').removeClass('active');
  });

$(".openinput").click(function(){
    var id=$(this).attr('id');
    $("."+id+"_text").css("display","none");
    $("."+id+"_input").removeClass("dispnone");
});




$("#searchpanel").click(function(){
	
var assignedbyid =$("#assignedbyid").val();

var assignedtoid =  $("#assignedtoid").val();

var priorityid =$("#priorityid").val();

var categoryid =$("#categoryid").val();

var deptid =$("#deptid").val();

var kstatusid =$("#kstatusid").val();

var fromdateval =	$("#dateFrom").val();
var todateval =	$("#dateTo").val();

var sfromdateval =	$("#sdateFrom").val();
var utodateval =	$("#udateTo").val();


   if(fromdateval != "")
	  {
	    if(sfromdateval =="" ||fromdateval == 'undefined' )  
	    	{
	    	alert("Select To date");
	    	return false;
	    	}
	  
	  }
  
  
  if(sfromdateval != "")
  {
    if(fromdateval =="" ||fromdateval == 'undefined' )  
    	{
    	alert("Select From Date");
    	return false;
    	}
  
  } 
  
  

  if(todateval != "")
	  {
	    if(utodateval =="" ||utodateval == 'undefined' )  
	    	{
	    	alert("Select To date");
	    	return false;
	    	}
	  
	  }
  
  
  if(utodateval != "")
  {
    if(todateval =="" ||todateval == 'undefined' )  
    	{
    	alert("Select From Date");
    	return false;
    	}
  
  }
  
  
  
  
  




  if(fromdateval =="" || fromdateval == 'undefined' || sfromdateval == ""  || sfromdateval == 'undefined')
	  {
	  fromdateval =0;
	  }
  
  if(todateval =="" ||todateval == 'undefined' || utodateval  == "" || utodateval == 'undefined' )
  {
	  todateval =0;
  }
  
  




console.log(assignedbyid+"--"+assignedtoid+"  "+priorityid+"  "+categoryid+"  "+deptid+"  "+kstatusid);


$.ajax({
	type : "GET",
	url : "getDataByFilter",
	data : "assignedbyid="+assignedbyid+"&assignedtoid="+assignedtoid+"&priorityid="+priorityid+"&categoryid="+categoryid+"&deptid="+deptid+"&kstatusid="+kstatusid+"&fromdateval="+fromdateval+"&todateval="+todateval+"&sfromdateval="+sfromdateval+"&utodateval="+utodateval,
	dataType : "text",
	beforeSend : function() {
         $.blockUI({ message: 'Please wait' });
      }, 
	success : function(data) {
		var parsejson = JSON.parse(data);
		var list =parsejson.listByDates;
		displayTable(list);

		$("#dateFrom").val("");
	$("#dateTo").val("");
	

	$("#sdateFrom").val("");
$("#udateTo").val("");
		
		
	},
	complete: function () {
        
        $.unblockUI();
   },
	error :  function(e){$.unblockUI();console.log(e);}
	
});


});

$("#frset").click(function (){
	
	$("#assignedbyid").val("0");

	 $("#assignedtoid").val("0");

	$("#priorityid").val("0");

	$("#categoryid").val("0");

	$("#deptid").val("0");

	$("#kstatusid").val("0");
	

		$("#dateFrom").val("");
	$("#dateTo").val("");
	

	$("#sdateFrom").val("");
$("#udateTo").val("");

});




	</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

 <!--  new print -->
<script type='text/javascript' src='https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js'></script> 
<script type='text/javascript' src='https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js'></script>
<script type='text/javascript' src='https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js'></script>
<script type='text/javascript' src='https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js'></script> 



<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js'></script>
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js'></script>
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js'></script>

<script type='text/javascript' src="${baseurl }/js/ajax.js" ></script>
 <!-- new print -->