package com.resale.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.resale.app.bean.BidBean;
import com.resale.app.model.entity.Bid;

@WebServlet("/bidaction")
public class BidAction extends HttpServlet {
    private BidBean bidBean = new BidBean();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/biditem.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("name");
        String phone = request.getParameter("phone");
        String bidAmountParam = request.getParameter("bid_amount");
        String itemName = request.getParameter("itemName");

        if (bidAmountParam != null && !bidAmountParam.isEmpty()) {
            try {
                double bidAmount = Double.parseDouble(bidAmountParam);

                Bid bid = new Bid(0, itemName, userName, phone, bidAmount);

                boolean isBidSubmitted = bidBean.submitBid(bid);

                if (isBidSubmitted) {
                    HttpSession session = request.getSession();
                    session.setAttribute("bidBean", bidBean);

                    request.setAttribute("confirmationMessage", "Bid made successfully!");
                } else {
                    request.setAttribute("errorMessage", "Bid submission failed. Please try again.");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Invalid bid amount. Please enter a valid number.");
            }
        } else {
            request.setAttribute("errorMessage", "Bid amount cannot be empty.");
        }

        request.getRequestDispatcher("/biditem.jsp").forward(request, response);
    }
}