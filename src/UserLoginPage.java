import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UserLoginPage extends JFrame {

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
					UserLoginPage frame = new UserLoginPage();
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
	public UserLoginPage() {
		//create frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//create content
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserLogin.setBounds(171, 11, 88, 28);
		contentPane.add(lblUserLogin);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(112, 72, 36, 14);
		contentPane.add(lblName);
		
		JLabel lblPin = new JLabel("PIN:");
		lblPin.setBounds(127, 117, 21, 14);
		contentPane.add(lblPin);
		
		nameTextfield = new JTextField();
		nameTextfield.setBounds(158, 69, 110, 20);
		contentPane.add(nameTextfield);
		nameTextfield.setColumns(10);
		
		pinTextfield = new JTextField();
		pinTextfield.setColumns(10);
		pinTextfield.setBounds(158, 114, 110, 20);
		contentPane.add(pinTextfield);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(169, 177, 89, 23);
		contentPane.add(btnEnter);
		
		JButton btnBack = new JButton("<");
		btnBack.setBounds(10, 11, 46, 23);
		contentPane.add(btnBack);
		
		//show page
		setVisible(true);
	}

}
