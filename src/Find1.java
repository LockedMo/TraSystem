/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:28
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Find1 extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JTable table = new JTable();
    private Connection conn;

    //创建查询界面
    public Find1(String sfd, String mdd, final String user){
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        //购票按钮
        JButton button = new JButton("\u8D2D\u7968");
        button.setFont(new Font("微软雅黑", Font.BOLD, 15));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                PurchaseFrame pf = new PurchaseFrame(user);
                pf.setVisible(true);
            }
        });

        contentPane.add(button, BorderLayout.SOUTH);
        this.setBounds(650,300,800,200);
        this.setTitle("车次信息");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //连接数据库，获取表
        try{
            DAO dao = new DAO();
            conn = dao.getconn();
            table = query(sfd,mdd);
        }catch(Exception e){e.printStackTrace();}
        this.getContentPane().add(new JScrollPane(table));
        this.setVisible(true);
        try{conn.close();}catch(Exception e){e.printStackTrace();}
    }

    //获取表函数
    public JTable query(String start,String end) throws SQLException{
        DefaultTableModel tbmode = new DefaultTableModel();
        String sql = "SELECT * FROM 车次信息 WHERE 始发地='"+start+"' AND 目的地='"+end+"'";

        try{
            Statement Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int colcount = meta.getColumnCount();
            for(int i = 1;i <= colcount;i++)
                tbmode.addColumn(meta.getColumnName(i));
            Object[]col = new Object[colcount];
            while(rs.next()){
                for(int j = 1;j <= col.length;j++)
                    col[j - 1] = rs.getString(j);
                tbmode.addRow(col);
            }
            rs.close();
            Stmt.close();
        }catch(Exception e){e.printStackTrace();}
        return new JTable(tbmode);
    }

}
