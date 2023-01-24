<%@ page import="ru.itmo.db.InternalOffer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Offers</title>
    <link href="../../css/table.css" rel="stylesheet">
    <link href="../../css/main.css" rel="stylesheet">
</head>

<body>
<h2>${profile}'s Offers</h2>
<hr>
<a href = "/">Back to the main page</a>
<hr>
<table>
    <tr>
        <th>ID</th>
        <th>Price</th>
        <th>Seller</th>
        <th>Buyer</th>
        <th>Date of publishing</th>
        <th>Details</th>
    </tr>
    <%
        List<InternalOffer> offers = (List<InternalOffer>) request.getAttribute("usersOffers");
        for (InternalOffer offer : offers) {
    %>
    <tr>
        <td><%= offer.getOid() %></td>
        <td><%= offer.getPrice() %></td>
        <td><%= offer.getSalesman() %></td>
        <td>
            <% if (offer.getStatus() == 1) { %>
                    <a href = "/users/<%= offer.getBuyer() %>">link</a>
            <% } else
               { %>
                    Offer is active
            <% }%>
        </td>
        <td><%= offer.getPublished() %></td>
        <td><a href = "/offers/<%= offer.getOid() %>">link</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>