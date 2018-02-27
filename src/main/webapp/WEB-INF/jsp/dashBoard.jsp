<style>
.btn-toolbar {
    margin-left: 5px;
}


   



</style>



<!-- Body starts here -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!-- <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script> -->
<!-- Body starts here -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="">Dashboard</li>
				</ul><!-- /.breadcrumb -->
			</div>
			<br>
			<div class="page-content container" style="background-color: #fff;">
			 <div class="row" style="margin-bottom:10px"; >
			
			<c:forEach var="issue" items="${severityCount}">
			<c:set var="String" value="${issue.key}"/>  
			<c:if test="${fn:contains(String, 'Critical')}"> 
			<div class="btn-toolbar pull-left" style=margin-left:5px !important"><span style="font-size:18px; lettee-spacinf:1px; color:#006699;">Assigned to Me</span>
		                    <a href="severity?id=${issue.key}" class="btn btn-danger " style=" border-radius: 15px;"><span id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
		   </div>
		   </c:if>
		   <c:if test="${fn:contains(String, 'Major')}"> 
			<div class="btn-toolbar pull-left">
		                    <a href="severity?id=${issue.key}" class="btn btn-warning "  style=" border-radius: 15px;"><span id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
		   </div>
		   </c:if>
		   <c:if test="${fn:contains(String, 'Minor')}"> 
			<div class="btn-toolbar pull-left">
		                    <a href="severity?id=${issue.key}" class="btn btn-primary "  style=" border-radius: 15px;"><span id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
		   </div>
		   </c:if>
		      </c:forEach>
		      
		      </div>
		     <div class="row" style="margin-bottom:10px"; >
		      
		      <c:forEach var="issue" items="${severityCountsBY}">
			<c:set var="String" value="${issue.key}"/>  
			<c:if test="${fn:contains(String, 'Critical')}"> 
			<div class="btn-toolbar pull-left" style=margin-left:5px !important"><span style="font-size:18px; lettee-spacinf:1px; color:#006699;">Assigned BY Me</span>
		                    <a href="severityby?id=${issue.key}" class="btn btn-danger " style=" border-radius: 15px;"><span id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
		   </div>
		   </c:if>
		   <c:if test="${fn:contains(String, 'Major')}"> 
			<div class="btn-toolbar pull-left">
		                    <a href="severityby?id=${issue.key}" class="btn btn-warning "  style=" border-radius: 15px;"><span id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
		   </div>
		   </c:if>
		   <c:if test="${fn:contains(String, 'Minor')}"> 
			<div class="btn-toolbar pull-left">
		                    <a href="severityby?id=${issue.key}" class="btn btn-primary "  style=" border-radius: 15px;"><span id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
		   </div>
		   </c:if>
		      </c:forEach>
		      </div>
		      <br>
		      
		      <div class="row">
		      
		        <c:forEach var="issue" items="${SevMonitoredCounts}">
			<c:set var="String" value="${issue.key}"/>  
			<c:if test="${fn:contains(String, 'Critical')}"> 
			<div class="btn-toolbar pull-left" style=margin-left:5px !important"><span style="font-size:18px; lettee-spacinf:1px; color:#006699;">Monitored BY Me</span>
		                    <a href="severityReportTo?id=${issue.key}" class="btn btn-danger " style=" border-radius: 15px;"><span id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
		   </div>
		   </c:if>
		   <c:if test="${fn:contains(String, 'Major')}"> 
			<div class="btn-toolbar pull-left">
		                    <a href="severityReportTo?id=${issue.key}" class="btn btn-warning "  style=" border-radius: 15px;"><span id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
		   </div>
		   </c:if>
		   <c:if test="${fn:contains(String, 'Minor')}"> 
			<div class="btn-toolbar pull-left">
		                    <a href="severityReportTo?id=${issue.key}" class="btn btn-primary "  style=" border-radius: 15px;"><span id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
		   </div>
		   </c:if>
		      </c:forEach>
		      
		      </div>
		      
		                
			
			<!-- History table starts Here -->
			
				<div class="row" style="background: white;">
							<div class="col-md-12" style=" margin-top:550px;">

<div class="col-md-8">
							<div id="assigned" class="widget-box widget-color-blue2">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-clock-o"></i>
<a class="white" href="#">Performance Timeline</a></h4>
		<div class="widget-toolbar">
			<a data-action="collapse" href="#">
				<!-- <i class="1 ace-icon fa bigger-125 fa-chevron-up"></i> -->
			</a>
		</div>
		<div class="widget-toolbar no-border hidden-xs">
			
		</div>
	</div>

	<div style="display: block;" class="widget-body">
		<div class="widget-main no-padding">
			<div class="table-responsive" style="overflow-x: inherit;">
				<table class="table table-bordered table-condensed table-striped table-hover">
<tbody>

<tr class="my-buglist-bug ">
			<tr>
                    		<th>By Date(days)</th>
                    		<th>Open</th>
                    		<th>Closed</th>
                    		<th>Balanced</th>
                    			
                    	</tr>
<c:forEach var="issue" items="${gapAndCount}">
       
<tr class="my-buglist-bug ">
		<td class="nowrap width-13">${issue.key} 
		</td>
		 <c:forEach items="${issue.value}" var="entry">
		<td>
		${entry}
        </td>
        </c:forEach> 
    
</tr>

</c:forEach>
                      </table>
        
       
