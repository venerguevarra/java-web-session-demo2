<%@ page language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Webshoppee</title>
</head>
<body>
	<h2>Webshoppee Shopping Cart</h2><hr/>
	<a href="${pageContext. request. contextPath}/index.jsp">Back</a><br/>
	<c:if test="${not empty shoppingCart.items}">
	<table>
	   <tr>
	       <td>ID</td>
	       <td>Name</td>
	       <td>Description</td>
	       <td>Price</td>
	       <td>Quantity</td>
	       <td>Total Price</td>
	       <td>Action</td>
	   </tr>
	   <c:forEach items="${shoppingCart.items}" var="item">
	   <tr>
           <td><c:out value="${item.id}"/></td>
           <td><c:out value="${item.name}"/></td>
           <td><c:out value="${item.description}"/></td>
           <td><c:out value="${item.price}"/></td>
           <td><c:out value="${item.quantity}"/></td>
           <td><c:out value="${item.totalPrice}"/></td>
           <td>
            <form action="${pageContext. request. contextPath}/shopping-cart" method="post">
                <input type="hidden" name="cartItemId" value="${item.id}">
                <input type="hidden" name="action" value="remove">
                <input type="submit" value="Remove Item">
            </form>
           </td>
       </tr>
	   </c:forEach>
	</table>
	<br/>
	<h2>Total Items: <c:out value="${shoppingCart.count}"/></h2>
	<h2>Grand Total: <c:out value="${shoppingCart.grandTotal}"/></h2>
	</c:if>
	<c:if test="${empty shoppingCart.items}">
	<h2>Shopping Cart Empty</h2> 
	</c:if>
</body>
</html>
