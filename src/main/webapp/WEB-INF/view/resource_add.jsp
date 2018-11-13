<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="<spring:url value="/resources/css/global.css"/>" type="text/css"/>
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>
<script src="<spring:url value="/resources/js/resource.js"/>"></script>
</head>
<body>

	<jsp:include page="../view/fragments/header.jsp"></jsp:include>

	<div class="container">
	
		<div class="row">
			<h1>Resource</h1>
		</div>
		
		<spring:url value="/resource/review" htmlEscape="true" var="formUrl" /> 
		
		<form:form action="${formUrl}" method="POST" modelAttribute="resource"> 	
			
			<div class="row">
				
				<div class="form-group">
					<label for="resource-name">Name</label>
					
					<!-- path is field name -->
					<form:input path="name" cssClass="form-control" id="resource-name" />					
				</div>

				<div class="form-group">
					<label for="resource-type">Type</label>
					<form:select path="type" items="${typeOptions}" cssClass="selectpicker"> 
					 
					<!-- <select id="resource-type" name="type" class="selectpicker">
						<option></option>
						<option value="material">Material</option>
						<option value="other">Other</option>
						<option value="staff">Staff</option>
						<option value="tech">Technical Equipment</option>
					</select> -->
					</form:select>
				</div>

				<div class="form-group">
					<label for="cost">Cost</label> 
					<form:input path="cost" id="cost" cssClass="form-control" /> 
					<!-- <input id="cost" type="text" class="form-control" name="cost" /> -->
				</div>

				<div class="form-group">
					<label for="unit">Unit of Measure</label>
					<form:radiobuttons path="unitOfMeasure" items="${radioOptions}" />
<%-- 					<form:input path="unitOfMeasure" id="cost" cssClass="form-control" /> 
 --%>					<!-- <input id="unit" type="text" class="form-control" name="unitOfMeasure" /> -->
				</div>
				
				<div class="form-group">
					<label for="indicators">Indicators</label>
					<form:checkboxes id="indicators" path="indicators" items="${checkOptions}" />
					<a id="request-link" href="#">Send Request</a>
				</div>
				
				<div class="form-group">
					<label for="notes">Notes</label>
					<form:textarea path="notes" cssClass="form-control" cols="4" rows="3" id="notes" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>

			</div>
		
		
		</form:form>
		
		<spring:url value="/resource/upload" var="uploadURl" />
		
		<form action="${uploadURL}" method="post" enctype="multipart/form-data">
			File to upload <input type="file" name="file"><br>
			<input type="submit" value="Upload"> Press here to upload file.
		</form>
		
	</div>
</body>
</html>