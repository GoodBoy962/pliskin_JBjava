<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<c:if test="${medClinicName == null}">
    <form action="/goods_info" method="get">
        <select name="name">
            <core:forEach var="string" items="${medClinicNames}">
                <option>${string}</option>
                <br>
            </core:forEach>
        </select><br/>
        <input type="submit">
    </form>
</c:if>
<c:if test="${city == null && medClinicName != null && street == null}">
    <form action="/goods_info" method="get">
        <input type="text" name="name" value="${medClinic.name}" readonly>
        <select name="city">
            <core:forEach var="city" items="${cities}">
                <option>${city}</option>
                <br>
            </core:forEach>
        </select><br/>
        <input type="submit">
    </form>
</c:if>
<c:if test="${city != null && street == null}">
    <form action="/goods_info" method="get">
        <input type="text" name="name" value=${medClinic.name} readonly>
        <input type="text" name="city" value=${city} readonly>
        <select name="street">
            <core:forEach var="street" items="${streets}">
                <option>${street}</option>
                <br>
            </core:forEach>
        </select><br/>
        <input type="submit">
    </form>
</c:if>
<c:if test="${street != null}">
    <form action="/goods_info/result" method="get">
        <input type="text" name="name" value=${medClinic.name} readonly>
        <input type="text" name="city" value=${city} readonly>
        <input type="text" name="street" value=${street} readonly>
        <select name="provider">
            <core:forEach var="provider" items="${providers}">
                <option>${provider}</option>
                <br>
            </core:forEach>
        </select><br/>
        <input type="submit">
    </form>
</c:if>

<br/>
<a href="/main">На главную</a>
</body>
</html>
