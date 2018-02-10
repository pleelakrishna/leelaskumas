<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<div class="clearfix"></div>
	<ol class="breadcrumb">
		<li><a href="#">Home</a></li>
		<li>Task Master</li>
	</ol>
	                       <div class="clearfix"></div><br>
	                       <form:form commandName="taskf">
	                        <div class="row">
                    		<div class="col-md-4">
                    			<div class="form-horizontal">
									<label for="focusedinput" class="col-md-6 control-label" style="padding-top:2px;">Tasks Types <span class="impColor">*</span></label>
									<select name="ttype" id="ttype" class="col-xs-10 col-sm-5" onfocus="removeBorder(this.id)" >
											<!-- <option value="0">Select</option> -->
											<option value="1" >Assigned to</option>
											<option value="2" >Assigned by</option>
											<option value="3" >Monitored by</option>
											<option value="4" >Resolved</option>
											
										</select>
                    			</div>
                    		</div>
                    		<div class="col-md-4">
                    			<div class="form-horizontal">
									<label for="focusedinput" class="col-md-6 control-label" style="padding-top:2px;">Department  <span class="impColor">*</span></label>
									<form:select path="additionalinfo" class="col-xs-10 col-sm-5 " onfocus="removeBorder(this.id)" >
											<form:options items="${departmentNames}"/>
										</form:select>
                    			</div>
                    		</div>
                    		</div>
                    		</form:form>
	
	
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
<!-- 		<a class="btn btn-info btn-lg"  onclick="PopupFillingStation();">Add Gas</a><br><br> -->
		<div class="row" id="moveTo">
			<div class="col-md-12 col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Add Task</h4>
					</div>
					<form:form class="form-horizontal" commandName="taskf" role="form" id="fillingstation-form" action="task" method="post" enctype="multipart/form-data">
					<div class="panel-body">
						<div class="row">
                    		<div class="col-md-6">
                    			<div class="form-group">
                    				<form:hidden path="id"/>
									<label for="focusedinput" class="col-md-6 control-label">Category  <span class="impColor">*</span></label>
									<form:select path="category" class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)" >
											<form:option value="" label="--- Select ---" />
											<form:options items="${category}"/>
										</form:select>
                    			</div>
                    		</div>
                    		<div class="col-md-6">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Severity <span class="impColor">*</span></label>
									
										<form:select path="severity" class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)">
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
									<form:select path="priority" class="col-xs-10 col-sm-5 validate" >
											<form:option value="" label="--- Select ---" />
											<form:options items="${priority}"></form:options>
										</form:select>
                    			</div>
                    		</div>
                    		<div class="col-md-6">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Assigned to <span class="impColor">*</span></label>
									
										<form:select path="assignto" class="col-xs-10 col-sm-5 validate" onfocus="removeBorder(this.id)">
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
									<form:input path="subject"  placeholder="Summary" class="col-xs-10 col-sm-5 validate" />
                    			</div>
                    		</div>
                    		<div class="col-md-6">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Description <span class="impColor">*</span></label>
									<div class="col-md-5">
									<form:textarea path="description" class="form-control validate" placeholder="Enter Description"/>
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
										<input type="file" name="file" id="file" class="col-sm-9 col-md-push-5" multiple="multiple" style="margin: 7px 0px 0px 0px;">
									</div>
                    		</div>
                    		</div>
                    		</div>
                    		
<!-- Modal Ends here-->

					</div>
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
	
	
	<!-- Modal Starts here-->
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
        	<!-- <div class="modal-footer">
          		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        	</div> -->
      	</div>
    </div>
</div>
<!-- Modal Ends here-->
			
			
			<!-- form model start here or add comment  -->
			
