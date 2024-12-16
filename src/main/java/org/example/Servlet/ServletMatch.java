package org.example.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Service.ManageMatchService;
import org.example.Util.GetJSP;
import org.example.Util.MapMatches;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/match-score")
public class ServletMatch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID uuid = UUID.fromString(req.getParameter("uuid"));
        req.setAttribute("idMatch",uuid);

        req.getRequestDispatcher(GetJSP.getJSPPath("GameField"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID uuid = UUID.fromString(req.getParameter("uuid"));
        System.out.println(uuid);
        String player = req.getParameter("playerWinPoint");

        String winnerName = ManageMatchService.getInstance().calculateScore(uuid,player);

        if(winnerName.isEmpty()){
            resp.setStatus(HttpServletResponse.SC_OK);
            req.setAttribute("idMatch",uuid);
            req.getRequestDispatcher(GetJSP.getJSPPath("GameField"))
                    .forward(req, resp);
        } else {
            resp.setStatus(HttpServletResponse.SC_OK);
            req.setAttribute("winnerName",winnerName);
            req.getRequestDispatcher(GetJSP.getJSPPath("WinnerPage"))
                    .forward(req, resp);
        }

    }
}
