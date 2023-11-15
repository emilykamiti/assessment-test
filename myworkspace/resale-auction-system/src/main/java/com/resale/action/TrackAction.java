package com.resale.action;

import com.resale.app.view.html.AppPage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/track")
public class TrackAction extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        new AppPage().renderHtml(req, resp, 1,
                "<h2>tracking </h2> track for your product here /register will go here");

    }
}
