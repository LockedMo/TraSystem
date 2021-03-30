/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:31
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Register {
    private Connection conn;
    public void Register(String a,String b){
        try{
            DAO dao = new DAO();
            conn = dao.getconn();
            String sql = "INSERT INTO 用户信息 VALUES('" +a+ "','" +b+ "')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            JOptionPane.showMessageDialog(null, "注册成功！");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "注册失败！");
            e.printStackTrace();
        }
    }
}
