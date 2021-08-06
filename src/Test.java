
import java.sql.*;
import javax.swing.JOptionPane;

public class Test {
    static  Database db = new Database() ;
    public static void main(String[] args) {
        select();
    }
    static void dropTable(){
        db.connect();
        Connection connection = db.getConnection();
        String create = "drop table product2" ;
        try {
            Statement statement = db.getConnection().createStatement();
            int r = statement.executeUpdate(create) ;
            System.out.println(r);
        } catch (SQLSyntaxErrorException e){
            JOptionPane.showMessageDialog(null, "already deleted");
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
    static void createTable(){
        db.connect();
        Connection connection = db.getConnection();
        String create = "create table product3 (code int primary key , name nvarchar(75), price float(10, 2))" ;
        try {
            Statement statement = db.getConnection().createStatement();
            int r = statement.executeUpdate(create) ;
            System.out.println(r);
        } catch (SQLSyntaxErrorException e){
            JOptionPane.showMessageDialog(null, "already there");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void select(){
        db.connect(); ;
        Connection connection = db.getConnection();
        String select  = "select * from product" ;

        try {
            Statement statement = connection.createStatement();
            ResultSet r = statement.executeQuery(select) ;
            if (r == null){
                JOptionPane.showMessageDialog(null, "no data found");
            }
            else{
                while(r.next()){
                    int code = r.getInt("code");
                    double price = r.getDouble("price") ;
                    String name  = r.getString("name") ;
                    System.out.println(code + " , " + price + " , " + name);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    static void testDelete(){
        db.connect();
        Connection connection =db.getConnection() ;
        String delete = "delete from product where code = ?" ;
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(delete);
            statement.setInt(1, 11);
            int r  = statement.executeUpdate() ;  // return 1  for success delete and 0 for no deletion
            System.out.println(r);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void testUpdate(){
        db.connect();
        Connection connection =db.getConnection();
        String update = "update product set price = ? , name = ? where code = ?" ;
        try {
            PreparedStatement statement = connection.prepareStatement(update) ;
            statement.setDouble(1, 15.75);
            statement.setString(2, "اوكسي كبير ");
            statement.setInt(3, 13) ;
            int r  = statement.executeUpdate() ;  // 1 for success update and 0 for no update
            System.out.println(r);

            connection.close() ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    static void testInsert(){
        db.connect();
        int code = 15 ;
        String name = "كونافه" ;
        double price = 4.0 ;
        String insertProduct = "insert into product (code , name, price) values (?, ?, ?)" ;
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(insertProduct) ;
            statement.setInt(1, code);
            statement.setString(2, name);
            statement.setDouble(3, price);

            int r = statement.executeUpdate() ;
            System.out.println(r);

            db.getConnection().close() ;
        } catch (SQLIntegrityConstraintViolationException E){
            JOptionPane.showMessageDialog(null, "already there");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
