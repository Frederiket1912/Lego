
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Command {
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, LoginSampleException, OrderException;

    public static Command from(HttpServletRequest request)
    {
        Command c;
        
        String origin = request.getParameter("command");
        
        HashMap<String, Command> commands;

        commands = new HashMap<>();
        commands.put("login", new CommandLogin());
        commands.put("register", new CommandRegister());
        commands.put("checkOrders", new CommandCheckOrders());
        commands.put("checkSpecificOrder", new CommandCheckSpecificOrder());
        commands.put("buy", new CommandBuy());
        commands.put("mainPage", new CommandMainPage());

       c = commands.getOrDefault(origin, new CommandUnknown());
        
        return c;
    }
}
