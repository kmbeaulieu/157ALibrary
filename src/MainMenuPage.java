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

public class MainMenuPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuPage frame = new MainMenuPage();
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
	public MainMenuPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToApple = new JLabel("Welcome to Apple Juice Library!");
		lblWelcomeToApple.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcomeToApple.setBounds(102, 28, 249, 28);
		contentPane.add(lblWelcomeToApple);
		
		JButton btnNewButton = new JButton("New User");
		btnNewButton.setBounds(79, 83, 124, 63);
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NewUserPage frame = new NewUserPage();
				frame.setVisible(true);	
			}
			});
		
		JButton btnUserLogin = new JButton("User Login");
		btnUserLogin.setBounds(240, 83, 124, 63);
		contentPane.add(btnUserLogin);
		
		JButton btnNewButton_1 = new JButton("Employee Console");
		btnNewButton_1.setBounds(240, 157, 124, 63);
		contentPane.add(btnNewButton_1);
		
		JButton btnSearchBooks = new JButton("Search Books");
		btnSearchBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SearchBooksPage frame = new SearchBooksPage();
				frame.setVisible(true);	
			}
			});
		btnSearchBooks.setBounds(79, 157, 124, 63);
		contentPane.add(btnSearchBooks);
		
	}

}
