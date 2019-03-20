
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommandCheckOrders extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, LoginSampleException, OrderException {    
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }
    
}
