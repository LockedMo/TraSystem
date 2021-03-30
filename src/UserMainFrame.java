/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:33
 */

import sun.security.krb5.internal.Ticket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class UserMainFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    //创建主界面
    public UserMainFrame(final String user) {
        setTitle("汽车票预订系统");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 300, 450, 400);
        //菜单栏
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("\u7528\u6237\u4FE1\u606F");
        menuBar.add(menu);
        //购票信息按钮
        JMenuItem menuItem = new JMenuItem("\u60A8\u7684\u8F66\u7968");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new Ticket(user);
            }
        });
        menu.add(menuItem);
        //退票系统按钮
        JMenuItem menuItem_1 = new JMenuItem("\u9000\u7968\u7CFB\u7EDF");
        menuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RefundFrame rf = new RefundFrame(user);
                rf.setVisible(true);
            }
        });
        menu.add(menuItem_1);
        //注销按钮
        JMenuItem menuItem_2 = new JMenuItem("\u6CE8\u9500");
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "注销成功！");
                dispose();
                Access acc = new Access();
                acc.setVisible(true);
            }
        });
        menu.add(menuItem_2);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //label
        JLabel lblNewLabel = new JLabel("\u8F66\u6B21\u67E5\u8BE2");
        lblNewLabel.setFont(new Font("黑体", Font.BOLD, 30));

        JLabel label = new JLabel("\u59CB\u53D1\u5730");

        JLabel label_1 = new JLabel("\u76EE\u7684\u5730");

        textField = new JTextField();
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);

        //查询按钮
        JButton button = new JButton("\u5F00\u59CB\u67E5\u8BE2");
        button.setFont(new Font("微软雅黑", Font.BOLD, 15));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sfd = textField.getText();
                String mdd = textField_1.getText();
                new Find1(sfd,mdd,user);
            }
        });


        //查询2按钮
        JButton button_1 = new JButton("\u7279\u5B9A\u8F66\u6B21\u53F7\u67E5\u8BE2");
        button_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String a = textField_2.getText();
                new Find2(a,user);
            }
        });



        //GroupLayout
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(36)
                                                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(53)
                                                                .addComponent(label))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(54)
                                                                .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                                .addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(button_1))
                                                                .addGap(75))
                                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(label_1)
                                                                .addGap(99))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(154)
                                                .addComponent(button))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(140)
                                                .addComponent(lblNewLabel)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(35)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(label_1))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(45)
                                .addComponent(button)
                                .addGap(36)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_1))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}

