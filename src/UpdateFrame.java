/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:32
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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class UpdateFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    //创建修改界面
    public UpdateFrame() {
        setTitle("\u4FEE\u6539\u8F66\u6B21\u4FE1\u606F");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 300, 601, 404);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //label
        JLabel label = new JLabel("\u8F93\u5165\u5C5E\u6027\uFF1A");
        label.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel label_1 = new JLabel("\u8F93\u5165\u5185\u5BB9\uFF1A");
        label_1.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel lblNewLabel = new JLabel("\u8F93\u5165\u8F66\u6B21\u53F7\uFF1A");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel label_2 = new JLabel("(属性名:始发地，目的地，出发时间，剩余票数，客车类型，票价)");
        label_2.setForeground(Color.RED);
        label_2.setFont(new Font("微软雅黑", Font.BOLD, 15));

        textField = new JTextField();
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);

        //修改按钮
        JButton button = new JButton("\u4FEE\u6539");
        button.setFont(new Font("微软雅黑", Font.BOLD, 15));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button){
                    String a = textField.getText();
                    String b = textField_1.getText();
                    String c = textField_2.getText();
                    if (b == "剩余票数"){
                        new Update(a,b,c,1);
                    }
                    else{
                        new Update(a,b,c,0);
                    }
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
                                                .addGap(76)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(label)
                                                        .addComponent(lblNewLabel)
                                                        .addComponent(label_1))
                                                .addGap(25)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                                                .addPreferredGap(ComponentPlacement.RELATED))
                                                        .addComponent(textField)
                                                        .addComponent(textField_2)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(68)
                                                .addComponent(label_2))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(211)
                                                .addComponent(button)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(63)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_1)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(40)
                                .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(button)
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }
}

