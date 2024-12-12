package org.example.Practice.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Practice.Entity.User;
import org.example.Practice.Service.Service;

import java.io.IOException;
import java.util.List;

@WebServlet("/allUser")
public class ServletJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = Service.getAllUsers();

        req.getSession().setAttribute("users", users);
        req.getRequestDispatcher("/web/WEB-INF/jsp/AllUser.jsp")
                .forward(req, resp);

    }
}
