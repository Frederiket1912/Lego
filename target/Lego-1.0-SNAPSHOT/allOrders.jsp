<%-- 
    Document   : allOrders
    Created on : Mar 22, 2019, 10:11:19 AM
    Author     : frede
--%>

<%@page import="DBAccess.User"%>
<%@page import="DBAccess.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("user")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    User user = (User) session.getAttribute("user");
    if (!user.getRole().equals("admin")){
        session.invalidate();
        request.getRequestDispatcher("index.jsp").forward(request, response);
        return;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
    </head>
    <body>
        <h1>All Orders Admin Page</h1>
        <table> 
            <thead><tr><th>Order Id</th><th>Shipped</th></tr></thead> <tbody>
                <% ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
                            for (Order order : orders) {
                        %>
                <tr>
                    <td><%= order.getOrderId()%></td> <td><%= order.isHasBeenShipped()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table> <br><br>
        <form action="FrontController" method="post">
            <h3>Select id of order to ship </h3>
            <input type="text" name="orderId"/>
            <input type="hidden" name="command" value="shipOrder"/>
            <input type="submit" value="Ship Order"/>
        </form> <br>
        <form action="FrontController" method="post">
            <h3>Back to main page </h3>
            <input type="hidden" name="command" value="mainPage"/>
            <input type="submit" value="Back to main page"/>
        </form> <br>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %>
    </body>
</html>
