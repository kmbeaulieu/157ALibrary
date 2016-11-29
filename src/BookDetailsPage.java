import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class BookDetailsPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookDetailsPage frame = new BookDetailsPage();
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
	public BookDetailsPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookDetails = new JLabel("Book Details");
		lblBookDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBookDetails.setBounds(167, 11, 94, 28);
		contentPane.add(lblBookDetails);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(138, 60, 24, 14);
		contentPane.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(125, 99, 37, 14);
		contentPane.add(lblAuthor);
		
		JLabel lblCopies = new JLabel("Copies:");
		lblCopies.setBounds(125, 138, 37, 14);
		contentPane.add(lblCopies);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(116, 180, 46, 14);
		contentPane.add(lblLocation);
		
		JLabel titleLabel = new JLabel("_________________");
		titleLabel.setBounds(172, 60, 107, 14);
		contentPane.add(titleLabel);
		
		JLabel authorLabel = new JLabel("_________________");
		authorLabel.setBounds(172, 99, 107, 14);
		contentPane.add(authorLabel);
		
		JLabel copiesLabel = new JLabel("_________________");
		copiesLabel.setBounds(172, 138, 107, 14);
		contentPane.add(copiesLabel);
		
		JLabel lblShelf = new JLabel("Shelf -");
		lblShelf.setBounds(172, 180, 37, 14);
		contentPane.add(lblShelf);
		
		JLabel lblRow = new JLabel("Row -");
		lblRow.setBounds(243, 180, 37, 14);
		contentPane.add(lblRow);
		
		JLabel shelfLabel = new JLabel("___");
		shelfLabel.setBounds(209, 180, 24, 14);
		contentPane.add(shelfLabel);
		
		JLabel rowLabel = new JLabel("___");
		rowLabel.setBounds(280, 180, 24, 14);
		contentPane.add(rowLabel);
		
		JButton btnBorrowBook = new JButton("Borrow This Book");
		btnBorrowBook.setBounds(161, 216, 132, 23);
		contentPane.add(btnBorrowBook);
		
		JButton btnBack = new JButton("<");
		btnBack.setBounds(10, 11, 46, 23);
		contentPane.add(btnBack);
	}

}
