package org.christinagorina.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    private ConfigurableApplicationContext springContext;
    private ConfigurableApplicationContext appCtx ;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        appCtx = springContext = new ClassPathXmlApplicationContext("spring/spring-db.xml");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
}
