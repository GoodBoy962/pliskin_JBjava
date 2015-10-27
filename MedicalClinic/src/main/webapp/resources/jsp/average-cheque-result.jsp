<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aleksandrpliskin
  Date: 23.10.15
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
${averageChequeInMedClinic}<br/><br/>

<c:if test="${city == null}">
    <form action="/average_cheque_result" method="get">
        <input type="text" name="name" value=${medClinic.name} readonly>
        <select name="city">
            <core:forEach var="city" items="${cities}">
                <option>${city}</option>
                <br>
            </core:forEach>
        </select><br/>
        <input type="submit">
    </form>
</c:if>
<c:if test="${city != null}">
    <form action="/average_cheque/current_office" method="get">
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

<p>${averageChequeInCurrentOfficeError}</p>
<a href="/main">На главную</a>
</body>
</html>
