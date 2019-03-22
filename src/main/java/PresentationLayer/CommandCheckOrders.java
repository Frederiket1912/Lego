package PresentationLayer;

import DBAccess.Order;
import DBAccess.User;
import FunctionLayer.LogicFacade;
import FunctionLayer.UserException;
import FunctionLayer.OrderException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandCheckOrders extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserException, OrderException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        LogicFacade lf = new LogicFacade();
        List<Order> orders = (ArrayList<Order>) lf.getOrders(user.getEmail());
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }

}
