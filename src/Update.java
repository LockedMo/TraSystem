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
            String sql0 = "UPDATE ������Ϣ SET "+a+"='"+b+"' WHERE ���κ�='"+c+"'";
            String sql1 = "UPDATE ������Ϣ SET "+a+"="+b+" WHERE ���κ�='"+c+"'";
            java.sql.Statement stmt = conn.createStatement();
            if(d == 0){
                stmt.executeUpdate(sql0);
            }
            else{
                stmt.executeUpdate(sql1);
            }
            conn.close();
            JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
            e.printStackTrace();
        }
    }
}


