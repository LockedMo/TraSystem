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
            String sql = "delete from ������Ϣ where ���κ�='"+a+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
            e.printStackTrace();
        }
    }

}

