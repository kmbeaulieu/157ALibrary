import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JList;
import javax.swing.JButton;

public class UserBorrowedPage extends JFrame {

	private JPanel contentPane;
	private DatabaseManager dbm = new DatabaseManager();
	String[] columnNames = {"title", "author", "checkOutDate", "dueDate", "overdue"};
	Object[][] result = null;
	private JTable table ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserBorrowedPage frame = new UserBorrowedPage(new User(0,"TEST USER",0,0,new Date(System.currentTimeMillis()),0.0));
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
		
		//we have the user id 
		if(user.getBorrowed() ==0)
		{
			JLabel noofBorrowed = new JLabel("No books borrowed yet.");
			noofBorrowed.setFont(new Font("Tahoma", Font.PLAIN,13));
			noofBorrowed.setBounds(132, 11, 161, 28);
			contentPane.add(noofBorrowed);
			
		}
		else
		{
			result = dbm.bookBorrowed(user);
			String[] columnNames = {"title", "author", "checkOutDate", "dueDate", "overdue"};
			/*
			Object[][] toPass = null;
			for(int i=0; i < result[0].length ; i++)
			{
				for(int j =0; j <result[0].length ; j++)
				{
					if(result[i][j] == null)
					{
						break;
					}
					else
					{
						
						toPass[]
					}
					
				}
				System.out.println(result[0][i]);
				
			}
			*/
			
			
			
		}
		
		 table = new JTable(result,columnNames );
		table.setBounds(132,100, 500, 300);
		contentPane.add(table);
		
		JLabel titleL = new JLabel("title");
		titleL.setFont(new Font("Tahoma", Font.BOLD, 15));
		titleL.setBounds(140, 50, 100, 20);
		contentPane.add(titleL);
		
		JLabel authorL = new JLabel("author");
		authorL.setFont(new Font("Tahoma", Font.BOLD, 15));
		authorL.setBounds(250, 50, 100, 20);
		contentPane.add(authorL);
		
		JLabel checkoutDateL = new JLabel("checkoutDate");
		checkoutDateL.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkoutDateL.setBounds(350, 50, 100, 20);
		contentPane.add(checkoutDateL);
		
		JLabel dueDateL = new JLabel("dueDate");
		dueDateL.setFont(new Font("Tahoma", Font.BOLD, 15));
		dueDateL.setBounds(450, 50, 100, 20);
		contentPane.add(dueDateL);
		
		JLabel overdueL = new JLabel("overdue");
		overdueL.setFont(new Font("Tahoma", Font.BOLD, 15));
		overdueL.setBounds(550, 50, 100, 10);
		contentPane.add(overdueL);
		
		
		JButton  extendBookBtn = new JButton("Extend this book");
		extendBookBtn.setBounds(250, 500, 200, 35);
		contentPane.add(extendBookBtn);
		extendBookBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				int s = table.getSelectedRow();
				
					String title = (String) result[s][0];
					String author = (String) result[s][1];
					Date dueDate = (Date) result[s][3];
					
				
					boolean res = dbm.extendDueDate(user, title, author, dueDate);
					
					
					if (res == true)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Congrats. Selected book's Due date has been extended by 1 week.");
						setVisible(true);
						
						dispose();
						new UserProfilePage(user);
						
						
						
					}
					else
					{
						
						
					}
					
				}
				
				
			});

		
		
		

		
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
