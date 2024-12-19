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
    private static final MatchListService instance = MatchListService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNumber = req.getParameter("pageNumber");
        String pageSize = req.getParameter("pageSize");
        String nameFilter = req.getParameter("nameFilter");

        List<Match> matchList = instance.getMatchList(pageNumber,pageSize,nameFilter);

        req.setAttribute("listMatches",matchList);
        req.setAttribute("pageNumber",pageNumber);
        req.setAttribute("pageSize",pageSize);
        req.setAttribute("nameFilter",nameFilter);

        req.getRequestDispatcher(GetJSP.getJSPPath("MatchList"))
                .forward(req, resp);
    }
}
