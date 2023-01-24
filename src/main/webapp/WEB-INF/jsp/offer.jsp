<%@ page import="ru.itmo.transfer.FormattedItem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Offer</title>
    <link href="../../css/table.css" rel="stylesheet">
    <link href="../../css/main.css" rel="stylesheet">
</head>

<body>
<h2>Offer details (Price: ${price})</h2>
<hr>
<a href = "/">Back to the main page</a>
<hr>
    <table>
        <tr>
            <th>Item type</th>
            <th>Item name</th>
            <th>Rarity class</th>
            <th>Description</th>
        </tr>
    <%
        List<FormattedItem> items = (List<FormattedItem>) request.getAttribute("items");
        for (FormattedItem item : items) {
    %>
        <tr>
            <td><%= item.getType() %></td>
            <td><%= item.getName() %></td>
            <td><%= item.getRarity() %></td>
            <td><%= item.getDescription() %></td>
        </tr>
    <%
        }
    %>
    </table>

<%--    <% if (session.getAttribute("session_username") != null) { %>--%>
        <form method="post">
            <input type="submit" />
        </form>
<%--    <% } %>--%>
</body>

</html>