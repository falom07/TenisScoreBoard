<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tennis</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newMatchPage.css">


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
    <img src="${pageContext.request.contextPath}/image/newGamePhoto.webp" height="40%" width="50%" alt="New Match">
    <div class="centerSquare">
        <form action="${pageContext.request.contextPath}/new-match" method="post" onsubmit="return checkForm(this)">
            <div class="inputFields">
                <div class="players">
                    <label id = "player1"><b>First Player:</b></label><br>
                    <input class="inputField" type="text" name="player1" id = "player1Name">
                    <p id="usernameAnswer"></p>
                </div>
                <div class="players">
                    <label id = "player2"><b>Second Player:</b> </label><br>
                    <input class="inputField" type="text" name="player2" id = "player2Name">
                    <p id="usernameAnswer2"></p>
                </div>


            </div>
            <button class="buttonSubmit" type="submit">Begin game</button>
        </form>
    </div>

</main>
<footer></footer>
<script>
    const checkedAnswer1 = '${requestScope.checkedAnswer1}';
    const checkedAnswer2 = '${requestScope.checkedAnswer2}';
</script>
<script src="${pageContext.request.contextPath}/js/validate.js"></script>
</body>
</html>