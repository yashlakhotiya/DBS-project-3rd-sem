import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Complaint extends JFrame {
	private JLabel label_0;
	private JLabel label_1;
	private JLabel label_2;
	private JTextArea textArea;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Complaint frame = new Complaint();
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
	public Complaint(String userId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 530);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegisterComplaint = new JButton("Register");
		btnRegisterComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComplainRegister comp = new ComplainRegister(userId);
				comp.setVisible(true);
			}
		});
		btnRegisterComplaint.addActionListener(e -> this.dispose());
		btnRegisterComplaint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegisterComplaint.setBounds(382, 443, 123, 26);
		contentPane.add(btnRegisterComplaint);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(313, 86, 110, 22);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("COMPLAINT DETAILS");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 26));
		label.setBounds(58, 33, 436, 55);
		contentPane.add(label);
		
		JLabel label_3 = new JLabel("Department");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Dialog", Font.BOLD, 25));
		label_3.setBounds(42, 124, 218, 29);
		contentPane.add(label_3);
		
		JLabel lblEmployeeNo = new JLabel("Date of complaint");
		lblEmployeeNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployeeNo.setFont(new Font("Dialog", Font.BOLD, 25));
		lblEmployeeNo.setBounds(42, 190, 212, 42);
		contentPane.add(lblEmployeeNo);
		
		JLabel label_5 = new JLabel("Employee Name");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Dialog", Font.BOLD, 25));
		label_5.setBounds(42, 228, 218, 38);
		contentPane.add(label_5);
		
		JLabel lblComplaintId = new JLabel("Complaint ID");
		lblComplaintId.setHorizontalAlignment(SwingConstants.LEFT);
		lblComplaintId.setFont(new Font("Dialog", Font.BOLD, 25));
		lblComplaintId.setBounds(42, 84, 212, 29);
		contentPane.add(lblComplaintId);
		
		JLabel lblWantToRegister = new JLabel("Want to register Complaint, click register");
		lblWantToRegister.setToolTipText("");
		lblWantToRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblWantToRegister.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblWantToRegister.setBounds(31, 446, 328, 25);
		contentPane.add(lblWantToRegister);
		
		label_0 = new JLabel("Select Complaint ID");
		label_0.setHorizontalAlignment(SwingConstants.LEFT);
		label_0.setFont(new Font("Arial", Font.ITALIC, 17));
		label_0.setBounds(312, 127, 193, 29);
		contentPane.add(label_0);
		
		label_1 = new JLabel("Select Complaint ID");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Arial", Font.ITALIC, 17));
		label_1.setBounds(314, 197, 191, 29);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Select Complaint ID");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Arial", Font.ITALIC, 17));
		label_2.setBounds(312, 239, 193, 23);
		contentPane.add(label_2);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescription.setFont(new Font("Dialog", Font.BOLD, 25));
		lblDescription.setBounds(41, 347, 216, 38);
		contentPane.add(lblDescription);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Tahoma", Font.ITALIC, 15));
		textArea.setBounds(318, 355, 218, 75);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(textArea);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAs la = new LoginAs();
				la.setVisible(true);
			}
		});
		btnLogOut.addActionListener(e -> this.dispose());
		btnLogOut.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnLogOut.setBounds(12, 13, 132, 29);
		contentPane.add(btnLogOut);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comp_id = "";
				try{
					comp_id = comboBox.getSelectedItem().toString();
					displayDetails(comp_id,userId);
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,"No pending Complaints","ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSubmit.setBounds(445, 84, 83, 25);
		contentPane.add(btnSubmit);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Dialog", Font.BOLD, 25));
		lblGender.setBounds(40, 306, 223, 38);
		contentPane.add(lblGender);
		
		label_6 = new JLabel("Select Complaint ID");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Arial", Font.ITALIC, 17));
		label_6.setBounds(316, 314, 189, 23);
		contentPane.add(label_6);
		
		JLabel lblDepartmentNo = new JLabel("Dept Phone");
		lblDepartmentNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartmentNo.setFont(new Font("Dialog", Font.BOLD, 25));
		lblDepartmentNo.setBounds(42, 160, 210, 29);
		contentPane.add(lblDepartmentNo);
		
		label_7 = new JLabel("Select Complaint ID");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Arial", Font.ITALIC, 17));
		label_7.setBounds(312, 159, 193, 29);
		contentPane.add(label_7);
		
		JLabel lblEmployeePhone = new JLabel("Employee Phone");
		lblEmployeePhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployeePhone.setFont(new Font("Dialog", Font.BOLD, 25));
		lblEmployeePhone.setBounds(41, 267, 215, 38);
		contentPane.add(lblEmployeePhone);
		
		label_8 = new JLabel("Select Complaint ID");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("Arial", Font.ITALIC, 17));
		label_8.setBounds(313, 278, 192, 23);
		contentPane.add(label_8);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setIcon(new ImageIcon("C:\\Users\\lakho\\Desktop\\DBSProject\\orange-waves-background.jpg"));
		label_1.setBounds(0, 0, 562, 483);
		contentPane.add(label_1);
		
		try {  
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","B2170905466");  
			Statement st = conn.createStatement();

			 ResultSet r=st.executeQuery("select complaint_id from complaint where complaint.citizen_id = " + "'" + userId + "'");

			 while (r.next()) {  
			     comboBox.addItem(r.getString("complaint_id"));  
			 }


			    conn.close();
			    } catch (Exception e) {  
			JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
			System.exit(0);  
			}
	}
	public void displayDetails(String comp_id,String userId) {
		String dept_name = "";
		String emp_name = "";
		String date = "";
		String description = "";
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","B2170905466");  
			Statement st = conn.createStatement();
			String gender = "";
			ResultSet r = st.executeQuery("select department_name,landline,to_char(date_of_complaint,'DD-MM-YYYY'),employee_name,phone,gender,description from complaint,employee,department where employee.employee_id = complaint.employee_id and employee.department_id = complaint.department_id and employee.department_id = department.department_id and  department.department_id = complaint.department_id and complaint.complaint_id = '" + comp_id + "'");
			while(r.next()) {
				label_0.setText(r.getString(1));
				label_7.setText(r.getString(2));
				label_1.setText(r.getString(3));
				label_2.setText(r.getString(4));
				gender = r.getString(6);
				if(gender.equals('M')) gender = "Male";
				else gender = "Female";
				label_6.setText(gender);
				label_8.setText(r.getString(5));
				textArea.setText(r.getString(7));
			}
			conn.close();
			    } catch (Exception e) {  
			JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
			System.exit(0);  
			}
	}
}
