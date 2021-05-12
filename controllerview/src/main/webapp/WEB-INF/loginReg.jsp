<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	    <meta charset="UTF-8">
	    <title>Registration Page</title>
	</head>
	<body id="wrapper">
		<div id="loginRegWrapper" class="d-flex justify-content-evenly">
		    
			    <form:form class= "form" method="POST" action="/registration" modelAttribute="user">
			    	<h1 class="mb-5">Register</h1>
			    	<p class ="text-danger"><c:out value="${please}" /></p>
			    	<p class ="text-success"><c:out value="${reg}" /></p>
			    	
			            <form:errors class="text-danger" path="firstName"/>
			   		<p class="d-flex ">
			            <form:label for="exampleFormControlInput1" class="col-form-label col-4" path="firstName">First Name:</form:label>
			            <form:input type="text" path="firstName" class="form-control-lg" id="exampleFormControlInput1" placeholder=""/>
			        </p>
			            
			            <form:errors class="text-danger" path="lastName"/>
			        <p class="d-flex ">
			            <form:label for="exampleFormControlInput1" class="col-form-label col-4" path="lastName">Last Name:</form:label>
			            <form:input type="text" path="lastName" class="form-control-lg" id="exampleFormControlInput1" placeholder=""/>
			        </p>
			        
			            
			            <form:errors class="text-danger" path="email"/>
			        <p class="d-flex ">
			            <form:label for="exampleFormControlInput1" class="col-form-label col-4" path="email">Email:</form:label>
			            <form:input type="email" path="email" class="form-control-lg" id="exampleFormControlInput1" placeholder=""/>
			        </p>
			        
			            
			            <form:errors class="text-danger" path="password"/>
			        <p class="d-flex ">
			            <form:label for="exampleFormControlInput1" class="col-form-label col-4" path="password">Password:</form:label>
			            <form:password path="password" class="form-control-lg" id="exampleFormControlInput1" placeholder=""/>
			        </p>
			            
			            
			            <form:errors class="text-danger" path="password"/>
			        <p class="d-flex ">
			            <form:label for="exampleFormControlInput1" class="form-label col-4" path="passwordConfirmation">Password Confirmation:</form:label>
			            <form:password path="passwordConfirmation" class="form-control-lg" id="exampleFormControlInput1" placeholder=""/>
			        </p>
			        
			            
			        <button type="submit" class="btn-lg btn-success">Register</button>
			    </form:form>
		    
		    
			    <form method="post" action="/login">
			    <h1 class="mb-5">Login</h1>
			    
			    <p class ="text-danger"><c:out value="${error}" /></p>
			    
			        <p class="d-flex ">
			            <label for="email"for="exampleFormControlInput1" class="col-form-label col-4">Email</label>
			            <input id="email" name="email" type="email" class="form-control-lg " id="exampleFormControlInput1" placeholder=""/>
			        </p>
			        
			            <form:errors  class="text-danger" path="email"/>
			            
			        <p class="d-flex ">
			            <label for="password" for="exampleFormControlInput1" class="col-form-label col-4">Password</label>
			            <input type="password" id="password" name="password" class="form-control-lg " id="exampleFormControlInput1" placeholder=""/>
			        </p>
			        
			            <form:errors class="text-danger" path="password"/>
			            
			        <button type="submit" class="btn-lg btn-success">Login</button>
			    </form>    
		    
	    </div>
	</body>
</html>