<%@ page language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Webshoppee</title>
</head>
<body>
	<h2>Webshoppee Book Catalog</h2><hr/>
	<a href="${pageContext. request. contextPath}/index.jsp">Back</a><br/>
	<table>
	   <tr>
	       <td>ID</td>
	       <td>Name</td>
	       <td>Description</td>
	       <td>Author ID</td>
	       <td>Price</td>
	       <td>Action</td>
	   </tr>
	   <c:forEach items="${bookCatalog}" var="book">
	   <tr>
           <td><c:out value="${book.id}"/></td>
           <td><c:out value="${book.name}"/></td>
           <td><c:out value="${book.description}"/></td>
           <td><c:out value="${book.authorId}"/></td>
           <td><c:out value="${book.price}"/></td>
           <td>
            <form action="${pageContext. request. contextPath}/shopping-cart" method="post">
                <input type="hidden" name="id" value="${book.id}">
                <input type="hidden" name="name" value="${book.name}">
                <input type="hidden" name="description" value="${book.description}">
                <input type="hidden" name="price" value="${book.price}">
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Add to Cart">
            </form>
           </td>
       </tr>
	   </c:forEach>
	</table>
</body>
</html>
