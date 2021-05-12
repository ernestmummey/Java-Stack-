<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
           <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>New Category</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	</head>
	<body>
	<div class="catContainer">
		<header>
			<h1 class = "catHeader">New Category</h1>
		</header>
		
			<form:form action="/categories" method="post" modelAttribute="category">
			    <p>
			        <form:label path="name">Name</form:label>
			        <form:errors path="name"/>
			        <form:input path="name"/>
			    </p>   
			    <input type="submit" value="Submit"/>
			</form:form> 
		</div>
	</body>
</html>