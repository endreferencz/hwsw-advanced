<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book details</title>
<link rel="stylesheet" href="<spring:theme code='style'/>" type="text/css" media="all">
</head>
<body>
  <div id="layout-one-fixed">
    <div id="container">
      <div id="header">
        <h1>Buy our book</h1>
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
        <h2>Title</h2>
        <p>${bookDetailsModel.bookSummary.title}</p>
        <h2>Author</h2>
        <p>${bookDetailsModel.bookSummary.author}</p>
        <h2>Synopsis</h2>
        <p>${bookDetailsModel.bookDetails.synopsis}</p>
        <p>
          <form:form modelAttribute="addShoppingCartBookItemRequest" servletRelativeAction="${bookDetailsModel.addToCartUrl}">
            <form:hidden path="bookId" />
            <button type="submit">Add to cart</button>
          </form:form>
        </p>
        <c:if test="${not empty bookDetailsModel.bookDetails.coverUrl}">
          <h2>Cover</h2>
          <img src="<c:url value='${bookDetailsModel.bookDetails.coverUrl}' />" />
        </c:if>
      </div>
    </div>
  </div>
</body>
</html>
