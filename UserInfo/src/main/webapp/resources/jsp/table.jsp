<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  com.pliskin.alex.service.User: aleksandrpliskin
  Date: 11.10.15
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
</head>
<body>
<table padding="3px" , border="1px">
    <td>Name</td>
    <td>Surname</td>
    <td>ThirdName</td>
    <c:if test="${userInfo.date!=null}">
        <td>BirthDate</td>
    </c:if>
    <c:if test="${userInfo.sex!=null}">
        <td>Sex</td>
    </c:if>
    </tr>
    <tr>
        <td>${userInfo.name}</td>
        <td>${userInfo.surname}</td>
        <td>${userInfo.thirdName}</td>
        <c:if test="${userInfo.date!=null}">
            <td>${userInfo.date}</td>
        </c:if>
        <c:if test="${userInfo.sex!=null}">
            <td>${userInfo.sex}</td>
        </c:if>
    </tr>
</table>
<a href="/logout">logout</a><br/>
</body>
</html>
