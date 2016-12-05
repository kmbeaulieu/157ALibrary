import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MainMenuPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable(){

	            @Override
	            public void run()
	            {
	            	//Set up page
	                new MainMenuPage().setVisible(true);
	            }
	        });
	    }


	/**
	 * Create the frame.
	 */
	public MainMenuPage() {
		//set up frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//set up content
		JLabel lblWelcomeToApple = new JLabel("Welcome to Apple Juice Library!");
		lblWelcomeToApple.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcomeToApple.setBounds(102, 28, 249, 28);
		contentPane.add(lblWelcomeToApple);
		
		//button and function
		JButton btnNewButton = new JButton("New User");
		btnNewButton.setBounds(79, 83, 140, 63);
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new NewUserPage();
				
			}
			});
		
		JButton btnUserLogin = new JButton("User Login");
		btnUserLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new UserLoginPage();
			}
			});
		btnUserLogin.setBounds(240, 83, 140, 63);
		contentPane.add(btnUserLogin);
		
		JButton btnNewButton_1 = new JButton("Employee Console");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new EmployeeLoginPage();
			}
			});
		btnNewButton_1.setBounds(240, 157, 140, 63);
		contentPane.add(btnNewButton_1);
		
		JButton btnSearchBooks = new JButton("Search Books");
		btnSearchBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new SearchBooksPage();
			}
			});
		btnSearchBooks.setBounds(79, 157, 140, 63);
		contentPane.add(btnSearchBooks);
		//show page
		setVisible(true);
		
		
	}

}
