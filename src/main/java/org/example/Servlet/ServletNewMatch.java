package org.example.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DTO.MatchPlayer;
import org.example.DTO.MatchScore;
import org.example.Service.MatchService;
import org.example.Util.GetJSP;
import org.example.Util.MapMatches;
import org.example.Util.ValidateForms;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/new-match")
public class ServletNewMatch extends HttpServlet {
    private static final MatchService MATCH_SERVICE = MatchService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(GetJSP.getJSPPath("NewMatch")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerName1 = req.getParameter("player1");
        String playerName2 = req.getParameter("player2");

        if(ValidateForms.isValidateNewMatch(playerName1, playerName2,req)){
            MatchScore match = MatchScore.builder()
                    .players(List.of(
                            new MatchPlayer(playerName1),
                            new MatchPlayer(playerName2)))
                    .build();



            UUID idMatch = MATCH_SERVICE.createNewMatch(match);


            req.getSession().setAttribute("idMatch",idMatch);
            req.getSession().setAttribute("matches",MapMatches.matchMap);



            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("/match-score?uuid="+idMatch);

        }else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            req.getRequestDispatcher(GetJSP.getJSPPath("NewMatch")).forward(req, resp);
        }




    }
}
