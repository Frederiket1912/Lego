
package FunctionLayer;

import DBAccess.Order;
import DBAccess.OrderMapper;
import DBAccess.User;
import DBAccess.UserMapper;
import java.util.ArrayList;


public class LogicFacade {

    public User createUser( String email, String password ) throws UserException {
        User user = new User(email, password, "customer");
        UserMapper um = new UserMapper();
        um.createUser( user );
        return user;
    }
    public User createAdminUser( String email, String password ) throws UserException {
        User user = new User(email, password, "admin");
        UserMapper um = new UserMapper();
        um.createUser( user );
        return user;
    }
    
    public  User login( String email, String password ) throws UserException {
        UserMapper um = new UserMapper();
        return um.login( email, password );
    }
    
    public boolean createOrder(String email, int width, int length, int height, int bricks2x4, int bricks2x2, int bricks2x1, boolean hasBeenShipped) throws OrderException{
        try {
        Order order = new Order(email, width, length, height, bricks2x4, bricks2x2, bricks2x1, hasBeenShipped);
        OrderMapper om = new OrderMapper();
        om.createOrder(order);
        return true;
        } catch (Exception ex){
            return false;
        }
        
    }
    
    public ArrayList<Order> getOrders(String email) throws OrderException{
        OrderMapper om = new OrderMapper();
        return om.getOrders(email);
    }
    
    public Order getOrder(int orderId) throws OrderException{
        OrderMapper om = new OrderMapper();
        return om.getOrder(orderId);
    }
    
    public ArrayList<Order> getAllOrders() throws OrderException{
        OrderMapper om = new OrderMapper();
        return om.getAllOrders();
    }
    
    public Order shipOrder(int orderId) throws OrderException{
        OrderMapper om = new OrderMapper();
        return om.shipOrder(orderId);
    }
    
    public static void main(String[] args) throws UserException {
        LogicFacade lf = new LogicFacade();
        User user = lf.login("admin@admin.dk", "1234");
        //System.out.println("LogigFacade " +user.getRole());
    }
}
