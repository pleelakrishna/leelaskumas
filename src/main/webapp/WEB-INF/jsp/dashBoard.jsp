<style>
.btn-toolbar {
	margin-left: 5px;
}

.priority th, td {
	text-align: center;
	border: 1px solid #efe9e9;
}

.prioritybg tr:nth-child(even) {
	background: #ccc;
	border: 1px solid red;
}

.assigned {
	width: 120px;
	height: 30px;
	line-height: 0.8;
	border-radius: 10px;
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
									<tr
										style="background-color: #006699; color: #fff; text-align: center;">

										<th>Unclosed Tasks /Severity</th>
										<th>Critical</th>
										<th>Major</th>
										<th>Minor</th>

									</tr>

									<tr class="prioritybg">
										<td>
											<div class="col-md-12" style="margin-left: 5px"!important">

												<span
													style="font-size: 18px; lettee-spacin: 1px; color: #006699;">Assigned
													To Me <c:forEach var="issue" items="${severityCount}">
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

												<c:if test="${fn:contains(String, 'Critical')}">
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
												<c:if test="${fn:contains(String, 'Major')}">
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
												<c:if test="${fn:contains(String, 'Minor')}">
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
													style="font-size: 18px; lettee-spacin: 1px; color: #006699;">Assigned
													By Me<c:forEach var="issue" items="${severityCountsBY}">
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
												<c:if test="${fn:contains(String, 'Critical')}">
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
												<c:if test="${fn:contains(String, 'Major')}">
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
												<c:if test="${fn:contains(String, 'Minor')}">
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
													style="font-size: 18px; lettee-spacin: 1px; color: #006699;">Monitored
													BY Me<c:forEach var="issue" items="${SevMonitoredCounts}">
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
												<c:if test="${fn:contains(String, 'Critical')}">
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

												<c:if test="${fn:contains(String, 'Major')}">
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
												<c:if test="${fn:contains(String, 'Minor')}">
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

							<!-- *********************************** By Status Start *****************-->

							<br>
							<div class="table-responsive">
								<table class="table table-bordered priority prioritybg"
									style="border: 1px solid #006699; width:;" id="statusTable">
									<thead>
										<tr
											style="background-color: #006699; color: #fff; text-align: center;">
											<th>By Status</th>
											<th>Open</th>
											<th>Resolved</th>
											<th>Closed</th>
											<th>Total</th>
										</tr>
									</thead>
									<tbody>


									</tbody>

								</table>
							</div>

							<!--  **************************  By Status End  ******************************-->

							<!-- *********************************** By Category Start *****************-->
							<br>
							<div class="table-responsive">
								<table class="table table-bordered priority prioritybg"
									style="border: 1px solid #006699; width:;" id="categoryTable">
									<thead>
										<tr
											style="background-color: #006699; color: #fff; text-align: center;">

											<th>By Category</th>
											<th>Open</th>
											<th>Resolved</th>
											<th>Closed</th>
											<th>Total</th>

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

											<th>Department Name</th>
											<th>Open</th>
											<th>Closed</th>
											<th>Balanced</th>

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
										<i class="ace-icon fa fa-clock-o"></i> <a class="white"
											href="#">Timeline</a>
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
														<th>By Date(days)</th>
														<th>Open</th>
														<th>Closed</th>
														<th>Balanced</th>

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
		<div class="col-md-12" style="width: 800px; margin-left: -55px;">
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
				+ '<thead><tr><th>Task No</th><th>Summary</th><th>Category</th><th>priority</th><th>Severity</th><th>Assigned By</th><th>Created Time</th><th>Description</th></tr></thead><tbody></tbody></table>';
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
		if (isClick == 'Yes')
			$('#notification').dataTable();

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

	var listOrders1 = ${list};
	if (listOrders1 != "") {
		$('#categoryTable body').html('');
		/* var tableHead = '<table id="example" class="table table-striped table-bordered datatables">'
			+ '<thead><tr><th>Company Code</th><th>Company Name</th><th>Contact Person Name</th><th>Contact Person Mobile</th><th>Email Id</th><th>Type of Comapany</th><th>Company Address</th><th>Remarks</th><th>Status</th><th style="text-align: center;"></th></tr></thead><tbody></tbody></table>';
		$('#tableId').html(tableHead); */
		serviceUnitArray = {};
		var categoryarray = null;
		var assigned = 0;
		var closed1 = 0;
		var resolved = 0;
		$
				.each(
						listOrders1,
						function(i, orderObj) {
							var totalcategory = 0;
							if (orderObj.kStatusNameWithId != "") {

								categoryarray = orderObj.kStatusNameWithId
										.split(",");
							}
							var occurrences = {};
							for (var i = 0, j = categoryarray.length; i < j; i++) {
								occurrences[categoryarray[i]] = (occurrences[categoryarray[i]] || 0) + 1;
							}
							if (occurrences['Assigned'] != undefined) {
								assigned = occurrences['Assigned'];
								totalcategory = totalcategory + assigned;
							} else {
								assigned = 0;
								totalcategory = totalcategory + assigned;
							}
							if (occurrences['Closed'] != undefined) {
								closed1 = occurrences['Closed'];
								totalcategory = totalcategory + closed1;
							} else {
								closed1 = 0;
								totalcategory = totalcategory + closed1;

							}
							if (occurrences['Resolved'] != undefined) {
								resolved = occurrences['Resolved'];
								totalcategory = totalcategory + resolved;
							} else {
								resolved = 0;
								totalcategory = totalcategory + resolved;
							}
							//<a href="severity?id=${issue.key}"
							console.log(occurrences['Assigned']);
							var tblRow = "<tr'>"
									+ "<td  title='"+orderObj.categoryName+"'>"
									+ orderObj.categoryName
									+ "</td>"
									+ "<td title='"+assigned+"' ><a href='categoryDashBord?status=2&categoryId="
									+ orderObj.categoryId
									+ "'  class='btn btn-danger assigned'>"
									+ assigned
									+ "</a></td>"
									+ "<td title='"+resolved+"'><a href='categoryDashBord?status=4&categoryId="
									+ orderObj.categoryId
									+ "'  class='btn btn-warning assigned'>"
									+ resolved
									+ "</td>"
									+ "<td title='"+closed1+"'><a href='categoryDashBord?status=1&categoryId="
									+ orderObj.categoryId
									+ "'  class='btn btn-primary assigned'>"
									+ closed1 + "</td>"
									+ "<td title='"+totalcategory+"'>"
									+ totalcategory + "</td>" + "</tr >";
							$(tblRow).appendTo("#categoryTable tbody");
						});
	}

	var byStatusList = ${byStatusList};
	if (byStatusList != "") {
		$('#statusTable body').html('');
		/* var tableHead = '<table id="example" class="table table-striped table-bordered datatables">'
			+ '<thead><tr><th>Company Code</th><th>Company Name</th><th>Contact Person Name</th><th>Contact Person Mobile</th><th>Email Id</th><th>Type of Comapany</th><th>Company Address</th><th>Remarks</th><th>Status</th><th style="text-align: center;"></th></tr></thead><tbody></tbody></table>';
		$('#tableId').html(tableHead); */
		serviceUnitArray = {};
		var categoryarray = null;
		var assigned = 0;
		var closed2 = 0;
		var resolved = 0;

		$
				.each(
						byStatusList,
						function(i, orderObj) {
							var totalStatus = 0;
							if (orderObj.kStatusNameWithId != "") {

								categoryarray = orderObj.statusConcatination
										.split(",");
							}
							var occurrences = {};
							for (var i = 0, j = categoryarray.length; i < j; i++) {
								occurrences[categoryarray[i]] = (occurrences[categoryarray[i]] || 0) + 1;
							}
							if (occurrences['Assigned'] != undefined) {
								assigned = occurrences['Assigned'];
								totalStatus = totalStatus + assigned;
							} else {
								assigned = 0;
								totalStatus = totalStatus + assigned;
							}
							if (occurrences['Closed'] != undefined) {
								closed2 = occurrences['Closed'];
								totalStatus = totalStatus + closed2;
							} else {
								closed2 = 0;
								totalStatus = totalStatus + closed2;

							}
							if (occurrences['Resolved'] != undefined) {
								resolved = occurrences['Resolved'];
								totalStatus = totalStatus + resolved;
							} else {
								resolved = 0;
								totalStatus = totalStatus + resolved;
							}
							//<a href="severity?id=${issue.key}"
							console.log(occurrences['Assigned']);
							var tblRow = "<tr'>"
									+ "<td  title='"+orderObj.statusName+"'>"
									+ orderObj.statusName
									+ "</td>"
									+ "<td title='"+assigned+"' ><a href='statusDashBord?status="
									+ orderObj.statusId
									+ "'  class='btn btn-danger assigned'>"
									+ assigned
									+ "</a></td>"
									+ "<td title='"+resolved+"'><a href='statusDashBord?status="
									+ orderObj.statusId
									+ "'  class='btn btn-warning assigned'>"
									+ resolved
									+ "</td>"
									+ "<td title='"+closed1+"'><a href='statusDashBord?status="
									+ orderObj.statusId
									+ "'  class='btn btn-primary assigned'>"
									+ closed2 + "</td>"
									+ "<td title='"+totalStatus+"'>"
									+ totalStatus + "</td>" + "</tr >";
							$(tblRow).appendTo("#statusTable tbody");
						});
	}
	
	
	
/* 	$("#ack").mouseover(function(){
		
		alert("hello mousehour");
	}); */
	var deptcountjson = ${deptcountjson};
	var deptcountclosedjson = ${deptcountclosedjson};
	
	
	
	
	if (deptcountjson != "") {
		$('#deptTable body').html('');
		displayDeptTask(deptcountjson,deptcountclosedjson);
		
	}
	
	function displayDeptTask(deptcountjson,deptcountclosedjson){
		
		$.each(deptcountjson, function(i,item) {
			
			console.log(deptcountjson[i]+"------"+deptcountclosedjson[i]);
			
			var diff=parseInt(item)-parseInt(deptcountclosedjson[i])
			console.log(item);
			 var tblRow = "<tr'>"
					+ "<td> "
					+ i
					+ "</a></td>"
					+ "<td ><a href='deptAll?id="+i+"'>"
					+ item
					+ "</a></td>"
					+ "<td ><a href='deptClosed?id="+i+"'>"
					+ deptcountclosedjson[i]
					+ "</a></td>"
					+ "<td ><a href='deptBalanced?id="+i+"'>"
					+ diff
					+ "</a></td>"
					+ "</tr >";
			$(tblRow).appendTo("#deptTable tbody"); 
		});
		
	}

		
	

</script>