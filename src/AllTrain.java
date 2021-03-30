/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:27
 */
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AllTrain extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JTable table = new JTable();
    private Connection conn;
    public AllTrain(){
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        this.setBounds(650,300,800,200);
        this.setTitle("全部车次信息");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try{
            DAO dao = new DAO();
            conn = dao.getconn();
            table = query3();
        }catch(Exception e){e.printStackTrace();}
        this.getContentPane().add(new JScrollPane(table));
        this.setVisible(true);
        try{conn.close();}catch(Exception e){e.printStackTrace();}
    }

    public JTable query3() throws SQLException{
        DefaultTableModel tbmode=new DefaultTableModel();
        String sql = "SELECT * FROM 车次信息";
        try{
            Statement Stmt = conn.createStatement();
            ResultSet rs = Stmt.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int colcount = meta.getColumnCount();
            for(int i = 1;i <= colcount;i++)
                tbmode.addColumn(meta.getColumnName(i));
            Object[]col=new Object[colcount];
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

