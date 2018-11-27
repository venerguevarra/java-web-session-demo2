<%@ page language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Webshoppee</title>
</head>
<body>
	<h2>Webshoppee Toy Catalog</h2><hr/>
	<a href="${pageContext. request. contextPath}/index.jsp">Back</a><br/>
	<table>
	   <tr>
	       <td>ID</td>
	       <td>Name</td>
	       <td>Description</td>
	       <td>Price</td>
	       <td>Action</td>
	   </tr>
	   <c:forEach items="${toyCatalog}" var="toy">
	   <tr>
           <td><c:out value="${toy.id}"/></td>
           <td><c:out value="${toy.name}"/></td>
           <td><c:out value="${toy.description}"/></td>
           <td><c:out value="${toy.price}"/></td>
           <td>
            <form action="${pageContext. request. contextPath}/shopping-cart" method="post">
                <input type="hidden" name="id" value="${toy.id}">
                <input type="hidden" name="name" value="${toy.name}">
                <input type="hidden" name="description" value="${toy.description}">
                <input type="hidden" name="price" value="${toy.price}">
                <input type="submit" value="Add to Cart">
            </form>
           </td>
       </tr>
	   </c:forEach>
	</table>
</body>
</html>
