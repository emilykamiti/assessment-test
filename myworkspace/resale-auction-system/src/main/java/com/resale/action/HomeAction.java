package com.resale.action;

import com.resale.app.view.html.AppPage;
import com.resale.app.bean.ItemBean;
import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeAction extends HttpServlet {

    private ItemBeanI itemBean = new ItemBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addItemLink = "<br/><a href=\"" + req.getContextPath() + "/add-item.jsp\">Add Item</a>";
        String itemListing = itemBean.showItems();
        new AppPage().renderHtml(req, resp, 0, addItemLink + itemListing);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemName = req.getParameter("name");
        String itemType = req.getParameter("type");
        String itemPriceParam = req.getParameter("price");
        String itemImage = req.getParameter("imageURL");

        if (itemName != null && !itemName.isEmpty()
                && itemType != null && !itemType.isEmpty()
                && itemPriceParam != null && !itemPriceParam.isEmpty()) {
            try {
                double itemPrice = Double.parseDouble(itemPriceParam);

                Item newItem = new Item(itemName, itemType, itemPrice, itemImage);
                itemBean.addOrUpdateItem(newItem);

                resp.sendRedirect(req.getContextPath() + "/home");
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        req.setAttribute("errorMessage", "Invalid input. Please fill in all the required fields with valid data.");
        doGet(req, resp); // Redirect to doGet to display the error message
    }
}
