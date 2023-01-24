<%@ page import="ru.itmo.db.InternalOffer" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>Offers</title>
    <link href="../../css/table.css" rel="stylesheet">
    <link href="../../css/main.css" rel="stylesheet">
</head>

<body>
<h2>Offers</h2>
<a href = "/login">Login</a>
<%  if (session.getAttribute("session_username") != null && !"".equals(session.getAttribute("session_username"))) { %>
    <a style="float: right;" href = "/users/${session_username}/create">Create a new offer</a>
<%  }%>
<hr>
<%  if (session.getAttribute("session_username") != null && !"".equals(session.getAttribute("session_username"))) { %>
        <a href = "/users/${session_username}">Your profile (${session_username})</a>
        <hr>
<%  }%>
<br>
<h4>Number of offers: ${length}</h4>
<hr>
<table>
    <tr>
        <th>ID</th>
        <th>Price</th>
        <th>Seller</th>
        <th>Date of publishing</th>
        <th>Details</th>
    </tr>
    <%
        ArrayList<InternalOffer> offers = (ArrayList<InternalOffer>) request.getAttribute("activeOffers");
        for (InternalOffer offer : offers) {
        %>
            <tr>
                <td><%= offer.getOid() %></td>
                <td><%= offer.getPrice() %></td>
                <td><%= offer.getSalesman() %></td>
                <td><%= offer.getPublished() %></td>
                <td><a href = "/offers/<%= offer.getOid() %>">link</a></td>
            </tr>
        <%
        }
    %>
</table>
</body>
</html>