<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="<spring:url value="/resources/css/global.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<jsp:include page="../view/fragments/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			
			<spring:url value="/project/add" var="formUrl" />
			<form:form action="${formUrl}" method="post" modelAttribute="project"  cssClass="col-md-8 col-md-offset-2">
			
				<div class="form-group">
					<label for="project-name">Name</label>
					<form:input path="name" cssClass="form-control" id="project-name"/>
					<form:errors path="name" cssClass="error"></form:errors>
				</div>

				<div class="form-group">
					<label for="project_type">Type</label>
					<form:select path="type" items="${types}" cssClass="selectpicker"></form:select>
				</div>
							
				<div class="form-group">
					<label for="sponsor-name">Sponsor Name</label>
					<form:input path="sponsor.name" cssClass="form-control" id="sponsor-name"/>
					
				</div>
				<div class="form-group">
					<label for="sponsor-phone">Sponsor Phone</label>
					<form:input path="sponsor.phone" cssClass="form-control" id="sponsor-phone"/>
					
				</div>
				<div class="form-group">
					<label for="sponsor-email">Sponsor Email</label>
					<form:input path="sponsor.email" cssClass="form-control" id="sponsor-email"/>
					
				</div>
			
				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<form:input path="authorizedFunds" cssClass="form-control" id="funds"/>
					
				</div>
			
				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<form:input path="authorizedHours" cssClass="form-control" id="hours"/>
				
				</div>
			
				<div class="form-group">
					<label for="project-name">Description</label>
					<form:textarea path="description" cssClass="form-control" cols="3"/>
					<form:errors path="description" cssClass="error"></form:errors> 
				</div>
				
				<div class="form-group">
					<label for="poc">Poc</label>
					<form:input path="pointOfContact[0]" cssClass="form-control" id="poc"/>
					
				</div>
				<div class="form-group">
					<label for="poc2">Poc2</label>
					<form:input path="pointOfContact[1]" cssClass="form-control" id="poc2"/>
					
				</div>
				<div class="form-group">
					<label for="poc3">Poc3</label>
					<form:input path="pointOfContact[2]" cssClass="form-control" id="poc3"/>
					
				</div>
				
				<div class="form-group">
					<label for="special">Special</label>
					<form:checkbox path="special" id="special"/>
					
				</div>
			
				<button type="submit" class="btn btn-default">Submit</button>
	
			</form:form>
			
		</div>
	</div>
</body>
</html>