<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Tennis</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/header.css" type="text/css">

    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/listMatch.css" type="text/css">


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
    <form action="${pageContext.request.contextPath}/matches" method="get" id="inputName">

        <input type="text" name="nameFilter" id="nameFilter" value="${requestScope.nameFilter}" >
        <input type="number" name="currentPage" value="${requestScope.currentPage}" hidden="hidden">
        <input type="number" name="pageSize" value="${requestScope.pageSize}" hidden="hidden">

        <button type="submit" class="searchName">Search</button>
    </form>

    <table class="tableForListMatch">

        <thead>
        <tr>
            <th>id</th>
            <th>Player1</th>
            <th>Player2</th>
            <th>Winner</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${requestScope.listMatches}" var='match' >
            <tr>
                <td>${match.id}</td>
                <td>${match.player1.name}</td>
                <td>${match.player2.name}</td>
                <td>${match.winner.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div id="lowerPanel">
        <div>

            <form action="${pageContext.request.contextPath}/matches" method="get">


                <button type="submit"  class="buttonsForPage" name="page"  value="first"><<</button>
                <button type="submit" class="buttonsForPage" name="page" value="previous"><</button>

                <button type="submit" class="buttonsForPage" name="page" value="${requestScope.listNumPages.get(0)}">${requestScope.listNumPages.get(0)}</button>
                <button id="currentPage" class="buttonsForPage" name="page" value="${requestScope.listNumPages.get(1)}" disabled>${requestScope.listNumPages.get(0)}</button>
                <button type="submit" class="buttonsForPage" name="page" value="${requestScope.listNumPages.get(2)}">${requestScope.listNumPages.get(0)}</button>

                <button type="submit" class="buttonsForPage" name="page" value="next">></button>
                <button type="submit" class="buttonsForPage" name="page" value="last">>></button>

                <input type="number" name="nameFilter" value="${requestScope.nameFilter}" hidden="hidden">
                <input type="number" name="pageSize" value="${requestScope.pageSize}" hidden="hidden">
                <input type="number" name="currentPage" value="${requestScope.currentPage}" hidden="hidden">
            </form>


        </div>
        <div>
            <form action="${pageContext.request.contextPath}/matches" method="get">

                <label for="size" id = "textForSize">Size</label>

                <select name="pageSize" id="size">
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                </select>

                <input type="number" name="nameFilter" value="${requestScope.nameFilter}" hidden="hidden">
                <input type="number" name="currentPage" value="${requestScope.currentPage}" hidden="hidden">

                <button type="submit" class="takeSizeButton" >Take</button>

            </form>

        </div>
    </div>




    </form>
    </div>
</main>
<footer></footer>
</body>
</html>
