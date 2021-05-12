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
		<title>Product Page</title>
	</head>
	<header>
		<h1>${products.name}</h1>
	</header>
	<body>
		<h3>Categories</h3>
		  <c:forEach items="${products.categories}" var="cat">
			<ul>
				<li><c:out value="${cat.name}"/></li>
			</ul>
		</c:forEach> 
		<form action="/product/${products.id}" method="post" > 
			<p>
				<label  for="formGroupExampleInput" class="col-sm-4 form-label">
					Add Category:
				</label>
					<select  name="category_id" class="form-select" id="specificSizeSelect">
						<c:forEach items = "${categories}" var="cat">
							<option value="${cat.id}" >
								<c:out value="${cat.name}"/>
							</option>
						</c:forEach>
					</select>
			</p>    
		    <input type="submit" value="Submit"/>
		</form>
	</body>
</html>