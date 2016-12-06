import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;

public class BookDetailsPage extends JFrame {

	private JPanel contentPane;
	private int bookID;
	private DatabaseManager dbm = new DatabaseManager();
	private Book book;
	private Location location;
	private JTextField userIdfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//BookDetailsPage frame = new BookDetailsPage(0);
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
	public BookDetailsPage(int BookID) {
		//create frame
		this.bookID = BookID;
		 book = dbm.selectBook(bookID);
		 try {
			location = dbm.selectLocation(book.getLocationId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(book.getAuthor());
		//System.out.println(location.getShelfId());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//create content
		JLabel lblBookDetails = new JLabel("Book Details");
		lblBookDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBookDetails.setBounds(167, 11, 94, 28);
		contentPane.add(lblBookDetails);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(138, 60, 40, 14);
		contentPane.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(125, 99, 50, 14);
		contentPane.add(lblAuthor);
		
		JLabel lblCopies = new JLabel("Copies:");
		lblCopies.setBounds(125, 138, 50, 14);
		contentPane.add(lblCopies);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(110, 180, 60, 14);
		contentPane.add(lblLocation);
		
		JLabel titleLabel = new JLabel(book.getTitle());
		titleLabel.setBounds(172, 60, 150, 14);
		contentPane.add(titleLabel);
		
		JLabel authorLabel = new JLabel(book.getAuthor());
		authorLabel.setBounds(172, 99, 150, 14);
		contentPane.add(authorLabel);
		
		String copies = String.valueOf(book.getCopies());
		JLabel copiesLabel = new JLabel(copies);
		copiesLabel.setBounds(172, 138, 107, 14);
		contentPane.add(copiesLabel);
		
		JLabel lblShelf = new JLabel("Shelf -");
		lblShelf.setBounds(172, 180, 50, 14);
		contentPane.add(lblShelf);
		
		JLabel lblRow = new JLabel("Row -");
		lblRow.setBounds(243, 180, 60, 14);
		contentPane.add(lblRow);
		
		String shelfid = String.valueOf(location.getShelfId());
		String rowid = String.valueOf(location.getRownumber());
		
		JLabel shelfLabel = new JLabel(shelfid);
		shelfLabel.setBounds(220, 180, 30, 14);
		contentPane.add(shelfLabel);
		
		JLabel rowLabel = new JLabel(rowid);
		rowLabel.setBounds(290, 180, 24, 14);
		contentPane.add(rowLabel);
		
		JLabel userlbl = new JLabel("Enter UserId: ");
		userlbl.setBounds(115, 220, 100, 14);
		contentPane.add(userlbl);
		 userIdfield = new JTextField();
		userIdfield.setBounds(200, 220, 70, 25);
		contentPane.add(userIdfield);
		
		JButton btnBorrowBook = new JButton("Borrow This Book");
		btnBorrowBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String userID = userIdfield.getText();
				int uID = Integer.parseInt(userID);
				java.util.Date utilDate = new java.util.Date();

				java.sql.Date checkoutDate = new java.sql.Date(utilDate.getTime());
				java.sql.Date dueDate = new java.sql.Date(utilDate.getTime());
				boolean insertLoan = dbm.insertLoan(uID, book.getBookId(), checkoutDate, dueDate, 0);
				if (insertLoan == true)
				{
					int res = JOptionPane.showOptionDialog(null,  "You have borrowed " + book.getTitle() + " on "+ checkoutDate.toString(), null, JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, null, null);
					//setVisible(true);
					
					if(res == 0)
					{
						dispose();
						new MainMenuPage();
						
					}
					
					
					
					
				}
				
				
				
				
			}
			});
		btnBorrowBook.setBounds(161, 260, 160, 23);
		contentPane.add(btnBorrowBook);
		
		JButton btnBack = new JButton("<");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new SearchBooksPage();
				
			}
			});
		btnBack.setBounds(10, 11, 46, 23);
		contentPane.add(btnBack);
		
		//show frame
		setVisible(true);
	}

}
