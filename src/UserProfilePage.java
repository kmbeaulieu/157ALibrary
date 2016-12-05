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

public class UserProfilePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfilePage frame = new UserProfilePage();
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
	public UserProfilePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserProfile = new JLabel("User Profile");
		lblUserProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserProfile.setBounds(171, 11, 90, 28);
		contentPane.add(lblUserProfile);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(125, 66, 36, 14);
		contentPane.add(lblName);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setBounds(115, 105, 46, 14);
		contentPane.add(lblBirthday);
		
		JLabel lblFeesDue = new JLabel("Fees Due:");
		lblFeesDue.setBounds(111, 150, 50, 14);
		contentPane.add(lblFeesDue);
		
		JLabel lblBooksBorrowed = new JLabel("Books Borrowed:");
		lblBooksBorrowed.setBounds(80, 199, 88, 14);
		contentPane.add(lblBooksBorrowed);
		
		JLabel nameLabel = new JLabel("__________________");
		nameLabel.setBounds(171, 66, 108, 14);
		contentPane.add(nameLabel);
		
		JLabel birthdayLabel = new JLabel("__________________");
		birthdayLabel.setBounds(171, 105, 108, 14);
		contentPane.add(birthdayLabel);
		
		JLabel feesLabel = new JLabel("__________________");
		feesLabel.setBounds(171, 150, 108, 14);
		contentPane.add(feesLabel);
		
		JLabel borrowedBooksLabel = new JLabel("__________________");
		borrowedBooksLabel.setBounds(171, 199, 108, 14);
		contentPane.add(borrowedBooksLabel);
		
		JButton btnBack = new JButton("<");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserLoginPage main = new UserLoginPage();
				main.setVisible(true);
			}
		});
		btnBack.setBounds(10, 9, 46, 23);
		contentPane.add(btnBack);
		
		JButton btnPayNow = new JButton("Pay Now");
		btnPayNow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserPaymentPage main = new UserPaymentPage();
				main.setVisible(true);
			}
		});
		btnPayNow.setBounds(289, 146, 89, 23);
		contentPane.add(btnPayNow);
		
		JButton btnMoreInfo = new JButton("More Info");
		btnMoreInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserBorrowedPage main = new UserBorrowedPage();
				main.setVisible(true);
			}
		});
		btnMoreInfo.setBounds(289, 195, 89, 23);
		contentPane.add(btnMoreInfo);
	}

}
