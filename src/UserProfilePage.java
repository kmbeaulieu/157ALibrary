import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JButton;

public class UserProfilePage extends JFrame {

	private JPanel contentPane;
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfilePage frame = new UserProfilePage(new User(0,"TEST USER",0,0,new Date(System.currentTimeMillis()),0.0));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param usr the user passed in
	 */
	public UserProfilePage(User usr) {
		//create frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//fill in passed in info
		user = usr;
		
		//create content
		JLabel lblUserProfile = new JLabel("User Profile");
		lblUserProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserProfile.setBounds(171, 11, 90, 28);
		contentPane.add(lblUserProfile);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(125, 66, 50, 14);
		contentPane.add(lblName);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setBounds(115, 105, 50, 14);
		contentPane.add(lblBirthday);
		
		JLabel lblFeesDue = new JLabel("Fees Due: $");
		lblFeesDue.setBounds(111, 150, 100, 14);
		contentPane.add(lblFeesDue);
		
		JLabel lblBooksBorrowed = new JLabel("Books Borrowed:");
		lblBooksBorrowed.setBounds(80, 199, 500, 14);
		contentPane.add(lblBooksBorrowed);
		
		JLabel nameLabel = new JLabel(user.getName());
		nameLabel.setBounds(171, 66, 108, 14);
		contentPane.add(nameLabel);
		
		JLabel birthdayLabel = new JLabel(user.getDob().toString());
		birthdayLabel.setBounds(171, 105, 200, 14);
		contentPane.add(birthdayLabel);
		
		JLabel feesLabel = new JLabel(String.valueOf(user.getFees()));
		feesLabel.setBounds(180, 150, 150, 14);
		contentPane.add(feesLabel);
		
		JLabel borrowedBooksLabel = new JLabel(String.valueOf(user.getBorrowed()));
		borrowedBooksLabel.setBounds(180, 200, 108, 14);
		contentPane.add(borrowedBooksLabel);
		
		JButton btnBack = new JButton("<");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new UserLoginPage();
			}
		});
		btnBack.setBounds(10, 9, 46, 23);
		contentPane.add(btnBack);
		
		JButton btnPayNow = new JButton("Pay Now");
		btnPayNow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new UserPaymentPage(user);
			}
		});
		btnPayNow.setBounds(289, 146, 89, 23);
		contentPane.add(btnPayNow);
		
		JButton btnMoreInfo = new JButton("More Info");
		btnMoreInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new UserBorrowedPage(user);
			}
		});
		btnMoreInfo.setBounds(289, 195, 89, 23);
		contentPane.add(btnMoreInfo);
		
		setVisible(true);
	}

}
