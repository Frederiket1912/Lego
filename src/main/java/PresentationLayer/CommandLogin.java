package PresentationLayer;

import DBAccess.User;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandLogin extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, LoginSampleException, OrderException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        LogicFacade lf = new LogicFacade();
        User user = lf.login( email, password );
        HttpSession session = request.getSession();
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
    

}
