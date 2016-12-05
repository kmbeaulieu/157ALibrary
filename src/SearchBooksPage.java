import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JButton;

import com.mysql.jdbc.Connection;

public class SearchBooksPage extends JFrame {

	private JPanel contentPane;
	private JTextField searchTextfield;
	private String bookToSearch;
	private DBDemo con = new DBDemo();
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					//SearchBooksPage frame = new SearchBooksPage();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchBooksPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchBooks = new JLabel("Search Books");
		lblSearchBooks.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearchBooks.setBounds(163, 11, 101, 28);
		contentPane.add(lblSearchBooks);
		
		searchTextfield = new JTextField();
		searchTextfield.setBounds(100, 78, 121, 20);
		contentPane.add(searchTextfield);
		searchTextfield.setColumns(10);
		
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(300, 78, 121, 20);
		contentPane.add(searchBtn);
		searchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					 bookToSearch = searchTextfield.getText();
					 ArrayList<Book> books = con.searchBookTitle(bookToSearch);
					 String[] columnNames = {"BookID", "Title", "Author", "Copies", "LocationID"};
					 for(int i = 0; i < books.size(); i++)
					 {
						 
						// System.out.format("%s,%s,%s,%s,%s", books.get(i).getBookId(),  books.get(i).getTitle()
							//	 ,  books.get(i).getAuthor(),  books.get(i).getCopies(),  books.get(i).getLocationId());
						 
					 }
				}
					 
					 
				
				
				
				
				/*
				DBDemo con = new DBDemo();
				try {
					 bookToSearch = searchTextfield.getText();
					Connection connection = (Connection) con.getConnection();
					
					String testQuery = "SELECT * FROM book where title=?";
					
					PreparedStatement ts = connection.prepareStatement(testQuery);
					ts.setString (1,bookToSearch);
					
					ResultSet rs = ts.executeQuery();
					
					
					while(rs.next()){
						int uid = rs.getInt("bookID");
						String title = rs.getString("title");
						String author = rs.getString("author");
						int copies = rs.getInt("copies");
						int locID = rs.getInt("locationID");
						System.out.format("%s,%s,%s,%s,%s", uid, title, author, copies, locID);
						
						
					
						
						
						
						
					}
					ts.close();
					connection.close();
				
				
			}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				
		
		
		});
		
		
		
		JButton selectButton = new JButton("select");
		selectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BookDetailsPage main = new BookDetailsPage();
				main.setVisible(true);
			}
		});
		selectButton.setBounds(100, 200, 80, 25);
		contentPane.add(selectButton);
	
		
		
		JButton btnBack = new JButton("<");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainMenuPage main = new MainMenuPage();
				main.setVisible(true);
			}
		});
		btnBack.setBounds(10, 11, 46, 23);
		contentPane.add(btnBack);
		
	}

}
