<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/matchScore.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">

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
    <h1>${requestScope.idMatch}</h1>
</header>
<main>
    <div class="squareForScore">
        <table class="tableForScore">
            <thead>
            <tr>
                <th>Players</th>
                <th>Sets</th>
                <th>Games</th>
                <th>Points</th>
                <th>Chose</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${sessionScope.matches[requestScope.idMatch].players.get(0).playerName}</td>
                <td>${sessionScope.matches[requestScope.idMatch].players.get(0).sets}</td>
                <td>${sessionScope.matches[requestScope.idMatch].players.get(0).games}</td>
                <td>${sessionScope.matches[requestScope.idMatch].players.get(0).points}</td>
                <td class="formPost">
                    <form action="" method="post" >
                        <button type="submit" class="buttonGet" name="playerWinPoint" value="player1">get</button>
                    </form></td>
            </tr>
            <tr>
                <td>${sessionScope.matches[requestScope.idMatch].players.get(1).playerName}</td>
                <td>${sessionScope.matches[requestScope.idMatch].players.get(1).sets}</td>
                <td>${sessionScope.matches[requestScope.idMatch].players.get(1).games}</td>
                <td>${sessionScope.matches[requestScope.idMatch].players.get(1).points}</td>
                <td class="formPost">
                    <form action="" method="post" >
                        <button type="submit" class="buttonGet" name="playerWinPoint" value="player2">get</button>
                    </form></td>
            </tr>
            </tbody>
        </table>



    </div>
</main>
<footer></footer>


</body>
</html>