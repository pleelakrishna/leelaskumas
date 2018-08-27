<style>
.btn-toolbar {
	margin-top:7px;
}
.priority th, td {
	text-align: center;
	border: 1px solid #efe9e9;
}
.prioritybg th,td:first-child {
text-align:left;}
.prioritybg tr:nth-child(even) {
	background: #ccc;
}
.table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td {
    padding: 5px;
    line-height: 1.428571429;
    vertical-align: top;
    border-top: 1px solid #e6e7e8;
}
.btp {
	border-top: 1px solid #aba8a8 !important;
}
.assigned {
	width:100px;
	line-height: 0.8;
	border-radius: 10px;
}
@media only screen and (max-width: 640px) and (min-width: 320px) {
 .amcharts-graph-column-element
{
fixedColumnWidth:100px;
} 

}
 .amcharts-graph-column-element
{
fixedColumnWidth:80px;
} 
table:nth-of-type(1) .th {
  background-image: linear-gradient(
    to top right,
    #f1c40f 50%,
    #e73c3c 50%
  );
}
.head {
	background: #e73c3c;
}
th {
	font-family: 'Roboto Condensed';
	font-size: 15px;
}
.lighter {
	font-family: 'Roboto Condensed';
	font-size: 17px;
}
.panel-heading h4 {
	font-size: 25px;
}
td {
	font-family: 'PT Sans';
	font-size: 14px;
}
.pad {
	padding-top:17px !important;
	text-align:center !important;
}
.pad1 {
	text-align:center !important;
}
label {
font-size:15px;}
.charts {
padding-top:10px;}
.amcharts-chart-div svg
{
width: auto !important;
min-width: 900px !important;
overflow: scroll;
}

.slice1 .amcharts-pie-slice {
  fill: #f00;
}
</style>


