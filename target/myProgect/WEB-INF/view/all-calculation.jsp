<%@ page language="java" contentType="text/html;charset=cp1251" %>
<%@ page pageEncoding="cp1251" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>
<body>

<div class="p-3 mb-2 bg-secondary text-white">
    <div class="container">
        <c:url var="mainPage" value="/">
        </c:url>

        <input type="button" value="Главная страница"
               onclick="window.location.href='${mainPage}'"
               class="btn btn-outline-light btn-sm"/>
        <br><br>

        <h3>Предыдущие рассчеты</h3>

        <table class="table table-bordered table-hover table-dark table-striped">
            <thead class="thead-dark">


            <tr>
                <th>Общая сумма</th>
                <th>Первоначальный взнос</th>
                <th>Срок кредитования</th>
                <th>Процентная ставка</th>
                <th>Действия</th>
            </tr>
            </thead>
            <tbody>

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

                    <td>
                        <input type="button" value="Рассчитать"
                               onclick="window.location.href='${calcul}'"
                               class="btn btn-outline-light btn-sm"/>


                        <input type="button" value="Удалить"
                               onclick="window.location.href='${deleteButton}'"
                               class="btn btn-outline-light btn-sm"/>

                    </td>

                </tr>
            </c:forEach>
            </tbody>

        </table>
</body>
</html>