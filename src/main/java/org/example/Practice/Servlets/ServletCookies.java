package org.example.Practice.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/test")
public class ServletCookies extends HttpServlet {
    private static final String name = "userFromCookies2";
    private final AtomicInteger count = new AtomicInteger(0);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cookies = req.getCookies();
        if (cookies == null || Arrays.stream(cookies)
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .isEmpty()) {
            Cookie vitalik = new Cookie(name, "Vitalik");
            vitalik.setPath("/test");
            vitalik.setMaxAge(10);
            resp.addCookie(vitalik);
            count.incrementAndGet();
        }
        resp.getWriter().println("Hello World,you are " + count.get() + " user");
    }
}
