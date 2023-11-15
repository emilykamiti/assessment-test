<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.resale.app.model.entity.Bid" %>
<%@ page import="com.resale.app.bean.BidBean" %>


<html>

<head>
    <title>Bid Table</title>
    <!-- Add your CSS styles if needed -->
</head>

<body>
    <h2>Bid Table</h2>
    
    <%-- Assuming bidBean is a session attribute --%>
    <% BidBean bidBean = (BidBean) session.getAttribute("bidBean"); %>

    <table border="1">
        <tr>
            <th>Username</th>
            <th>Phone</th>
            <th>Bid Amount</th>
        </tr>
        <% if (bidBean != null) { %>
            <% for (Bid bid : bidBean.getAllBids()) { %>
                <tr>
                    <td><%= bid.getUserName() %></td>
                    <td><%= bid.getPhone() %></td>
                    <td><%= bid.getBidAmount() %></td>
                </tr>
            <% } %>
        <% } else { %>
            <tr>
                <td colspan="3">No bids available</td>
            </tr>
        <% } %>
    </table>
</body>

</html>
