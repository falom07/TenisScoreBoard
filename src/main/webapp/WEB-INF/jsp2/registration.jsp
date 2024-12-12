<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <label for="username"> Username :
        <input type="text" name="username" id="username"><br>
    </label>
    <label for="address"> Address :
        <input type="text" name="address" id="address"><br>
    </label>
    <label for="companyId"> Company
        <select name = "companyId" id="companyId">
            <c:forEach var="company" items="${sessionScope.companies}">
                <option value="${company.id}">${company.name}</option>
<%--                <option>${company.name}</option>--%>
            </c:forEach>
        </select>
    </label>
    <label for="birthday"> Birthday
        <input type="date" name="birthday" id="birthday"><br>
    </label>

    <button type="submit">Submit</button>
</form>
</body>
</html>
