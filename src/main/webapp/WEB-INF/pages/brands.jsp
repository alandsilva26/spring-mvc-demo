<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>


<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Brands</title>
  </head>
  <body>
    <c:forEach items="${brands}" var="brand">
        <div style="display: flex; flex-direction: row;margin-bottom: 0.25em;gap: 0.5em;">
            <div>${brand.brandId} - ${brand.title}&nbsp;</div> 
            <form method="GET" action="edit" style="display: block;">
                <input type="hidden" name="brandId" value="${brand.brandId}">
                <button type="submit" style="color: blue">Edit</button>
            </form>
            <form method="POST" action="delete" style="display: block;">
                <input type="hidden" name="brandId" value="${brand.brandId}">
                <button type="submit" style="color: red">Delete</button>
            </form>
        </div>
    </c:forEach>

</br>
<c:if test="${editingMode == false || editingMode == null}">
<form method="POST">
    <label for="title">Brand Title</label>
    <input type="text" name="title">
    <button type="submit">Submit</button>
</form>
</c:if>
<c:if test="${editingMode == true}">
<h1>Editing Brand</h1>
<form method="POST" action="edit">
    <input type="hidden" name="brandId" value="${editBrand.brandId}">
    <label for="title">Brand Title</label>
    <input type="text" name="title" value="${editBrand.title}">
    <button type="submit">Submit</button>
</form>
</c:if>
  </body>
</html>
