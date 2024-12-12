package org.example.Practice.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Practice.DTO.UserDTO;
import org.example.Practice.Entity.Company;
import org.example.Practice.Service.ServiceRegistration;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/registration")
public class ServletRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> list = List.of(
                Company.builder().id(1).name("Amazon").build(),
                Company.builder().id(2).name("Eldorado").build(),
                Company.builder().id(3).name("Netflix").build(),
                Company.builder().id(4).name("Google").build(),
                Company.builder().id(5).name("Pizz").build());
        if(req.getSession().getAttribute("user") == null){
            req.getSession().setAttribute("companies", list);
            req.getRequestDispatcher("/web/WEB-INF/jsp/registration.jsp")
                    .forward(req, resp);
        }else{
            req.getRequestDispatcher("/web/WEB-INF/jsp/home.jsp")
                    .forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println();
        UserDTO user = UserDTO.builder()
                .username(req.getParameter("username"))
                .birthday(req.getParameter("birthday").transform(LocalDate::parse))
                .company(req.getParameter("companyId").transform(Integer::parseInt))
                .address(req.getParameter("address"))
                .build();
        int res = ServiceRegistration.saveUser(user);
        user.setId(res);
        if(res != 1){
            req.getSession().setAttribute("user", user);
            req.getSession().setMaxInactiveInterval(60);
        }
        req.getRequestDispatcher("/web/WEB-INF/jsp/home.jsp")
                .forward(req, resp);

    }
}
