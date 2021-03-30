/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:26
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Access extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    //Main
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Access frame = new Access();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //创建界面
    public Access() {
        setTitle("欢迎使用汽车票预订系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 300, 450, 355);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //标签设置
        JLabel label = new JLabel("用户登录");
        label.setFont(new Font("宋体", Font.BOLD, 30));
        JLabel lblNewLabel = new JLabel("用户名");
        JLabel lblNewLabel_1 = new JLabel("密码");
        textField = new JTextField();
        textField.setColumns(10);
        passwordField = new JPasswordField();
        //登录按钮
        JButton btnNewButton = new JButton("登录");
        btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = textField.getText();
                String pass = new String(passwordField.getPassword());
                try{
                    boolean com = UserLoginIn(user,pass);     //调用UserLoginIn函数
                    if(com){
                        JOptionPane.showMessageDialog(null, "用户登录成功！");
                        UserMainFrame umf = new UserMainFrame(user);
                        umf.setVisible(true);
                        dispose();
                    }
                    else{JOptionPane.showMessageDialog(null, "用户登录失败！");}
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });


        //注册按钮
        JButton button = new JButton("注册");
        button.setFont(new Font("微软雅黑", Font.BOLD, 15));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                RegisterFrame rf = new RegisterFrame();
                rf.setVisible(true);
            }
        });


        //管理员登陆按钮
        JButton btnNewButton_1 = new JButton("管理员登录");
        btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = textField.getText();
                String pass = new String(passwordField.getPassword());
                try{
                    boolean com = SaLoginIn(user,pass);    //调用SaLoginIn函数
                    if(com){
                        JOptionPane.showMessageDialog(null, "管理员登录成功！");
                        SaMainFrame smf = new SaMainFrame(user);
                        smf.setVisible(true);
                        dispose();
                    }
                    else{JOptionPane.showMessageDialog(null, "管理员登录失败！");}
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });


        //GroupLayout
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(54)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel)
                                                        .addComponent(lblNewLabel_1))
                                                .addGap(23)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(passwordField)
                                                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                                        .addComponent(btnNewButton)
                                                        .addComponent(button, Alignment.TRAILING))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(btnNewButton_1))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(143)
                                                .addComponent(label)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(25)
                                .addComponent(label)
                                .addGap(26)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(55)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton_1))
                                .addGap(47)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton)
                                        .addComponent(button))
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }

    //判断用户登陆
    boolean UserLoginIn(String accountT,String namesT) throws Exception{
        String sql;
        DAO dao = new DAO();
        Connection conn = dao.getconn();
        Statement stmt = conn.createStatement();
        sql = "SELECT * FROM 用户信息";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            String acc = rs.getString(1);
            String names = rs.getString(2);
            if(acc.equals(accountT) && names.equals(namesT)){
                return true;
            }
        }
        return false;
    }

    //判断管理员登陆
    boolean SaLoginIn(String accountT,String namesT) throws Exception{
        String sql;
        DAO dao = new DAO();
        Connection conn = dao.getconn();
        Statement stmt = conn.createStatement();
        sql = "select * from 管理员信息";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String acc = rs.getString(1);
            String names = rs.getString(2);
            if(acc.equals(accountT) && names.equals(namesT)){
                return true;
            }
        }
        return false;
    }

}
