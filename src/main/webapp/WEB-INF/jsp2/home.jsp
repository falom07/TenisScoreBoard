<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello<span style="color: crimson"> ${sessionScope.user.username}</span>
<form action="${pageContext.request.contextPath}/logOut" method="get">
    <button type="submit">LogOut</button>
</form>

</body>
</html>
