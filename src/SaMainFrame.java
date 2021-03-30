/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:31
 */


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaMainFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    //创建管理员界面
    public SaMainFrame(String user) {
        setTitle("欢迎，管理员！");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 300, 450, 300);
        //菜单栏
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("\u76F8\u5173");
        menuBar.add(menu);
        //注销菜单按钮
        JMenuItem menuItem = new JMenuItem("\u6CE8\u9500");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "注销成功！");
                dispose();
                Access acc = new Access();
                acc.setVisible(true);
            }
        });
        //用户信息菜单按钮
        JMenuItem menuItem_1 = new JMenuItem("\u7528\u6237\u8D44\u6599\u67E5\u8BE2");
        menuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserInfo uf = new UserInfo();
                uf.setVisible(true);
            }
        });
        menu.add(menuItem_1);
        menu.add(menuItem);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //label
        JLabel label = new JLabel("\u6B22\u8FCE\u6765\u5230\u7BA1\u7406\u5458\u6A21\u5F0F");
        label.setFont(new Font("微软雅黑", Font.BOLD, 24));

        //录入按钮
        JButton button = new JButton("\u5F55\u5165\u8F66\u6B21");
        button.setFont(new Font("微软雅黑", Font.BOLD, 15));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddFrame af = new AddFrame();
                af.setVisible(true);
            }
        });

        //修改按钮
        JButton button_1 = new JButton("\u4FEE\u6539\u8F66\u6B21\u4FE1\u606F");
        button_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateFrame uf = new UpdateFrame();
                uf.setVisible(true);
            }
        });

        //查询按钮
        JButton btnNewButton = new JButton("\u67E5\u770B\u6240\u6709\u8F66\u6B21");
        btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AllTrain at = new AllTrain();
                at.setVisible(true);
            }
        });

        //删除按钮
        JButton button_2 = new JButton("\u5220\u9664\u8F66\u6B21");
        button_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EraseFrame ef = new EraseFrame();
                ef.setVisible(true);
            }
        });

        //GroupLayout
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(94)
                                .addComponent(label)
                                .addContainerGap(112, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(70)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnNewButton)
                                                .addGap(18)
                                                .addComponent(button_2))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(button)
                                                .addGap(46)
                                                .addComponent(button_1)))
                                .addContainerGap(90, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(35)
                                .addComponent(label)
                                .addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(button)
                                        .addComponent(button_1))
                                .addGap(27)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton)
                                        .addComponent(button_2))
                                .addGap(42))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
