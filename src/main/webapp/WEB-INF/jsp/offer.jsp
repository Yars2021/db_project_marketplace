<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Offer</title>
</head>

<body>
<h2>${name}</h2>
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