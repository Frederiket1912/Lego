<%-- 
    Document   : specificOrder
    Created on : Mar 20, 2019, 12:22:22 PM
    Author     : frede
--%>

<%@page import="FunctionLayer.Wall"%>
<%@page import="FunctionLayer.WallBuilder"%>
<%@page import="FunctionLayer.OrderException"%>
<%@page import="java.util.List"%>
<%@page import="DBAccess.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.LogicFacade"%>
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
        <title>Specific Order Page</title>
    </head>
    <body> <%-- alle værdier skal gemmes i request i command siden --%>
        <% User user = (User) session.getAttribute("user");
            Order order = (Order) request.getAttribute("order");
            LogicFacade lf = new LogicFacade();
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            String email = user.getEmail();
            int height = order.getHeight();
            int length = order.getLength();
            int width = order.getWidth();
        %>
        <h2>Hello <% out.print(email);%> this is info about order with id: <%out.print(orderId);%></h2>
        <br><br>
        <h3>Lego house specifications:</h3>
        Height: <%out.print(height);%> &nbsp;&nbsp; Length: <%out.print(length);%>&nbsp;&nbsp;     Width: <%out.print(width);%> <br><br>
        <table>
            <thead><tr><th>Block Type</th><th>Wall 1</th><th>Wall 2</th><th>Wall 3</th><th>Wall 4</th><th>ialt</th></tr></thead> <tbody>
                        <%
                            WallBuilder wb = new WallBuilder();
                            Wall wall1 = wb.buildWall(height, length);
                            Wall wall2 = wb.buildWall(height, width - 4);
                        %>
                <tr>
                    <td>2x4</td> <td><%= wall1.getAmountOf2x4()%></td><td><%= wall2.getAmountOf2x4()%></td><td><%= wall1.getAmountOf2x4()%></td><td><%= wall2.getAmountOf2x4()%></td><td><%= wall1.getAmountOf2x4() * 2 + wall2.getAmountOf2x4() * 2%></td>
                </tr>
                <tr>
                    <td>2x2</td> <td><%= wall1.getAmountOf2x2()%></td><td><%= wall2.getAmountOf2x2()%></td><td><%= wall1.getAmountOf2x2()%></td><td><%= wall2.getAmountOf2x2()%></td><td><%= wall1.getAmountOf2x2() * 2 + wall2.getAmountOf2x2() * 2%></td>
                </tr>
                <tr>
                    <td>2x1</td> <td><%= wall1.getAmountOf2x1()%></td><td><%= wall2.getAmountOf2x1()%></td><td><%= wall1.getAmountOf2x1()%></td><td><%= wall2.getAmountOf2x1()%></td><td><%= wall1.getAmountOf2x1() * 2 + wall2.getAmountOf2x1() * 2%></td>
                </tr>
            </tbody>
        </table> <br><br>
        <form action="FrontController" method="post">
            <h3>Back to orders</h3>
            <input type="hidden" name="command" value="checkOrders"/>
            <input type="submit" value="Back to orders"/>
        </form> <br>
        <form action="FrontController" method="post">
            <h3>Back to main page</h3>
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
