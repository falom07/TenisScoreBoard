package org.example.Filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import org.example.Util.GetJSP;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = {"/*"})
public class FilterError implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        }catch (Exception e){
            request.setAttribute("error", e.getMessage());
            HttpServletRequest req = (HttpServletRequest) request;
            req.getRequestDispatcher(GetJSP.getJSPPath("500"))
                    .forward(request, response);
        }
    }
}