<!-- Body starts here -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script> -->
<!-- Body starts here -->
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs ace-save-state" id="breadcrumbs">
			<ul class="breadcrumb">
				<li class="">Dashboard</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<security:authorize access="hasRole('ROLE_ADMIN')">
		<div class="container" align="center"><br>
		<input type="radio" class="" name="scharts"  value="1" id="departmentId" checked>   <label for="departmentId">DepartmentWise</label> 
  		&nbsp; &nbsp; <input type="radio" name="scharts"  value="0" id="categoryId">  <label for="categoryId">CategoryWise</label> <br>
  		</div>
		<div class="charts" id="deptcharts">
			<div class="col-md-6">
				<p align="center">Closed Tasks</p>
				<div id="chartdiv1"></div>
			</div>
			<div class="col-md-6">
				<p  align="center">Pending Tasks</p>
				<div id="chartdiv0"></div>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<p  align="center">Open Tasks</p>
				<div id="chartdiv"  class="table-responsive"></div>
			</div><div class="clearfix"></div>
		</div>
		<div class="charts table-responsive" id="catecharts">
			<div class="col-md-6">
				<p align="center">Closed Tasks</p>
				<div id="chartdiv1c"></div>
			</div>
			<div class="col-md-6">
				<p  align="center">Pending Tasks</p>
				<div id="chartdiv0c"></div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<p  align="center">Open Tasks</p>
				<div id="chartdivc" class="table-responsive"></div>
			</div><div class="clearfix"></div>
		</div>
		</security:authorize>
		
		
		<div class="page-content container" style="background-color: #fff;">
			<div class="col-md-12"
				style="background-color: white !important; padding-top: 15PX;">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Dashboard</h4>
						<div class="options">
							<a href="javascript:;" class="panel-collapse"><i
								class="fa fa-chevron-down"></i></a>
						</div>
					</div>

					<div class="panel-body collapse in">
						<div class="col-md-8">

							<div class="table-responsive">
								<table class="table table-bordered priority prioritybg"
									style="border: 1px solid #006699; width:;">
									<tr style="background-color: #006699; color: #fff; text-align: center;">

										<th class="th"><span style="float:right;">Priority</span><br><span style="float:left;">Unclosed Tasks</span></th>
										<th class="pad">High</th>
										<th class="pad">Medium</th>
										<th class="pad">Low</th>

									</tr>

									<tr class="prioritybg">
										<td>
											<div class="col-md-12" style="margin-left: 5px"!important">

												<span
													style="font-size: 14px; lettee-spacin: 1px; color: #006699; margin-left:-15px;">Assigned
													to me <c:forEach var="issue" items="${severityCount}">
														<c:set var="String" value="${issue.key}" />
														<c:if test="${fn:contains(String, 'Total')}">
															<a href="severity?id=${issue.key}">( ${issue.value} )</a>
														</c:if>


													</c:forEach>
												</span>
											</div>
										</td>
										<td><c:forEach var="issue" items="${severityCount}">
												<c:set var="String" value="${issue.key}" />

												<c:if test="${fn:contains(String, 'High')}">
													<div class="col-md-12">

														<a href="severity?id=${issue.key}"
															class="btn btn-danger assigned "> <span
															id="unseentasks">${issue.value} </span> <%-- <br>${issue.key}  --%></a>
														<!-- <a href="severity?id=Critical"
													class="btn btn-danger assigned " style=""><span
													id="unseentasks"> 0 </span> </a> -->
													</div>
												</c:if>
											</c:forEach></td>
										<td><c:forEach var="issue" items="${severityCount}">
												<c:set var="String" value="${issue.key}" />
												<c:if test="${fn:contains(String, 'Medium')}">
													<div class="col-md-12">
														<!-- <a href="severity?id=Major" class="btn btn-warning assigned"><span
													id="unseentasks"> 0 </span> </a> -->
														<a href="severity?id=${issue.key}"
															class="btn btn-warning assigned "> <span
															id="unseentasks">${issue.value} </span> <%-- <br>${issue.key} --%>
														</a>
													</div>
												</c:if>
											</c:forEach></td>
										<td><c:forEach var="issue" items="${severityCount}">
												<c:set var="String" value="${issue.key}" />
												<c:if test="${fn:contains(String, 'Low')}">
													<div class="col-md-12">
														<!-- <a href="severity?id=Minor" class="btn btn-primary assigned"><span
													id="unseentasks"> 1 </span></a> -->

														<a href="severity?id=${issue.key}"
															class="btn btn-primary assigned"> <span
															id="unseentasks">${issue.value} </span> <%-- <br>${issue.key}  --%></a>
													</div>
												</c:if>
											</c:forEach></td>
									</tr>
									<tr>
										<td>
											<div class="col-md-12" style="margin-left: 5px"!important">


												<span
													style="font-size: 14px; lettee-spacin: 1px; color: #006699; margin-left:-15px;">Assigned
													by me<c:forEach var="issue" items="${severityCountsBY}">
														<c:set var="String" value="${issue.key}" />
														<c:if test="${fn:contains(String, 'Total')}">
															<a href="severityby?id=${issue.key}">( ${issue.value}
																)</a>
														</c:if>


													</c:forEach>

												</span>
											</div>
										</td>
										<td><c:forEach var="issue" items="${severityCountsBY}">
												<c:set var="String" value="${issue.key}" />
												<c:if test="${fn:contains(String, 'High')}">
													<div class="col-md-12">


														<a href="severityby?id=${issue.key}"
															class="btn btn-danger assigned "> <span
															id="unseentasks"> ${issue.value} </span>
														<%--<br>${issue.key} --%>
														</a>
														<!-- <a href="severity?id=Critical"
													class="btn btn-danger assigned"><span id="unseentasks">
														0 </span> </a> -->
													</div>
												</c:if>
											</c:forEach></td>
										<td><c:forEach var="issue" items="${severityCountsBY}">
												<c:set var="String" value="${issue.key}" />
												<c:if test="${fn:contains(String, 'Medium')}">
													<div class="col-md-12">
														<!-- <a href="severity?id=Major" class="btn btn-warning assigned"><span
													id="unseentasks"> 0 </span> </a> -->

														<a href="severityby?id=${issue.key}"
															class="btn btn-warning assigned "> <span
															id="unseentasks">${issue.value} </span>
														<%-- <br>${issue.key}  --%></a>
													</div>
												</c:if>
											</c:forEach></td>
										<td><c:forEach var="issue" items="${severityCountsBY}">
												<c:set var="String" value="${issue.key}" />
												<c:if test="${fn:contains(String, 'Low')}">
													<div class="col-md-12">
														<!-- <a href="severity?id=Minor" class="btn btn-primary assigned"><span
													id="unseentasks"> 1 </span> </a> -->

														<a href="severityby?id=${issue.key}"
															class="btn btn-primary assigned"
															style="border-radius: 15px;"> <span id="unseentasks">${issue.value}
														</span>
														<%-- <br>${issue.key} --%>
														</a>
													</div>
												</c:if>
											</c:forEach></td>
									</tr>
									<tr>
										<td>


											<div class="col-md-12" style="margin-left: 5px"!important">
												<span
													style="font-size: 14px; lettee-spacin: 1px; color: #006699; margin-left:-15px;">Monitored
													by me<c:forEach var="issue" items="${SevMonitoredCounts}">
														<c:set var="String" value="${issue.key}" />
														<c:if test="${fn:contains(String, 'Total')}">
															<a href="severityReportTo?id=${issue.key}">(
																${issue.value} )</a>
														</c:if>


													</c:forEach>
												</span>
											</div>

										</td>

										<td><c:forEach var="issue" items="${SevMonitoredCounts}">
												<c:set var="String" value="${issue.key}" />
												<c:if test="${fn:contains(String, 'High')}">
													<div class="col-md-12">
														<a href="severityReportTo?id=${issue.key}"
															class="btn btn-danger assigned"> <span
															id="unseentasks"> ${issue.value} </span>
														<%-- <br>${issue.key} --%>
														</a>
													</div>
												</c:if>
											</c:forEach></td>
										<td><c:forEach var="issue" items="${SevMonitoredCounts}">
												<c:set var="String" value="${issue.key}" />

												<c:if test="${fn:contains(String, 'Medium')}">
													<div class="col-md-12">
														<!-- <a href="severity?id=Critical"
													class="btn btn-danger assigned"><span id="unseentasks">
														0 </span></a> -->

														<a href="severityReportTo?id=${issue.key}"
															class="btn btn-warning assigned"><span
															id="unseentasks"> ${issue.value} </span>
														<%-- <br>${issue.key}  --%></a>
													</div>
												</c:if>
											</c:forEach></td>

										<td><c:forEach var="issue" items="${SevMonitoredCounts}">
												<c:set var="String" value="${issue.key}" />
												<c:if test="${fn:contains(String, 'Low')}">
													<div class="col-md-12">
														<!-- <a href="severity?id=Minor" class="btn btn-primary assigned"><span
													id="unseentasks"> 1 </span></a> -->

														<a href="severityReportTo?id=${issue.key}"
															class="btn btn-primary assigned"> <span
															id="unseentasks"> ${issue.value} </span>
														<%-- <br>${issue.key}  --%></a>
													</div>
												</c:if>
											</c:forEach></td>
									</tr>
								</table>
							</div>
							<!-- *********************************** By Severity End *****************-->

							
							<!-- *********************************** By Category Start *****************-->
							<br>
							<div class="table-responsive">
								<table class="table table-bordered priority prioritybg"
									style="border: 1px solid #006699; width:;" id="categoryTable">
									<thead>
										<tr
											style="background-color: #006699; color: #fff; text-align: center;">

											<th class="head pad1">By Category</th>
											<th class="pad1">Assigned</th>
											<th class="pad1">Acknowledged</th>
											<th class="pad1">In-Process</th>
											<th class="pad1">Resolved</th>
											<th class="pad1">Closed</th>
											<th class="pad1">Reopen</th>
											<th class="pad1">Total</th>

										</tr>
									</thead>

									<tbody>
									

									</tbody>
								</table>
							</div>

							<!--  ************************** By Category End  ******************************-->
							
							
							<br>
							
							
						

							
							<!-- *********************************** By Department Start *****************-->
							 <security:authorize access="hasRole('ROLE_ADMIN')">
							<div class="table-responsive">
								<table class="table table-bordered priority prioritybg"
									style="border: 1px solid #006699; width:;" id="deptTable">
									<thead>
										<tr
											style="background-color: #006699; color: #fff; text-align: center;">

											<th class="head pad1">Department Name</th>
											<th class="pad1">Assigned</th>
											<th class="pad1">Acknowledged</th>
											<th class="pad1">In-Process</th>
											<th class="pad1">Resolved</th>
											<th class="pad1">Closed</th>
											<th class="pad1">Reopen</th>
											<th class="pad1">Total</th>

										</tr>
									</thead>

									<tbody>
									

									</tbody>
								</table>
							</div>
								</security:authorize>
								
								<!--  ************************** By Department  End  ******************************-->

						</div>



						<div class="col-md-4" style="border: 1px solid #ccc;">
							<div id="assigned" class="widget-box widget-color-blue2">
								<div class="widget-header widget-header-small">
									<h4 class="widget-title lighter">
										<a class="white" href="#"><i class="ace-icon fa fa-clock-o"></i> Timeline</a>
									</h4>
									<div class="widget-toolbar">
										<a data-action="collapse" href="#"> <!-- <i class="1 ace-icon fa bigger-125 fa-chevron-up"></i> -->
										</a>
									</div>
									<div class="widget-toolbar no-border hidden-xs"></div>
								</div>

								<div style="display: block;" class="widget-body">
									<div class="widget-main no-padding">
										<div class="table-responsive" style="overflow-x: inherit;">
											<table
												class="table table-bordered table-condensed table-striped table-hover ">
												<tbody>

													<tr class="my-buglist-bug ">
													<tr>
														<th class="pad1 btp">By Date(days)</th>
														<th class="pad1 btp">Open</th>
														<th class="pad1 btp">Closed</th>
														<th class="pad1 btp">Pending</th>

													</tr>
													<c:forEach var="issue" items="${gapAndCount}">

														<tr class="my-buglist-bug ">
															<td class="nowrap width-13">${issue.key}</a></td>
															<c:forEach items="${issue.value}" var="entry"
																varStatus="loop">
																<td><a
																	href="timeline${loop.index}?range=${issue.key}">${entry}</a></td>
															</c:forEach>

														</tr>

													</c:forEach>
											</table>


										</div>
									</div>
								</div>
								<!-- /.row -->
							</div>
							<!-- /.page-content -->
						</div>







					</div>
				</div>
				<!-- <div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Dashboard</h4>
						<div class="options">
							<a href="" class="panel-collapse"><i class="fa fa-chevron-down"></i></a>
						</div>
					</div>
					<div class="panel-body collapse in">
						
						<div class="col-md-2"></div>
					</div>
				</div>
			</div> -->

				<%-- <div class="row" style="margin-bottom: 10px"; >

				<c:forEach var="issue" items="${severityCount}">
					<c:set var="String" value="${issue.key}" />
					<c:if test="${fn:contains(String, 'Critical')}">
						<div class="btn-toolbar pull-left" style="margin-left: 5px"!important">
							<span
								style="font-size: 18px; lettee-spacinf: 1px; color: #006699;">Assigned
								to Me</span> <a href="severity?id=${issue.key}" class="btn btn-danger "
								style="border-radius: 15px;"><span id="unseentasks">
									${issue.value} </span><br>${issue.key} </a>
						</div>
					</c:if>
					<c:if test="${fn:contains(String, 'Major')}">
						<div class="btn-toolbar pull-left">
							<a href="severity?id=${issue.key}" class="btn btn-warning "
								style="border-radius: 15px;"><span id="unseentasks">
									${issue.value} </span><br>${issue.key} </a>
						</div>
					</c:if>
					<c:if test="${fn:contains(String, 'Minor')}">
						<div class="btn-toolbar pull-left">
							<a href="severity?id=${issue.key}" class="btn btn-primary "
								style="border-radius: 15px;"><span id="unseentasks">
									${issue.value} </span><br>${issue.key} </a>
						</div>
					</c:if>
				</c:forEach>

			</div>
			<div class="row" style="margin-bottom: 10px"; >

				<c:forEach var="issue" items="${severityCountsBY}">
					<c:set var="String" value="${issue.key}" />
					<c:if test="${fn:contains(String, 'Critical')}">
						<div class="btn-toolbar pull-left" style="margin-left: 5px"!important">
							<span style="font-size: 18px; lettee-spacinf: 1px; color: #006699;">Assigned	BY Me</span> 
							
							<a href="severityby?id=${issue.key}"
								class="btn btn-danger " style="border-radius: 15px;"><span
								id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
						</div>
					</c:if>
					<c:if test="${fn:contains(String, 'Major')}">
						<div class="btn-toolbar pull-left">
							<a href="severityby?id=${issue.key}" class="btn btn-warning "
								style="border-radius: 15px;"><span id="unseentasks">
									${issue.value} </span><br>${issue.key} </a>
						</div>
					</c:if>
					<c:if test="${fn:contains(String, 'Minor')}">
						<div class="btn-toolbar pull-left">
							<a href="severityby?id=${issue.key}" class="btn btn-primary "
								style="border-radius: 15px;"><span id="unseentasks">
									${issue.value} </span><br>${issue.key} </a>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<br>

			<div class="row">

				<c:forEach var="issue" items="${SevMonitoredCounts}">
					<c:set var="String" value="${issue.key}" />
					<c:if test="${fn:contains(String, 'Critical')}">
						<div class="btn-toolbar pull-left" style="margin-left: 5px"!important">
							<span
								style="font-size: 18px; lettee-spacinf: 1px; color: #006699;">Monitored
								BY Me</span> 
								<a href="severityReportTo?id=${issue.key}"
								class="btn btn-danger " style="border-radius: 15px;"><span
								id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
						</div>
					</c:if>
					<c:if test="${fn:contains(String, 'Major')}">
						<div class="btn-toolbar pull-left">
							<a href="severityReportTo?id=${issue.key}"
								class="btn btn-warning " style="border-radius: 15px;"><span
								id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
						</div>
					</c:if>
					<c:if test="${fn:contains(String, 'Minor')}">
						<div class="btn-toolbar pull-left">
							<a href="severityReportTo?id=${issue.key}"
								class="btn btn-primary " style="border-radius: 15px;"><span
								id="unseentasks"> ${issue.value} </span><br>${issue.key} </a>
						</div>
					</c:if>
				</c:forEach>

			</div>
 --%>


				<!-- History table starts Here -->

				<div class="row" style="background: white;">


					<div class="col-sm-4">
						<div class="space-10"></div>

					</div>
					<!-- /.row -->
					<!-- /.page-content -->
				</div>
			</div>
		</div>
		<!-- /.page-content -->
	</div>
	<!-- /.main-content-inner -->
