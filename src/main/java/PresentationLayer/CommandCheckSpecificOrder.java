package PresentationLayer;

import DBAccess.Order;
import DBAccess.User;
import FunctionLayer.LogicFacade;
import FunctionLayer.UserException;
import FunctionLayer.OrderException;
import FunctionLayer.Wall;
import FunctionLayer.WallBuilder;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandCheckSpecificOrder extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserException, OrderException {
        HttpSession session = request.getSession();
        LogicFacade lf = new LogicFacade();
        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            request.setAttribute("orderId", orderId);
            Order order = lf.getOrder(orderId);
            int height = order.getHeight();
            int length = order.getLength();
            int width = order.getWidth();
            request.setAttribute("height", height);
            request.setAttribute("length", length);
            request.setAttribute("width", width);
            WallBuilder wb = new WallBuilder();
            Wall wall1 = wb.buildWall(height, length);
            Wall wall2 = wb.buildWall(height, width - 4);
            request.setAttribute("wall1", wall1);
            request.setAttribute("wall2", wall2);
        } catch (OrderException ex) {
            request.setAttribute("error", "Order not found. Please enter id from one of your orders");
            User user = (User) session.getAttribute("user");
            String email = user.getEmail();
            ArrayList<Order> orders = lf.getOrders(email);
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        } catch (NumberFormatException ex) {
            request.setAttribute("error", "Please enter only numbers");
            User user = (User) session.getAttribute("user");
            String email = user.getEmail();
            ArrayList<Order> orders = lf.getOrders(email);
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        }
        request.getRequestDispatcher("specificOrder.jsp").forward(request, response);
    }

}
