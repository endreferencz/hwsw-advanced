<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping</title>
<link rel="stylesheet" href="<spring:theme code='style'/>" type="text/css" media="all">
</head>
<body>
  <div id="layout-one-fixed">
    <div id="container">
      <div id="header">
        <h1>Browse our books</h1>
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
        <form:form modelAttribute="listBooksRequest" method="get">
          <label for="title">Title</label>
          <form:input path="title" type="text" id="title" placeholder="Title" />
          <button type="submit">Search</button>
        </form:form>
        <table>
          <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Available format</th>
          </tr>

          <c:forEach var="book" items="${listBooksModel.books}">
            <tr>
              <td><a href="<c:url value='${book.detailsUrl}' />">${book.title}</a></td>
              <td>${book.author}</td>
              <td>${book.bookFormat}</td>
            </tr>
          </c:forEach>

        </table>
      </div>
    </div>
  </div>
</body>
</html>