</div>

<div id="notifyModal" class="modal fade" data-backdrop="static"
	data-keyboard="false" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="col-md-12 mod" style="width: auto;">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Unread Tasks List</h4>
					<!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
				</div>
				<div class="panel-body collapse in">
					<!-- <input type="checkbox" class="form-check-input" onclick="inactiveData();" id="inActive"> <label class="form-check-label">Show Inactive List</label> -->
					<div class="table" id="tableId">
						<table cellpadding="0" cellspacing="0" border="0"	class="table table-striped table-bordered datatables"	id="notification">
							<thead>
								<tr>
									<th>Dept ID</th>
									<th>Name</th>
									<th>Description</th>
									<th>Status</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<script type="text/javascript">
	$(window).load(
			function() {
				var formData = new FormData();
				formData.append('ttypeid', "1");
				$.fn.makeMultipartRequest('POST', 'setNotifyData', false,
						formData, false, 'text', function(data) {
							var jsonobj = $.parseJSON(data);
							var alldata = jsonobj.allOrders1;
							//console.log(alldata)
							if (alldata != "") {
								displayTable(alldata)
								$('#notifyModal').modal('show');
							}

						});
			});
	
	 $(document).ready(function(){
	    if(!window.location.hash) {
	        window.location = window.location + '#loaded';
	        window.location.reload();
	    }
	    
	    $("#catecharts").hide();
	}); 

	$(".dashBoard").addClass("active");
	$(document).ready(function() {
		$('.dashBoard').on('click', function() {
		});
	});
