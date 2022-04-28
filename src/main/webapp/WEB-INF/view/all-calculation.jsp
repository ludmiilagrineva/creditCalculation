<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<body>
<h2>
    Предыдущие расчеты
</h2>
<br><br>
<table>

<tr>
    <th>Общая сумма</th>
    <th>Первоначальный взнос</th>
    <th>Срок</th>
    <th>Процентная ставка</th>
    <th>Дата</th>
</tr>
    <br><br>
    <c:forEach var="calc" items="${allCalc}">

    <c:url var="deleteButton" value="/delete">
        <c:param name="calcId" value="${calc.id}"/>
    </c:url>
        <c:url var="calcul" value="/show-calculation">
            <c:param name="calcId" value="${calc.id}"/>

    </c:url>
<tr>
    <td>${calc.amountOfCredit}</td>
    <td>${calc.deposit}</td>
    <td>${calc.years}</td>
    <td>${calc.percent}</td>
    <td>${calc.date}</td>
    <td>
        <input type="button" value="рассчитать"
               onclick="window.location.href='${calcul}'"/>
    </td>

        <td>
            <input type="button" value="Удалить"
            onclick="window.location.href='${deleteButton}'"/>
        </td>

</tr>
</c:forEach>
</table>
</body>
</html>