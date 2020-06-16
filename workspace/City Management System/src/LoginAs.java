import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginAs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAs frame = new LoginAs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginAs() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 379);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginAs = new JLabel("LOGIN AS");
		lblLoginAs.setForeground(new Color(0, 0, 0));
		lblLoginAs.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginAs.setFont(new Font("Yu Gothic", Font.BOLD, 50));
		lblLoginAs.setBounds(114, 42, 319, 69);
		contentPane.add(lblLoginAs);
		
		JButton btnCitizen = new JButton("CITIZEN");
		btnCitizen.setForeground(Color.PINK);
		btnCitizen.setBackground(Color.BLACK);
		btnCitizen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnCitizen.addActionListener(e -> this.dispose());
		btnCitizen.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnCitizen.setBounds(190, 130, 162, 43);
		contentPane.add(btnCitizen);
		
		JButton btnEmployee = new JButton("EMPLOYEE");
		btnEmployee.setForeground(Color.PINK);
		btnEmployee.setBackground(Color.BLACK);
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					EmployeeLogin empLogin = new EmployeeLogin();
					empLogin.setVisible(true);
			}
		});
		btnEmployee.addActionListener(e -> this.dispose());
		btnEmployee.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnEmployee.setBounds(172, 214, 195, 43);
		contentPane.add(btnEmployee);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setIcon(new ImageIcon("C:\\Users\\lakho\\Desktop\\DBSProject\\orange-waves-background.jpg"));
		label_1.setBounds(0, 0, 562, 332);
		contentPane.add(label_1);
	}
}
