import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

public class EmployeeLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextfield;
	private JTextField pinTextfield;

	/**
	 * Create the frame.
	 */
	public EmployeeLoginPage() {
		//set up frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//set up contents
		JLabel lblEmployeeLogin = new JLabel("Employee Login");
		lblEmployeeLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeeLogin.setBounds(159, 11, 250, 28);
		contentPane.add(lblEmployeeLogin);
		
		JButton btnBack = new JButton("<");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new MainMenuPage();	
			}
			});
		btnBack.setBounds(10, 11, 46, 23);
		contentPane.add(btnBack);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(121, 77, 60, 14);
		contentPane.add(lblName);
		
		JLabel lblPin = new JLabel("PIN:");
		lblPin.setBounds(131, 122, 50, 14);
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
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new EmployeeMenuPage();
			}
			});
		btnEnter.setBounds(177, 178, 89, 23);
		contentPane.add(btnEnter);
		
		//show page
		setVisible(true);
	}

}
