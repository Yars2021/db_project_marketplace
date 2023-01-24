<%@ page import="ru.itmo.db.InternalOffer" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Offers</title>
</head>

<body>
<h2>Offers</h2>
<a href = "/login">login</a>
<table>
    Number of offers: ${length}
    <tr>
        <th>ID</th>
        <th>Price</th>
        <th>Seller</th>
        <th>Date of publishing</th>
        <th>Details</th>
    </tr>
</table>
${activeOffers.salesman}
<a href = "/create">new offer</a>
</body>
</html>