<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="<spring:theme code='style'/>" type="text/css" media="all">
</head>
<body>
  <div id="layout-one-fixed">
    <div id="container">
      <div id="header">
        <h1>Welcome in ${homepageModel.bookshopName}</h1>
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
        <form:form modelAttribute="loginRequest" action="j_spring_security_check">
          <form:errors  element="div" cssClass="validation-error" />
          <div class="form-group">
            <p>
              <label for="input_username">Username</label>
              <form:input path="username" id="input_username" placeholder="Username" />
            </p>
            <p>
              <label for="input_password">Password</label>
              <form:input path="password" id="input_password" placeholder="Password" />
            </p>
          </div>
          <p>
            <button type="submit" class="btn btn-default">Login</button>
          </p>
        </form:form>
      </div>
    </div>
  </div>
</body>
</html>
