<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<!DOCTYPE html>
<html>

<body>
<form:form action="" modelAttribute="calculation">
    <form:hidden path="id"/>
    ≈жемес€чный платеж ${calculation.inMouns(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} руб.
    <br><br>
    ѕереплата по процентам ${calculation.overpayment(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} руб.
    <br><br>
    ƒолг+проценты ${calculation.total(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} руб.
    <br><br>
    проценты в мес€ц ${calculation.dolgPiece(calculation.amountOfCredit, calculation.deposit, calculation.percent)} руб.
    <br><br>
    основной долг ${calculation.percentPiece(calculation.amountOfCredit, calculation.deposit, calculation.percent)} руб.
</form:form>




<%--<h2>--%>


<%--</h2>--%>
<%--<p th:text="'ежемес€чный платеж '+${idCalc.inMouns(idCalc.amountOfCredit, idCalc.deposit, idCalc.years, idCalc.percent)}"/>--%>
</body>
</html>