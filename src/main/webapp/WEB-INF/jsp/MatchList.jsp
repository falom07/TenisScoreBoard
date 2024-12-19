<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tennis</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>

<header>
    <form action="${pageContext.request.contextPath}/" method="get">
        <button type="submit" class="homePage" >Home</button>
    </form>

    <form action="${pageContext.request.contextPath}/matches" method="get">
        <button type="submit" class="matchesPage" >Matches</button>
    </form>

    <form action="${pageContext.request.contextPath}/new-match" method="get">
        <button type="submit" class="newMatch" >New</button>
    </form>

</header>

<main>
<c:forEach items="${requestScope.listMatches}" var='match' >
    <b>${match.player1.name} --- </b>
    <b>${match.player2.name}</b><br>
</c:forEach>

<form action="${pageContext.request.contextPath}/matches" method="get">
    <label for="page">Page</label>
    <input type="number" name="pageNumber" id="page" value="${requestScope.pageNumber}">

    <label for="size">How much</label>

    <select name="pageSize" id="size">
        <option value="${requestScope.pageSize}" selected>${requestScope.pageSize}</option>
        <option value="5">5</option>
        <option value="10">10</option>
        <option value="20">20</option>
        <option value="50">50</option>
        <option value="100">100</option>
    </select>

    <label for="nameFilter">Name search</label>
    <input type="text" name="nameFilter" id="nameFilter" value="${requestScope.nameFilter}" >

    <button type="submit">Take</button>

</form><br>

<form action="${pageContext.request.contextPath}/matches" method="get">




</form>
</main>


<footer></footer>

</body>
</html>
