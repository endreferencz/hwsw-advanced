<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <div class="authentication">
          <c:if test="${not empty homepageModel.loginUrl}">
            <a href="<c:url value='${homepageModel.loginUrl}' />">Login</a>
          </c:if>
          <c:if test="${not empty homepageModel.logoutUrl}">
            <a href="<c:url value='${homepageModel.logoutUrl}' />">Logout</a>
          </c:if>
        </div>

        <h1>Welcome in ${homepageModel.bookshopName}</h1>
      </div>
      <div id="navigation">
        <ul>
          <li><a href="<c:url value='/' />">Home</a></li>
          <li><a href="<c:url value='/shopping.html' />">Bookstore</a></li>
          <c:if test="${not empty homepageModel.adminUrl}">
            <li><a href="<c:url value='${homepageModel.adminUrl}' />">Manage books</a></li>
          </c:if>
          <li><a href="<c:url value='/showShoppingCart.html' />">View shopping cart</a></li>
          <li>
            <div class="language-selector">
              <c:forEach var="languageSelector" items="${homepageModel.languageSelectors}">
                <a href="<c:url value='${languageSelector.languageSelectorUrl}' />">${languageSelector.languageCode}</a>
              </c:forEach>
            </div>
          <li>
        </ul>
      </div>
      <div id="content">
        <p>
          <spring:message code="com.epam.bookshop.welcome_message" />
        </p>
      </div>
    </div>
  </div>
</body>
</html>
