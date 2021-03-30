/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:28
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Erase {
    private Connection conn;

    public Erase(String a){
        try{
            DAO dao = new DAO();
            conn = dao.getconn();
            String sql = "delete from 车次信息 where 车次号='"+a+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            JOptionPane.showMessageDialog(null, "删除成功！");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "删除失败！");
            e.printStackTrace();
        }
    }

}

