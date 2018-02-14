<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
<script type="text/javascript" src="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/a549aa8780dbda16f6cff545aeabc3d71073911e/src/js/bootstrap-datetimepicker.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/a549aa8780dbda16f6cff545aeabc3d71073911e/build/css/bootstrap-datetimepicker.css">
<script type='text/javascript'>
$(function () {

	 $('#taskdeadline').datetimepicker({        

	    useCurrent: false,
	    format: 'DD-MMM-YYYY hh:mm A',
	    showTodayButton: true,
	    sideBySide: true,
// 	    showClose: true,
// 	    showClear: true,
	    toolbarPlacement: 'top'

	  });
	});

</script>












	<div class="clearfix"></div>
	<ol class="breadcrumb">
		<li><a href="#">Home</a></li>
		<li>Task Master</li>
	</ol>
	                       <div class="clearfix"></div><br>
	                       <form>
	                        <div class="row">
                    		<div class="col-md-4">
                    			<div class="form-horizontal">
									<label for="focusedinput" class="col-md-6 control-label" style="padding-top:2px;">Tasks Types <span class="impColor">*</span></label>
									<select id="ttype"  class="col-xs-10 col-sm-5 " >
											<c:forEach var="list" items="${tasksSelection}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
                    			</div>
                    		</div>
                    		<div class="col-md-4">
                    			<div class="form-horizontal">
									<label for="focusedinput" class="col-md-6 control-label" style="padding-top:2px;">Department  <span class="impColor">*</span></label>
									<select id="deptid"  class="col-xs-10 col-sm-5 " >
											<c:forEach var="list" items="${departmentNames}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
                    			</div>
                    		</div>
                    		</div>
                    		</form>
                    		<br>
	<div class="clearfix"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Task List</h4>
						<div class="options">
							<a href="javascript:;" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
						</div>
					</div>
					<div class="panel-body collapse in">
					<input type="checkbox" class="form-check-input" onclick="inactiveData();" id="inActive"> <label class="form-check-label">Show Inactive List</label>
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
		<div class="row" id="moveTo">
			<div class="col-md-12 col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Add Task</h4>
					</div>
					<form:form class="form-horizontal" modelAttribute="taskf"  action="savetask" method="post" enctype="multipart/form-data">
					<div class="panel-body">
						<div class="row">
                    		<div class="col-md-6">
                    			<div class="form-group">
                    				<form:hidden path="id"/>
									<label for="focusedinput" class="col-md-6 control-label">Category  <span class="impColor">*</span></label>
									<form:select path="category" class="col-xs-10 col-sm-5 validate1" onfocus="removeBorder(this.id)" >
											<form:option value="" label="--- Select ---" />
											<form:options items="${category}"/>
										</form:select>
                    			</div>
                    		</div>
                    		<div class="col-md-6">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Severity <span class="impColor">*</span></label>
									
										<form:select path="severity" class="col-xs-10 col-sm-5 validate1" onfocus="removeBorder(this.id)">
										<form:option value="" label="--- Select ---" />
										 <form:options items="${severity}"/>
										</form:select>	
										<span class="hasError" id="stationnameError"></span>
								    
                    			</div>
                    		</div>
                    		
                    		
                    	</div>
                    	<div class="row">
                    		<div class="col-md-6">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Priority  <span class="impColor">*</span></label>
									<form:select path="priority" class="col-xs-10 col-sm-5 validate1" >
											<form:option value="" label="--- Select ---" />
											<form:options items="${priority}"></form:options>
										</form:select>
                    			</div>
                    		</div>
                    		<div class="col-md-6">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Assigned to <span class="impColor">*</span></label>
									
										<form:select path="assignto" class="col-xs-10 col-sm-5 validate1" onfocus="removeBorder(this.id)">
											<form:option value="" label="--- Select ---" />
										 	<form:options items="${userNames}"/>
										</form:select>
										<span class="hasError" id="stationnameError"></span>
								    
                    			</div>
                    		</div>
                    		
                    		
                    	</div>
                    	<div class="row">
                    		<div class="col-md-6">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Summary  <span class="impColor">*</span></label>
									<form:input path="subject"  placeholder="Summary" class="col-xs-10 col-sm-5 validate1" />
                    			</div>
                    		</div>
                    		<div class="col-md-6">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Description <span class="impColor">*</span></label>
									<div class="col-md-5">
									<form:textarea path="description" class="form-control validate1" placeholder="Enter Description"/>
									<span class="hasError" id="stationnameError"></span>
								    </div>
                    			</div>
                    		</div>
                    	</div>
                    	
                    	<div class="row">
                    		<div class="col-md-6">
                    		<div class="form-group">
                    		<label class="ace-file-input ace-file-multiple col-sm-3 col-md-push-3 control-label no-padding-right" >Attach File(s)</label>
									<div class="col-md-8">
										<input type="file" name="file1" id="file1" class="col-sm-9 col-md-push-5" multiple="multiple" style="margin: 7px 0px 0px 0px;">
									</div>
                    		</div>
                    		</div>
                    		<div class="col-md-6">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Task DeadLine <span class="impColor">*</span></label>
									<div class="col-md-6">
								    	<form:input path="taskdeadline" value="" class="form-control validate "  placeholder="Task deadLine" />
								    </div>
                    			</div>
                    		</div>
                    		</div>
                    		
                    		<div id="getting-started"></div>
                    		


					</div>
					<div class="panel-footer">
				      	<div class="row">
				      		<div class="col-sm-12">
				      			<div class="btn-toolbar text-center">
					      			<input type="submit" id="submitMainForm"  value="Submit" class="btn-primary btn"/>
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
	
	
	<!-- Task History Modal Starts here-->
