package CourseManagementSystem;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
//jframe to display updated results
public class StudentReport extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentReport frame = new StudentReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public static void displayResult(){
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		model.setRowCount(0);			
		String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
	    String baseUsername = "root";
	    String basePassword = "";
	    String email = Login.mail();
	    try {
	           Connection con = DriverManager.getConnection(url, baseUsername, basePassword);
	           Statement stmt = con.createStatement();
	           String query = "select * from coursemanagementsystem.result WHERE Email = '"+email+"'";
	           ResultSet rs = stmt.executeQuery(query);
	           while(rs.next()){
	        	   String id = rs.getString(1);
	        	   String name= rs.getString(2);
	        	   String mail= rs.getString(3);
	        	   String module = rs.getString(4);
	        	   String course= rs.getString(5);
	        	  
	        	   String marks= rs.getString(6);
	        	   String data[]= {id,name, mail,module,course,marks};
	        	   model.addRow(data);
	           }
	       }
			catch (SQLException e1) {
	           e1.printStackTrace();
	       }	
	}
	/**
	 * Create the frame.
	 */
	public StudentReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 113, 704, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","First Name", "Last Name", "Email", "Course", "Marks"
			}
		));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 65, 704, 15);
		contentPane.add(separator);
		//		pannel.setBorder(BorderFactory.createRaisedBevelBorder());.
				
		
				JLabel lblResult = new JLabel("Student Report");
				lblResult.setBounds(23, 10, 180, 35);
				contentPane.add(lblResult);
				lblResult.setBackground(new Color(255, 255, 255));
				lblResult.setFont(new Font("Dialog", Font.BOLD, 16));
				
				JButton btnNewButton = new JButton("Student Report");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						displayResult();
						 String url = "jdbc:mysql://localhost:3306/coursemanagementsystem";
					     String dbUsername = "root";
					     String dbPassword = "";
						  try {
						         Connection c = DriverManager.getConnection(url, dbUsername, dbPassword);
						         Statement s = c.createStatement();
						         String query = " CREATE DATABASE IF NOT EXISTS coursemanagementsystem";
						         s.executeUpdate(query);
						        String resultStudent = "Select * from coursemanagementsystem.result where email = '"+Login.mail()+"' ";
						         s.executeQuery(resultStudent);
						     } catch (SQLException f) {
						         System.out.println(f);
						     }
						
					}
					
				});
				btnNewButton.setBounds(513, 20, 122, 21);
				contentPane.add(btnNewButton);
		
	}
}
