<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/winnerPage.css">
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
    <div class="sideHalf"></div>
    <div class="centerHalf">
        <div class="winnerForm">
            <h1>Winner: ${requestScope.winnerName}</h1>
        </div>
    </div>
    <div class="sideHalf"></div>
</main>
<footer></footer>

</body>
</html>
