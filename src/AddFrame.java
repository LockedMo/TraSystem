/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:26
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;

    //创建录入界面
    public AddFrame(){
        setTitle("录入车次");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 300, 450, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //label
        JLabel label = new JLabel("车次号：");
        label.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel label_1 = new JLabel("始发地：");
        label_1.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel label_2 = new JLabel("目的地：");
        label_2.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel label_3 = new JLabel("出发时间：");
        label_3.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel label_4 = new JLabel("剩余票数：");
        label_4.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel label_5 = new JLabel("客车类型：");
        label_5.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel label_6 = new JLabel("票价：");
        label_6.setFont(new Font("宋体", Font.BOLD, 15));

        textField = new JTextField();
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setColumns(10);

        //录入按钮
        final JButton button = new JButton("录入");
        button.setFont(new Font("微软雅黑", Font.BOLD, 15));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button){
                    String a = textField.getText();
                    String b = textField_1.getText();
                    String c = textField_2.getText();
                    String d = textField_3.getText();
                    int f = Integer.valueOf(textField_4.getText());
                    String g = textField_5.getText();
                    String h = textField_6.getText();
                    new Add(a,b,c,d,f,g,h);
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
                                                .addGap(45)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(label_1)
                                                        .addComponent(label)
                                                        .addComponent(label_2)
                                                        .addComponent(label_5)
                                                        .addComponent(label_4)
                                                        .addComponent(label_3)
                                                        .addComponent(label_6))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                        .addComponent(textField_1)
                                                        .addComponent(textField_2)
                                                        .addComponent(textField_3)
                                                        .addComponent(textField_4)
                                                        .addComponent(textField_5)
                                                        .addComponent(textField_6)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(170)
                                                .addComponent(button)))
                                .addContainerGap(91, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(38)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_1))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_2))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_3))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_4))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_5))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_6))
                                .addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(button)
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }
}

