<!-- Body starts here -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script> -->
<!-- Body starts here -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="">Dashboard</li>
				</ul><!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
			
				<div class="row" style="background: white;">
							<div class="col-md-12">

<div class="col-md-8">
							<div id="assigned" class="widget-box widget-color-blue2">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-clock-o"></i>
<a class="white" href="#">Timeline</a></h4>
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
							<div id="assigned" class="widget-box widget-color-blue2">
	<div class="widget-header widget-header-small">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-clock-o"></i>
<a class="white" href="#"> Status Wise Summary</a></h4>
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
                    		<th>By Status(days)</th>
                    		<th>Total</th>
                    	</tr>
<c:forEach var="issue" items="${statusCount}">
<tr class="my-buglist-bug ">
		<td class="nowrap width-13">${issue.key} 
		</td>
		<td class="nowrap width-13">${issue.value} 
		</td>
</tr>
</c:forEach>
</table>
</div>
</div>
						</div><!-- /.row -->
					</div><!-- /.page-content -->
					</div>
				</div>
							</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content-inner -->
	</div>
<script type="text/javascript">
$(".dashBoard").addClass("active");
$(document).ready(function(){
$('.dashBoard').on('click', function(){
});
});
</script>