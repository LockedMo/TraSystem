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
            String sql = "DELETE FROM ������Ϣ WHERE ���κ�='"+a+"' AND �û���=��"+user+"''";
            String sql2 = "UPDATE ������Ϣ SET ʣ��Ʊ��=ʣ��Ʊ��+1 WHERE ���κ�='"+a+"'"; //���³�����Ϣ
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            conn.close();
            JOptionPane.showMessageDialog(null, "��Ʊ�ɹ���");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "��Ʊʧ�ܣ�");
            e.printStackTrace();
        }
    }

}

