/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:27
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Add {
    private Connection conn;

    public Add(String a,String b,String c,String d,int f,String g,String h){
        try{
            DAO dao = new DAO();
            conn = dao.getconn();
            String sql = "INSERT INTO 车次信息(车次号,始发地,目的地,出发时间,剩余票数,客车类型,票价) VALUES('"+a+"','"+b+"','"+c+"','"+d+"',"+f+",'"+g+"','"+h+"')";
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            JOptionPane.showMessageDialog(null, "录入成功！");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "录入失败！");
            e.printStackTrace();
        }
    }

}
