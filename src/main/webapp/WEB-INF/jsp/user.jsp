<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>User</title>
</head>

<body>
<h2>${name}</h2>
<table>
    <tr><td>Buyer rep</td><td>${buyer_rep}</td></tr>
    <tr><td>Salesman rep</td><td>${sales_rep}</td></tr>
    <tr><td>Purchass</td><td><a href="/users/<c:out value="${login}" />/deals">Deals</a></td></tr>
    <tr><td>Sales</td><td><a href="/users/<c:out value="${login}" />/offers">Offers</a></td></tr>
</table>

</body>

</html>