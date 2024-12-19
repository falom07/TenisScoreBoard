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
<h1>How you got here, I don't know. But I'd like to know, my contact details for feedback: @cringe_developer007</h1>

<p>Message : ${requestScope.error}</p>

<form action="${pageContext.request.contextPath}/" method="get">
    <button type="submit"><b>Home</b></button>
</form>
</body>
</html>
