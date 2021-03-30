/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:32
 */

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Ticket extends JFrame{
    private static final long serialVersionUID = 1L;
    JTable table=new JTable();
    private Connection conn;
    //��������
    public Ticket(java.lang.String user){
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        this.setBounds(600,300,800,300);
        this.setTitle("�ѹ�����");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //�������ݿ⣬��ȡ��
        try{
            DAO dao = new DAO();
            conn = dao.getconn();
            table=query3(user);
        }   catch(Exception e){e.printStackTrace();}
        this.getContentPane().add(new JScrollPane(table));
        this.setVisible(true);
        try{conn.close();}catch(Exception e){e.printStackTrace();}
    }

    //��ȡ����
    public JTable query3(String user) throws SQLException{
        DefaultTableModel tbmode=new DefaultTableModel();
        String sql="SELECT �û���,������Ϣ.���κ�,������Ϣ.ʼ����,������Ϣ.Ŀ�ĵ�,������Ϣ.����ʱ��  FROM ������Ϣ,������Ϣ WHERE �û���='"+ user+"' AND ������Ϣ.���κ�=������Ϣ.���κ�";
        try{
            Statement Stmt=conn.createStatement();
            ResultSet rs=Stmt.executeQuery(sql);
            ResultSetMetaData meta=rs.getMetaData();
            int colcount=4;
            for(int i=1;i<=colcount;i++)
                tbmode.addColumn(meta.getColumnName(i));
            Object[]col=new Object[colcount];
            while(rs.next()){
                for(int j=1;j<=col.length;j++)
                    col[j-1]=rs.getString(j);
                tbmode.addRow(col);
            }
            rs.close();
            Stmt.close();
        }catch(Exception e){e.printStackTrace();}
        return new JTable(tbmode);
    }

}
