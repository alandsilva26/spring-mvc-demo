<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
	<h1>Add Product</h1>
	<form method="POST">
		<div>
			<label for="title">Title</label>
			<input type="text" name="title" /> </br>
			<label for="brandTitle">Brand</label>
			<input type="text" list="brand-list"
				name="brandTitle" id="brand-title"> </br>
			<datalist id="brand-list">
				<c:forEach items="${brands}" var="brand">
					<option value="${brand.title}">
				</c:forEach>
			</datalist>
			<label for="number">Price</label>
			<input type="number" name="price" /></br>
			<label for="quantity">Quantity</label>
			<input type="number" name="quantity">
			<button type="submit">Submit</button>
		</div>
	</form>
</body>
</html>