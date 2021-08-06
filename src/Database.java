
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    Connection connection ;
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
    public void insertInto(String insert){
        try {
            PreparedStatement statement = connection.prepareStatement(insert) ;
            statement.executeUpdate() ;

        } catch (SQLException e) {
            System.err.println("error while inserting");
            e.printStackTrace();
        }
    }
}
