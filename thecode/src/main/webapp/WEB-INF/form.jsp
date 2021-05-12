<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>


<html>
	<head>
		<meta charset="UTF-8">
		<title>Secret Code</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<div class= "mx-5">
			<p class=" mx-5 my-5" ><c:out value= "${error}"/></p>
			<h4 class=" mx-5 my-5">What is the code ?</h4>
			<form method = "Post" action="/login">
				<div class="mx-5 my-5 col-lg-3">
		    			<input type="text" name= "secret" class="form-control col-lg-3"/>
		  		</div>
		  		<div>
		  			<button type="submit" value="submit" class="mx-5 btn btn-info">Try Code</button>
		  		</div>
			</form>
		</div>
	</body>
</html>