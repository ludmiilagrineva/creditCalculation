<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<body>
<h2>
    ���������� �������
</h2>
<br><br>
<table>

<tr>
    <th>����� �����</th>
    <th>�������������� �����</th>
    <th>����</th>
    <th>���������� ������</th>
    <th>����</th>
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
        <input type="button" value="����������"
               onclick="window.location.href='${calcul}'"/>
    </td>

        <td>
            <input type="button" value="�������"
            onclick="window.location.href='${deleteButton}'"/>
        </td>

</tr>
</c:forEach>
</table>
</body>
</html>