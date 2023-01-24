<%@ page import="ru.itmo.db.InternalItem" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.itmo.transfer.FormattedItem" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>User</title>
    <link href="../../css/table.css" rel="stylesheet">
    <link href="../../css/main.css" rel="stylesheet">
</head>

<body>
<h2>${username}</h2>
<hr>
<a href = "/">Back to the main page</a>
<hr>
<table>
    <tr><td>Buyer reputation</td><td>${b_rep}</td></tr>
    <tr><td>Salesman reputation</td><td>${s_rep}</td></tr>
    <tr><td>Balance</td><td>${sessionScope.session_username == prof_id ? balance : "???"}</td></tr>
    <hr>
    <table>
        <tr>
            <th>Class</th>
            <th>Name</th>
            <th>Rarity</th>
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
    <hr>
    <tr><td><a href="/users/${prof_id}/deals">Deals History</a></td></tr>
    <tr><td><a href="/users/${prof_id}/offers">Offers History</a></td></tr>
</table>

</body>

</html>