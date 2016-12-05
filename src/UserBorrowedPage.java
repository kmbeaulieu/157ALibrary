import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
					UserBorrowedPage frame = new UserBorrowedPage();
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
	public UserBorrowedPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserBorrowedBooks = new JLabel("User Borrowed Books");
		lblUserBorrowedBooks.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserBorrowedBooks.setBounds(132, 11, 161, 28);
		contentPane.add(lblUserBorrowedBooks);
		
		JButton btnBack = new JButton("<");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserProfilePage frame = new UserProfilePage();
				frame.setVisible(true);	
			}
			});

		btnBack.setBounds(10, 11, 46, 23);
		contentPane.add(btnBack);
	}

}
