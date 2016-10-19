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
        <h1>Add new book</h1>
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
        <c:if test="${not empty message}">
          <div class="alert alert-success">${message}</div>
        </c:if>
        <form:form modelAttribute="addBookRequest" action="addBookPost.html" enctype="multipart/form-data">
          <div class="form-group">
            <p>
              <label for="input_title">Title</label>
              <form:input path="title" id="input_title" placeholder="Title" />
              <form:errors path="title" element="div" cssClass="validation-error" />
            </p>
            <p>
              <label for="input_author">Author</label>
              <form:input path="author" id="input_author" placeholder="Author" />
              <form:errors path="author" element="div" cssClass="validation-error" />
            </p>
            <p>
              <label for="input_format">Format</label>
              <form:select path="format" id="input_format" items="${addBookFormModel.availableBookFormats}" />
            </p>
            <p>
              <label for="input_synopsis">Synopsis</label>
              <form:textarea path="synopsis" id="input_synopsis" placeholder="Synopsis" />
            </p>
            <p>
              <label for="cover">Cover</label>
              <form:input path="cover" type="file" id="cover" />
            </p>

          </div>

          <p>
            <button type="submit" class="btn btn-default">Add</button>
          </p>
        </form:form>
      </div>
    </div>
  </div>
</body>
</html>
