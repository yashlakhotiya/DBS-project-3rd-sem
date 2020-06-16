import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;

public class EmployeeComplainHistory extends JFrame {

	private JPanel contentPane;
	private JLabel label_3;
	private JLabel label_5;
	private JLabel label_7;
	private JLabel label_8;
	private JTextArea textArea;
	private DefaultListModel dlm;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { EmployeeComplainHistory frame = new
	 * EmployeeComplainHistory(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public EmployeeComplainHistory(String empId) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComplaintHistory = new JLabel("COMPLAINT HISTORY");
		lblComplaintHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplaintHistory.setFont(new Font("Verdana", Font.BOLD, 30));
		lblComplaintHistory.setBounds(85, 37, 396, 69);
		contentPane.add(lblComplaintHistory);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		list.setForeground(new Color(0, 0, 0));
		list.setBackground(new Color(255, 255, 255));
		list.setBounds(22, 137, 95, 260);
		contentPane.add(list);
		
		 ListSelectionListener listSelectionListener = new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent listSelectionEvent) {
		    	  String compId = "";
		    	  compId = list.getSelectedValue().toString();
		    	  displayDetails(compId); 
		      }
		 };
		 list.addListSelectionListener(listSelectionListener);
		
		JLabel lblServiceDate = new JLabel("Service date");
		lblServiceDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblServiceDate.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblServiceDate.setBounds(137, 274, 148, 29);
		contentPane.add(lblServiceDate);
		
		JLabel lblDeptPhone = new JLabel("Citizen ID");
		lblDeptPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeptPhone.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblDeptPhone.setBounds(126, 191, 137, 29);
		contentPane.add(lblDeptPhone);
		
		JLabel label_2 = new JLabel("Date of complaint");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 25));
		label_2.setBounds(141, 227, 201, 42);
		contentPane.add(label_2);
		
		JLabel lblComplaintId = new JLabel("Complaint ID");
		lblComplaintId.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplaintId.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblComplaintId.setBounds(134, 148, 157, 38);
		contentPane.add(lblComplaintId);
		
		JLabel label_6 = new JLabel("Description");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Dialog", Font.PLAIN, 25));
		label_6.setBounds(140, 310, 136, 38);
		contentPane.add(label_6);
		
		
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(339, 322, 201, 75);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(textArea);
		
		label_5 = new JLabel("Select Complaint ID");
		label_5.setFont(new Font("Tahoma", Font.ITALIC, 17));
		label_5.setBounds(379, 281, 162, 23);
		contentPane.add(label_5);
		
		label_8 = new JLabel("Select Complaint ID");
		label_8.setFont(new Font("Tahoma", Font.ITALIC, 17));
		label_8.setBounds(378, 239, 162, 23);
		contentPane.add(label_8);
		
		label_3 = new JLabel("Select Complaint ID");
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 17));
		label_3.setBounds(378, 193, 161, 29);
		contentPane.add(label_3);
		
		label_7 = new JLabel("Select Complaint ID");
		label_7.setFont(new Font("Tahoma", Font.ITALIC, 17));
		label_7.setBounds(378, 153, 161, 29);
		contentPane.add(label_7);
		
		try {
			dlm = new DefaultListModel();
			Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl" ,"system","B2170905466");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select complaint_id from complaint_serviced where employee_id = " + "'" + empId + "'");
            while(rs.next()) {
            	dlm.addElement(rs.getString(1));
            }
            list.setModel(dlm);
            
            JButton btnBack = new JButton("BACK");
            btnBack.addActionListener(e -> this.dispose());
            btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
            btnBack.setBounds(12, 13, 85, 25);
            contentPane.add(btnBack);
            
            JLabel label_1 = new JLabel("");
    		label_1.setHorizontalAlignment(SwingConstants.LEFT);
    		label_1.setIcon(new ImageIcon("C:\\Users\\lakho\\Desktop\\DBSProject\\orange-waves-background.jpg"));
    		label_1.setBounds(0, 0, 562, 483);
    		contentPane.add(label_1);
            System.out.println("connected");
            con.close();
            
            
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void displayDetails(String compId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","B2170905466");  
			Statement st = conn.createStatement();
			ResultSet r = st.executeQuery("select citizen_id,to_char(date_of_complaint,'DD-MM-YYYY'),to_char(date_of_service,'DD-MM-YYYY'),description from complaint_serviced where complaint_id = " + "'" + compId + "'");
			while(r.next()) {
				
				label_3.setText(r.getString(1));
				label_8.setText(r.getString(2));
				label_5.setText(r.getString(3));
				textArea.setText(r.getString(4));
			}
			label_7.setText(compId);
			conn.close();
			    } catch (Exception e) {  
			JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
			System.exit(0);  
			}
	}
}
