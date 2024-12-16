<%--
  Created by IntelliJ IDEA.
  User: vitalik
  Date: 16.12.2024
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Как ты сюда попал,я не знаю.Но очень хочу узнать,мой тг для связи : @cringe_developer007</h1>

<p>Message : ${requestScope.error}</p>

<form action="${pageContext.request.contextPath}/" method="get">
    <button type="submit"><b>Home</b></button>
</form>
</body>
</html>
