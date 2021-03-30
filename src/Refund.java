/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:30
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Refund {
    private Connection conn;

    public Refund(String a,String user){
        try{
            DAO dao = new DAO();
            conn = dao.getconn();
            String sql = "DELETE FROM 订购信息 WHERE 车次号='"+a+"' AND 用户名=‘"+user+"''";
            String sql2 = "UPDATE 车次信息 SET 剩余票数=剩余票数+1 WHERE 车次号='"+a+"'"; //更新车次信息
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            conn.close();
            JOptionPane.showMessageDialog(null, "退票成功！");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "退票失败！");
            e.printStackTrace();
        }
    }

}

