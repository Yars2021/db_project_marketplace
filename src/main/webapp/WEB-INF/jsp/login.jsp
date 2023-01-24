<html>

<head>
    <title>Login</title>
    <link href="../../css/table.css" rel="stylesheet">
    <link href="../../css/main.css" rel="stylesheet">
</head>

<body>
<h2>Authorization</h2>
<hr>
<a href = "/">Back to the main page</a>
<hr>
<form method="post">
    Name : <input type="text" name="session_username" />
    Password : <input type="password" name="password" />
    <input type="submit" />
</form>
${user_status}
</body>

</html>