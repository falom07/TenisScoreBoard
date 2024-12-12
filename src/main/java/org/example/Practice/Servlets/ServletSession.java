package org.example.Practice.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Practice.Entity.Web;

import java.io.IOException;
import java.time.LocalTime;

@WebServlet("/session")
public class ServletSession extends HttpServlet {
    private static final String USER = "user";
    private static LocalTime now = LocalTime.now();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        Web web = (Web) session.getAttribute(USER);
        if (web == null) {
            web = Web.builder()
                    .title("Jon Sina")
                    .id(901)
                    .id_coocies(session.getId())
                    .build();
            session.setAttribute(USER, web);
            session.setMaxInactiveInterval(30);
        }

        resp.setContentType("text/html");
        resp.getWriter().println(web.toString());
    }
}
