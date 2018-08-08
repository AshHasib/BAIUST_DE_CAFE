
package baiustdecafe;

import controlmanager.DatabaseManager;
import java.sql.*;
public class MainClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        
        LoginScreen loginScreen=new LoginScreen();
        
        Connection con=DatabaseManager.getCon();
        Statement st=con.createStatement();
        
        ResultSet rs=st.executeQuery("select * from log_user;");
        
        if(rs.next()) {
            //ResultSetMetaData rsmd=rs.getMetaData();
            
            String username=rs.getString(2);
            
            new InventoryScreen(username).setVisible(true);
        }
        
        else {
            new LoginScreen().setVisible(true);
        }
        
    }
}
