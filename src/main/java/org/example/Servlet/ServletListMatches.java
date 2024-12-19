package org.example.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Entity.Match;
import org.example.Service.MatchListService;
import org.example.Util.GetJSP;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/matches")
public class ServletListMatches extends HttpServlet {
    private static final MatchListService matchListService = MatchListService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        String pageSize = req.getParameter("pageSize");
        String nameFilter = req.getParameter("nameFilter");
        String currentPage = req.getParameter("currentPage");

        String pageNumber = matchListService.getUsersDesirePage(page,currentPage,pageSize);

        List<Match> matchList = matchListService.getMatchList(pageNumber,pageSize,nameFilter);
        List<String> listNumPages = matchListService.getNumPages(pageNumber,pageSize);


        req.setAttribute("listNumPages",listNumPages);

        req.setAttribute("listMatches",matchList);
        req.setAttribute("currentPage",pageNumber);
        req.setAttribute("pageSize",pageSize);
        req.setAttribute("nameFilter",nameFilter);

        req.getRequestDispatcher(GetJSP.getJSPPath("MatchList"))
                .forward(req, resp);
    }
}
