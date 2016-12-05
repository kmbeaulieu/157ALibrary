import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JTextField;

public class NewEmployeePage extends JFrame {

	private Date dob = new Date(0, 0, 0);
	private JPanel contentPane;
	private JTextField nameTextfield;
	private JTextField birthdayTextfield;
	private JTextField pinTextfield;
	private JTextField departmentTextfield;
	private DatabaseManager dbm;
	private String username;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//set up dbm
		dbm = new DatabaseManager();
		//set up contents
		JLabel lblCreateANew = new JLabel("Create A New Employee");
		lblCreateANew.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreateANew.setBounds(128, 11, 200, 28);
		contentPane.add(lblCreateANew);
		
		JButton btnBack = new JButton("<");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new EmployeeMenuPage();
			}
			});
		btnBack.setBounds(10, 11, 46, 23);
		contentPane.add(btnBack);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(122, 74, 50, 14);
		contentPane.add(lblName);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setBounds(107, 102, 80, 14);
		contentPane.add(lblBirthday);
		
		JLabel lblPin = new JLabel("PIN:");
		lblPin.setBounds(132, 130, 40, 14);
		contentPane.add(lblPin);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(82, 161, 100, 14);
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
		btnCreateEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//	Employee e = new Employee(departmentTextfield.getText(),nameTextfield.getText(),new Date(System.currentTimeMillis()),Integer.parseInt(pinTextfield.getText()));
				username = nameTextfield.getText();
				int year = Integer.parseInt(birthdayTextfield.getText().substring(0, 4));
				int month = Integer.parseInt(birthdayTextfield.getText().substring(5,7));
				int day = Integer.parseInt(birthdayTextfield.getText().substring(8, 10));
				dob.setDate(day);
				//The month will loop back around. 13 = 01 so January. 
				dob.setMonth(month-1);
				//because Java copied C, Dates use year - 1900 or something like that. This is why there is a magic number to fix this error. 
				dob.setYear(year-1900);
				//System.out.println(e.getName());
				//first make a user. Then make an employee. All employees are library users.
				dbm.insertUser(username, dob);
				int uid = dbm.selectUserDob(username, dob).getUid();
				Date jd = new Date(System.currentTimeMillis());
				String dept = departmentTextfield.getText();
				dbm.insertEmployee( uid, dept, username, jd, Integer.parseInt(pinTextfield.getText()));
				
				JOptionPane.showMessageDialog(new JFrame(), "Congrats. Welcome to the team. Use the back button to browse library. Your PIN is " + pinTextfield.getText() + ". "
						+ "Talk to a supervisor if you forget it. Your library PIN is " + uid +". You can look it up in the database using your employee PIN.");
				setVisible(true);
			}
			});
		
		
		//display page
		setVisible(true);
	}

}
