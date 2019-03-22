<%-- 
    Document   : orders
    Created on : Mar 20, 2019, 11:27:27 AM
    Author     : frede
--%>

<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="java.util.List"%>
<%@page import="DBAccess.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBAccess.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("user")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
    </head>
    <body>
        <% User user = (User) session.getAttribute("user"); %>
        <h1> <% out.print(user.getEmail());%>'s Order Page!</h1>
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
            <h3>Select id of order to look at </h3>
            <input type="text" name="orderId"/>
            <input type="hidden" name="command" value="checkSpecificOrder"/>
            <input type="submit" value="Check Order Details"/>
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
