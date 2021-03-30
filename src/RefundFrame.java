/**
 * @author mzc
 * @version 1.0
 * @date 2020/6/23 11:30
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

public class RefundFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    //¥¥Ω®ÕÀ∆±ΩÁ√Ê
    public RefundFrame(final String user) {
        setTitle("\u9000\u7968\u754C\u9762");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(650, 300, 450, 117);
        contentPane = new JPanel();
        contentPane.setForeground(Color.BLUE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //label
        JLabel label = new JLabel("\u8F66\u6B21\u53F7\uFF1A");
        label.setFont(new Font("ÀŒÃÂ", Font.BOLD, 15));

        textField = new JTextField();
        textField.setColumns(10);

        //ÕÀ∆±∞¥≈•
        JButton btnNewButton = new JButton("\u9000\u7968");
        btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 15));
        btnNewButton.setForeground(Color.RED);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = textField.getText();
                new Refund(a,user);
            }
        });



        //GroupLayout
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(32)
                                .addComponent(label)
                                .addGap(18)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                .addGap(27)
                                .addComponent(btnNewButton)
                                .addContainerGap(38, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addContainerGap(98, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label)
                                        .addComponent(btnNewButton))
                                .addGap(121))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