</script>


<script>
	/* $(window).load(function(){        
	 $('#notifyModal').modal('show');
	 });  */

	var loginUserId = "1"

	function displayTable(listOrders) {
		$('#tableId').html('');
		var tableHead = '<table id="notification" class="table table-striped table-bordered datatables">'
				+ '<thead><tr><th>Task No</th><th>Task Subject</th><th>Category</th><th>priority</th><th>Severity</th><th>Assigned By</th><th>Created Time</th><th>Description</th></tr></thead><tbody></tbody></table>';
		$('#tableId').html(tableHead);
		serviceUnitArray = {};

		$.each(listOrders, function(i, orderObj) {
			if (orderObj.additionalinfo == "0") {
				var deleterow = "<a class='deactivate' onclick='opentasks("
						+ orderObj.id
						+ ",0)'><i class='fa fa-folder-open-o'></i></a>"
			} else {
				var deleterow = "<a class='activate' onclick='opentasks("
						+ orderObj.id
						+ ",1)'><i class='fa fa-eye-slash'></i></a>"
			}

			var edit = "<a class='edit editIt' onclick='editTask("
					+ orderObj.id + ")'><i class='fa fa-edit'></i></a>"

			var view = "<a class='view viewIt' onclick='viewTask("
					+ orderObj.id + ")'>" + orderObj.taskno + "</a>"
			var view2 = "<a class='view viewIt' href='viewTicket?id="
					+ orderObj.id + "&pgn=1'>" + orderObj.taskno + "</a>"
			var comment = "<a class='comment commentIt' onclick='addComment("
					+ orderObj.id + ")'>   <i class='fa fa-comments'></i></a>"
			var time = "<a class='time timeIt' onclick='showdeadline("
					+ orderObj.id
					+ ")'> <i class='fa fa-hourglass-half'></i> </a>"
			serviceUnitArray[orderObj.id] = orderObj;
			var tblRow = "<tr>" + "<td title='"+orderObj.taskno+"'>" + view2
					+ "</td>" + "<td title='"+orderObj.subject+"'>"
					+ orderObj.subject + "</td>"
					+ "<td title='"+orderObj.category+"'>" + orderObj.category
					+ "</td>" + "<td title='"+orderObj.priority+"'>"
					+ orderObj.priority + "</td>" + "</td>"
					+ "<td title='"+orderObj.severity+"'>" + orderObj.severity
					+ "</td>" + "<td title='"+orderObj.assignby+"'>"
					+ orderObj.assignby + "</td>"
					+ "<td title='"+orderObj.createdTime+"'>"
					+ new Date(orderObj.createdTime).toDateString() + "</td>"
					+ "<td title='"+orderObj.description+"'>"
					+ orderObj.description + "</td>"
					/* + "<td style='text-align: center;white-space: nowrap;'>"
					 "</td>" */+ "</tr>";
			$(tblRow).appendTo("#tableId table tbody");
		});
		

	}

	function opentasks(id, status) {
		var checkstr = null;
		if (status == 0) {
			status = 1;
			alert('Task Marked as Read');
		}
		var formData = new FormData();
		formData.append('id', id);
		formData.append('additionalinfo', status);
		$.fn.makeMultipartRequest('POST', 'openTask', false, formData, false,
				'text', function(data) {
					var jsonobj = $.parseJSON(data);
					var alldata = jsonobj.allOrders1;
					var result = $.parseJSON(alldata);
					if (result.length > 0) {
						displayTable(result)
						getHeadersCounts()

					} else
						getHeadersCounts()
						//location.reload()

				});

	}

	function goToTaskListBySelection(selection) {

		alert("hi");
		alert(selection);
		var ttype = selection;
		var formData = new FormData();
		formData.append('ttypeid', ttype);
		$.fn.makeMultipartRequest('POST', 'setdata', false, formData, false,
				'text', function(data) {
					var jsonobj = $.parseJSON(data);
					var alldata = jsonobj.list;
					displayTable(alldata);
					toolTips()
					makeEmpty()

				});
	}

	/* var listOrders1 = ${list};
	if (listOrders1 != "") {
		showCategoryTable(listOrders1);
	}else{
		showCategoryTable(listOrders1);
	} */
	

	
	
	