<div class="modal fade" id="myModal" data-backdrop="static" data-keyboard="false" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header"  style="background: #4f8edc;">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"> Task History </h4>
        	</div>
        	<div class="modal-body">
				<div class="row">
				<div class="table-responsive" id="HtableId">
							<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered datatables" id="example">
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
			
			
			
			
			
<!-- add comment Modal Starts here-->
<div class="modal fade" id="formModal" data-backdrop="static" data-keyboard="false" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="background: #2973cf;">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" style="color: white;"> Add Comment </h4>
        	</div>
        	<div class="modal-body">
					<form class="form-horizontal">
					<div class="panel-body">
						<div class="row">
                    		<div class="col-md-5">
                    			<div class="form-group">
                    				<!-- <input type=hidden path="id"/> -->
                    				
                    				<input type=hidden name="issueid" id="issueid" value="">
                    				
									<label for="focusedinput" class="col-md-6 control-label">Status  <span class="impColor">*</span></label>
										<select  name="kpstatus" id="kpstatus" class="col-xs-10 col-sm-5  validate2 " >
											<c:forEach var="list" items="${kpstatuses}">
											<option value=${list.key}>${list.value} </option>
											</c:forEach>
										</select>
                    			</div>
                    		</div>
                    		<div class="col-md-6">
                    		<div class="form-group" style=" width: 154%;">
									<label class="ace-file-input ace-file-multiple col-sm-3 control-label no-padding-right" >Attach File(s)</label>
									<div class="col-md-9">
										<input type="file" name="fileupload[]" id="fileupload" multiple style="margin: 5px 0px 0px 0px;">
									</div>
							</div>
							</div>
							</div>
							<br>
							<div class="row">
                    		<div class="col-md-7">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Comment <span class="impColor">*</span></label>
									<div class="col-md-6">
									<input type="text"  name="commet" id="commet"  onkeyup="removeBorder(this.id)" class="form-control validate2" placeholder="Enter commit" style="width: 320px;">
									<span class="hasError" id="stationnameError"></span>
								    </div>
                    			</div>
                    		</div>
                    		
                    		</div>
                    		
                    		
                    		<div class="panel-footer">
				      	<div class="row">
				      		<div class="col-sm-12">
				      			<div class="btn-toolbar text-center">
					      			<input type="button" id="modelSubmit" value="Submit"  onclick="submitCommet()" class="btn-primary btn"/>
					      			<input type="reset" value="Reset" class="btn-danger btn cancel"/>
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
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" style="color: white;">Task Count Down</h4>
			</div>
			<div> </div>	<div class="modal-body">
			<p id="demo"></p>
			
			</div>
		</div>
	</div>
	</div>   <!-- deadline Model ends here -->
	
	
	


<script type="text/javascript">
var loginUserId =${objuserBean.id};
var listOrders1 = ${allOrders1};
if (listOrders1 != "") {
	displayTable(listOrders1)
}