<%-- 			
<!-- Modal Starts here-->
<div class="modal fade" id="formModal" data-backdrop="static" data-keyboard="false" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="background: #2973cf;">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" style="color: white;"> Add Comment </h4>
        	</div>
        	<div class="modal-body">
					<form:form class="form-horizontal" commandName="subTaskf"  method="post" enctype="multipart/form-data">
					<div class="panel-body">
						<div class="row">
                    		<div class="col-md-5">
                    			<div class="form-group">
                    				<form:hidden path="id"/>
                    				
                    				<form:hidden path="issueid"/>
                    				
									<label for="focusedinput" class="col-md-6 control-label">Status  <span class="impColor">*</span></label>
									<form:select path="kpstatus" class="col-xs-10 col-sm-5 validateCmt" onfocus="removeBorder(this.id)" style="margin: 6px 0px 0px 0px;
    width: 50%;" >
											<form:option value="" label="--- Select ---" />
											<form:options items="${kpstatuses}"/>
										</form:select>
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
									<form:textarea path="comment" class="form-control validateCmt" placeholder="Enter commit" style="width: 320px;"/>
									<span class="hasError" id="stationnameError"></span>
								    </div>
                    			</div>
                    		</div>
                    		
                    		</div>
                    		
                    		
                    		<div class="panel-footer">
				      	<div class="row">
				      		<div class="col-sm-12">
				      			<div class="btn-toolbar text-center">
					      			<input type="button" id="submit2" value="Submit"  onclick="submitCommet()" class="btn-primary btn"/>
					      			<input type="reset" value="Reset" class="btn-danger btn cancel"/>
				      			</div>
				      		</div>
				      	</div>
			      	</div>
                    		</div>
                    		
                    		</form:form>
                    		
				</div> <!-- body -->
					
				</div> <!-- content end here -->
				
			</div>  <!--  dialog ends here-->
        	<!-- <div class="modal-footer">
          		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        	</div> -->
      	</div> <!--  model close here-->
<!-- Modal Ends here-->
			<!-- container -->
 --%>			
			
			
			
			


</body>
<%-- <script type='text/javascript' src='${baseurl }/js/custemValidation.js'></script>  --%>
<script>
</script>
<script type="text/javascript">
var listOrders1 = ${allOrders1};
if (listOrders1 != "") {
	displayTable(listOrders1)
}

function displayTable(listOrders) {
	$('#tableId').html('');
	var tableHead = '<table id="example" class="table table-striped table-bordered datatables">'
			+ '<thead><tr><th>TaskNo</th><th>Summary</th><th>Category</th><th>priority</th><th>Assigned</th><th>UpdatedTime</th><th style="text-align: center;"></th></tr></thead><tbody></tbody></table>';
	$('#tableId').html(tableHead);
	serviceUnitArray = {};
	$.each(listOrders,function(i, orderObj) {
		if(orderObj.status == "1"){
			var deleterow = "<a class='deactivate' onclick='deletetask("+ orderObj.id+ ",0)'><i class='fa fa-eye'></i></a>"
		}else{  
			var deleterow = "<a class='activate' onclick='deletetask("+ orderObj.id+ ",1)'><i class='fa fa-eye-slash'></i></a>"
		}
		var edit = "<a class='edit editIt' onclick='editCylinder("	+ orderObj.id+ ")'><i class='fa fa-edit'></i></a>"
		var view = "<a class='view viewIt' onclick='viewTask("	+ orderObj.id+ ")'>"+ orderObj.taskno+ "</a>"
		var comment = "<a class='view viewIt' onclick='addComment("	+ orderObj.id+ ")'>   <i class='fa fa-comments'></i></a>"
		var time = "<a class='view viewIt' onclick='showdeadline()'> <i class='fa fa-hourglass-half'></i> </a>"
		serviceUnitArray[orderObj.id] = orderObj;
		var tblRow = "<tr>"
			+ "<td title='"+orderObj.taskno+"'>"+ view + "</td>"
			+ "<td title='"+orderObj.subject+"'>"+ orderObj.subject + "</td>"
			+ "<td title='"+orderObj.category+"'>"+ orderObj.category + "</td>"
			+ "<td title='"+orderObj.priority+"'>"+ orderObj.priority + "</td>"
			+ "<td title='"+orderObj.assignto+"'>"+ orderObj.assignto + "</td>"
			+ "<td title='"+orderObj.updatedTime+"'>"+ orderObj.updatedTime + "</td>"
			+ "<td style='text-align: center;white-space: nowrap;'>" + edit + "&nbsp;&nbsp;" + deleterow + "&nbsp;&nbsp;" + comment + "&nbsp;&nbsp;" + time + "</td>" 
			+ "</tr>";
		$(tblRow).appendTo("#tableId table tbody");
	});
	if(isClick=='Yes') $('#example').dataTable();
	
}


