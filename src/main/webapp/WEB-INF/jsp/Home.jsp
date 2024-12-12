<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tennis</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/header.css" type="text/css">

    <link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/css/homePage.css">
</head>

<body>

<header>
    <form action="${pageContext.request.contextPath}/" method="get">
        <button type="submit" class="homePage" >Home</button>
    </form>

    <form action="${pageContext.request.contextPath}/match" method="get">
        <button type="submit" class="matchesPage" >Matches</button>
    </form>

    <form action="${pageContext.request.contextPath}/new-match" method="get">
        <button type="submit" class="newMatch" >New</button>
    </form>
</header>
<main>

    <div class="page">
        <a><div class = "button"><p><b>Watch all matches </b></p></div></a>
        <form action="${pageContext.request.contextPath}/new-match" method="get">
            <button type="submit" class="button" >New</button>
        </form>
    </div>
</main>
<footer>

</footer>

</body>
</html>