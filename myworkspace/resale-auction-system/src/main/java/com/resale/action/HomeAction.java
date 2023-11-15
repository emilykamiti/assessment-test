package com.resale.action;

import com.resale.app.view.html.AppPage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resale.app.bean.ItemBean;
import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;

@WebServlet("/home")
public class HomeAction extends HttpServlet {

    ItemBeanI itemBean = new ItemBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new AppPage().renderHtml(req, resp, 0,
                "<br/><a href=\"./add-item.jsp\">Add Item</a>" + itemBean.showItems());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemName = req.getParameter("name");
        String itemType = req.getParameter("type");
        double itemPrice = Double.parseDouble(req.getParameter("price"));
        String itemImage = req.getParameter("imageURL");

        Item newItem = new Item(itemName, itemType, itemPrice, itemImage);

        try {
            itemBean.addOrUpdateItem(newItem);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
