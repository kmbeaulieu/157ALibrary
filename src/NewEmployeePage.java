import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class NewEmployeePage extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextfield;
	private JTextField birthdayTextfield;
	private JTextField pinTextfield;
	private JTextField departmentTextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEmployeePage frame = new NewEmployeePage();
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
	public NewEmployeePage() {
		//set up frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//set up contents
		JLabel lblCreateANew = new JLabel("Create A New Employee");
		lblCreateANew.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreateANew.setBounds(128, 11, 178, 28);
		contentPane.add(lblCreateANew);
		
		JButton btnBack = new JButton("<");
		btnBack.setBounds(10, 11, 46, 23);
		contentPane.add(btnBack);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(122, 74, 31, 14);
		contentPane.add(lblName);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setBounds(107, 102, 46, 14);
		contentPane.add(lblBirthday);
		
		JLabel lblPin = new JLabel("PIN:");
		lblPin.setBounds(132, 130, 21, 14);
		contentPane.add(lblPin);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(92, 161, 61, 14);
		contentPane.add(lblDepartment);
		
		nameTextfield = new JTextField();
		nameTextfield.setBounds(163, 68, 132, 20);
		contentPane.add(nameTextfield);
		nameTextfield.setColumns(10);
		
		birthdayTextfield = new JTextField();
		birthdayTextfield.setColumns(10);
		birthdayTextfield.setBounds(163, 99, 132, 20);
		contentPane.add(birthdayTextfield);
		
		pinTextfield = new JTextField();
		pinTextfield.setColumns(10);
		pinTextfield.setBounds(163, 127, 132, 20);
		contentPane.add(pinTextfield);
		
		departmentTextfield = new JTextField();
		departmentTextfield.setColumns(10);
		departmentTextfield.setBounds(163, 158, 132, 20);
		contentPane.add(departmentTextfield);
		
		JButton btnCreateEmployee = new JButton("Create Employee");
		btnCreateEmployee.setBounds(166, 206, 132, 23);
		contentPane.add(btnCreateEmployee);
		
		//display page
		setVisible(true);
	}

}
