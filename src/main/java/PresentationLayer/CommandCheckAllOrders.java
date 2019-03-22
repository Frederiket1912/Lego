/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author frede
 */
public class CommandCheckAllOrders extends Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserException, OrderException {
        HttpSession session = request.getSession();
        LogicFacade lf = new LogicFacade();
        List<Order> orders = (ArrayList<Order>) lf.getAllOrders();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("allOrders.jsp").forward(request, response);
    }
    
}
