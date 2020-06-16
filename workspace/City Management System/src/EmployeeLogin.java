import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class EmployeeLogin extends JFrame {
	private JLabel lblEnterEmpId;
	private JLabel label;
	private String empId;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLogin frame = new EmployeeLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public EmployeeLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 529);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeLogin = new JLabel("EMPLOYEE LOGIN");
		lblEmployeeLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeLogin.setFont(new Font("Verdana", Font.BOLD, 30));
		lblEmployeeLogin.setBounds(122, 51, 319, 69);
		contentPane.add(lblEmployeeLogin);
		
		JLabel lblEmpId = new JLabel("Emp ID");
		lblEmpId.setToolTipText("");
		lblEmpId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpId.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmpId.setBounds(12, 143, 138, 31);
		contentPane.add(lblEmpId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(158, 148, 226, 22);
		contentPane.add(textField);
		empId = textField.getText().toString();
		JButton button = new JButton("LOGIN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				empId = textField.getText().toString();
				if(empId.equals("")){
					JOptionPane.showMessageDialog(null,"Enter Employee ID","Error Connection", JOptionPane.WARNING_MESSAGE);
				}
				else {
					pressSubmit(empId);
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button.setBounds(424, 146, 115, 29);
		contentPane.add(button);
		
		JLabel lblComplainId = new JLabel("Complain ID");
		lblComplainId.setToolTipText("");
		lblComplainId.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplainId.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblComplainId.setBounds(34, 240, 138, 31);
		contentPane.add(lblComplainId);
		
		lblEnterEmpId = new JLabel("Enter Emp Id In the field above");
		lblEnterEmpId.setBounds(270, 240, 205, 31);
		contentPane.add(lblEnterEmpId);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setToolTipText("");
		lblCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCustomerName.setBounds(34, 289, 177, 31);
		contentPane.add(lblCustomerName);
		
		label = new JLabel("Enter Emp Id In the field above");
		label.setBounds(270, 284, 205, 31);
		contentPane.add(label);
		
		JButton btnServiced = new JButton("SERVICED");
		btnServiced.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String empId = textField.getText().toString();
				pressServiced(empId);
			}
		});
		btnServiced.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnServiced.setBounds(326, 361, 115, 25);
		contentPane.add(btnServiced);
		
		JLabel lblIfYouHave = new JLabel("Serviced the complaint, press serviced");
		lblIfYouHave.setToolTipText("");
		lblIfYouHave.setHorizontalAlignment(SwingConstants.CENTER);
		lblIfYouHave.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblIfYouHave.setBounds(34, 361, 265, 25);
		contentPane.add(lblIfYouHave);
		
		JButton btnHistory = new JButton("HISTORY");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				empId = textField.getText().toString();
				if(empId.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter Employee ID","ERROR!", JOptionPane.WARNING_MESSAGE); 
				}
				else{
					try {  
						Class.forName("oracle.jdbc.driver.OracleDriver");  
						Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","B2170905466");  
						Statement st = conn.createStatement();
						
						ResultSet r = st.executeQuery("select * from employee where employee_id = '" + empId + "'");
						if(r.next() == false) {
							JOptionPane.showMessageDialog(null,"Enter Valid Employee ID","ERROR", JOptionPane.WARNING_MESSAGE);
						}
						else{
							EmployeeComplainHistory ech = new EmployeeComplainHistory(empId);
							ech.setVisible(true);
						}
					}
					catch (Exception e) {  
						JOptionPane.showMessageDialog(null,"You have no pending complaints","Voila!", JOptionPane.WARNING_MESSAGE);   
					}
			}
		}
		});
		btnHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHistory.setBounds(326, 415, 115, 25);
		contentPane.add(btnHistory);
		
		JLabel lblHistoryOfComplaint = new JLabel("History Of Complaint Serviced");
		lblHistoryOfComplaint.setToolTipText("");
		lblHistoryOfComplaint.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistoryOfComplaint.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblHistoryOfComplaint.setBounds(5, 415, 265, 25);
		contentPane.add(lblHistoryOfComplaint);
		
		JButton here = new JButton("HERE");
		here.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAs la = new LoginAs();
				la.setVisible(true);
			}
		});
		here.addActionListener(e -> this.dispose());
		here.setFont(new Font("Tahoma", Font.PLAIN, 19));
		here.setBounds(409, 13, 103, 29);
		contentPane.add(here);
		
		JLabel lblNotAnEmployee = new JLabel("Go to Login Page, click here");
		lblNotAnEmployee.setToolTipText("");
		lblNotAnEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotAnEmployee.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNotAnEmployee.setBounds(0, 16, 328, 25);
		contentPane.add(lblNotAnEmployee);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setIcon(new ImageIcon("C:\\Users\\lakho\\Desktop\\DBSProject\\orange-waves-background.jpg"));
		label_1.setBounds(0, 0, 562, 483);
		contentPane.add(label_1);
	}
	public void pressSubmit(String empId) {
		String compId = "";
		String custName = "";
		
		try {  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","B2170905466");  
			Statement st = conn.createStatement();
			ResultSet r = st.executeQuery("select * from employee where employee_id = '" + empId + "'");
			if(r.next() == false) {
				JOptionPane.showMessageDialog(null,"Enter Valid Employee ID","ERROR", JOptionPane.WARNING_MESSAGE);
			}
			else {
				r=st.executeQuery("select complaint_id,citizen_name from complaint,citizen where citizen.citizen_id = complaint.citizen_id and complaint.employee_id = " + "'" + empId + "'");
				while (r.next()) {  
					compId = r.getString(1);
					custName = r.getString(2);
				}
				if(compId.equals("") && custName.equals("")) {
					lblEnterEmpId.setText("No pending complaints");
					label.setText("No pending complaints");
				}
				else{
					lblEnterEmpId.setText(compId);
					label.setText(custName);
				}
				conn.close();
			} 
		}catch (Exception e) {  
			
			
			JOptionPane.showMessageDialog(null,"You have no pending complaints","Voila!", JOptionPane.WARNING_MESSAGE);  
			 
		}
	}
	
	public void pressServiced(String empId) {
		if(empId.contentEquals("")) {
			JOptionPane.showMessageDialog(null,"Enter Employee ID","ERROR!", JOptionPane.WARNING_MESSAGE); 
		}
			else{
				try {  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","B2170905466");  
				Statement st = conn.createStatement();
				
				ResultSet r = st.executeQuery("select * from employee where employee_id = '" + empId + "'");
				if(r.next() == false) {
					JOptionPane.showMessageDialog(null,"Enter Valid Employee ID","ERROR", JOptionPane.WARNING_MESSAGE);
				}
				else{
						r = st.executeQuery("select complaint_id from complaint where employee_id = " + "'" + empId + "'");
					if(r.next() == false) {
						JOptionPane.showMessageDialog(null,"No complaints registered with this account","Voila!", JOptionPane.WARNING_MESSAGE);
					}
					else {
						st.executeUpdate("delete from complaint where employee_id = " + "'" + empId + "'");
						st.executeUpdate("commit");
						JOptionPane.showMessageDialog(null,"Complaint serviced","Voila!", JOptionPane.WARNING_MESSAGE);
						lblEnterEmpId.setText("");
						label.setText("");
						conn.close();
					}
				}
			} 
				catch (Exception e) {
					
					
						JOptionPane.showMessageDialog(null,"Error Servicing Complaints","ERROR!", JOptionPane.WARNING_MESSAGE);   
					
			}
		}
	}
}
