<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aleksandrpliskin
  Date: 25.10.15
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:if test="${result == null}"><p>Ничего не было оправлено</p></c:if>
<c:if test="${result != null}">
    <c:forEach var="date" items="${result}">
        <p>отправлено ${date}</p>
    </c:forEach>
</c:if>
<a href="/main">На главную</a>
</body>
</html>
