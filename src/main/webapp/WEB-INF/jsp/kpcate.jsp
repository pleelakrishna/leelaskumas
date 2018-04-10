<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<div class="clearfix"></div>
	<ol class="breadcrumb">
		<li><a href="dashBoard">Home</a></li>
		<li>Category Master</li>
	</ol>
	<div class="clearfix"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12" style="background-color: white !important; padding-top: 15PX;">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Category List</h4>
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
						<h4>Add Category</h4>
					</div>
					<form:form class="form-horizontal" commandName="catef" role="form" id="fillingstation-form" action="category" method="post" enctype="multipart/form-data">
					<div class="panel-body">
						<div class="row">
                    		<div class="col-md-6">
                    			<div class="form-group">
                    				<form:hidden path="id"/>
									<label for="focusedinput" class="col-md-6 control-label">Category Name <span class="impColor">*</span></label>
									<div class="col-md-5">
										<form:input path="category" class="form-control validate onlyCharacters" placeholder="Enter Category  Name"/>	
										<span class="hasError" id="stationnameError"></span>
								    </div>
                    			</div>
                    		</div>
                    		<div class="col-md-6">
                    			<div class="form-group">
									<label for="focusedinput" class="col-md-6 control-label">Category Images <span class="impColor">*</span></label>
									<div class="col-md-5">
										<input type="file" name="file1" id="file1" class="validate "  accept="image/*" style="margin: 7px 0px 0px 0px;">
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
<%-- <script type='text/javascript' src='${baseurl }/js/custemValidation.js'></script>  --%>
<script>
</script>
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
			+ '<thead><tr><th>Category Name</th><th>Category Images </th><th style="text-align: center;">Options</th></tr></thead><tbody></tbody></table>';
	$('#tableId').html(tableHead);
	serviceUnitArray = {};
	$.each(listOrders,function(i, orderObj) {
		
		if(orderObj.categoryimg==undefined) orderObj.categoryimg='';
		else
			{
				var list=orderObj.categoryimg.split('*');
				var categoryimg='';
				for(var i=0;i<list.length;i++)
				{
					categoryimg=categoryimg+'<a href="reportDocuments/'+list[i]+'" target="_blank" title="'+list[i]+'"><img src="reportDocuments/'+list[i]+'" style="height:42px; width:42px"></a>';
				}
				orderObj.categoryimg=categoryimg;
			}
		
		
		if(orderObj.status == "1"){
			var deleterow = "<a class='deactivate' onclick='deletecategory("+ orderObj.id+ ",0)'><i class='fa fa-eye'></i></a>"
		}else{  
			var deleterow = "<a class='activate' onclick='deletecategory("+ orderObj.id+ ",1)'><i class='fa fa-eye-slash'></i></a>"
		}
		var edit = "<a class='edit editIt' onclick='editCate("	+ orderObj.id+ ")'><i class='fa fa-edit'></i></a>"
		serviceUnitArray[orderObj.id] = orderObj;
		var tblRow = "<tr>"
			+ "<td title='"+orderObj.category+"'>"+ orderObj.category + "</td>"
			+ "<td title='"+orderObj.categoryimg+"'>"+ orderObj.categoryimg + "</td>"
			+ "<td style='text-align: center;white-space: nowrap;'>" + edit + "&nbsp;&nbsp;" + deleterow + "</td>" 
			+ "</tr>";
		$(tblRow).appendTo("#tableId table tbody");
	});
	if(isClick=='Yes') $('.datatables').dataTable();
	
}


function editCate(id) {
	$("#id").val(serviceUnitArray[id].id);
	$("#category").val(serviceUnitArray[id].category);
	$("#status").val(serviceUnitArray[id].status);
	$("#submit1").val("Update");
	$(window).scrollTop($('#moveTo').offset().top);
}

function deletecategory(id,status){
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
		$.fn.makeMultipartRequest('POST', 'deleteCate', false, formData, false, 'text', function(data){
			var jsonobj = $.parseJSON(data);
			var alldata = jsonobj.allOrders1;
			displayTable(alldata);
			toolTips();
			$('#inActive').prop('checked', false);
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
		
		$.fn.makeMultipartRequest('POST', 'inActivekpCategories', false,
				formData, false, 'text', function(data) {
			var jsonobj = $.parseJSON(data);
			var alldata = jsonobj.allOrders1;
			displayTable(alldata);
			console.log(jsonobj.allOrders1);
				});
		
}		
		
		document.getElementById("file1").onchange = function () {
		    var reader = new FileReader();
		    if(this.files[0].size>528385){
		        alert("Image Size should not be greater than 1000Kb");
		        $("#file1").attr("src","blank");
		       // $("#file1").hide();  
		        $('#file1').wrap('<form>').closest('form').get(0).reset();
		        $('#file1').unwrap();     
		        return false;
		    }
		    if(this.files[0].type.indexOf("image")==-1){
		        alert("Invalid Type");
		        $("#file1").attr("src","blank");
		        //$("#file1").hide();  
		       $('#file1').wrap('<form>').closest('form').get(0).reset();
		      //  $('#file1').unwrap();         
		        return false;
		    }   
		    reader.onload = function (e) {
		        // get loaded data and render thumbnail.
		        document.getElementById("menu_image").src = e.target.result;
		        $("#file1").show(); 
		    };

		    // read the image file as a data URL.
		    reader.readAsDataURL(this.files[0]);
		};
		



$("#pageName").text("Category Master");
$(".category").addClass("active"); 
</script>