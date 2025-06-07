package CourseManagementSystem;
//jframe to delete student 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentDelete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField studentId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDelete frame = new StudentDelete();
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
	public StudentDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 16));
		lblId.setBounds(23, 111, 68, 15);
		contentPane.add(lblId);
		
		studentId = new JTextField();
		studentId.setBounds(128, 105, 139, 30);
		contentPane.add(studentId);
		studentId.setColumns(10);
		
		JButton btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = studentId.getText();
				StudentDeletequery ds = new StudentDeletequery();
				ds.deleteing(id);
				Dashboard.dataStudent();
				dispose();
			}
		});
		btnDelete.setBounds(128, 165, 134, 37);
		contentPane.add(btnDelete);
		
		JLabel lblDeleteStudent = new JLabel("Delete Student ");
		lblDeleteStudent.setFont(new Font("Dialog", Font.BOLD, 22));
		lblDeleteStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteStudent.setBounds(22, 12, 360, 37);
		contentPane.add(lblDeleteStudent);
	}

}
