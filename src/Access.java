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

    //��������
    public Access() {
        setTitle("��ӭʹ������ƱԤ��ϵͳ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 300, 450, 355);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //��ǩ����
        JLabel label = new JLabel("�û���¼");
        label.setFont(new Font("����", Font.BOLD, 30));
        JLabel lblNewLabel = new JLabel("�û���");
        JLabel lblNewLabel_1 = new JLabel("����");
        textField = new JTextField();
        textField.setColumns(10);
        passwordField = new JPasswordField();
        //��¼��ť
        JButton btnNewButton = new JButton("��¼");
        btnNewButton.setFont(new Font("΢���ź�", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = textField.getText();
                String pass = new String(passwordField.getPassword());
                try{
                    boolean com = UserLoginIn(user,pass);     //����UserLoginIn����
                    if(com){
                        JOptionPane.showMessageDialog(null, "�û���¼�ɹ���");
                        UserMainFrame umf = new UserMainFrame(user);
                        umf.setVisible(true);
                        dispose();
                    }
                    else{JOptionPane.showMessageDialog(null, "�û���¼ʧ�ܣ�");}
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });


        //ע�ᰴť
        JButton button = new JButton("ע��");
        button.setFont(new Font("΢���ź�", Font.BOLD, 15));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                RegisterFrame rf = new RegisterFrame();
                rf.setVisible(true);
            }
        });


        //����Ա��½��ť
        JButton btnNewButton_1 = new JButton("����Ա��¼");
        btnNewButton_1.setFont(new Font("΢���ź�", Font.BOLD, 15));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = textField.getText();
                String pass = new String(passwordField.getPassword());
                try{
                    boolean com = SaLoginIn(user,pass);    //����SaLoginIn����
                    if(com){
                        JOptionPane.showMessageDialog(null, "����Ա��¼�ɹ���");
                        SaMainFrame smf = new SaMainFrame(user);
                        smf.setVisible(true);
                        dispose();
                    }
                    else{JOptionPane.showMessageDialog(null, "����Ա��¼ʧ�ܣ�");}
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

    //�ж��û���½
    boolean UserLoginIn(String accountT,String namesT) throws Exception{
        String sql;
        DAO dao = new DAO();
        Connection conn = dao.getconn();
        Statement stmt = conn.createStatement();
        sql = "SELECT * FROM �û���Ϣ";
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

    //�жϹ���Ա��½
    boolean SaLoginIn(String accountT,String namesT) throws Exception{
        String sql;
        DAO dao = new DAO();
        Connection conn = dao.getconn();
        Statement stmt = conn.createStatement();
        sql = "select * from ����Ա��Ϣ";
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
