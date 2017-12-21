<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html >
<head>
<%
	String baseurl =  request.getScheme() + "://" + request.getServerName() +      ":" +   request.getServerPort() +  request.getContextPath();
	session.setAttribute("baseurl", baseurl);
%>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>APCEI</title>
  <!-- PLUGINS CSS STYLE -->

  <link href="${baseurl}/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="${baseurl }/plugins/animate.css">

<!--   <link rel="stylesheet" href="plugins/selectbox/select_option1.css"> -->

<!--   <link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css"> -->


<!--   <link rel="stylesheet" type="text/css" href="plugins/rs-plugin/css/settings.css" media="screen"> -->

  <link rel="stylesheet" type="text/css" href="${baseurl }/css/chosen.css" media="screen">

	<script src="${baseurl }/js/jquery.min.js"></script>

  <!-- CUSTOM CSS -->

  <link rel="stylesheet" href="${baseurl }/css1/style.css">

  <link rel="stylesheet" href="${baseurl }/css1/default.css" id="option_color">



<style>
.your-class::-webkit-input-placeholder {color: #e73d4a !important;}
.your-class::-moz-placeholder {color: #e73d4a !important;}

.default-class::-webkit-input-placeholder {color: #e73d4a !important;}
.default-class::-moz-placeholder {color: #e73d4a !important;}

.companyType{font-size: 12px;cursor: pointer;}

.form-control {
  background-color:#FFFFFF;
  background-image:none;
  border:1px solid #999;
  border-radius:4px;
  box-shadow:rgba(0, 0, 0, 0.075) 0 1px 1px inset;
  color:#555555;
  display:block;
  font-size:14px;
  height:30px;
  line-height:1.42857;
  padding:1px 12px;
  transition:border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
  width:100%;
}

.apply_from .form-group .label { padding: 8px; }
.apply_from .form-group .label { color:#000; float:right; font-size:13px;font-weight: bold; }
.form-group { margin-bottom:0px; }

textarea { height: inherit !important; }

span.has-error {
	color: red;
	font-weight: normal;
	font-size: 12px;
	width:auto;
	margin: 0px;
}

input, textarea { margin: 0px !important; }

.margin-bottom { margin-bottom: 20px !important; }

form input.error, textarea.error, select.error, #s2id_subject.error {border: 1px solid red !important;}

span.star { color: black !important; }

.msgcss
{
	width: 50%;
	margin: auto;
	font-weight: bold;
	text-align: center;
	top: 0;
	left:0;
	right:0;
	position: fixed;
	font-size: 14px;
	z-index:99999;
}

@media print {
  .notprint { visibility: hidden; }
}
.alreadyMember{float: right;}

@media(max-width: 480px){
	.text-field{
		margin-bottom: 0.5em;
	}
	.alreadyMember, .apply_from .form-group .label {
		float: left;
	}
}

.alert-success, .alert-warning, .alert-danger{color: white !important;}
.alert-success{background-color: #4CAF50 !important;}
.alert-warning{background-color: #ff6600 !important;}
.alert-danger{background-color: #d43f3a !important;}

 </style>

</head>
 <c:choose>
	    <c:when test="${empty param.page}">
 <c:set var="pagenum" value=""/> 
	    </c:when>
	    <c:otherwise>
	
	<c:set var="pagenum" value="${param.page}"/> 
	    </c:otherwise>
	</c:choose>
<body class="body-wrapper" >

	<div class="main_wrapper">

    	<header class="header-wrapper"  >
			<div id="headerimg"><img src="${baseurl}/img/header-bill.jpg" class="img-responsive" width="100%"></div>
	    </header>

		<div class="aboutArea" >

			<div class="container">

				<div class="panel panel-default">

					<div class="panel-heading" align="center">
						<!-- <button type="button" class="btn btn-success pull-right"><a href="index.php" style="color:white;">BACK</a></button> -->
    					<a href="getList" style="float: left;">My Bookings</a> &nbsp; &nbsp; &nbsp;
     					<a href="../logoutHome" style="float: right;">Log Out</a>
    					<h3 id="planingNameID"></h3>
						<p style="margin:0px;"><b>Registration Amount: Rs.</b> <span id="planPriceId"></span>/- </p>
					</div>

					<div class="panel-body" style="margin:0 auto;">
					    			<c:if test="${not empty msg}">
										<div class="msgcss alert alert-success fadeIn animated"><span>${msg}</span></div>
									</c:if>
<%-- 					    <div style="animation-iteration-count: 5;animation-duration: 1s;" class="msgcss alert alert-success fadeIn animated"><span>${msg} kfkgyhukj</span></div> --%>
					    <div class="form-group" style="margin-bottom:0px;">
					    	<form class="form-horizontal" method="post" id="membershipFormCheck">
					    	<div class="row">
					            <div class="col-xs-12 col-md-4">
					                <label class="control-label alreadyMember">Already a Member</label>
					            </div>
					            <div class="col-xs-12 col-md-3">
					                <div class="text-field">
					                    <input type="text" name="memebershipId" id="memebershipId" class="form-control" placeholder="Enter Membership-ID">
					                    <span class="has-error" id="memebershipMessage"></span>
					                </div>
					            </div>
					            <div class="col-xs-12 col-sm-12 col-md-2">
					            	<input type="button" class="btn btn-sm btn-primary" id="checkMembership" value="Check"/>
					            </div>
					        </div>
					        </form>
						</div><!--end form group-->
						
						<hr style="margin-bottom: 0px;">
					    
					    <div class="form-group" style="margin-bottom:0px;">
					        <div class="row">
					            <div class="col-xs-12 col-sm-4">
					                <div class="label">Interested to</div>
<!-- 									<label class="control-label" style="float: right;">Interested to</label> -->
					            </div>
					
					            <div class="col-xs-12 col-sm-4">
					                <div class="text-field">
					                    <h4 style="margin:8px 0px 0px 0px">Join for</h4>
					                </div>
					            </div>
					        </div>
					    </div><!--end form group-->
									
<form:form method="post" class="apply_from" modelAttribute="membersForm" action="saveMembers" id="saveMembers" enctype="multipart/form-data">


<form:hidden path="page" value="${param.page}"/>
 <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label"></div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:select path="packagePlan" class="form-control chosen-select" multiple="true" onfocus="removeBorder(this.id)" onchange="PackageChange(this.id);">
                    	<form:option value="">-- Select Plan --</form:option>
                        <form:options items="${plans }"></form:options>
                	</form:select>
                </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                	<span>Fee: </span><span id="priceId"></span><br>
                	<span>GST (18%): </span><span id="gstId"> </span><br>
                	<span>Total Price: </span><span id="totalPrice"></span>
            </div>
        </div>
    </div><!--end form group-->
    
 <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">District <span class="star">*</span></div>
            </div>

            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
					<form:select path="districtId" class="form-control" onblur="validate(this.id,'');" onfocus="removeBorder(this.id)" onchange="getChapters(this.id);">
                    	<form:option value="">Select District</form:option>
                        <form:options items="${districts}"></form:options>
                	</form:select>
                </div>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Chapter <span class="star">*</span></div>
            </div>

            <div class="col-xs-12 col-sm-4">
            <form:hidden path="chapterId"/>
                <div class="text-field">
					<form:select path="chapterId1" class="form-control" onblur="validate(this.id,'');" onfocus="removeBorder(this.id)" disabled="true">
                   		<form:option value="">Select Chapter</form:option>
                        <form:options items="${chapters}"></form:options>
                	</form:select>
                </div>
            </div>
        </div>
    </div><!--end form group-->
    
    
  <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Applicant Name <span class="star">*</span></div>
            </div>

            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                    <form:input path="name" class="form-control onlyCharacters" placeholder="Enter Name" onblur="validate(this.id,'Enter Name');" onfocus="removeBorder(this.id)"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->
    
    <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Designation <span class="star">*</span></div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                    <form:input class="form-control onlyCharacters" onblur="validate(this.id,'Enter Designation');" onfocus="removeBorder(this.id)" path="designation" placeholder="Designation"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->    
    
    <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Photo </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                  <input type="file" name="images" />
                   <span class="imageupload_error has-error" id="imageupload_error"></span>
                </div>
            </div>
        </div>
    </div><!--end form group-->    

    <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Address <span class="star">*</span></div>
            </div>

            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                    <form:input  class="form-control onlyCharacters" path="address" placeholder="Enter Address" onblur="validate(this.id,'Enter Address');" onfocus="removeBorder(this.id)"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->
    
    <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">City  <span class="star">*</span></div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                    <form:input class="form-control onlyCharacters" path="city" placeholder="Enter City" onblur="validate(this.id,'Enter City');" onfocus="removeBorder(this.id)"/>
                </div>
            </div>
        </div>

    </div><!--end form group-->
 
    <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Mobile No <span class="star">*</span></div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                    <form:input class="form-control numericOnly" onfocus="removeBorder(this.id)" maxlength="13" path="mobileNo" placeholder="Enter Mobile Number"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->
    <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Alternative Mobile No </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                    <form:input class="form-control numericOnly" maxlength="13" path="mobileNo2" placeholder="Enter Alternative Mobile Number"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->

    <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Office No  </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                    <form:input class="form-control numericOnly" maxlength="13" path="officeNo" placeholder="Enter Office Number"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->
    
    
    <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Email ID</div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                    <form:input class="form-control" path="emailID" placeholder="Enter Email ID" />
                </div>
            </div>
        </div>
    </div>

  
   <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Website </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                    <form:input class="form-control" path="website" placeholder="Enter Website URL"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->
  
  
 	<div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Constitution of the company </div>
            </div>
            <div class="col-xs-12 col-sm-8">
                <div class="text-field">
                     <label class="companyType" for="companyType1">
      					<form:radiobutton path="companyType" value="PartnerShip" /> PartnerShip
    				</label> 
    				<label class="companyType" for="companyType2">
      					<form:radiobutton path="companyType" value="Propritorship"/> Propritorship
    				</label> 
    				<label class="companyType" for="companyType3">
      					<form:radiobutton path="companyType"  value="Pvt Ltd"/> Pvt Ltd
				    </label> 
				    <label class="companyType" for="companyType4">
      					<form:radiobutton path="companyType" value="Public Ltd" /> Public Ltd
    				</label>
				    <label class="companyType" for="companyType5">
				      	<form:radiobutton path="companyType"  value="Government" /> Government
				    </label>
				    <label class="companyType" for="companyType6">
				      	<form:radiobutton path="companyType"  value="Others"/> Others
				    </label>
                </div>
            </div>
        </div>
    </div><!--end form group-->  
 
  
   <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Company Registration No </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control" path="companyRegistrationNo" placeholder="Enter Company Registration No"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->  
  
  
  <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Company Incorporate Date </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control" path="companyIncorporateDate" placeholder="Enter Company Incorporate Date"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->  
   
  
  
  <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">GST </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control"  path="GST" placeholder="Enter GST Number"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->  
  
  
  
  <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Other than companies </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control" path="othercompanies" placeholder="Other than companies"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->  
  
  
   <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Years of Inception </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control numericOnly" path="yearsofInception" placeholder="Enter Years of Inception"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->  
    
    
 <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Nature of business <span class="star">*</span></div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control" path="natureofBusiness" placeholder="Enter Nature of business" onblur="validate(this.id,'Enter Nature of business');" onfocus="removeBorder(this.id)"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->    
    
    
   <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Services offered <span class="star">*</span></div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control" path="servicesoffered" placeholder="Services offered" onblur="validate(this.id,'Enter Services offered');" onfocus="removeBorder(this.id)"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->
    
   
    
    <div class="packagePlanOptions">
    <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Turnover </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control numericOnly" path="turnover" placeholder="Turnover"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->   
    
    
   
    <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Year Preceeding Last year </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control numericOnly" path="yearPreceedingLastyear" placeholder="Year Preceeding Last year"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->  
      
 
   <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Preceeding year </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control numericOnly" path="preceedingyear" placeholder="Preceeding year"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->  
    
    
     <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Alternative Representative Name  </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control onlyCharacters" path="alternativeRepresentativeName" placeholder="Alternative Representative Name"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->  
    
    
   <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Designation  </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control onlyCharacters" path="alternativeRepresentatDesignation" placeholder="Designation"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->   
     
 
  <div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Photo </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                    <input type="file" name="alterImage" accept=".png,.jpg"/>
                    <span class="altupload_error has-error" id="altupload_error"></span>
                </div>
            </div>
        </div>
    </div><!--end form group-->   
 
 
	<div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">
                <div class="label">Mobile No  </div>
            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
                     <form:input class="form-control numericOnly" path="alternativeRepresentatMobileNo" placeholder="Mobile No" maxlenth="13"/>
                </div>
            </div>
        </div>
    </div><!--end form group-->
 </div>
 
  <br />

 	<div class="form-group">
        <div class="row">
            <div class="col-xs-12 col-sm-4">

            </div>
            <div class="col-xs-12 col-sm-4">
                <div class="text-field">
					<input type="submit" value="Register" id="submitForm" class="btn btn-primary">
                   	<button type="button" onclick="window.location.reload()" id="resetBtn" name="resetBtn" class="btn btn-danger">Reset</button>
                </div>
            </div>
        </div>
    </div>
<br />
<br />

 

</form:form>



</div>

</div>

 </div>

 </div> 

<footer class="footer-v1">
  <div class="footer clearfix">
    <div class="container">
      <div class="row clearfix">
        <div class="col-sm-6 col-xs-12 copyRight">
          <p>APCEI © 2017. All Rights Reserved</p>
        </div><!-- col-sm-6 col-xs-12 -->
        <div class="col-sm-6 col-xs-12 privacy_policy">
          <a href="http://www.charvikent.com">Designed by Charvikent ITES Pvt Ltd.</a>
        </div><!-- col-sm-6 col-xs-12 -->
      </div><!-- row clearfix -->
    </div><!-- container -->
  </div><!-- footer -->
</footer>

</div>


<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.js" type="text/javascript"></script> -->
<script src="${baseurl }/js/chosen.jquery.js"></script>
<script src="${baseurl }/js/custemValidation.js"></script>
<script src="${baseurl }/js/ajax.js"></script>
<script type="text/javascript">
window.setTimeout(function() {
   $(".msgcss").fadeTo(500, 0).slideUp(500, function(){
       $(this).remove(); 
   });
}, 4000);

function getChapters(id){
	var id = $("#"+id).val();
	if(id != null){
	var formData = new FormData();
     formData.append('id', id);
	$.fn.makeMultipartRequest('POST', 'getChapters', false,
			formData, false, 'text', function(data){
		var jsonobj = $.parseJSON(data);
		var chapterId = jsonobj.chapterId;
		$("#chapterId").val(chapterId);
		$("#chapterId1").val(chapterId);
 	 $("#chapterId1").css("border", "");
	  $("#chapterId1").css('color','black');
	  $('#chapterId1').addClass('default-class');
		$("#chapterId1").trigger("choose:update");
	});
	}
}

$(document).ready(function()
{
// 	$(".packagePlanOptions").hide();
	$('input[type=file]').change(function()
	{
		var val = $(this).val().toLowerCase();
		var regex = new RegExp("(.*?)\.(png|jpg)$");
 		if(!(regex.test(val)))
 		{
			$(this).val('');
			alert('Please Select .png/.jpg format only..!');
		}
 	});
});

function validate(id, errorMessage)
{
	var styleBlock = '.placeholder-style.placeholder-style::-moz-placeholder {color: #cc0000;} .placeholder-style::-webkit-input-placeholder {color: #cc0000;}';
	if($('#'+id).val() ==  null || $('#'+id).val() == "" || $('#'+id).val()=="undefined"){
		$('style').append(styleBlock);
		$('#'+id).css('border-color','#cc0000');
		$('#'+id).attr('placeholder',errorMessage);
		$('#'+id).addClass('placeholder-style');
//		$('#'+id).css('color','#cc0000');
//		$('#'+id+'Error').text(errorMessage);
	}else{
		$('#'+id).css('border-color','');
		$('#'+id).removeClass('placeholder-style');
//		$('#'+id).css('color','');
//		$('#'+id+'Error').text("");
	}
}

$("#submitForm").click(function(event)
{		
	if($('#chapterId').val() ==  null || $('#chapterId').val() == ""  || $('#chapterId').val()=="undefined" || 
			$('#address').val() ==  null || $('#address').val() == ""  || $('#address').val()=="undefined" || 
			$('#name').val() ==  null || $('#name').val() == ""  || $('#name').val()=="undefined" || 
			$('#designation').val() ==  null || $('#designation').val() == ""  || $('#designation').val()=="undefined" || 
			$('#city').val() ==  null || $('#city').val() == ""  || $('#city').val()=="undefined" || 
			$('#mobileNo').val() ==  null || $('#mobileNo').val() == ""  || $('#mobileNo').val()=="undefined" || 
			$('#mobileNo').val().length<10 || $('#districtId').val() ==  null || $('#districtId').val() == ""  || 
			$('#districtId').val()=="undefined" || $('#officeNo').val() ==  null || $('#packagePlan').val() == "" || 
			$('#packagePlan').val()=="undefined" || $('#natureofBusiness').val() ==  null || $('#natureofBusiness').val() == "" || 
			$('#natureofBusiness').val()=="undefined" || $('#servicesoffered').val() ==  null || 
			$('#servicesoffered').val() == "" || $('#servicesoffered').val()=="undefined")
	{
		if($('#chapterId').val() ==  null || $('#chapterId').val() == "" || $('#chapterId').val()=="undefined" ) 
		{
			$('#chapterId').css('color','#cc0000');
			$('#chapterId').css('border-color','#cc0000');
			$('#chapterId').attr('placeholder','Select ChapterId');
			$('#chapterId').addClass('your-class');
		}
		if($('#name').val() ==  null || $('#name').val() == "" || $('#name').val()=="undefined" ) 
		{
			$('#name').css('color','#cc0000');
			$('#name').css('border-color','#cc0000');
			$('#name').attr('placeholder','Enter Name');
			$('#name').addClass('your-class');
		}
		if($('#designation').val() ==  null || $('#designation').val() == "" || $('#designation').val()=="undefined" ) 
		{
			$('#designation').css('color','#cc0000');
			$('#designation').css('border-color','#cc0000');
			$('#designation').attr('placeholder','Enter Designation');
			$('#designation').addClass('your-class');
		}
		if($('#address').val() ==  null || $('#address').val() == "" || $('#address').val()=="undefined" ) 
		{
			$('#address').css('color','#cc0000');
			$('#address').css('border-color','#cc0000');
			$('#address').attr('placeholder','Enter Address');
			$('#address').addClass('your-class');    
		}
		if($('#districtId').val() ==  null || $('#districtId').val() == "" || $('#districtId').val()=="undefined" ) 
		{
			$('#districtId').css('color','#cc0000');
			$('#districtId').css('border-color','#cc0000');
			$('#districtId').attr('placeholder','Enter DistrictId');
			$('#districtId').addClass('your-class');
		} 
		if($('#city').val() ==  null || $('#city').val() == "" || $('#city').val()=="undefined" ) 
		{
			$('#city').css('color','#cc0000');
			$('#city').css('border-color','#cc0000');
			$('#city').attr('placeholder','Enter City');
			$('#city').addClass('your-class');
		}
		if($('#mobileNo').val() ==  null || $('#mobileNo').val() == "" || $('#mobileNo').val()=="undefined") 
		{
			$('#mobileNo').css('color','#cc0000');
			$('#mobileNo').css('border-color','#cc0000');
			$('#mobileNo').attr('placeholder','Enter Mobile Number');
			$('#mobileNo').addClass('your-class');
		}
		if($('#mobileNo').val().length<10) 
		{
			$('#mobileNo').css('color','#cc0000');
			$('#mobileNo').css('border-color','#cc0000');
			$('#mobileNo').attr('placeholder','Invalid Mobile Number');
			$('#mobileNo').addClass('your-class');
		}
		if($('#packagePlan').val() ==  null || $('#packagePlan').val() == "" || $('#packagePlan').val()=="undefined") 
		{
			$('#packagePlan').css('color','#cc0000');
			$('#packagePlan').css('border-color','#cc0000');
			$('#packagePlan').attr('placeholder','Select packagePlan');
			$('#packagePlan').addClass('your-class');
		}
		if($('#natureofBusiness').val() ==  null || $('#natureofBusiness').val() == ""  || $('#natureofBusiness').val()=="undefined") 
		{
			$('#natureofBusiness').css('color','#cc0000');
			$('#natureofBusiness').css('border-color','#cc0000');
			$('#natureofBusiness').attr('placeholder','Enter Nature of Business');
			$('#natureofBusiness').addClass('your-class');
		}
		if($('#servicesoffered').val() ==  null || $('#servicesoffered').val() == ""  || $('#servicesoffered').val()=="undefined") 
		{
			$('#servicesoffered').css('color','#cc0000');
			$('#servicesoffered').css('border-color','#cc0000');
			$('#servicesoffered').attr('placeholder','Enter Services offered');
			$('#servicesoffered').addClass('your-class');
		}
		return false;
	}
	else
	{
		$("#submitForm").attr("disabled",true);
		$("#submitForm").val("Please wait...");
// 		$("#submitForm").hide();
	}
	$("#saveMembers").submit();
	event.preventDefault();
});

function PackageChange(id)
{
	var id = $("#"+id).val();
	if(id != null && id != "" && id != "undefiened"){
    for(var i=0;i<id.length;i++)
    {
		if(id[i]== '2' || id[i]=='3'){
	    	$(".packagePlanOptions").show();
	    }
    	if(id[i] =="2"){
    		$("#packagePlan").find("option[value=3]").prop('disabled',true);
    	}else{
    		 $("#packagePlan").find("option[value=3]").prop('disabled',false);
    	}
    	if(id[i] =="3"){
    		$("#packagePlan").find("option[value=2]").prop('disabled',true);
    	}else{
    		$("#packagePlan").find("option[value=2]").prop('disabled',false);
    	}
    }
    $.ajax({
		type : "POST",
		url : "getPrice.json",
		data : "name=" + id,
		dataType : "text", 
		success : function(response) {
			var jsonobj = $.parseJSON(response);
			var list =jsonobj.list;
			var gst= parseInt(list[0].gst);
			var TotalPrice= parseInt(list[0].TotalPrice);
			var price= parseInt(list[0].price);
			$("#gstId").text(gst);
			$("#totalPrice").text(TotalPrice);
			$("#priceId").text(price);
			//resetStatus(serviceId);
			//resetVendor(serviceId);
			},
			error : function(e) {
				}
	});
	}
// 		var chapterId = jsonobj.chapterId;
// 		$("#chapterId").val(chapterId);
//  	 $("#chapterId").css("border", "");
// 	  $("#chapterId").css('color','black');
// 	  $('#chapterId').addClass('default-class');
// 		$("#chapterId").trigger("choose:update");
}
	
 var pagenum = "${pagenum}";
 if(pagenum =="event"){
$("#packagePlan").val(1);
PackageChange("packagePlan");
 $("#planingNameID").text("Event Registration");
 $("#planPriceId").text("500");
 $(".packagePlanOptions").hide();
 }
 if(pagenum =="membership"){
	 $("#packagePlan").val(2);	
	 PackageChange("packagePlan");
	 $("#planingNameID").text("Membership Registration"); 
	 $("#planPriceId").text("5000");
	 $(".packagePlanOptions").show();
	  }
 if(pagenum =="lifetime"){
	 $("#packagePlan").val(3);	
	 PackageChange("packagePlan");
	 $("#planingNameID").text("Lifetime Registration");
	 $("#planPriceId").text("50000");
	 $(".packagePlanOptions").show();
	  }
</script>

</body>
</html>
