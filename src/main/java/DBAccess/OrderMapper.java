
package DBAccess;


import FunctionLayer.OrderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OrderMapper {
    
    public void createOrder( Order order ) throws OrderException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into `Orders` (email, width, length, height, 2x4Bricks, 2x2Bricks, 2x1Bricks) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, order.getEmail() );
            ps.setInt( 2, order.getWidth());
            ps.setInt( 3, order.getLength());
            ps.setInt( 4, order.getHeight());
            ps.setInt( 5, order.getBricks2x4());
            ps.setInt( 6, order.getBricks2x2());
            ps.setInt( 7, order.getBricks2x1());
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new OrderException( ex.getMessage() );
        }
    }
    
    public ArrayList<Order> getOrders(String email) throws OrderException{
         try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Orders` where email ='"+email+"';";
            ArrayList<Order> orders = new ArrayList<>();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()){
                orders.add(new Order(rs.getString("email"), rs.getInt("width"), rs.getInt("length"), rs.getInt("height"), rs.getInt("2x4Bricks"), rs.getInt("2x2Bricks"), rs.getInt("2x1Bricks"), rs.getBoolean("hasBeenShipped"), rs.getInt("orderId")));
            }
            return orders;
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new OrderException( ex.getMessage() );
        }
    }
    
    public Order getOrder(int orderId) throws OrderException{
        for (Order o : getAllOrders()) {
            if (o.getOrderId() == orderId){
                return o;
            }
        }
            throw new OrderException("Order not found");
    }
    
    public ArrayList<Order> getAllOrders() throws OrderException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Orders`;";
            ArrayList<Order> orders = new ArrayList<>();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()){
                orders.add(new Order(rs.getString("email"), rs.getInt("width"), rs.getInt("length"), rs.getInt("height"), rs.getInt("2x4Bricks"), rs.getInt("2x2Bricks"), rs.getInt("2x1Bricks"), rs.getBoolean("hasBeenShipped"), rs.getInt("orderId")));
            }
            return orders;
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new OrderException( ex.getMessage() );
        }
    }
    
    public Order shipOrder(int orderId) throws OrderException{
            try {
            String SQL = "update `Orders` set `hasBeenShipped` = 1 where orderId = " + orderId + ";";
            Connection connection = DBConnector.connection();
            connection.createStatement().executeUpdate(SQL);
            return getOrder(orderId);
            } catch ( SQLException | ClassNotFoundException ex ) {
            throw new OrderException( ex.getMessage() );
        }
    }
    
    public static void main(String[] args) throws OrderException {
        OrderMapper om = new OrderMapper();
        ArrayList<Order> orders = om.getAllOrders();
        System.out.println(orders.get(3).isHasBeenShipped());
    }
}
