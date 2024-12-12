<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title2</title>
</head>
<body>
<s:forEach var="user" items="${sessionScope.users}">
    <span>Id : ${user.id}</span><br>
    <span>Username : ${user.username}</span><br>
    <span>Company : ${user.company}</span><br>
    <span>-----------------------------------------</span>
</s:forEach>
<a href="${pageContext.request.contextPath}/session"> <button>Click</button></a>
</body>
</html>
