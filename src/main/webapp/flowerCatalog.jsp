<%@ page language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Webshoppee</title>
</head>
<body>
	<h2>Webshoppee Flower Catalog</h2><hr/>
	<a href="${pageContext. request. contextPath}/index.jsp">Back</a><br/>
	<table>
	   <tr>
	       <td>ID</td>
	       <td>Name</td>
	       <td>Description</td>
	       <td>Price</td>
	       <td>Action</td>
	   </tr>
	   <c:forEach items="${flowerCatalog}" var="flower">
	   <tr>
           <td><c:out value="${flower.id}"/></td>
           <td><c:out value="${flower.name}"/></td>
           <td><c:out value="${flower.description}"/></td>
           <td><c:out value="${flower.price}"/></td>
           <td>
            <form action="${pageContext. request. contextPath}/shopping-cart" method="post">
                <input type="hidden" name="id" value="${flower.id}">
                <input type="hidden" name="name" value="${flower.name}">
                <input type="hidden" name="description" value="${flower.description}">
                <input type="hidden" name="price" value="${flower.price}">
                <input type="submit" value="Add to Cart">
            </form>
           </td>
       </tr>
	   </c:forEach>
	</table>
</body>
</html>
