<%@ page import="ru.itmo.transfer.FormattedItem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Create</title>
    <link href="../../css/table.css" rel="stylesheet">
    <link href="../../css/main.css" rel="stylesheet">
</head>

<body>
<h2>Create Offer</h2>
<hr>
<a href = "/">Back to the main page</a>
<hr>
<form method="post">
    <select name="iid" style="width: 450px" size="8" multiple>
        <%
            List<FormattedItem> items = (List<FormattedItem>) request.getAttribute("items");
            for (FormattedItem item : items) {
        %>
            <option value="<%= item.getIid() %>">
                <%= item.getType() %>&Tab;&vert;&Tab;
                <%= item.getName() %>&Tab;&vert;&Tab;
                <%= item.getRarity() %>
            </option>
        <%
            }
        %>
    </select>
    <hr>
    Price: <input name="price" type="text"/>
    <input type="submit" />
</form>
</body>

</html>