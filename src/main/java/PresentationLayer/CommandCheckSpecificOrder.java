package PresentationLayer;

import DBAccess.Order;
import DBAccess.User;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandCheckSpecificOrder extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, LoginSampleException, OrderException {
        HttpSession session = request.getSession();
        LogicFacade lf = new LogicFacade();
        try {
            User user = (User) session.getAttribute("user");
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            String email = user.getEmail();
            Order order = lf.getOrder(orderId, email);
            request.setAttribute("order", order);
        } catch (OrderException ex) {
            request.setAttribute("error", "Order not found. Please enter id from one of your orders");
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        } catch (NumberFormatException ex) {
            request.setAttribute("error", "Please enter only numbers");
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        }
        request.getRequestDispatcher("specificOrder.jsp").forward(request, response);
    }

}