function editCylinder(id) {
	$("#id").val(serviceUnitArray[id].id);
	$("#subject").val(serviceUnitArray[id].subject);
	$("#category").val(serviceUnitArray[id].categoryid);
	$("#severity").val(serviceUnitArray[id].severityid);
	$("#priority").val(serviceUnitArray[id].priorityid);
	$("#assignto").val(serviceUnitArray[id].assigntoid);
	$("#uploadfile").val(serviceUnitArray[id].uploadfile);
	$("#description").val(serviceUnitArray[id].description);
	$("#submit1").val("Update");
	$(window).scrollTop($('#moveTo').offset().top);
}



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
		console.log(alldata);
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


/*  view task history here */

function addComments(id){
	var formData = new FormData();
    formData.append('id', id);
	$.fn.makeMultipartRequest('POST', 'addcomment', false, formData, false, 'text', function(data){
		var jsonobj = $.parseJSON(data);
		var alldata = jsonobj.list;
		$('#HtableId').html('');
		var tableHead = '<table id="example" class="table table-striped table-bordered datatables">'
			+ '<thead><tr><th>Date Modified</th><th>User Name</th><th>Attachment</th><th>Change1</th></tr></thead><tbody></tbody></table>';
	$('#HtableId').html(tableHead);
	console.log(alldata);
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
			+ "<td title='"+orderObj.uploadfiles+"'>"+ orderObj.uploadfiles + "</td>"
			+ "<td title='"+orderObj.description+"'>"+ orderObj.description + "</td>"
			+ "</tr>";
		$(tblRow).appendTo("#HtableId table tbody");
		
	});
		$("#myModal").modal();
	});


}

/* display datatable by  user selection    */

function Go(){
	var dept1=$('#additionalinfo').val();
	var ttype=$('#ttype').val();
	
	alert("dept"+dept1);
	alert("ttype"+ttype);
	
	var formData = new FormData();
	    formData.append('ttypeid', ttype);
	    formData.append('deptid', dept1);
	
	$.fn.makeMultipartRequest('POST', 'setdata', false, formData, false, 'text', function(data){
		var jsonobj = $.parseJSON(data);
		var alldata = jsonobj.list;
		console.log(alldata);
			displayTable(alldata)
	
	 
	 
	 });
}


	
	
	
	
$('#ttype').on('change', function() {
	  var ttype=$('#ttype').val();
	  
	  if($('#ttype').val()!='0')
	  {
		 
		  
	  var formData = new FormData();
	    formData.append('ttypeid', ttype);
	$.fn.makeMultipartRequest('POST', 'setdata', false, formData, false, 'text', function(data){
		var jsonobj = $.parseJSON(data);
		var alldata = jsonobj.list;
		console.log(alldata);
			displayTable(alldata)
	
	 
	 
	 });
	  }
	  else
		  {
		  alert("to be implemented");
		  }
	  
	})
	
	
	
	
	$('#additionalinfo').on('change', function() {
		
		 var dept=$('#additionalinfo').val();
		 
		 var formData = new FormData();
		    formData.append('deptid', dept);
		$.fn.makeMultipartRequest('POST', 'setdataDeptWise', false, formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			var alldata = jsonobj.allOrders1;
			console.log(alldata);
			var myJSON = JSON.stringify(alldata);
				displayTable(alldata)
		
		 
		 
		 });
	})
	
	
	
	
	function submitCommet()
	{
			var kpstatus=$('#kpstatus').val();
		    var comment=$('#comment').val();
		    var issueid=$('#issueid').val();
			   
			   var formData = new FormData();
			   
			   formData.append('comment', comment);
			   formData.append('kpstatus', kpstatus);
			   formData.append('issueid', issueid);
			   
			   
	    	var ins = document.getElementById('fileupload').files.length;
	    	
	    	for(var i=0; i< ins; i++)
	    	{	
	    	var portfolio_values = document.getElementById('fileupload').files[i];
			formData.append('file[]', portfolio_values);
			}
	    	console.log("files data"+portfolio_values);
	    	
	    	console.log(formData);
	    	
	 		$.ajax({
				type:"post",
				enctype: 'multipart/form-data',
			  	url: "subTask", 
			  	data:formData,
			  	processData: false,  // tell jQuery not to process the data
				contentType: false,  // tell jQuery not to set contentType
			  	
			  	success: function(result){
			  		$('#kpstatus').val("");
			  		$('#comment').val("");
			  		$('#fileupload').val("");
			  		$('#submit2').hide();
			  		alert("comment inserted successfully");
			  	
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
			console.log(jsonobj.allOrders1);
			displayTable(alldata);
		});
	}
}

function validate(id, errorMessage)
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
$("#pageName").text("Task Master");
$(".task").addClass("active"); 
</script>