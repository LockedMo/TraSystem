/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:27
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EraseFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textField;


    //创建删除界面
    public EraseFrame() {
        setTitle("删除界面");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 300, 435, 120);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //label
        JLabel label = new JLabel("\u8F66\u6B21\u53F7\uFF1A");
        label.setFont(new Font("宋体", Font.BOLD, 15));
        textField = new JTextField();
        textField.setColumns(10);

        //删除按钮
        JButton btnNewButton = new JButton("\u5220\u9664");
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = textField.getText();
                new Erase(a);
            }
        });



        //GroupLayout
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(27)
                                .addComponent(label)
                                .addGap(18)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addGap(33)
                                .addComponent(btnNewButton)
                                .addContainerGap(55, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(22)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton)
                                        .addComponent(label))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
