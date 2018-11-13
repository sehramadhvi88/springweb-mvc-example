<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>
</head>
<body>
	
	<jsp:include page="../view/fragments/header.jsp"></jsp:include>
	
	<div class="container">
	
		<h2>Current Project</h2>
		<ul class="list-group">
			<li class="list-group-item"><label>Project Name:</label><span>${currentProject.name}</span></li>
			<li class="list-group-item"><label>Sponsor:</label><span>${currentProject.sponsor}</span></li>
			<li class="list-group-item"><label>Description:</label><span>${currentProject.description}</span></li>
		</ul>
	
	</div>
	
</body>
</html>