<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="<spring:theme code='style'/>" type="text/css" media="all">
</head>
<body>
  <div id="layout-one-fixed">
    <div id="container">
      <div id="header">
        <h1>Shopping cart</h1>
      </div>
      <div id="navigation">
        <ul>
          <li><a href="<c:url value='/' />">Home</a></li>
          <li><a href="<c:url value='/shopping.html' />">Bookstore</a></li>
          <li><a href="<c:url value='/addBookForm.html' />">Manage books</a></li>
          <li><a href="<c:url value='/showShoppingCart.html' />">View shopping cart</a></li>
        </ul>
      </div>
      <div id="content">
        <c:choose>
          <c:when test="${not empty shoppingCartModel.cartItems}">
            <table>
              <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Format</th>
                <th>Quantity</th>
              </tr>

              <c:forEach var="cartItem" items="${shoppingCartModel.cartItems}">
                <tr>
                  <td><a href="<c:url value='${cartItem.book.detailsUrl}' />">${cartItem.book.title}</a></td>
                  <td>${cartItem.book.author}</td>
                  <td>${cartItem.book.bookFormat}</td>
                  <td>${cartItem.quantity}</td>
                </tr>
              </c:forEach>

            </table>
            <a href="<c:url value='${shoppingCartModel.clearShoppingCartUrl}' />">Empty cart</a>
          </c:when>
          <c:otherwise>
            <p>Your shopping cart is empty.</p>
          </c:otherwise>
        </c:choose>
        
      </div>
    </div>
  </div>
</body>
</html>
