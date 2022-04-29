<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<!DOCTYPE html>
<html>

<body>
heeey
<form:form action="" modelAttribute="calculate">
    <form:hidden path="id"/>
${calculate.amountOfCredit}
${calculate.deposit}
    ${calculate.percent}
    ${calculate.years}
</form:form>

</body>
</html>