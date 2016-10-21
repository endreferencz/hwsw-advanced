<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>Shopping cart</title>
</head>
<body>

	<c:choose>
		<c:when test="${ fn:length(cart) == 0 }">Cart is empty.</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${ cart }" var="item">
					<li>${ item }</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	
	<p>
	<form action="cart" method="post">
		<input type="text" name="element">
		<input type="submit">
	</form>
	
	<p>
	<a href="cart?delete">Empty cart</a>

</body>
</html>