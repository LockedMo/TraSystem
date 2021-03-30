/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:29
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Purchase {
    private Connection conn;

    public Purchase(String user,String a){
        try{
            DAO dao = new DAO();
            conn = dao.getconn();
            //String sql = "INSERT INTO 订购信息 SELECT 用户名,车次号,始发地,目的地,出发时间  FROM 车次信息 and 用户信息 WHERE 车次号='"+a+"' GROUP BY 车次号,始发地,目的地,出发时间";
            String sql = "INSERT INTO 订购信息 VALUES('" +user+ "','" +a+ "')";
            String sql2 = "UPDATE 车次信息 SET 剩余票数=剩余票数-1 WHERE 车次号='"+a+"'";  //更新车次信息
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            conn.close();
            JOptionPane.showMessageDialog(null, "购票成功！");
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "购票失败！");
            e.printStackTrace();
        }
    }

}
