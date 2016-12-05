import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JList;
import javax.swing.JButton;

public class UserBorrowedPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserBorrowedPage frame = new UserBorrowedPage(new User(0,"TEST USER",0,0,new Date(),0.0));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param user passed in user value
	 */
	public UserBorrowedPage(final User user) {
		//set up frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//set up contents
		JLabel lblUserBorrowedBooks = new JLabel("User Borrowed Books");
		lblUserBorrowedBooks.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserBorrowedBooks.setBounds(132, 11, 161, 28);
		contentPane.add(lblUserBorrowedBooks);
		
		JButton btnBack = new JButton("<");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserProfilePage frame = new UserProfilePage(user);
				frame.setVisible(true);	
			}
			});

		btnBack.setBounds(10, 11, 46, 23);
		contentPane.add(btnBack);
		
		setVisible(true);
	}

}
