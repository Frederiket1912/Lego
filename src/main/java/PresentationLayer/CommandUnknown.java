
package PresentationLayer;

import FunctionLayer.UserException;
import FunctionLayer.OrderException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommandUnknown extends Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserException, OrderException {
        request.setAttribute("error", "unknown command");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
}
