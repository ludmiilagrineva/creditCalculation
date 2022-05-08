<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>
<body class="p-3 mb-2 bg-secondary text-white">
<c:url var="back" value="/calculations">
</c:url>
<input type="button" value="�����"
       onclick="window.location.href='${back}'"/>
<c:url var="mainPage" value="/">
</c:url>

<input type="button" value="������� ��������"
       onclick="window.location.href='${mainPage}'"
       class="btn btn-outline-light btn-sm"/>

<form:form action="#" modelAttribute="calculation">
    <form:hidden path="id"/>
    <br>
    ����������� ������ ${calculation.inMouns(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} ���.
    <br><br>
    ��������� �� ��������� ${calculation.overpayment(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} ���.
    <br><br>
    ����+�������� ${calculation.total(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} ���.
    <br><br>
<%--    �������� ����  ${calculation.dolgPiece(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} ���.--%>
<%--    <br><br>--%>
<%--    �������� � ����� ${calculation.percentPiece(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} ���.--%>

</form:form>
<h1>������ ��������</h1>

<table class="table table-bordered table-hover table-dark table-striped">
    <thead class="thead-dark">
    <tr>
        <th>������ �</th>
        <th>���� �������</th>
        <th>����� ����� �������</th>
        <th>����� ��������� �����</th>
        <th>��������</th>
<%--        <th>������� �����</th>--%>
        </tr>
    </thead>
    <tbody>

<c:forEach var="i" begin="1" end="${calculation.years*12}">
    <tr>
        <td>${i} </td>
        <td>${calculation.grafikPayment(calculation.years)}</td>

        <td> ${calculation.inMouns(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)}</td>
        <td>${calculation.dolgPiece(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} </td>
            <%--        <td>${calculation.inMouns(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)-((calculation.amountOfCredit-calculation.deposit)-(i-1)*calculation.inMouns(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent))*calculation.percent/12/100} </td>--%>
        <td>${calculation.percentPiece(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} </td>
            <%--        <td>${((calculation.amountOfCredit-calculation.deposit)-(i-1)*calculation.inMouns(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent))*calculation.percent/12/100}</td>--%>
<%--        <td>${calculation.ostatok(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} </td>--%>
    </tr>
<%--    </c:forEach>--%>
    </tbody>



    </c:forEach>
<%--</h2>--%>
<%--<p th:text="'����������� ������ '+${idCalc.inMouns(idCalc.amountOfCredit, idCalc.deposit, idCalc.years, idCalc.percent)}"/>--%>
</body>
</html>