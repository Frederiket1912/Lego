<%-- 
    Document   : main
    Created on : Mar 19, 2019, 2:26:40 PM
    Author     : frede
--%>

<%@page import="DBAccess.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("user")){
    request.getRequestDispatcher("index.jsp").forward(request, response);
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <% User user = (User) session.getAttribute("user");
        String email = user.getEmail();
        %>    
        <h1>Welcome  <% out.print(email);%></h1><br>
        <% String confirmation = (String) session.getAttribute("confirmation");
            %>
        <form method="post">
            <h3> Specify measurements of your lego house </h3><br>
            <h3> Length and width must be at least 5, otherwise your house will have no room inside. Numbers must be positive. </h3><br>
            Length:<input type="text" name="length"/><br/><br/>
            Width:<input type="text" name="width"/><br/><br/>
            Height:<input type="text" name="height"/><br/><br/>
            <input type="hidden" name="command" value="buy">
            <input type="submit" value="buy"/>  
        </form>
        <br>
        <% if (null != confirmation){
            out.println("<h3>Confirmation:</h3>");
            out.print(confirmation);
        }
        %>
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
           %>
           <form action="FrontController" method="post">
            <h3> Check your orders </h3><br>
            <input type="hidden" name="command" value="checkOrders">
            <input type="submit" value="Check Orders"/>  
        </form>
    </body>
</html>
