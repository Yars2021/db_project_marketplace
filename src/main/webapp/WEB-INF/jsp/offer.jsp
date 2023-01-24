<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Offer</title>
    <link href="../../css/table.css" rel="stylesheet">
    <link href="../../css/main.css" rel="stylesheet">
</head>

<body>
<h2>${name}</h2>
<hr>
<a href = "/">Back to the main page</a>
<hr>
<table>
    <tr><td>Class</td><td>${class}</td></tr>
    <tr><td>Rarity</td><td>${rarity}</td></tr>
    <tr><td>Owner</td><td><a href="/users/${owner}">${owner}</a></td></tr>
    <tr><td>Description</td></tr>
</table>
<form method="post">
    <input type="Buy" />
</form>
</body>

</html>