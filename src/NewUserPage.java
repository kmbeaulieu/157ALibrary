import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NewUserPage extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextfield;
	private JTextField birthdayTextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUserPage frame = new NewUserPage();
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
	public NewUserPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateANew = new JLabel("Create A New User");
		lblCreateANew.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreateANew.setBounds(143, 21, 148, 35);
		contentPane.add(lblCreateANew);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(122, 81, 31, 14);
		contentPane.add(lblName);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setBounds(107, 119, 46, 14);
		contentPane.add(lblBirthday);
		
		nameTextfield = new JTextField();
		nameTextfield.setBounds(157, 78, 121, 20);
		contentPane.add(nameTextfield);
		nameTextfield.setColumns(10);
		
		birthdayTextfield = new JTextField();
		birthdayTextfield.setColumns(10);
		birthdayTextfield.setBounds(157, 116, 121, 20);
		contentPane.add(birthdayTextfield);
		
		JButton createUserButton = new JButton("Create User");
		createUserButton.setBounds(171, 177, 91, 23);
		contentPane.add(createUserButton);
		
		JButton backButton = new JButton("<");
		backButton.setBounds(10, 11, 46, 23);
		contentPane.add(backButton);
	}

}
