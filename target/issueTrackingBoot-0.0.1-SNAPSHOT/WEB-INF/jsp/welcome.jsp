<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>ABN</title>
</head>
<body>

 <!-- <a href="/newReligion"> Add Religion</a>
  -->
 <div class="container">
  
  <div class="panel panel-default">
  
    <div class="panel-heading">
             <div class="panel-title pull-left">
             Religions
         </div>
        <div class="panel-title pull-right"><a href="/newReligion"> Add New Religion</a></div>
        <div class="clearfix"></div>
    </div>
    
    
    <div class="panel-body">
<table class="table table-bordered table-hover specialCollapse">

	<tr>
		<th width="80"> Sno</th>
		<th width="120"> Active</th>
		<th width="120">Description</th>
		<th width="60">name</th>
		<th width="60">Religion_system</th>
		<th width="120">Options</th>
	</tr>

 <c:forEach var="religion" items="${religions}">
 <tr>
 <td>${religion.sno }</td>
 <td>${religion.active }</td>
 <td>${religion.description }</td>
  <td>${religion.name }</td>
 <td>${religion.religionSystem}</td>
 <td>
 <a href="/editReligion/${religion.sno }">Edit</a>
 <a href="/deleteReligion/${religion.sno }">Delete</a>
 
 </td>
 </tr>
 
</c:forEach>
 </table>

</div>
  </div>
</div>
</body>
</html>