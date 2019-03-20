<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Lego Shop!</h1>
        <h3>Login </h3> <br>
        <form action="FrontController" method="post">
            Email:<input type="text" name="email"/><br/><br/>
            Password:<input type="password" name="password"/><br/><br/>
            <input type="hidden" name="command" value="login">
            <input type="submit" value="login"/>  
        </form>
        <br><br>
        <h3>Create new user</h3> <br>
        <form action="FrontController" method="post">
            Email:<input type="text" name="email"/><br/><br/>
            Password:<input type="password" name="password"/><br/><br/>
            Repeat Password:<input type="password" name="passwordRepeat"/><br/><br/>
            <input type="hidden" name="command" value="register"/>
            <input type="submit" value="register"/>  
        </form>
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>
    </body>
</html>