</div>
</div>



						</div><!-- /.row -->
					</div><!-- /.page-content -->
					</div>
					<div class="col-sm-4">
				<div class="space-10"></div>

						</div><!-- /.row -->
					</div><!-- /.page-content -->
					</div>
				</div>
							</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content-inner -->
	</div>
	
	<div id="notifyModal" class="modal fade" role="dialog"  data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog">
    <!-- Modal content-->
<div class="col-md-12">
				<div class="panel panel-primary">
				
					<div class="panel-heading">
						<h4>Unread Tasks List</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="panel-body collapse in">
					<!-- <input type="checkbox" class="form-check-input" onclick="inactiveData();" id="inActive"> <label class="form-check-label">Show Inactive List</label> -->
						<div class="table-responsive" id="tableId">
							<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered datatables" id="notification">
								<thead><tr><th>Dept ID</th><th>Name</th><th>Description</th><th>Status</th><th></th></tr></thead>
								<tbody></tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

  </div>
</div>
<script type="text/javascript">
$(window).load(function(){
	var formData = new FormData();
    formData.append('ttypeid', "1");
$.fn.makeMultipartRequest('POST', 'setNotifyData', false, formData, false, 'text', function(data){
	var jsonobj = $.parseJSON(data);
	var alldata = jsonobj.allOrders1;
	//console.log(alldata)
	if (alldata != "") {
		displayTable(alldata)
		$('#notifyModal').modal('show');
		
	}
	 
 });
$('#notifyModal').focus(); 
});

$(".dashBoard").addClass("active");
$(document).ready(function(){
$('.dashBoard').on('click', function(){
});
});
</script>
<script>
/* $(window).load(function(){        
   $('#notifyModal').modal('show');
    });  */
    
    
    
    
    
    var loginUserId ="1"
    
function displayTable(listOrders) {
	$('#tableId').html('');
	var tableHead = '<table id="notification" class="table table-striped table-bordered datatables">'
			+ '<thead><tr><th>Task No</th><th>Summary</th><th>Category</th><th>priority</th><th>Assigned By</th><th>Created Time</th><th>Description</th><th style="text-align: center;"></th></tr></thead><tbody></tbody></table>';
	$('#tableId').html(tableHead);
	serviceUnitArray = {};
	
	$.each(listOrders,function(i, orderObj) {
		/* if(orderObj.additionalinfo == "0"){
			var deleterow = "<a class='deactivate' onclick='opentasks("+ orderObj.id+ ",0)'><i class='fa fa-folder-open-o'></i></a>"
		}else{  
			var deleterow = "<a class='activate' onclick='opentasks("+ orderObj.id+ ",1)'><i class='fa fa-eye-slash'></i></a>"
		} */
		
		var deleterow = "<a class='activate' href='viewTicket?id="+ orderObj.id+ "><i class='fa fa-eye-slash'></i></a>"
		
		var edit = "<a class='edit editIt' onclick='editTask("	+ orderObj.id+ ")'><i class='fa fa-edit'></i></a>"
		
		
		
		var view = "<a class='view viewIt' onclick='viewTask("	+ orderObj.id+ ")'>"+ orderObj.taskno+ "</a>"
		var view2 = "<a class='view viewIt' href='viewTicket?id="	+ orderObj.id+ "'>"+ orderObj.taskno+ "</a>"
		var comment = "<a class='comment commentIt' onclick='addComment("	+ orderObj.id+ ")'>   <i class='fa fa-comments'></i></a>"
		var time = "<a class='time timeIt' onclick='showdeadline("	+ orderObj.id+ ")'> <i class='fa fa-hourglass-half'></i> </a>"
		serviceUnitArray[orderObj.id] = orderObj;
		var tblRow = "<tr>"
			+ "<td title='"+orderObj.taskno+"'>"+ view2 + "</td>"
			+ "<td title='"+orderObj.subject+"'>"+ orderObj.subject + "</td>"
			+ "<td title='"+orderObj.category+"'>"+ orderObj.category + "</td>"
			+ "<td title='"+orderObj.priority+"'>"+ orderObj.priority + "</td>"
			+ "<td title='"+orderObj.assignby+"'>"+ orderObj.assignby + "</td>"
			+ "<td title='"+orderObj.createdTime+"'>"+ new Date(orderObj.createdTime).toDateString() + "</td>"
			+ "<td title='"+orderObj.description+"'>"+ orderObj.description + "</td>"
			+ "<td style='text-align: center;white-space: nowrap;'>" + deleterow +  "</td>" 
			+ "</tr>";
		$(tblRow).appendTo("#tableId table tbody");
	});
	if(isClick=='Yes') $('#notification').dataTable();
	
}
    
    
    
    function opentasks(id,status){
    	var checkstr=null;
    	if(status == 0	){
    		status=1;
    	 alert('Task Marked as Read');
    	}
    		var formData = new FormData();
    	    formData.append('id', id);
    	    formData.append('additionalinfo', status);
    		$.fn.makeMultipartRequest('POST', 'openTask', false, formData, false, 'text', function(data){
    			var jsonobj = $.parseJSON(data);
    			var alldata = jsonobj.allOrders1;
    			var result=$.parseJSON(alldata);
    			if(result.length>0)
    				{
    			displayTable(result)
    			getHeadersCounts()
    			
    				}
    			else
    				getHeadersCounts()
    				//location.reload()
    				
    		});
    	
    }
    
 
    
    </script>