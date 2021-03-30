import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 12:38
 */
public class DAO {
    public Connection getconn(){
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost:1436; DatabaseName=ts";
        String user = "root";
        String password = "19981207";
        try{
            /*   Class.forName("com.mysql.jdbc.Driver");*/
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch (Exception e){
            System.out.println("1");
        }
        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("¡¨Ω” ß∞‹");
        }
        return conn;
    }
}
