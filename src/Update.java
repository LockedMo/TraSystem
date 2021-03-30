/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:32
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Update {
    private Connection conn;
    public Update(String a,String b,String c,int d){
        try{
            DAO dao = new DAO();
            conn = dao.getconn();
            String sql0 = "UPDATE 车次信息 SET "+a+"='"+b+"' WHERE 车次号='"+c+"'";
            String sql1 = "UPDATE 车次信息 SET "+a+"="+b+" WHERE 车次号='"+c+"'";
            java.sql.Statement stmt = conn.createStatement();
            if(d == 0){
                stmt.executeUpdate(sql0);
            }
            else{
                stmt.executeUpdate(sql1);
            }
            conn.close();
            JOptionPane.showMessageDialog(null, "修改成功！");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "修改失败！");
            e.printStackTrace();
        }
    }
}


