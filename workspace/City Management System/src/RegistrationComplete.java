import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RegistrationComplete extends JDialog {
	public JLabel lblUserid;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			RegistrationComplete dialog = new RegistrationComplete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public RegistrationComplete(String id) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblYourUniqueUser = new JLabel("Your Unique User ID is:");
		lblYourUniqueUser.setBounds(29, 109, 213, 33);
		lblYourUniqueUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourUniqueUser.setFont(new Font("Dialog", Font.PLAIN, 20));
		getContentPane().add(lblYourUniqueUser);
		
		JLabel lblRegistrationSuccessful = new JLabel("REGISTRATION SUCCESSFUL");
		lblRegistrationSuccessful.setBounds(8, 37, 420, 33);
		lblRegistrationSuccessful.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrationSuccessful.setFont(new Font("Dialog", Font.BOLD, 25));
		getContentPane().add(lblRegistrationSuccessful);
		
		JLabel lblUserid = new JLabel(id);
		lblUserid.setBounds(263, 115, 122, 20);
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblUserid);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(329, 215, 67, 25);
			getContentPane().add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login login = new Login();
					login.setVisible(true);
				}
			});
			okButton.addActionListener(e -> this.dispose());
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\lakho\\Desktop\\DBSProject\\orange-waves-background.jpg"));
		label.setBounds(0, 0, 432, 253);
		getContentPane().add(label);
		
	}
}
