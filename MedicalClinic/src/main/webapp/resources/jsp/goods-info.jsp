<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: aleksandrpliskin
  Date: 18.10.15
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<a href="/main">На главную</a>
<form action="/goods_info/sending_goods" method="get">
  <select name="name">
    <core:forEach var="string" items="${medClinicNames}">
      <option>${string}</option>
      <br>
    </core:forEach>
    <form:input path=""
  </select><br/>
</form>
</body>
</html>
