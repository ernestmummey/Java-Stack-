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
		<title>Category Page</title>
	</head>
	<header>
		<h1>${categories.name}</h1>
	</header>
	<body>
		<h3>Products</h3>
		 <c:forEach items="${categories.products}" var="prod">
			<ul>
				<li><c:out value="${prod.name}"/></li>
			</ul>
		</c:forEach> 
		<form action="/category/${categories.id}" method="post"> 
			<p>
				<label for="formGroupExampleInput" class="col-sm-4 form-label">
					Add Product:
				</label>
				<select name="product_id" class="form-select" id="specificSizeSelect">
					<c:forEach items = "${products}" var="prod">
						<option value="${prod.id }" >
							<c:out value="${prod.name}"/>
						</option>
					</c:forEach>
				</select>
			</p>    
		    <input type="submit" value="Submit"/>
		</form> 
	</body>
</html>