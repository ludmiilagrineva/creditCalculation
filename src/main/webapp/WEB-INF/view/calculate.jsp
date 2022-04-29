<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<!DOCTYPE html>
<html>
<body>

<br>
<form:form action="newCalculate" modelAttribute="calculate">
    <br> <br>
    Стоимость недвижимости <br>
    <form:input path="amountOfCredit" id="flying"/>
    <form:errors path="amountOfCredit"/>  <br>

    <input type="range" min="0" max="10000000" step="1" value="50" form="flying">
    <br> <br>


    Первоначальный взнос <br>
    <form:input path="deposit"/>
    <form:errors path="deposit"/>  <br>
    <input type="range" min="0" max="1000000" step="1" value="50">
    <br> <br>
    Срок кредитования <br>
    <form:input path="years"/>
    <form:errors path="years"/>  <br>
    <input type="range" min="1" max="30" step="1" value="1">
    <br> <br>
    Процентная ставка <br>
    <form:input path="percent"/>
    <form:errors path="percent"/>  <br>
    <input type="range" min="1" max="100" step="1" value="1">
    <br> <br>
<%--    Дата <form:input path="date"/>--%>
    <br> <br>
    <input type="submit" value="рассчитать">


</form:form>
</body>
</html>