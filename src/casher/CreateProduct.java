package casher;



import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohamed
 */
public class CreateProduct {
    
    public boolean create(String tableName){
        Database db = new Database() ;        
        db.connect();        
        Connection connection = db.getConnection();
        
        String create = "create table "+tableName+" (code int primary key , name nvarchar(100), price float(10, 2), quantity int , description nvarchar(200))" ;        
        try {
            Statement statement = connection.createStatement();
            
            int r = statement.executeUpdate(create) ;
            connection.close();
            System.out.println("table : " + tableName + " created");
            return true ;
        } 
        catch (SQLSyntaxErrorException e){
            System.out.println("table already there");
            JOptionPane.showMessageDialog(null, "table already there");            
        }
        catch (SQLException e) {
            System.out.println("error while creating product table");
            e.printStackTrace();
        
        }
        return false ;    
    }
}
