
package DBAccess;

import FunctionLayer.UserException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserMapper {
    
    public void createUser( User user ) throws UserException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new UserException( ex.getMessage() );
        }
    }
    
    public User login( String email, String password ) throws UserException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                User user = new User( email, password, role );
                return user;
            } else {
                throw new UserException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new UserException(ex.getMessage());
        }
    }
    
    public static void main(String[] args) throws UserException {
        UserMapper um = new UserMapper();
         User u = um.login("admin@admin.dk", "1234");
         //System.out.println(u.getRole());
           
    }
}
