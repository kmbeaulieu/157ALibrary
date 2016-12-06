import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class UserPaymentPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * 
	 * @param user the user passed in
	 */
	public UserPaymentPage(User usr) {
		//create frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//fill in passed in info, set up database connection
		final User user = usr;
		final DatabaseManager dbm = new DatabaseManager();
		//create content
		JLabel lblUserPayment = new JLabel("User Payment");
		lblUserPayment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserPayment.setBounds(160, 11, 104, 24);
		contentPane.add(lblUserPayment);
		
		JLabel lblFeesDue = new JLabel("Fees Due:");
		lblFeesDue.setBounds(119, 76, 100, 14);
		contentPane.add(lblFeesDue);
		
		JLabel lblPaymentAmount = new JLabel("Payment Amount:");
		lblPaymentAmount.setBounds(82, 121, 100, 14);
		contentPane.add(lblPaymentAmount);
		
		final JLabel feesLabel = new JLabel("$ " + user.getFees());
		feesLabel.setBounds(178, 76, 86, 14);
		contentPane.add(feesLabel);
		
		final JFormattedTextField paymentAmountTextfield = new JFormattedTextField();
		paymentAmountTextfield.setBounds(185, 118, 86, 20);
		contentPane.add(paymentAmountTextfield);
		
		JButton payNowButton = new JButton("Pay Now");
		payNowButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){
				
				try {
					double newFees = dbm.payFees(user.getUid(), Double.valueOf(paymentAmountTextfield.getText()));
					paymentAmountTextfield.setValue(newFees);
					feesLabel.setText("$ " + newFees);
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		payNowButton.setBounds(175, 181, 89, 23);
		contentPane.add(payNowButton);
		
		
		
		JButton button = new JButton("<");
		button.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			dispose();
			//go back with the updated info
			new UserProfilePage(dbm.selectUser(user.getName(), user.getUid()));
		}
	});
		button.setBounds(10, 11, 46, 23);
		contentPane.add(button);
		//show page
		setVisible(true);
	}

}
