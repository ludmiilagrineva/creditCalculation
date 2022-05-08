<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>

<body>
<%--    <input type="button" value="рассчитать"--%>
<%--           onclick="window.location.href='calculate'">--%>
<div class="p-3 mb-2 bg-secondary text-white">
    <div class="container">
        <%--        кнопка не двигается!!!--%>
        <div class="float-sm-right">

            <input type="button" value="Предыдущие расчеты"
                   onclick="window.location.href='calculations'">
        </div>
        <br><br>


        <form:form action="newCalculate" modelAttribute="calculate">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        Стоимость недвижимости <br>
                        <form:input path="amountOfCredit" value="" class="form-control mb-1 col-4" placeholder="Введите стоимость недвижимости"/>
                        <form:errors path="amountOfCredit"/>
                        <small id="helpBlock" class="form-text text-white">
                            руб.
                        </small> <br>

                    </div>
                </div>
            </div>
            <br>
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        Первоначальный взнос <br>
                        <form:input path="deposit" class="form-control mb-1 col-4" placeholder="Введите сумму первоначального взноса"/>
                        <form:errors path="deposit"/>
                        <small id="helpBlock" class="form-text text-white">
                            руб.
                        </small> <br>
                    </div>
                </div>
            </div>
            <br>
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        Срок кредитования <br>
                        <form:input path="years" class="form-control mb-1 col-4" placeholder="Введите срок кредитования"/>
                        <form:errors path="years"/>
                        <small id="helpBlock" class="form-text text-white">
                            лет
                        </small> <br>
                    </div>
                </div>
            </div>
            <br>
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        Процентная ставка <br>
                        <form:input path="percent" class="form-control mb-1 col-4" placeholder="Введите процентную ставку"/>
                        <form:errors path="percent"/>
                        <small id="helpBlock" class="form-text text-white">
                            %
                        </small> <br>
                    </div>
                </div>
            </div>
            <br>

            <input type="submit" value="рассчитать">

        </form:form>
        <br> <br> <br>
    </div>
</div>
</body>
</html>