/* 	$("#ack").mouseover(function(){
		
		alert("hello mousehour");
	}); */
	var deptcountjson = ${deptcountjson};
	var deptcountclosedjson = ${deptcountclosedjson};
	var deptcountAssignedjson = ${deptcountAssignedjson};
	var deptcountAcknowldgedson = ${deptcountAcknowldgedson};
	var deptcountResolved = ${deptcountResolved};
	var deptcountInProgress = ${deptcountInProgress};
	var deptcountReopen = ${deptcountReopen};
	
	
	
	
	if (deptcountjson != "") {
		$('#deptTable body').html('');
		displayDeptTask(deptcountjson,deptcountclosedjson,deptcountAssignedjson,deptcountAcknowldgedson,deptcountResolved,deptcountInProgress,deptcountReopen);
		
	}
	
	function displayDeptTask(deptcountjson,deptcountclosedjson,deptcountAssignedjson,deptcountAcknowldgedson,deptcountResolved,deptcountInProgress,deptcountReopen){
		
		$.each(deptcountjson, function(i,item) {
			
			//console.log(deptcountjson[i]+"------"+deptcountclosedjson[i]);
			
			var diff=parseInt(item)-parseInt(deptcountclosedjson[i])
			//console.log(item);
			 var tblRow = "<tr'>"
					+ "<td> "
					+ i
					+ "</a></td>"
					+ "<td ><a href='deptAssigned?id="+i+"'>"
					+ deptcountAssignedjson[i]
					+ "</a></td>"
					+ "<td ><a href='deptacknowledged?id="+i+"'>"
					+ deptcountAcknowldgedson[i]
					+ "</a></td>"
					+ "<td ><a href='deptinprogress?id="+i+"'>"
					+ deptcountInProgress[i]
					+ "</a></td>"
					+ "<td ><a href='deptresolved?id="+i+"'>"
					+ deptcountResolved[i]
					+ "</a></td>"
					+ "<td ><a href='deptClosed?id="+i+"'>"
					+ deptcountclosedjson[i]
					+ "</a></td>"
					+ "<td ><a href='deptReopen?id="+i+"'>"
					+ deptcountReopen[i]
					+ "</a></td>"
					+ "<td ><a href='deptAll?id="+i+"'>"
					+ item
					+ "</a></td>"
					/* + "<td ><a href='deptBalanced?id="+i+"'>"
					+ diff
					+ "</a></td>" */
					+ "</tr >";
			$(tblRow).appendTo("#deptTable tbody"); 
		});
		
	}
	
	/* *****************************************category table code***************************** */
	var categorycountjson = ${categorycountjson};
	var categorycountclosedjson = ${categorycountclosedjson};
	var categorycountAssignedjson = ${categorycountAssignedjson};
	var categorycountAcknowldgedson = ${categorycountAcknowldgedson};
	var categorycountResolved = ${categorycountResolved};
	var categorycountInProgress = ${categorycountInProgress};
	var categorycountReopen = ${categorycountReopen};
	var categorycountPending = ${categorycountPending};
	
	
	var chartDeptAllCounts = ${chartDeptAllCounts};
	
	var chartDeptClosed = ${chartDeptClosed};
	var chartDeptPending = ${chartDeptPending};
	
	var barChartDeptAllCounts = ${barChartDeptAllCounts};
	var barChartDeptClosed = ${barChartDeptClosed};
	var barChartDeptPending = ${barChartDeptPending};
	
	
	
	
	
	
	if (categorycountjson != "") {
		$('#categoryTable body').html('');
		displayCategoryTask(categorycountjson,categorycountclosedjson,categorycountAssignedjson,categorycountAcknowldgedson,categorycountResolved,categorycountInProgress,categorycountReopen,categorycountPending);
		
	}
	
	function displayCategoryTask(categorycountjson,categorycountclosedjson,categorycountAssignedjson,categorycountAcknowldgedson,categorycountResolved,categorycountInProgress,categorycountReopen,categorycountPending){
		$.each(categorycountjson, function(i,item) {
			
			//console.log(deptcountjson[i]+"------"+deptcountclosedjson[i]);
			
			//var diff=parseInt(item)-parseInt(deptcountclosedjson[i])
			//console.log(item);
			 var tblRow = "<tr'>"
					+ "<td> "
					+ i
					+ "</a></td>"
					+ "<td ><a href='catAssigned?id="+i+"'>"
					+ categorycountAssignedjson[i]
					+ "</a></td>"
					+ "<td ><a href='catacknowledged?id="+i+"'>"
					+ categorycountAcknowldgedson[i]
					+ "</a></td>"
					+ "<td ><a href='catinprogress?id="+i+"'>"
					+ categorycountInProgress[i]
					+ "</a></td>"
					+ "<td ><a href='catresolved?id="+i+"'>"
					+ categorycountResolved[i]
					+ "</a></td>"
					+ "<td ><a href='catClosed?id="+i+"'>"
					+ categorycountclosedjson[i]
					+ "</a></td>"
					+ "<td ><a href='catReopen?id="+i+"'>"
					+ categorycountReopen[i]
					+ "</a></td>"
					+ "<td ><a href='catAll?id="+i+"'>"
					+ item
					+ "</a></td>"
					+ "</tr >";
			$(tblRow).appendTo("#categoryTable tbody"); 
		});
		
	}
	
		
	
	var cylinderstatuscount =[{"cylinderstatus":"Empty","count":"1676"},{"cylinderstatus":"FillingStation","count":"265"},{"cylinderstatus":"Filled","count":"107"},{"cylinderstatus":"QualityCheck","count":"103"},{"cylinderstatus":"Truck","count":"605"},{"cylinderstatus":"Delivered","count":"90"},{"cylinderstatus":"Returned","count":34},{"cylinderstatus":"MissedCylinder","count":1}];
	/* var chart = AmCharts.makeChart( "chartdiv", {
		  "type": "pie",
		  "theme": "light",
		  "dataProvider":chartDeptAllCounts,
		  "valueField": "number",
		  "titleField": "status",
		  "outlineAlpha": 0.4,
		  "depth3D": 15,
		  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
		  "angle": 30,
		  "export": {
		    "enabled": true
		  }
		} ); */
		
		AmCharts.addInitHandler(function(chart) {
			  // check if there are graphs with autoColor: true set
			  for(var i = 0; i < chart.graphs.length; i++) {
			    var graph = chart.graphs[i];
			    if (graph.autoColor !== true)
			      continue;
			    var colorKey = "autoColor-"+i;
			    graph.lineColorField = colorKey;
			    graph.fillColorsField = colorKey;
			    for(var x = 0; x < chart.dataProvider.length; x++) {
			      var color = chart.colors[x]
			      chart.dataProvider[x][colorKey] = color;
			    }
			  }
			  
			}, ["serial"]);
		
		
		var chart = AmCharts.makeChart( "chartdiv", {
			  "type": "serial",
			  "theme": "light",
			  "dataProvider":chartDeptAllCounts,
			  "valueAxes": [{
			        "position": "left",
			        "axisAlpha":0,
			        "gridAlpha":0
			    }],
			    "graphs": [{
			        "balloonText": "[[category]]: <b>[[value]]</b>",
			        "fillAlphas": 0.85,
			        "lineAlpha": 0.1,
			        "type": "column",
			        "topRadius":1,
			        "valueField": "number",
			        "autoColor": true
			    }],
			    "depth3D": 40,
				"angle": 30,
			    "chartCursor": {
			        "categoryBalloonEnabled": false,
			        "cursorAlpha": 0,
			        "zoomable": false
			    },
			    "categoryField": "status",
			    "categoryAxis": {
			        "gridPosition": "start",
			        "axisAlpha":0,
			        "gridAlpha":0,
			        "labelRotation":50

			    },
			    "export": {
			    	"enabled": true
			     }

			}, 0);
		
		var chart = AmCharts.makeChart( "chartdiv0", {
			  "type": "serial",
			  "theme": "light",
			  "dataProvider":chartDeptPending,
			  "valueAxes": [{
			        "position": "left",
			        "axisAlpha":0,
			        "gridAlpha":0
			    }],
			    "graphs": [{
			        "balloonText": "[[category]]: <b>[[value]]</b>",
			        "fillAlphas": 0.85,
			        "lineAlpha": 0.1,
			        "type": "column",
			        "topRadius":1,
			        "valueField": "number",
			        "autoColor": true
			    }],
			    "depth3D": 40,
				"angle": 30,
			    "chartCursor": {
			        "categoryBalloonEnabled": false,
			        "cursorAlpha": 0,
			        "zoomable": false
			    },
			    "categoryField": "status",
			    "categoryAxis": {
			        "gridPosition": "start",
			        "axisAlpha":0,
			        "gridAlpha":0,
			        "labelRotation":50

			    },
			    "export": {
			    	"enabled": true
			     }

			}, 0);
		
		
		var chart = AmCharts.makeChart( "chartdiv1", {
			  "type": "serial",
			  "theme": "light",
			  "dataProvider":chartDeptPending,
			  "valueAxes": [{
			        "position": "left",
			        "axisAlpha":0,
			        "gridAlpha":0
			    }],
			    "graphs": [{
			        "balloonText": "[[category]]: <b>[[value]]</b>",
			        "fillAlphas": 0.85,
			        "lineAlpha": 0.1,
			        "type": "column",
			        "topRadius":1,
			        "valueField": "number",
			        "autoColor": true
			    }],
			    "depth3D": 40,
				"angle": 30,
			    "chartCursor": {
			        "categoryBalloonEnabled": false,
			        "cursorAlpha": 0,
			        "zoomable": false
			    },
			    "categoryField": "status",
			    "categoryAxis": {
			        "gridPosition": "start",
			        "axisAlpha":0,
			        "gridAlpha":0,
			        "labelRotation":50

			    },
			    "export": {
			    	"enabled": true
			     }

			}, 0);
	
	
	
		
	
		
		/* category charts codes */
		
		
		
	
	
		
		var chart = AmCharts.makeChart( "chartdivc", {
			  "theme": "light",
			  "type": "serial",
			  "dataProvider":barChartDeptAllCounts,
			  "valueAxes": [{
			        "position": "left",
			        "axisAlpha":0,
			        "gridAlpha":0
			    }],
			    "graphs": [{
			        "balloonText": "[[category]]: <b>[[value]]</b>",
			        "fillAlphas": 0.85,
			        "lineAlpha": 0.1,
			        "type": "column",
			        "topRadius":1,
			        "valueField": "number",
			        "autoColor": true
			    }],
			    "depth3D": 40,
				"angle": 30,
			    "chartCursor": {
			        "categoryBalloonEnabled": false,
			        "cursorAlpha": 0,
			        "zoomable": false
			    },
			    "categoryField": "status",
			    "categoryAxis": {
			        "gridPosition": "start",
			        "axisAlpha":0,
			        "gridAlpha":0,
			        "labelRotation":50

			    },
			    "export": {
			    	"enabled": true
			     }

			}, 0);
		
		
		var chart = AmCharts.makeChart( "chartdiv0c", {
			  "theme": "light",
			  "type": "serial",
			  "dataProvider":barChartDeptPending,
			  "valueAxes": [{
			        "position": "left",
			        "axisAlpha":0,
			        "gridAlpha":0
			    }],
			    "graphs": [{
			        "balloonText": "[[category]]: <b>[[value]]</b>",
			        "fillAlphas": 0.85,
			        "lineAlpha": 0.1,
			        "type": "column",
			        "topRadius":1,
			        "valueField": "number",
			        "autoColor": true
			    }],
			    "depth3D": 40,
				"angle": 30,
			    "chartCursor": {
			        "categoryBalloonEnabled": false,
			        "cursorAlpha": 0,
			        "zoomable": false
			    },
			    "categoryField": "status",
			    "categoryAxis": {
			        "gridPosition": "start",
			        "axisAlpha":0,
			        "gridAlpha":0,
			        "labelRotation":50

			    },
			    "export": {
			    	"enabled": true
			     }

			}, 0);
		
		
		var chart = AmCharts.makeChart( "chartdiv1c", {
			  "theme": "light",
			  "type": "serial",
			  "dataProvider":barChartDeptClosed,
			  "valueAxes": [{
			        "position": "left",
			        "axisAlpha":0,
			        "gridAlpha":0
			    }],
			    "graphs": [{
			        "balloonText": "[[category]]: <b>[[value]]</b>",
			        "fillAlphas": 0.85,
			        "lineAlpha": 0.1,
			        "type": "column",
			        "topRadius":1,
			        "valueField": "number",
			        "autoColor": true
			    }],
			    "depth3D": 40,
				"angle": 30,
			    "chartCursor": {
			        "categoryBalloonEnabled": false,
			        "cursorAlpha": 0,
			        "zoomable": false
			    },
			    "categoryField": "status",
			    "categoryAxis": {
			        "gridPosition": "start",
			        "axisAlpha":0,
			        "gridAlpha":0,
			        "labelRotation":50

			    },
			    "export": {
			    	"enabled": true
			     }

			}, 0);
		
		
		
		
	
		
	
		
		
		 $('input[name=scharts]').on('change', function(e) {
			 
			 var val=$('[name="scharts"]:checked').val();
		    
		    if(val ==1)
		    	{
		    	$("#catecharts").hide();
		    	$("#deptcharts").show();
		    	
		    	
		    	}
		    else
		    	{
		    	$("#catecharts").show();
		    	$("#deptcharts").hide();
		    	
		    	}
		}); 

</script>