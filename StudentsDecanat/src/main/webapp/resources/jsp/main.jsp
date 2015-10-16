<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Введите ФИО студента, чтобы получить соответсвующий результат</h2>
<br/>

<h3>Суммарный балл</h3>

<form action="/total" method="get">
    <label>Имя</label><input type="text" name="name" required>
    <label>Фамилия</label><input type="text" name="surname" required>
    <label>Отчество</label><input type="text" name="thirdname" required>
    <input type="submit" value="Get">
</form>
<h5><font color="red">${error1}</font></h5>
<br/>
<br/>

<h3>Средний балл</h3>

<form action="/average" method="get">
    <label>Имя</label><input type="text" name="name" required>
    <label>Фамилия</label><input type="text" name="surname" required>
    <label>Отчество</label><input type="text" name="thirdname" required>
    <input type="submit" value="Get">
</form>
<h5><font color="red">${error2}</font></h5>
<br/>
<br/>

<h3>Здесь необхимо ввести дополнительно название предмета</h3>

<h3>Баллы за конкретный предмет</h3>

<form action="/current-subject" method="get">
    <label>Имя</label><input type="text" name="name" required>
    <label>Фамилия</label><input type="text" name="surname" required>
    <label>Отчество</label><input type="text" name="thirdname" required>
    <!--<label>Предмет</label><input type="text" name="subject" required>-->
    <label>Предмет</label>
    <select name="subject">
        <!--
        <option>0</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        -->
        <option>MATAN</option>
        <option>PROGR</option>
        <option>DISRC</option>
        <option>ALGEM</option>
        <option>ALG</option>
        <option>EN</option>
    </select>
    <input type="submit" value="Get">
</form>
<h5><font color="red">${error3}</font></h5>
<br/>
</body>
</html>
