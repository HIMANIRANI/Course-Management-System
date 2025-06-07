package CourseManagementSystem;

//course delete from db use coursedelete query
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourseDelete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CourseID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseDelete frame = new CourseDelete();
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
	public CourseDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(40, 72, 76, 24);
		contentPane.add(lblNewLabel);
		
		CourseID = new JTextField();
		CourseID.setBounds(137, 75, 129, 31);
		contentPane.add(CourseID);
		CourseID.setColumns(10);
		
		JButton courseDelete = new JButton("Delete Course");
		courseDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = CourseID.getText();
				CourseDeletequery cd = new CourseDeletequery();
				cd.deletingCourse(id);
				Dashboard.courseData();
				dispose();
				
			}
		});
		courseDelete.setBounds(131, 142, 135, 25);
		contentPane.add(courseDelete);
	}
}
