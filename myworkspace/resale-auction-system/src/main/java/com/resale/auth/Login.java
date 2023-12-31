package com.resale.auth;

import org.apache.commons.lang3.StringUtils;

import com.resale.app.model.entity.User;
import com.resale.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId")))
            resp.sendRedirect("./home");
        else
            resp.sendRedirect("./login.html");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Database database = Database.getDbInstance();

        System.out.println("This is the time the database was created: " + database.getDatabaseCreateAt());

        for (User user : database.getUsers()) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                HttpSession httpSession = req.getSession(true);


                httpSession.setAttribute("loggedInId", new Date().getTime() + "");
                httpSession.setAttribute("username", username);

                resp.sendRedirect("./home");
  return;
            }
        }
        PrintWriter print = resp.getWriter();
        print.write("<html><body>Invalid login details <a href=\".\"> Login again </a></body></html>");

    }

}