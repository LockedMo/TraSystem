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
            //String sql = "INSERT INTO ������Ϣ SELECT �û���,���κ�,ʼ����,Ŀ�ĵ�,����ʱ��  FROM ������Ϣ and �û���Ϣ WHERE ���κ�='"+a+"' GROUP BY ���κ�,ʼ����,Ŀ�ĵ�,����ʱ��";
            String sql = "INSERT INTO ������Ϣ VALUES('" +user+ "','" +a+ "')";
            String sql2 = "UPDATE ������Ϣ SET ʣ��Ʊ��=ʣ��Ʊ��-1 WHERE ���κ�='"+a+"'";  //���³�����Ϣ
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            conn.close();
            JOptionPane.showMessageDialog(null, "��Ʊ�ɹ���");
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "��Ʊʧ�ܣ�");
            e.printStackTrace();
        }
    }

}
