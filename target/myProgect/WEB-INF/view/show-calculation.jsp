<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<!DOCTYPE html>
<html>

<body>
<form:form action="" modelAttribute="calculation">
    <form:hidden path="id"/>
    ����������� ������ ${calculation.inMouns(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} ���.
    <br><br>
    ��������� �� ��������� ${calculation.overpayment(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} ���.
    <br><br>
    ����+�������� ${calculation.total(calculation.amountOfCredit, calculation.deposit, calculation.years, calculation.percent)} ���.
    <br><br>
    �������� � ����� ${calculation.dolgPiece(calculation.amountOfCredit, calculation.deposit, calculation.percent)} ���.
    <br><br>
    �������� ���� ${calculation.percentPiece(calculation.amountOfCredit, calculation.deposit, calculation.percent)} ���.
</form:form>




<%--<h2>--%>


<%--</h2>--%>
<%--<p th:text="'����������� ������ '+${idCalc.inMouns(idCalc.amountOfCredit, idCalc.deposit, idCalc.years, idCalc.percent)}"/>--%>
</body>
</html>