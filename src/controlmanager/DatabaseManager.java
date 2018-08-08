
package controlmanager;

/**
 *
 * @author Hasib
 */

import java.sql.*;
public class DatabaseManager {
    
    
    public static Connection getCon() throws ClassNotFoundException, SQLException {
        
        
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/baiustdecafe","root","1103054");
        return con;
    }
}
