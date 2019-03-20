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

public class CommandRegister extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, LoginSampleException, OrderException {
        HttpSession session = request.getSession();
        LogicFacade lf = new LogicFacade();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordRepeat");
        if (password.equals(passwordRepeat)) {
            User user = lf.createUser(email, password);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } else {
            throw new LoginSampleException("the two passwords did not match");
        }
    }

}
