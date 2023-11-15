package com.resale.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.resale.app.bean.ItemBean;
import com.resale.app.bean.ItemBeanI;
import com.resale.app.model.entity.Item;

@WebServlet("/itemaction")
public class ItemAction extends BaseAction {

    private Item item = new Item(null, null, 0, null);

    private ItemBeanI itemBean = new ItemBean();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        serializeForm(item, req.getParameterMap());
        itemBean.addOrUpdateItem(item);

        resp.sendRedirect("./home");

    }
}
