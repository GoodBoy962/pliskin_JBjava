<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>AverageCheque</title>
</head>
<body>
<h2>Средний чек учреждения</h2>

<form action="/average_cheque_result" method="get">
    <label>Название Медицинского учреждения</label><br/>
    <select name="name">
        <core:forEach var="string" items="${medClinicNames}">
            <option>${string} </option>
            <br>
        </core:forEach>
    </select>
    <input type="submit">
</form>
<a href="/main">На главную</a>
</body>
</html>
