
package controlmanager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Hasib
 */
public class ProductManager {
    public static int insertPurchase(int id,double price,String p_date,int quantity) {
        int flag=0;
        
        try {
            Connection con=DatabaseManager.getCon();
            Statement st=con.createStatement();
            
            String sql="insert into purchase ( p_id, price, p_date, quantity) "
                    + "values("+id+","+price+",'"+p_date+"',"+quantity+")";
            
            flag=st.executeUpdate(sql);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Purchase Error");
        }
       
        return flag;
    }
    
    public static int insertSale(int id,double price,String p_date,int quantity) {
        int flag=0;
        
        try {
            Connection con=DatabaseManager.getCon();
            Statement st=con.createStatement();
            
            String sql="insert into sale ( p_id, price, s_date, quantity) "
                    + "values("+id+","+price+",'"+p_date+"',"+quantity+");";
            
            flag=st.executeUpdate(sql);
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"This product is not available");
        }
        
        
        return flag;
    }
    
    public static int getProductQuantity (String productname) throws ClassNotFoundException, SQLException {
        Connection con=DatabaseManager.getCon();
        Statement st=con.createStatement();
        
        ResultSet rs=st.executeQuery("select quantity from product where productname='"+productname+"';");
        int qty=rs.getInt(3);
        
        return qty;
    }
    
    public static String getSumPurchase() {
        String sum="";
        
        Connection con;
        try {
            con = DatabaseManager.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select sum(price) from purchase");
            
           if(rs.next()) {
                sum=rs.getString(1);
                return sum;
           }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
        return sum;
    }
    
    
    public static String getSumSale() {
        String sum="";
        
        Connection con;
        try {
            con = DatabaseManager.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select sum(price) from sale");
            
            if(rs.next()) {
                sum=rs.getString(1);
                return sum;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
        return sum;
    }
}
