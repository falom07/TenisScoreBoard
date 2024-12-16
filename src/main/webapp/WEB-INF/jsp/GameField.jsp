<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tennis</title>
</head>
<body>
dfvc
<p>Player 1: ${sessionScope.matches[sessionScope.idMatch].players.get(0).playerName}</p>
<p>point: ${sessionScope.matches[sessionScope.idMatch].players.get(0).points}</p>
<p>game: ${sessionScope.matches[sessionScope.idMatch].players.get(0).games}</p>
<p>sets: ${sessionScope.matches[sessionScope.idMatch].players.get(0).sets}</p>
<form action="" method="post">
    <button type="submit" name = "playerWinPoint" value="player1">pl1</button>
</form>

<p>Player 2: ${sessionScope.matches[sessionScope.idMatch].players.get(1).playerName}</p>
<p>point: ${sessionScope.matches[sessionScope.idMatch].players.get(1).points}</p>
<p>game: ${sessionScope.matches[sessionScope.idMatch].players.get(1).games}</p>
<p>sets: ${sessionScope.matches[sessionScope.idMatch].players.get(1).sets}</p>
<form action="" method="post">
    <button type="submit" name = "playerWinPoint" value="player2">pl2</button>
</form>


</body>
</html>
