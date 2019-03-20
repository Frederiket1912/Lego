
package DBAccess;

import java.sql.SQLException;


public class ConnectionTest {

    public static void main(String[] args) {
        ConnectionTest t = new ConnectionTest();
        DBConnector d = t.getdb();
        System.out.println("Nåede så langt");
    }
    
    public DBConnector getdb(){
        try {
            DBConnector db = new DBConnector();
            return db;
        } catch (Exception ex) {
            System.out.println("Fejl ved forbindelse");
        }
        return null;
    }
}

