import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class EmployeeLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextfield;
	private JTextField pinTextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLoginPage frame = new EmployeeLoginPage();
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
	public EmployeeLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeLogin = new JLabel("Employee Login");
		lblEmployeeLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeeLogin.setBounds(159, 11, 117, 28);
		contentPane.add(lblEmployeeLogin);
		
		JButton btnBack = new JButton("<");
		btnBack.setBounds(10, 11, 46, 23);
		contentPane.add(btnBack);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(121, 77, 31, 14);
		contentPane.add(lblName);
		
		JLabel lblPin = new JLabel("PIN:");
		lblPin.setBounds(131, 122, 21, 14);
		contentPane.add(lblPin);
		
		nameTextfield = new JTextField();
		nameTextfield.setBounds(159, 74, 117, 20);
		contentPane.add(nameTextfield);
		nameTextfield.setColumns(10);
		
		pinTextfield = new JTextField();
		pinTextfield.setColumns(10);
		pinTextfield.setBounds(159, 119, 117, 20);
		contentPane.add(pinTextfield);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(177, 178, 89, 23);
		contentPane.add(btnEnter);
	}

}
