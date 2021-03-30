/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:29
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PurchaseFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    //´´½¨¹ºÂò½çÃæ
    public PurchaseFrame(String user) {
        setTitle("\u8D2D\u4E70\u754C\u9762");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(650, 300, 434, 122);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //label
        JLabel label = new JLabel("\u8F66\u6B21\u53F7\uFF1A");
        label.setFont(new Font("ËÎÌå", Font.BOLD, 15));

        textField = new JTextField();
        textField.setColumns(10);

        //¹ºÆ±°´Å¥
        JButton button = new JButton("\u8D2D\u7968");
        button.setForeground(Color.BLUE);
        button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = textField.getText();
                new Purchase(a,user);
            }
        });


        //GroupLayout
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(23)
                                .addComponent(label)
                                .addGap(18)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(button)
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(21)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button))
                                .addContainerGap(1, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

}
