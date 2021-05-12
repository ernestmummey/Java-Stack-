<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>


<html>
	<head>
		<meta charset="UTF-8">
		<title>Counting</title>
	</head>
	<body>
		<h2>You have visited <a href="#">http://your_server</a> <c:out value="${count}"/> times.</h2>
		<h4><a href="/">Test another visit ?</a></h4>
	</body>
</html>