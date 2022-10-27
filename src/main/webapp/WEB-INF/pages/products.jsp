<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
<h1>All Products</h1>
<a href="/demo/products/add">Add new Product</a>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Brand</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.productId}</td>
					<td>${product.title}</td>
					<td>${product.price}</td>
					<td>${product.quantity}</td>
					<td>${product.brand.title}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>