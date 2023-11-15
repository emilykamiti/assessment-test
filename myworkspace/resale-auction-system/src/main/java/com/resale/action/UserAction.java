package com.resale.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.UserBean;
import com.resale.app.bean.UserBeanI;
import com.resale.app.model.entity.User;

@WebServlet("/user")
public class UserAction extends BaseAction {
    UserBeanI userBean = new UserBean();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.html").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User registerUser = new User();
        serializeForm(registerUser, req.getParameterMap());
        userBean.register(registerUser);

        resp.sendRedirect("./login");
    }
}