function displayTable(listOrders) {
	$('#tableId').html('');
	var tableHead = '<table id="example" class="table table-striped table-bordered datatables">'
			+ '<thead><tr><th>Task No</th><th>Summary</th><th>Category</th><th>priority</th><th>Assigned</th><th>Created Time</th><th style="text-align: center;"></th></tr></thead><tbody></tbody></table>';
	$('#tableId').html(tableHead);
	serviceUnitArray = {};
	
	$.each(listOrders,function(i, orderObj) {
		if(loginUserId == "1")
			{
		if(orderObj.status == "1"){
			var deleterow = "<a class='deactivate' onclick='deletetask("+ orderObj.id+ ",0)'><i class='fa fa-eye'></i></a>"
		}else{  
			var deleterow = "<a class='activate' onclick='deletetask("+ orderObj.id+ ",1)'><i class='fa fa-eye-slash'></i></a>"
		}
		
		var edit = "<a class='edit editIt' onclick='editTask("	+ orderObj.id+ ")'><i class='fa fa-edit'></i></a>"
		
			}
		else
		{
			edit ="";
			deleterow ="";
		}
		
		
		
		
		var view = "<a class='view viewIt' onclick='viewTask("	+ orderObj.id+ ")'>"+ orderObj.taskno+ "</a>"
		var comment = "<a class='comment commentIt' onclick='addComment("	+ orderObj.id+ ")'>   <i class='fa fa-comments'></i></a>"
		var time = "<a class='time timeIt' onclick='showdeadline("	+ orderObj.id+ ")'> <i class='fa fa-hourglass-half'></i> </a>"
		serviceUnitArray[orderObj.id] = orderObj;
		var tblRow = "<tr>"
			+ "<td title='"+orderObj.taskno+"'>"+ view + "</td>"
			+ "<td title='"+orderObj.subject+"'>"+ orderObj.subject + "</td>"
			+ "<td title='"+orderObj.category+"'>"+ orderObj.category + "</td>"
			+ "<td title='"+orderObj.priority+"'>"+ orderObj.priority + "</td>"
			+ "<td title='"+orderObj.assignto+"'>"+ orderObj.assignto + "</td>"
			+ "<td title='"+orderObj.createdTime+"'>"+ new Date(orderObj.createdTime).toDateString() + "</td>"
			+ "<td style='text-align: center;white-space: nowrap;'>" + edit + "&nbsp;&nbsp;" + deleterow + "&nbsp;&nbsp;" + comment + "&nbsp;&nbsp;" + time + "</td>" 
			+ "</tr>";
		$(tblRow).appendTo("#tableId table tbody");
	});
	if(isClick=='Yes') $('#example').dataTable();
	
}


function editTask(id) {
	$("#id").val(serviceUnitArray[id].id);
	$("#subject").val(serviceUnitArray[id].subject);
	$("#category").val(serviceUnitArray[id].categoryid);
	$("#severity").val(serviceUnitArray[id].severityid);
	$("#priority").val(serviceUnitArray[id].priorityid);
	$("#assignto").val(serviceUnitArray[id].assigntoid);
	$("#uploadfile").val(serviceUnitArray[id].uploadfile);
	$("#description").val(serviceUnitArray[id].description);
	$("#taskdeadline").val(serviceUnitArray[id].taskdeadline);
	$("#submit1").val("Update");
	$(window).scrollTop($('#moveTo').offset().top);
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






function addComment(id){
	$("#issueid").val(id);
	$("#formModal").modal();
	
	
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
	    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
	    document.getElementById("demo").innerHTML='';
	    // Output the result in an element with id="demo"
	    document.getElementById("demo").innerHTML = days + "d " + hours + "h "
	    + minutes + "m " + seconds + "s ";
	    
	    
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
		    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
		    document.getElementById("demo").innerHTML='';
		    // Output the result in an element with id="demo"
		    document.getElementById("demo").innerHTML = days + "d " + hours + "h "
		    + minutes + "m " + seconds + "s ";
		    
		    
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
	 });
	  
	  
	  
	})
	
	
	
	
	$("#deptid").on('change', function() {
		 var dept=$('#deptid').val();
		 var formData = new FormData();
		    formData.append('deptid', dept);
		$.fn.makeMultipartRequest('POST', 'setdataDeptWise', false, formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			var alldata = jsonobj.allOrders1;
			var myJSON = JSON.stringify(alldata);
				displayTable(alldata);
		
		 
		 
		 });
	})
	
	
	
	
	function submitCommet()
	{
	var idArrayCmt11 = $.makeArray($('.validate2').map(function() {
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
			   
			   var formData = new FormData();
			   
			   formData.append('commet', commet);
			   formData.append('kpstatus', kpstatus);
			   formData.append('issueid', issueid);
			   
			   
			   
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
			window.location.reload();
			var alldata = jsonobj.allOrders1;
			displayTable(alldata);
		});
	}
}


$('#kpstatus').on('change',function() {
	var issueCreatedBY =$('#ttype').val();
	var loginid=${objuserBean.id}
	
	if($('#kpstatus').val()=='1')
		{
		
	if( issueCreatedBY!= "2")
		{
		
		alert("you are not authorized to close ticket");
		$('#kstatus').css('border-color', 'red');
		$('#kstatus').val("");
		$('modelSubmit').prop('disabled',true)
		}
	else
		{
		
		$('modelSubmit').prop('disabled',false)
		}
	
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





$("#pageName").text("Task Master");
$(".task").addClass("active"); 
</script>