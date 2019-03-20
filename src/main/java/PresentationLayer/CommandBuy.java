
package PresentationLayer;

import DBAccess.User;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;
import FunctionLayer.Wall;
import FunctionLayer.WallBuilder;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CommandBuy extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, LoginSampleException, OrderException {
        HttpSession session = request.getSession();
        LogicFacade lf = new LogicFacade();
        WallBuilder wb = new WallBuilder();
        try {
            int length = Integer.parseInt(request.getParameter("length"));
            int width = Integer.parseInt(request.getParameter("width"));
            int height = Integer.parseInt(request.getParameter("height"));
        if (length < 5 || width < 5 || height < 1){
            throw new OrderException("Numbers must be positive. Length and width must be at least 5. Please try again.");
        }
        Wall wall1 = wb.buildWall(height, length);
        Wall wall2 = wb.buildWall(height, width-4);
        int bricks2x4 = wall1.getAmountOf2x4()*2 + wall2.getAmountOf2x4()*2;
        int bricks2x2 = wall1.getAmountOf2x2()*2 + wall2.getAmountOf2x2()*2;
        int bricks2x1 = wall1.getAmountOf2x1()*2 + wall2.getAmountOf2x1()*2;
        User user = (User) session.getAttribute("user");
        String email = user.getEmail();
        if (lf.createOrder(email, width, length, height, bricks2x4, bricks2x2, bricks2x1, false)){
        session.setAttribute("confirmation", "Your order has been placed");
        }
        } catch (NumberFormatException ex){
            throw new OrderException("The given numbers could not be read, please try again with different numbers");
        }
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
  
}
