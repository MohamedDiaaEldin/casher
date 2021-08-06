package casher;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Database {
    private Connection connection ;
    
    
    public  void connect(){
        String  url = "jdbc:mysql://localhost:3306/test" ;
        String username = "mohamed" ;
        String pass = "123" ;

        try {
            connection = DriverManager.getConnection(url, username, pass);
            System.out.println("connected");
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection(){
        return this.connection ;
    }
    
    public boolean insertProduct(Product product){        
        connect(); 
        
        String insertProduct = "insert into product (code , name, price, quantity, description) values (?, ?, ?, ?, ?)" ;
        try {
            PreparedStatement statement = connection.prepareStatement(insertProduct) ;
            statement.setInt(1, product.getCode());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setString(5, product.getDescription()) ;
            statement.executeUpdate() ;
            
            System.out.println("product added");            
            connection.close();
        } catch (SQLIntegrityConstraintViolationException E){
            JOptionPane.showMessageDialog(null, "المنتج موجود بالفعل");
            System.out.println(E.getStackTrace());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false ;
    }
        
    
    
}
