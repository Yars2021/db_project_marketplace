<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Create</title>
</head>

<body>
<h2>Create Offer</h2>
<form method="post">
    <select width=300 style="width: 350px"
            size="8" multiple>
        <c:forEach items="${items}" var="item">
            <option value='${item}'>${item.name}</option>
        </c:forEach>
    </select>
    Price: <input type="text" name="price" />
    <input type="submit" />

</form>
</body>

</html>