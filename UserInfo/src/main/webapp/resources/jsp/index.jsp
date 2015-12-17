<%--
  Created by IntelliJ IDEA.
  com.pliskin.alex.service.User: aleksandrpliskin
  Date: 10.10.15
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Table for Input</title>
</head>
<body>
<form action="/table" method="post">
    <label> Name: </label><input type="text" id="name" name="name" required>
    <label> Surname: </label><input type="text" id="surname" name="surname" required>
    <label> Last name: </label><input type="text" id="thirdName" name="thirdName" required>
    <label> Birth date: </label><input type="date" id="date" name="date">
    <label> Sex </label>
    <select name="sex">
        <option name="n" type="text"></option>
        <option name="m" type="text">MALE</option>
        <option name="f" type="text">FEMALE</option>
    </select>
    <input type="submit" value="Submit">
</form>
</body>
</html>
