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
            String sql = "INSERT INTO ������Ϣ(���κ�,ʼ����,Ŀ�ĵ�,����ʱ��,ʣ��Ʊ��,�ͳ�����,Ʊ��) VALUES('"+a+"','"+b+"','"+c+"','"+d+"',"+f+",'"+g+"','"+h+"')";
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            JOptionPane.showMessageDialog(null, "¼��ɹ���");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¼��ʧ�ܣ�");
            e.printStackTrace();
        }
    }

}
